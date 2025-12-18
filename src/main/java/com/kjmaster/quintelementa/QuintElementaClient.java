package com.kjmaster.quintelementa;

import com.kjmaster.quintelementa.foundation.ponder.QuintElementaPonderPlugin;

import net.createmod.ponder.foundation.PonderIndex;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = QuintElementa.ID, dist = Dist.CLIENT)
public class QuintElementaClient {
	public QuintElementaClient(IEventBus modEventBus, ModContainer container) {
		modEventBus.addListener(QuintElementaClient::clientInit);
	}

	public static void clientInit(final FMLClientSetupEvent event) {
		AllPartialModels.init();
		PonderIndex.addPlugin(new QuintElementaPonderPlugin());
	}
}
