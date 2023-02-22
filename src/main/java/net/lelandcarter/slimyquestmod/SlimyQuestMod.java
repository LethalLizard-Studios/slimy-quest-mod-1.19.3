package net.lelandcarter.slimyquestmod;

import net.fabricmc.api.ModInitializer;

import net.lelandcarter.slimyquestmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlimyQuestMod implements ModInitializer {
	public static final String MOD_ID = "slimyquestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger("slimyquestmod");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}