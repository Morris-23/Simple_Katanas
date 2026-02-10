package com.morris__.simplekatanas.custom;

import com.morris__.simplekatanas.Item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModItemProperties {

    private static final Item[] KATANAS = {
            ModItems.WOODEN_KATANA,
            ModItems.STONE_KATANA,
            ModItems.GOLD_KATANA,
            ModItems.IRON_KATANA,
            ModItems.DIAMOND_KATANA,
            ModItems.NETHERITE_KATANA
    };

    public static void register() {
        for (Item katana : KATANAS) {
            registerBlocking(katana);
        }
    }

    private static void registerBlocking(Item item) {
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.of("simple_katanas", "blocking"),
                (stack, world, entity, seed) -> {
                    if (entity == null) return 0f;
                    return entity.isUsingItem() &&
                            entity.getActiveItem() == stack
                            ? 1f : 0f;
                }
        );
    }
}
