package com.kjmaster.quintelementa.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;

import org.jetbrains.annotations.NotNull;

public class CEssence extends ConfigBase {

	public final ConfigBool disableFlux = b(false, "disableFlux", Comments.disableFlux);

	public final ConfigFloat mediumSpeed = f(30, 0, 4096, "mediumSpeed", Comments.epm, Comments.mediumSpeed);
	public final ConfigFloat fastSpeed = f(100, 0, 65535, "fastSpeed", Comments.epm, Comments.fastSpeed);

	@Override
	public @NotNull String getName() {
		return "essence";
	}

	private static class Comments {
		static String mediumSpeed = "Minimum speed of essence flow to be considered 'medium'";
		static String fastSpeed = "Minimum speed of essence flow to be considered 'fast'";
		static String epm = "[in Essence per Minute]";
		static String disableFlux = "Disable the Flux mechanic altogether.";
	}
}
