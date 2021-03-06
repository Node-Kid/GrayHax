package com.grayjam.grayhax.GrayHax.modules;

import com.grayjam.grayhax.GrayHax.GrayHax;
import com.grayjam.grayhax.GrayHax.events.Event;

import net.minecraft.client.Minecraft;

public class Module {
	protected Minecraft mc = Minecraft.getMinecraft();
	private String name;
	private int key;
	private boolean toggled;
	private Category category;
	public Module(String nm, int k, Category c) {
		name = nm;
		key = k;
		category = c;
		toggled = false;
	}
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}
	public void onEvent(Event e) {
		for(Module m : GrayHax.modules) {
			if(!m.isToggled())
				continue;
			m.onEvent(e);
		}
	}
 	public Minecraft getMc() {
		return mc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public boolean isToggled() {
		return toggled;
	}
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
}
