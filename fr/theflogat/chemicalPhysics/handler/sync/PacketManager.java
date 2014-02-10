package fr.theflogat.chemicalPhysics.handler.sync;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityCPU;
import fr.theflogat.chemicalPhysics.tileEntity.container.ContainerCPU;

public class PacketManager implements IPacketHandler{
	@Override
	public void onPacketData(INetworkManager handler, Packet250CustomPayload packet, Player player) {
		ByteArrayInputStream reader = new ByteArrayInputStream(packet.data);
		
		int pckID = reader.read();
		EntityPlayer entPlayer = (EntityPlayer)player;
		switch(pckID){
		case 0:
			Container cont = entPlayer.openContainer;
			if(cont!=null && cont instanceof ContainerCPU){
				ContainerCPU contCPU = (ContainerCPU)cont;
				TileEntityCPU tile = contCPU.getTile();
			}
		
		
		
		}
	}
	
	public static void sendEnergyPacket(int pow){
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(byteStream);
		
		try{
			data.write((byte)0);
			data.write(pow);
		}catch(IOException e){
			e.printStackTrace();
			System.err.append("Failed To Send Energy Packet");
		}		
	}
}
