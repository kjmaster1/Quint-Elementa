package com.kjmaster.quintelementa.foundation.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class TintedFluidType extends FluidType {
	private final ResourceLocation stillTexture;
	private final ResourceLocation flowingTexture;
	private final int tintColor;
	private final ResourceLocation overlayTexture;

	public TintedFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture, int tintColor) {
		this(properties, stillTexture, flowingTexture, null, tintColor);
	}

	public TintedFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture, @Nullable ResourceLocation overlayTexture, int tintColor) {
		super(properties);
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
		this.overlayTexture = overlayTexture;
		this.tintColor = tintColor;
	}

	@Override
	@SuppressWarnings("removal") // Suppress deprecation warning for NeoForge 1.21
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			@Override
			public @NotNull ResourceLocation getStillTexture() {
				return stillTexture;
			}

			@Override
			public @NotNull ResourceLocation getFlowingTexture() {
				return flowingTexture;
			}

			@Override
			public @Nullable ResourceLocation getOverlayTexture() {
				return overlayTexture;
			}

			@Override
			public int getTintColor() {
				return tintColor;
			}
		});
	}
}
