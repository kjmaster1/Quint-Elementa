package com.kjmaster.quintelementa;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import org.jetbrains.annotations.ApiStatus.Internal;

public class AllAttachmentTypes {

	private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, QuintElementa.ID);

	@Internal
	public static void register(IEventBus modEventBus) {
		ATTACHMENT_TYPES.register(modEventBus);
	}
}
