package com.kjmaster.quintelementa;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;

public class AllPartialModels {

	private static PartialModel block(String path) {
		return PartialModel.of(QuintElementa.asResource("block/" + path));
	}

	private static PartialModel entity(String path) {
		return PartialModel.of(QuintElementa.asResource("entity/" + path));
	}

	public static void init() {
		// init static fields
	}
}
