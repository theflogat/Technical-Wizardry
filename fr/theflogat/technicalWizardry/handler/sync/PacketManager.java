package fr.theflogat.technicalWizardry.handler.sync;

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
import cpw.mods.fml.common.network.Player;
import fr.theflogat.redstoneFluxControl.ContainerRFController;
import fr.theflogat.redstoneFluxControl.TERFController;

public class PacketManager implements IPacketHandler {
	@Override
	public void onPacketData(INetworkManager handler, Packet250CustomPayload packet, Player player) {
		ByteArrayInputStream reader = new ByteArrayInputStream(packet.data);
		
		int pckID = reader.read();
		EntityPlayer entPlayer = (EntityPlayer)player;
		
		switch(pckID){
		case 0:
			
			break;
		}
	}
}
