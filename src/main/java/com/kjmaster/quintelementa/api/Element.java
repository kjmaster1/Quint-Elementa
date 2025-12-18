package com.kjmaster.quintelementa.api;

import net.createmod.catnip.theme.Color;

import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;

import net.minecraft.util.StringRepresentable;

public enum Element implements StringRepresentable {
	AIR("Air", 0xFFFCE458),
	ARCANE("Arcane", 0xFF6B3174),
	EARTH("Earth", 0xFF85AB02),
	FIRE("Fire", 0xFFCC4B00),
	WATER("Water", 0xFF04A988);

	public final int colorHex;
	public final Color color;
	public final String properName;

	Element(String properName, int colorHex) {
		this.properName = properName;
		this.colorHex = colorHex;
		this.color = new Color(colorHex);
	}

	@Override
	public @NotNull String getSerializedName() {
		return name().toLowerCase();
	}

	public static int getFluidColorInt(String path) {
		if (path.contains("air")) return AIR.colorHex;
		if (path.contains("arcane")) return ARCANE.colorHex;
		if (path.contains("earth")) return EARTH.colorHex;
		if (path.contains("fire")) return FIRE.colorHex;
		if (path.contains("water")) return WATER.colorHex;
		return 0xFFFFFFFF; // White Opaque
	}

	public static Color getFluidColor(String path) {
		if (path.contains("air")) return AIR.color;
		if (path.contains("arcane")) return ARCANE.color;
		if (path.contains("earth")) return EARTH.color;
		if (path.contains("fire")) return FIRE.color;
		if (path.contains("water")) return WATER.color;
		return new Color(0xFFFFFFFF); // White Opaque
	}
}
