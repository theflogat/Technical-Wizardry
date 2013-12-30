package fr.theflogat.technicalWizardry.handler.sync;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.Player;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEMobMagnet;

public class PacketItemInserterSync extends ModPacket{

	private TEItemInserter itemInser;
	
	public PacketItemInserterSync() { }

	public PacketItemInserterSync(TEItemInserter tile) {
		this.itemInser = tile;
	}
	
	@Override
	public ByteArrayOutputStream asOutputStream() throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(stream);
		writeSubchannel(data);
		data.writeInt(itemInser.xCoord);
		data.writeInt(itemInser.yCoord);
		data.writeInt(itemInser.zCoord);
		//data.writeInt(itemInser.getSlotValue());
		return stream;
	}

	@Override
	public boolean readPayload(Packet250CustomPayload packet,INetworkManager manager, Player player, String subchannel)
			throws IOException {
		if(subchannel.equals(getSubchannel()) && player != null && player instanceof EntityPlayer) {
			ByteArrayInputStream stream = new ByteArrayInputStream(packet.data);
			DataInputStream inputStream = new DataInputStream(stream);
			skipSubchannel(inputStream);
			int x = inputStream.readInt();
			int y = inputStream.readInt();
			int z = inputStream.readInt();
			int slotValue = inputStream.readInt();
			TEItemInserter itemInser = (TEItemInserter) ((EntityPlayer)player).worldObj.getBlockTileEntity(x, y, z);
			itemInser = (TEItemInserter) ((EntityPlayer)player).worldObj.getBlockTileEntity(x, y, z);
			ItemStack stack = PacketManager.getItemStackFromStream(inputStream);
			return true;
		}
		return false;
	}

	@Override
	public String getSubchannel() {
		return References.SUBCHANNEL_ITEMINSETERSYNC;
	}

}
