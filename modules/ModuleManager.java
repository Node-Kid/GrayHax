package com.grayjam.grayhax.GrayHax.modules;

import java.util.ArrayList;

public class ModuleManager {
	private static ArrayList<Module> mods;
	public ModuleManager() {
		mods = new ArrayList<Module>();
		//combat
		
		//movement
		
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
}
