package com.grayjam.grayhax.GrayHax.modules.combat;
import org.lwjgl.input.Keyboard;

import com.grayjam.grayhax.GrayHax.modules.Category;
import com.grayjam.grayhax.GrayHax.modules.Module;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
public class FastBow extends Module{

	public FastBow() {
		super("FastBow", Keyboard.KEY_B, Category.COMBAT);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.player.getHealth() > 0 
					&& mc.player.onGround 
					|| mc.player.capabilities.isCreativeMode
					&& mc.player.inventory.getCurrentItem() != null
					&& mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow
					&& mc.gameSettings.keyBindUseItem.pressed) {
				Minecraft.getMinecraft().playerController.processRightClick(mc.player, mc.world, EnumHand.MAIN_HAND);
				Minecraft.getMinecraft().player.inventory.getCurrentItem().getItem().onItemRightClick(mc.world, mc.player, EnumHand.MAIN_HAND);
				for(int i = 0; i < 20; i ++) {
					mc.player.connection.sendPacket(new CPacketPlayer(false));
					mc.getConnection().sendPacket(new CPacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0,0,0), EnumFacing.DOWN));
					mc.player.inventory.getCurrentItem().getItem().onPlayerStoppedUsing(mc.player.inventory.getCurrentItem(), mc.world, mc.player, 10);
				}
			}
		}
	}
}
