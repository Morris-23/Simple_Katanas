package com.morris__.simplekatanas.Item;

import com.morris__.simplekatanas.Item.custom.KatanaItem;
import com.morris__.simplekatanas.SimpleKatanas;
import com.morris__.simplekatanas.custom.KatanaTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item WOODEN_KATANA;
    public static Item STONE_KATANA;
    public static Item GOLD_KATANA;
    public static Item IRON_KATANA;
    public static Item DIAMOND_KATANA;
    public static Item NETHERITE_KATANA;

    public static void registerModItems() {

        WOODEN_KATANA = registerItem("wooden_katana",
                new KatanaItem(
                        ToolMaterials.WOOD,
                        new Item.Settings()
                                .maxDamage(ToolMaterials.WOOD.getDurability())
                                .attributeModifiers(
                                        SwordItem.createAttributeModifiers(
                                                ToolMaterials.WOOD, 3, -2.8f
                                        )
                                ),
                        KatanaTier.WOOD
                )
        );


        STONE_KATANA = registerItem("stone_katana",
                new KatanaItem(ToolMaterials.STONE, new Item.Settings()
                        .maxDamage(ToolMaterials.STONE.getDurability())
                        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -2.8f)),
                        KatanaTier.STONE));

        GOLD_KATANA = registerItem("gold_katana",
                new KatanaItem(ToolMaterials.GOLD, new Item.Settings()
                        .maxDamage(ToolMaterials.GOLD.getDurability())
                        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 3, -2.8f)),
                        KatanaTier.METAL));

        IRON_KATANA = registerItem("iron_katana",
                new KatanaItem(ToolMaterials.IRON, new Item.Settings()
                        .maxDamage(ToolMaterials.IRON.getDurability())
                        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.8f)),
                        KatanaTier.METAL));

        DIAMOND_KATANA = registerItem("diamond_katana",
                new KatanaItem(ToolMaterials.DIAMOND, new Item.Settings()
                        .maxDamage(ToolMaterials.DIAMOND.getDurability())
                        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.8f)),
                        KatanaTier.METAL));

        NETHERITE_KATANA = registerItem("netherite_katana",
                new KatanaItem(ToolMaterials.NETHERITE, new Item.Settings()
                        .maxDamage(ToolMaterials.NETHERITE.getDurability())
                        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.8f)),
                        KatanaTier.METAL));

        SimpleKatanas.LOGGER.info("Registering Mod Items for " + SimpleKatanas.MOD_ID);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                Identifier.of(SimpleKatanas.MOD_ID, name),
                item);
    }
}
