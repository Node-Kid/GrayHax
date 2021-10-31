package com.grayjam.grayhax.GrayHax.gui;

import com.grayjam.grayhax.GrayHax.GrayHax;
import com.grayjam.grayhax.GrayHax.utils.Wrapper;
import com.grayjam.grayhax.GrayHax.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	public void renderGameOverlay(float p_175180_1_){
	      super.renderGameOverlay(p_175180_1_);
	      drawRect(2,2,95,14, 0x80000000);
	      Wrapper.fr.drawString("GrayHax", 4, 4, 0x808080);
	      Wrapper.fr.drawString("FPS: " + mc.getDebugFPS(), 50, 4, -1);
	      renderArrayList();
	}
	private void renderArrayList() {
		int yCount = 10;
		int index = 0;
		long x = 0;
		for(Module m : GrayHax.instance.moduleManager.getModules()) {
			m.onRender();
			if(m.isToggled()) {
				Wrapper.fr.drawString(m.getName(), 5, yCount + 5, 0xC3C5E1);
				yCount += 10;
				index++;
				x++;
			}
		}
	}
}
