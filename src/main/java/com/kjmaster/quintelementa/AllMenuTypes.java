package com.kjmaster.quintelementa;

import com.tterrag.registrate.builders.MenuBuilder.ForgeMenuFactory;
import com.tterrag.registrate.builders.MenuBuilder.ScreenFactory;
import com.tterrag.registrate.util.entry.MenuEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class AllMenuTypes {


	private static <C extends AbstractContainerMenu, S extends Screen & MenuAccess<C>> MenuEntry<C> register(
		String name, ForgeMenuFactory<C> factory, NonNullSupplier<ScreenFactory<C, S>> screenFactory) {
		return QuintElementa.registrate()
			.menu(name, factory, screenFactory)
			.register();
	}

	public static void register() {
	}
}
