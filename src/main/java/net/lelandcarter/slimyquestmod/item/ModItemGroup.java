package net.lelandcarter.slimyquestmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lelandcarter.slimyquestmod.SlimyQuestMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup SLIMYQUEST;

    public static void registerItemGroups() {
        SLIMYQUEST = FabricItemGroup.builder(new Identifier(SlimyQuestMod.MOD_ID, "slimyquest"))
                .displayName(Text.translatable("itemgroup.slimyquest"))
                .icon(() -> new ItemStack(ModItems.SLIME_INGOT)).build();
    }
}
