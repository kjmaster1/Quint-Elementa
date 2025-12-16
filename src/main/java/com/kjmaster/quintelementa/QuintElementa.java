package com.kjmaster.quintelementa;

import org.slf4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kjmaster.quintelementa.foundation.data.QuintElementaRegistrate;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(QuintElementa.ID)
public class QuintElementa {

	public static final String ID = "quint_elementa";
	public static final String NAME = "Quint Elementa";

	public static final Logger LOGGER = LogUtils.getLogger();

	private static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
		.disableHtmlEscaping()
		.create();

	private static final QuintElementaRegistrate REGISTRATE = QuintElementaRegistrate.create(ID)
		.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

	public QuintElementa(IEventBus modEventBus, ModContainer modContainer) {

		REGISTRATE.registerEventListeners(modEventBus);

		AllSoundEvents.prepare();
		AllCreativeModeTabs.register(modEventBus);
		AllBlocks.register();
		AllItems.register();
		AllFluids.register();
		AllMenuTypes.register();
		AllBlockEntityTypes.register();
		AllRecipeTypes.register(modEventBus);
		AllParticleTypes.register(modEventBus);
		AllPackets.register();
		AllAttachmentTypes.register(modEventBus);


		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		modEventBus.addListener(AllSoundEvents::register);
	}

	public static ResourceLocation asResource(String path) {
		return ResourceLocation.fromNamespaceAndPath(ID, path);
	}

	public static QuintElementaRegistrate registrate() {
		if (!STACK_WALKER.getCallerClass().getPackageName().startsWith("com.kjmaster.quintelementa"))
			throw new UnsupportedOperationException("Other mods are not permitted to use Quint Elementa's registrate instance.");
		return REGISTRATE;
	}
}
