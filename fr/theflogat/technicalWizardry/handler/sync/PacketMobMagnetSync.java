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
import fr.theflogat.technicalWizardry.tileEntity.TEMobMagnet;
import fr.theflogat.technicalWizardry.lib.References;

public class PacketMobMagnetSync extends ModPacket {

	TEMobMagnet mobMagnet;

	public PacketMobMagnetSync(TEMobMagnet mobMagnet) {
		this.mobMagnet = mobMagnet;
	}

	@Override
	public ByteArrayOutputStream asOutputStream() throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(stream);
		writeSubchannel(data);
		data.writeInt(mobMagnet.xCoord);
		data.writeInt(mobMagnet.yCoord);
		data.writeInt(mobMagnet.zCoord);
		return stream;
	}

	@Override
	public boolean readPayload(Packet250CustomPayload packet, INetworkManager manager, Player player, String subchannel) throws IOException {
		if(subchannel.equals(getSubchannel()) && player != null && player instanceof EntityPlayer) {
			ByteArrayInputStream stream = new ByteArrayInputStream(packet.data);
			DataInputStream inputStream = new DataInputStream(stream);
			skipSubchannel(inputStream);
			int x = inputStream.readInt();
			int y = inputStream.readInt();
			int z = inputStream.readInt();
			TEMobMagnet mobMagnet = (TEMobMagnet) ((EntityPlayer)player).worldObj.getBlockTileEntity(x, y, z);
			ItemStack stack = PacketManager.getItemStackFromStream(inputStream);
			return true;
		}
		return false;
	}

	@Override
	public String getSubchannel() {
		return References.SUBCHANNEL_MOBMAGNETSYNC;
	}
}
