package com.grayjam.grayhax.GrayHax;

import org.lwjgl.opengl.Display;

import com.grayjam.grayhax.GrayHax.modules.ModuleManager;

public class GrayHax {
	public static String name = "GrayHax", version = "0.1.0", creator = "GrayJam";
	public static ModuleManager moduleManager;
	public static void startClient() {
		moduleManager = new ModuleManager();
		
		Display.setTitle(name + " " + version);
		
	}
	
}
