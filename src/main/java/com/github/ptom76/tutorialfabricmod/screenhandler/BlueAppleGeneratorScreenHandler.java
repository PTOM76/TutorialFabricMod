package com.github.ptom76.tutorialfabricmod.screenhandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BlueAppleGeneratorScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public BlueAppleGeneratorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(1));
    }

    public BlueAppleGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlers.BLUE_APPLE_GENERATOR_SCREEN_HANDLER, syncId);
        this.inventory = inventory;

        //inventory.onOpen(playerInventory.player);

        // 真ん中にInventoryのスロット追加
        addSlot(new Slot(inventory, 0, 80, 35));

        // PlayerInventoryのスロット追加
        for (int h = 0; h < 3; ++h) {
            for (int w = 0; w < 9; ++w) {
                addSlot(new Slot(playerInventory, w + h * 9 + 9, 8 + w * 18, 84 + h * 18));
            }
        }

        // PlayerInventory (ホットバー)のスロット追加
        for (int w = 0; w < 9; ++w) {
            addSlot(new Slot(playerInventory, w, 8 + w * 18, 142));
        }
    }

    // 1.19.2以前ではメソッド名がtransferSlot
    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        // スロットがスタックを持つとき、
        if (slot.hasStack()) {
            // スロットからスタックを取得
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            // スロットのIDがインベントリのサイズより小さいとき、
            if (index < this.inventory.size()) {
                // インベントリのサイズ～全体のサイズ→プレイヤーのインベントリに入れる
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                // Index 0～インベントリのサイズに入れる→インベントリに入れる
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
