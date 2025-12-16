package com.kjmaster.quintelementa.content.essence;

import net.createmod.catnip.theme.Color;

public class QEColor {

	public static final int AIR_INT = 0xFFFCE458;
	public static final int ARCANE_INT = 0xFF6B3174;
	public static final int EARTH_INT = 0xFF85AB02;
	public static final int FIRE_INT = 0xFFCC4B00;
	public static final int WATER_INT = 0xFF04A988;

	public static final Color AIR = new Color(AIR_INT);
	public static final Color ARCANE = new Color(ARCANE_INT);
	public static final Color EARTH = new Color(EARTH_INT);
	public static final Color FIRE = new Color(FIRE_INT);
	public static final Color WATER = new Color(WATER_INT);

	public static int getFluidColor(String path) {
		if (path.contains("air")) return AIR_INT;
		if (path.contains("arcane")) return ARCANE_INT;
		if (path.contains("earth")) return EARTH_INT;
		if (path.contains("fire")) return FIRE_INT;
		if (path.contains("water")) return WATER_INT;
		return 0xFFFFFFFF; // White Opaque
	}
}
