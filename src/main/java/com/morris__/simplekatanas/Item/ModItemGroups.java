package com.morris__.simplekatanas.Item;

import com.morris__.simplekatanas.SimpleKatanas;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SIMPLE_KATANAS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SimpleKatanas.MOD_ID, "simple_katanas_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.IRON_KATANA))
                    .displayName(Text.translatable("itemgroup.simplekatanas.simple_katanas"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WOODEN_KATANA);
                        entries.add(ModItems.STONE_KATANA);
                        entries.add(ModItems.GOLD_KATANA);
                        entries.add(ModItems.IRON_KATANA);
                        entries.add(ModItems.DIAMOND_KATANA);
                        entries.add(ModItems.NETHERITE_KATANA);
                    }).build());

    public static void registerItemGroups() {
        SimpleKatanas.LOGGER.info("Registering ModItemGroups");
    }
}

