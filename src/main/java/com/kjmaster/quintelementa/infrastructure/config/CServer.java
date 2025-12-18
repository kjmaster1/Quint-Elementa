package com.kjmaster.quintelementa.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;

import org.jetbrains.annotations.NotNull;

public class CServer extends ConfigBase {

	public final ConfigGroup infrastructure = group(0, "infrastructure", Comments.infrastructure);

	@Override
	public @NotNull String getName() {
		return "server";
	}

	private static class Comments {
		static String infrastructure = "The Backbone of Quint Elementa";
	}
}
