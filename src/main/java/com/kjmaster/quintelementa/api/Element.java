package com.kjmaster.quintelementa.api;

import org.jetbrains.annotations.NotNull;

import net.minecraft.util.StringRepresentable;

public enum Element implements StringRepresentable {
	AIR("Air"),
	ARCANE("Arcane"),
	EARTH("Earth"),
	FIRE("Fire"),
	WATER("Water");

	public final String properName;

	Element(String properName) {
		this.properName = properName;
	}

	@Override
	public @NotNull String getSerializedName() {
		return name().toLowerCase();
	}
}
