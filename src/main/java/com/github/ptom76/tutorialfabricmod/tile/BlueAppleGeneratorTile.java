package com.github.ptom76.tutorialfabricmod.tile;

import com.github.ptom76.tutorialfabricmod.inventory.IInventory;
import com.github.ptom76.tutorialfabricmod.item.Items;
import com.github.ptom76.tutorialfabricmod.screenhandler.BlueAppleGeneratorScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlueAppleGeneratorTile extends BlockEntity implements NamedScreenHandlerFactory, IInventory, SidedInventory, BlockEntityTicker<BlueAppleGeneratorTile> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    // クールダウン
    private int cooldown;

    public BlueAppleGeneratorTile(BlockPos pos, BlockState state) {
        super(Tiles.BLUE_APPLE_GENERATOR_TILE, pos, state);
        cooldown = 0;
    }

    // 1tickの処理
    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlueAppleGeneratorTile blockEntity) {
        if (world.isClient) return;
        cooldown++;

        // 1秒に1回の処理にする
        if (cooldown < 60) return;
        cooldown = 0;

        if (inventory.get(0).isEmpty())
            // 空のとき、スタックをセットする
            inventory.set(0, new ItemStack(Items.TUTORIAL_ITEM, 1));
        else
            // スタックの量を1つ追加
            inventory.get(0).increment(1);
    }

    // nbtにNBTを書き込む
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    // nbtからNBTを読み込む
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        // 1.18.2以前ではnew Translatable(String key)
        return Text.translatable("block.tutorialfabricmod.blue_apple_generator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BlueAppleGeneratorScreenHandler(syncId, inv, this);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        // Index 0のスロットのみだけ 複数あるならnew int[]{0, 1, 2, 3...}
        return new int[]{0};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        // 上ではないときは(ホッパーなどで)抽出可能
        return dir != Direction.UP;
    }
}
