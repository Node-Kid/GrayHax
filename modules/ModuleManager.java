package com.grayjam.grayhax.GrayHax.modules;

import java.util.ArrayList;

import com.grayjam.grayhax.GrayHax.modules.*;
import com.grayjam.grayhax.GrayHax.modules.movement.*;

public class ModuleManager {
	private static ArrayList<Module> mods;
	public ModuleManager() {
		mods = new ArrayList<Module>();
		//combat
		
		//movement
		newMod(new AutoSprint());
		//player
		
		//render
		
		//misc
	}
	public static void newMod(Module m)  {
		mods.add(m);
	}
	public static ArrayList<Module> getModules() {
		return mods;
	}
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	public static void onRender() {
		for(Module m : mods) {
			m.onRender();
		}
	}
	public static void onKey(int k) {
		for(Module m : mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}
}
