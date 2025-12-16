package com.kjmaster.quintelementa;

import net.createmod.catnip.net.base.BasePacketPayload;
import net.createmod.catnip.net.base.CatnipPacketRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.Locale;

public enum AllPackets implements BasePacketPayload.PacketTypeProvider {

	;

	static {

	}

	private final CatnipPacketRegistry.PacketType<?> type;

	<T extends BasePacketPayload> AllPackets(Class<T> clazz, StreamCodec<? super RegistryFriendlyByteBuf, T> codec) {
		String name = this.name().toLowerCase(Locale.ROOT);
		this.type = new CatnipPacketRegistry.PacketType<>(
			new CustomPacketPayload.Type<>(QuintElementa.asResource(name)),
			clazz, codec
		);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends CustomPacketPayload> CustomPacketPayload.Type<T> getType() {
		return (CustomPacketPayload.Type<T>) this.type.type();
	}

	public static void register() {
		CatnipPacketRegistry packetRegistry = new CatnipPacketRegistry(QuintElementa.ID, QuintElementaBuildInfo.VERSION);
		for (AllPackets packet : AllPackets.values()) {
			packetRegistry.registerPacket(packet.type);
		}
		packetRegistry.registerAllPackets();
	}
}
