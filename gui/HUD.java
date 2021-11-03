package com.grayjam.grayhax.GrayHax.gui;

import com.grayjam.grayhax.GrayHax.GrayHax;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import com.grayjam.grayhax.GrayHax.modules.Module;

public class HUD {
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc);
		fr.drawStringWithShadow(GrayHax.name + " v" + GrayHax.version, 2, 2, -1);
		for(Module m : GrayHax.modules) {
			if(!m.isToggled()) continue;
			Gui.drawRect(0, 12, fr.getStringWidth(m.getName()) + 4, 15 + fr.FONT_HEIGHT, 0x90000000);
			//Gui.drawRect(left, top, right, button, 0);
			fr.drawString(m.getName(), 2, 14, -1);
		}
	}
}
