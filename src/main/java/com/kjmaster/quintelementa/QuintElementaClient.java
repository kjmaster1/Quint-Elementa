package com.kjmaster.quintelementa;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = QuintElementa.ID, dist = Dist.CLIENT)
public class QuintElementaClient {
	public QuintElementaClient(IEventBus modEventBus, ModContainer container) {
		container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

		modEventBus.addListener(QuintElementaClient::clientInit);
	}

	public static void clientInit(final FMLClientSetupEvent event) {
		AllPartialModels.init();
	}
}
