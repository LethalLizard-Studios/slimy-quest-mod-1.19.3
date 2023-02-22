package net.lelandcarter.slimyquestmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lelandcarter.slimyquestmod.SlimyQuestMod;
import net.lelandcarter.slimyquestmod.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block WORM_DIRT = registerBlock("worm_block",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.7f).sounds(BlockSoundGroup.GRAVEL),
                    UniformIntProvider.create(2, 4)), ItemGroups.NATURAL);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SlimyQuestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SlimyQuestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SLIMYQUEST).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        SlimyQuestMod.LOGGER.info("Registering ModBlocks for "+SlimyQuestMod.MOD_ID);
    }
}