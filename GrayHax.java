package com.grayjam.grayhax.GrayHax;

import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import com.grayjam.grayhax.GrayHax.events.Event;
import com.grayjam.grayhax.GrayHax.gui.HUD;
//import com.grayjam.grayhax.GrayHax.modules.ModuleManager;
import com.grayjam.grayhax.GrayHax.modules.combat.*;
import com.grayjam.grayhax.GrayHax.modules.movement.*;
import com.grayjam.grayhax.GrayHax.modules.Module;

public class GrayHax {
	public static String name = "GrayHax", version = "0.1.0";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
//	public static ModuleManager moduleManager;
	public static GrayHax instance = new GrayHax();
	public static HUD hud = new HUD();
	public static void startClient() {
//		moduleManager = new ModuleManager();
		modules.add(new FastBow());
		modules.add(new KillAura());
		modules.add(new AutoSprint());
		Display.setTitle(name + " " + version);
	}
	public static void keyPress(int key) {
		for(Module m : modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	public static void onEvent(Event e) {
		for(Module m : modules) {
			if(!m.isToggled())
				continue;
			m.onEvent(e);
		}
	}
	
}
