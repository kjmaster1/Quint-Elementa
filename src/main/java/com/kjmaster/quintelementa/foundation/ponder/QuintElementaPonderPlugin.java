package com.kjmaster.quintelementa.foundation.ponder;

import com.kjmaster.quintelementa.QuintElementa;

import com.kjmaster.quintelementa.infrastructure.ponder.AllQuintElementaPonderTags;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

import org.jetbrains.annotations.NotNull;

public class QuintElementaPonderPlugin implements PonderPlugin {

	@Override
	public @NotNull String getModId() {
		return QuintElementa.ID;
	}

	@Override
	public void registerTags(@NotNull PonderTagRegistrationHelper<ResourceLocation> helper) {
		AllQuintElementaPonderTags.register(helper);
	}

	@Override
	public void registerScenes(@NotNull PonderSceneRegistrationHelper<ResourceLocation> helper) {
		// Scenes will be registered here in future steps
	}
}
