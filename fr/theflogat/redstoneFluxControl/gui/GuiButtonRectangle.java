package fr.theflogat.redstoneFluxControl.gui;

public class GuiButtonRectangle {
	
	int x;
	int y;
	int w;
	int h;
	int id;
	
	public GuiButtonRectangle(int x, int y, int w, int h, int id){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.id = id;
	}
	
	public void render(GuiRFController gui, int scrX, int scrY){
		gui.drawTexturedModalRect(x + gui.getLeft(), y + gui.getTop(), scrX, scrY, w, h);
	}
	
	public boolean isInRegion(GuiRFController gui, int mouseX, int mouseY){
		int X = mouseX - gui.getLeft();
		int Y = mouseY - gui.getTop();
		
		if(x <= X && X <= x + w && y <= Y && Y <= y + h){
			return true;
		}
		
		return false;
	}
}
