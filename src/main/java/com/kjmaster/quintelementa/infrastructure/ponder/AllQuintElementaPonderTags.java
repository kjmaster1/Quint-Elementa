package com.kjmaster.quintelementa.infrastructure.ponder;

import com.kjmaster.quintelementa.AllFluids;
import com.kjmaster.quintelementa.QuintElementa;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class AllQuintElementaPonderTags {

	public static final ResourceLocation

	AIR = loc("air"),
	ARCANE = loc("arcane"),
	EARTH = loc("earth"),
	FIRE = loc("fire"),
	WATER = loc("water");

	private static ResourceLocation loc(String id) {
		return QuintElementa.asResource(id);
	}

	public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {

		PonderTagRegistrationHelper<RegistryEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

		PonderTagRegistrationHelper<ItemLike> itemHelper = helper.withKeyFunction(
			RegisteredObjectsHelper::getKeyOrThrow);

		helper.registerTag(AIR)
			.addToIndex()
			.item(AllFluids.AIR_ESSENCE.getBucket().orElseThrow(), true, false)
			.title("Air")
			.description("Air Element")
			.register();

		helper.registerTag(ARCANE)
			.addToIndex()
			.item(AllFluids.ARCANE_ESSENCE.getBucket().orElseThrow(), true, false)
			.title("Arcane")
			.description("Arcane Element")
			.register();

		helper.registerTag(EARTH)
			.addToIndex()
			.item(AllFluids.EARTH_ESSENCE.getBucket().orElseThrow(), true, false)
			.title("Earth")
			.description("Earth Element")
			.register();

		helper.registerTag(FIRE)
			.addToIndex()
			.item(AllFluids.FIRE_ESSENCE.getBucket().orElseThrow(), true, false)
			.title("Fire")
			.description("Fire Element")
			.register();

		helper.registerTag(WATER)
			.addToIndex()
			.item(AllFluids.WATER_ESSENCE.getBucket().orElseThrow(), true, false)
			.title("Water")
			.description("Water Element")
			.register();

		HELPER.addToTag(AIR)
			.add(AllFluids.AIR_ESSENCE);

		itemHelper.addToTag(AIR)
			.add(AllFluids.AIR_ESSENCE.getBucket().orElseThrow());

		HELPER.addToTag(ARCANE)
			.add(AllFluids.ARCANE_ESSENCE);

		itemHelper.addToTag(ARCANE)
			.add(AllFluids.ARCANE_ESSENCE.getBucket().orElseThrow());

		HELPER.addToTag(EARTH)
			.add(AllFluids.EARTH_ESSENCE);

		itemHelper.addToTag(EARTH)
			.add(AllFluids.EARTH_ESSENCE.getBucket().orElseThrow());

		HELPER.addToTag(FIRE)
			.add(AllFluids.FIRE_ESSENCE);

		itemHelper.addToTag(FIRE)
			.add(AllFluids.FIRE_ESSENCE.getBucket().orElseThrow());

		HELPER.addToTag(WATER)
			.add(AllFluids.WATER_ESSENCE);

		itemHelper.addToTag(WATER)
			.add(AllFluids.WATER_ESSENCE.getBucket().orElseThrow());
	}
}
