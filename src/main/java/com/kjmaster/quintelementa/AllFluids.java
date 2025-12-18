package com.kjmaster.quintelementa;

import com.kjmaster.quintelementa.api.Element;
import com.kjmaster.quintelementa.foundation.data.QuintElementaRegistrate;
import com.kjmaster.quintelementa.foundation.fluid.TintedFluidType;
import com.tterrag.registrate.util.entry.FluidEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Flowing;

public class AllFluids {

	private static final ResourceLocation WATER_STILL = ResourceLocation.withDefaultNamespace("block/water_still");
	private static final ResourceLocation WATER_FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");

	// The shared texture path for all essence buckets
	private static final ResourceLocation BUCKET_BASE = QuintElementa.asResource("item/essence_bucket");
	private static final ResourceLocation BUCKET_FLUID = QuintElementa.asResource("item/essence_bucket_liquid");

	private static final QuintElementaRegistrate REGISTRATE = QuintElementa.registrate();

	static {
		REGISTRATE.setCreativeTab(AllCreativeModeTabs.BASE_CREATIVE_TAB);
	}

	// Air: Light, gaseous
	public static final FluidEntry<Flowing> AIR_ESSENCE = REGISTRATE
		.fluid("air_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, Element.AIR.colorHex))
		.lang("Air Essence")
		.properties(p -> p
			.density(500)
			.viscosity(100)
			.motionScale(0.02)
			.rarity(Rarity.UNCOMMON))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? Element.AIR.colorHex : -1)
		.build()
		.register();

	// Arcane: Glowing, viscous
	public static final FluidEntry<BaseFlowingFluid.Flowing> ARCANE_ESSENCE = REGISTRATE
		.fluid("arcane_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, Element.ARCANE.colorHex))
		.lang("Arcane Essence")
		.properties(p -> p
			.lightLevel(10)
			.viscosity(2500)
			.density(1500)
			.rarity(Rarity.RARE))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? Element.ARCANE.colorHex : -1)
		.build()
		.register();

	// Earth: Heavy, sludge-like
	public static final FluidEntry<BaseFlowingFluid.Flowing> EARTH_ESSENCE = REGISTRATE
		.fluid("earth_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, Element.EARTH.colorHex))
		.lang("Earth Essence")
		.properties(p -> p
			.viscosity(6000)
			.density(4000)
			.motionScale(0.005))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? Element.EARTH.colorHex : -1)
		.build()
		.register();

	// Fire: Hot, bright
	public static final FluidEntry<BaseFlowingFluid.Flowing> FIRE_ESSENCE = REGISTRATE
		.fluid("fire_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, Element.FIRE.colorHex))
		.lang("Fire Essence")
		.properties(p -> p
			.lightLevel(15)
			.temperature(1300)
			.viscosity(1500)
			.canHydrate(false))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? Element.FIRE.colorHex : -1)
		.build()
		.register();

	// Water: Standard
	public static final FluidEntry<BaseFlowingFluid.Flowing> WATER_ESSENCE = REGISTRATE
		.fluid("water_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, Element.WATER.colorHex))
		.lang("Water Essence")
		.properties(p -> p
			.canHydrate(true)
			.canExtinguish(true)
			.viscosity(1000)
			.density(1000))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? Element.WATER.colorHex : -1)
		.build()
		.register();

	public static void register() {
	}
}
