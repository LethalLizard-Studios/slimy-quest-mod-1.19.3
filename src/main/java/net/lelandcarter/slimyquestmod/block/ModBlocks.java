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
                    UniformIntProvider.create(1, 2)), ItemGroups.NATURAL, 64);
    public static final Block ROCKY_WORM_DIRT = registerBlock("rocky_worm_block",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(1.0f).sounds(BlockSoundGroup.GRAVEL).requiresTool(),
                    UniformIntProvider.create(1, 2)), ItemGroups.NATURAL, 64);

    public static final Block COMPOSTINGBIN = registerBlock("compostingbin",
            new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.0f).sounds(BlockSoundGroup.WOOD)), ItemGroups.FUNCTIONAL, 16);
    public static final Block COMPOSTINGBIN_FULL = registerBlock("compostingbin_full",
            new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).strength(1.0f).sounds(BlockSoundGroup.WOOD)), ItemGroups.FUNCTIONAL, 16);
    public static final Block ROCKET = registerBlock("rocket",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.WHITE_GRAY).strength(2.0f).sounds(BlockSoundGroup.LANTERN).requiresTool()), ItemGroups.FUNCTIONAL, 1);

    private static Block registerBlock(String name, Block block, ItemGroup group, int maxCount) {
        registerBlockItem(name, block, group, maxCount);
        return Registry.register(Registries.BLOCK, new Identifier(SlimyQuestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, int maxCount) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SlimyQuestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().maxCount(maxCount)));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SLIMYQUEST).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        SlimyQuestMod.LOGGER.info("Registering ModBlocks for "+SlimyQuestMod.MOD_ID);
    }
}
