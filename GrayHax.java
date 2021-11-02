package com.grayjam.grayhax.GrayHax;

import org.lwjgl.opengl.Display;

import com.grayjam.grayhax.GrayHax.events.Event;
import com.grayjam.grayhax.GrayHax.gui.HUD;
import com.grayjam.grayhax.GrayHax.modules.ModuleManager;

public class GrayHax {
	public static String name = "GrayHax", version = "0.1.0";
	public static ModuleManager moduleManager;
	public static GrayHax instance = new GrayHax();
	public static HUD hud = new HUD();
	public static void onEvent(Event e) {
		
	}
	public static void startClient() {
		moduleManager = new ModuleManager();
		
		Display.setTitle(name + " " + version);
		
	}
	
}
