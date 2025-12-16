package com.kjmaster.quintelementa;

import com.kjmaster.quintelementa.content.essence.QEColor;
import com.kjmaster.quintelementa.content.essence.fluid.TintedFluidType;
import com.kjmaster.quintelementa.foundation.data.QuintElementaRegistrate;
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
			(p, s, f) -> new TintedFluidType(p, s, f, QEColor.AIR_INT))
		.lang("Air Essence")
		.properties(p -> p
			.density(500)
			.viscosity(100)
			.motionScale(0.02)
			.rarity(Rarity.UNCOMMON))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? QEColor.AIR_INT : -1)
		.build()
		.register();

	// Arcane: Glowing, viscous
	public static final FluidEntry<BaseFlowingFluid.Flowing> ARCANE_ESSENCE = REGISTRATE
		.fluid("arcane_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, QEColor.ARCANE_INT))
		.lang("Arcane Essence")
		.properties(p -> p
			.lightLevel(10)
			.viscosity(2500)
			.density(1500)
			.rarity(Rarity.RARE))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? QEColor.ARCANE_INT : -1)
		.build()
		.register();

	// Earth: Heavy, sludge-like
	public static final FluidEntry<BaseFlowingFluid.Flowing> EARTH_ESSENCE = REGISTRATE
		.fluid("earth_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, QEColor.EARTH_INT))
		.lang("Earth Essence")
		.properties(p -> p
			.viscosity(6000)
			.density(4000)
			.motionScale(0.005))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? QEColor.EARTH_INT : -1)
		.build()
		.register();

	// Fire: Hot, bright
	public static final FluidEntry<BaseFlowingFluid.Flowing> FIRE_ESSENCE = REGISTRATE
		.fluid("fire_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, QEColor.FIRE_INT))
		.lang("Fire Essence")
		.properties(p -> p
			.lightLevel(15)
			.temperature(1300)
			.viscosity(1500)
			.canHydrate(false))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? QEColor.FIRE_INT : -1)
		.build()
		.register();

	// Water: Standard
	public static final FluidEntry<BaseFlowingFluid.Flowing> WATER_ESSENCE = REGISTRATE
		.fluid("water_essence", WATER_STILL, WATER_FLOW,
			(p, s, f) -> new TintedFluidType(p, s, f, QEColor.WATER_INT))
		.lang("Water Essence")
		.properties(p -> p
			.canHydrate(true)
			.canExtinguish(true)
			.viscosity(1000)
			.density(1000))
		.source(BaseFlowingFluid.Source::new)
		.bucket()
		.model((ctx, prov) -> prov.generated(ctx::getEntry, BUCKET_BASE, BUCKET_FLUID))
		.color(() -> () -> (stack, tintIndex) -> tintIndex == 1 ? QEColor.WATER_INT : -1)
		.build()
		.register();


	public static void register() {
	}
}
