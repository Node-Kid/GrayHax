//package com.grayjam.grayhax.GrayHax.modules;
//
//import java.util.ArrayList;
//
//import com.grayjam.grayhax.GrayHax.modules.combat.*;
//import com.grayjam.grayhax.GrayHax.modules.movement.*;
//
//public class ModuleManager {
//	private static ArrayList<Module> mods;
//	public ModuleManager() {
//		mods = new ArrayList<Module>();
//		//combat
//		newMod(new FastBow());
//		newMod(new KillAura());
//		//movement
//		newMod(new AutoSprint());
//		//player
//		
//		//render
//		
//		//misc
//	}
//	public static void newMod(Module m)  {
//		mods.add(m);
//	}
//	public static ArrayList<Module> getModules() {
//		return mods;
//	}
//	public static void onUpdate() {
//		for(Module m : mods) {
//			m.onUpdate();
//		}
//	}
//	public static void onRender() {
//		for(Module m : mods) {
//			m.onRender();
//		}
//	}