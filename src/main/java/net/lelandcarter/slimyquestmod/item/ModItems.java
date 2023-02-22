package net.lelandcarter.slimyquestmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lelandcarter.slimyquestmod.SlimyQuestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STEEL = registerItem("steel",
            new Item(new FabricItemSettings()));
    public static final Item MIXED_INGOT = registerItem("mixed_ingot",
            new Item(new FabricItemSettings()));
    public static final Item SLIME_INGOT = registerItem("slime_ingot",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SlimyQuestMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, STEEL);
        addToItemGroup(ItemGroups.INGREDIENTS, MIXED_INGOT);
        addToItemGroup(ItemGroups.INGREDIENTS, SLIME_INGOT);

        addToItemGroup(ModItemGroup.SLIMYQUEST, STEEL);
        addToItemGroup(ModItemGroup.SLIMYQUEST, MIXED_INGOT);
        addToItemGroup(ModItemGroup.SLIMYQUEST, SLIME_INGOT);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SlimyQuestMod.LOGGER.info("Registering Mod Items for "+SlimyQuestMod.MOD_ID);

        addItemsToItemGroup();
    }
}
