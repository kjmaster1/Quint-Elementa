package com.kjmaster.quintelementa.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;

import org.jetbrains.annotations.NotNull;

public class CClient extends ConfigBase {

	public final ConfigGroup client = group(0, "client",
		Comments.client);

	@Override
	public @NotNull String getName() {
		return "client";
	}

	private static class Comments {
		static String client = "Client-only settings - If you're looking for general settings, look inside your worlds serverconfig folder!";
	}
}
