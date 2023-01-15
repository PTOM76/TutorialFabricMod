package com.github.ptom76.tutorialfabricmod.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class ClickCountBlockTile extends BlockEntity {
    private int clickCount = 0;

    public ClickCountBlockTile(BlockPos pos, BlockState state) {
        super(Tiles.CLICK_COUNT_BLOCK_TILE, pos, state);
    }

    // nbtにNBTを書き込む
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("clickCount", clickCount);
    }

    // nbtからNBTを読み込む
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        clickCount = nbt.getInt("clickCount");
    }

    public void increaseClickCount() {
        clickCount++;
    }

    public void decreaseClickCount() {
        clickCount--;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public int getClickCount() {
        return clickCount;
    }
}
