package com.morris__.simplekatanas;

import com.morris__.simplekatanas.Item.ModItemGroups;
import com.morris__.simplekatanas.Item.ModItems;
import com.morris__.simplekatanas.custom.ModEvents;
import com.morris__.simplekatanas.custom.ModItemProperties;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleKatanas implements ModInitializer {
	public static final String MOD_ID = "simple_katanas";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModItemProperties.register();
        ModEvents.registerEvents();

	}
}