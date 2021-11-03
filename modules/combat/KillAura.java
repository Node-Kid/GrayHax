package com.grayjam.grayhax.GrayHax.modules.combat;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import com.grayjam.grayhax.GrayHax.modules.Category;
import com.grayjam.grayhax.GrayHax.modules.Module;
import com.grayjam.grayhax.GrayHax.utils.Timer;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
public class KillAura extends Module{
	public Timer timer = new Timer();
	public KillAura() {
		super("KillArua", Keyboard.KEY_R, Category.COMBAT);
	}
	@Override
	public void onUpdate() {
		if(!this.isToggled()) 
			return;
		for(Iterator<Entity> entites = mc.world.loadedEntityList.iterator(); entites.hasNext();) {
			Object obj = entites.next();
			if(obj instanceof EntityLivingBase) {
				EntityLivingBase entity = (EntityLivingBase) obj;
				if(entity instanceof EntityPlayerSP) 
					continue;
				if(mc.player.getDistanceToEntity(entity) <= 6.2173613F) {
					if(entity.isEntityAlive()) {
						if(timer.hasTimeElapsed(625, true)) {
							mc.playerController.attackEntity(mc.player, entity);
							mc.player.swingArm(EnumHand.MAIN_HAND);				
						}
					}
				}
			}
		}
	}
}
