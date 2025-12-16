package com.kjmaster.quintelementa;

import com.kjmaster.quintelementa.foundation.data.QuintElementaRegistrate;

public class AllBlocks {
	private static final QuintElementaRegistrate REGISTRATE = QuintElementa.registrate();

	static {
		REGISTRATE.setCreativeTab(AllCreativeModeTabs.BASE_CREATIVE_TAB);
	}

	public static void register() {
	}

}
