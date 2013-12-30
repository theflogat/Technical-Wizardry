package fr.theflogat.technicalWizardry.handler.sync;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.Player;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

public abstract class ModPacket {

	public abstract ByteArrayOutputStream asOutputStream() throws IOException;

	public abstract boolean readPayload(Packet250CustomPayload packet, INetworkManager manager, Player player, String subchannel) throws IOException;

	public abstract String getSubchannel();

	public ByteArrayOutputStream emptyStream() throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(stream);
		writeSubchannel(data);
		return stream;
	}

	public final void skipSubchannel(DataInputStream stream) throws IOException {
		stream.readUTF();
	}

	public final void writeSubchannel(DataOutputStream stream) throws IOException {
		stream.writeUTF(getSubchannel());
	}

}
