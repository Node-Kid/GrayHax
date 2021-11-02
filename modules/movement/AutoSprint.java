package com.grayjam.grayhax.GrayHax.modules.movement;
import org.lwjgl.input.Keyboard;

import com.grayjam.grayhax.GrayHax.events.Event;
import com.grayjam.grayhax.GrayHax.events.listeners.EventUpdate;
import com.grayjam.grayhax.GrayHax.modules.Category;
import com.grayjam.grayhax.GrayHax.modules.Module;
public class AutoSprint extends Module{

	public AutoSprint() {
		super("AutoSprint", Keyboard.KEY_F, Category.MOVEMENT);
	}
	public void onEnable() {
		if(this.isToggled()) {
			super.onEnable();		
		}
	}
	public void onDisable() {
		mc.player.setSprinting(false);
		super.onDisable();
	}
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.player.setSprinting(true);
			}
		}
	}
}
