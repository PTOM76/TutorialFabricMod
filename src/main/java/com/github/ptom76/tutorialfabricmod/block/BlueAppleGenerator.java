package com.github.ptom76.tutorialfabricmod.block;

import com.github.ptom76.tutorialfabricmod.tile.BlueAppleGeneratorTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlueAppleGenerator extends Block implements BlockEntityProvider {

    // 東西南北の方向性
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public BlueAppleGenerator(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.appendProperties(builder);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(FACING, ctx.getPlayer().getHorizontalFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlueAppleGeneratorTile(pos, state);
    }

    @SuppressWarnings("deprecation")
    @Override
    // ブロックを右クリックした時に呼び出される関数
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        BlockEntity tile = world.getBlockEntity(pos);
        if (tile instanceof BlueAppleGeneratorTile) {
            BlueAppleGeneratorTile blueAppleGeneratorTile = (BlueAppleGeneratorTile) tile;

            // GUIを開く
            player.openHandledScreen(blueAppleGeneratorTile);

            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, tile) -> {
            if (tile instanceof BlueAppleGeneratorTile) {
                BlueAppleGeneratorTile blueAppleGeneratorTile = (BlueAppleGeneratorTile) tile;
                blueAppleGeneratorTile.tick(world1, pos, state1, blueAppleGeneratorTile);
            }
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            Inventory inventory = (Inventory) blockEntity;

            // アイテムをドロップさせる
            ItemScatterer.spawn(world, pos, inventory);

            // コンパレータの更新
            world.updateComparators(pos, this);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
