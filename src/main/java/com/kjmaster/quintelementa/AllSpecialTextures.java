package com.kjmaster.quintelementa;

import org.jetbrains.annotations.NotNull;

import net.createmod.catnip.render.BindableTexture;
import net.minecraft.resources.ResourceLocation;

public enum AllSpecialTextures implements BindableTexture {

	;

	public static final String ASSET_PATH = "textures/special/";
	private final ResourceLocation location;

	AllSpecialTextures(String filename) {
		location = QuintElementa.asResource(ASSET_PATH + filename);
	}

	public @NotNull ResourceLocation getLocation() {
		return location;
	}
}
