package fr.theflogat.technicalWizardry.proxies;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler{


    /**
     * Called at the "start" phase of a tick
     * 
     * Multiple ticks may fire simultaneously- you will only be called once with all the firing ticks
     * 
     * @param type
     * @param tickData
     */
    public void tickStart(EnumSet<TickType> type, Object... tickData){
    	
    }
    
    /**
     * Called at the "end" phase of a tick
     * 
     * Multiple ticks may fire simultaneously- you will only be called once with all the firing ticks
     * 
     * @param type
     * @param tickData
     */
    public void tickEnd(EnumSet<TickType> type, Object... tickData){
    	
    }
    
    /**
     * Returns the list of ticks this tick handler is interested in receiving at the minute
     */
    public EnumSet<TickType> ticks(){
		return null;
    	
    }
    
    /**
     * A profiling label for this tick handler
     */
    public String getLabel(){
		return null;
    	
    }
    
}
