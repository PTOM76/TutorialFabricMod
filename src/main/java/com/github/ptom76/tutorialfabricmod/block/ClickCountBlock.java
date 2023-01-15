package com.github.ptom76.tutorialfabricmod.block;

import com.github.ptom76.tutorialfabricmod.tile.ClickCountBlockTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ClickCountBlock extends Block implements BlockEntityProvider {

    // 東西南北の方向性
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ClickCountBlock(Settings settings) {
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
        return new ClickCountBlockTile(pos, state);
    }

    @SuppressWarnings("deprecation")
    @Override
    // ブロックを右クリックした時に呼び出される関数
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity tile = world.getBlockEntity(pos);
        if (tile instanceof ClickCountBlockTile) {
            ClickCountBlockTile clickCountBlockTile = (ClickCountBlockTile) tile;

            if (player.isSneaking()) {
                // プレイヤーにメッセージを送る
                if (!world.isClient)
                    player.sendMessage(Text.literal("クリックした回数: " + clickCountBlockTile.getClickCount()));
                return ActionResult.SUCCESS;
            }

            // クリック回数を増やす
            clickCountBlockTile.increaseClickCount();
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
