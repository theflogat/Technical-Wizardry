package fr.theflogat.redstoneFluxControl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import fr.theflogat.redstoneFluxControl.lib.References;

public class PacketManager implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player player) {
		ByteArrayInputStream reader = new ByteArrayInputStream(packet.data);
		
		int pckID = reader.read();
		EntityPlayer entPlayer = (EntityPlayer)player;
		
		switch(pckID){
		case 0:
			manageButtonEvent(reader.read(), entPlayer);
			break;
		}
	}
	
	public static void sendButtonPacket(int buttonId){
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(byteStream);
		
		try{
			data.write((byte)0);
			data.write(buttonId);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(References.MOD_ID.toLowerCase(), byteStream.toByteArray()));
		}catch(IOException e){
			e.printStackTrace();
			System.err.append("Failed To Send Energy Packet");
		}	
	}
	
	public static void manageButtonEvent(int id, EntityPlayer entPlayer){
		if(entPlayer.openContainer != null && entPlayer.openContainer instanceof ContainerRFController){
			ContainerRFController cont = (ContainerRFController)entPlayer.openContainer;
			TERFController te = cont.getTile();
			TileEntity tile = entPlayer.worldObj.getBlockTileEntity(te.xCoord, te.yCoord, te.zCoord);
			if(tile != null && tile instanceof TERFController){
				te = (TERFController)tile;
				te.receiveButtonEvent(id);
			}
		}
	}
}
