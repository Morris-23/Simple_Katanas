package com.morris__.simplekatanas.datagen;

import com.morris__.simplekatanas.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.NETHERITE_KATANA)
                .add(ModItems.DIAMOND_KATANA)
                .add(ModItems.IRON_KATANA)
                .add(ModItems.GOLD_KATANA)
                .add(ModItems.STONE_KATANA)
                .add(ModItems.WOODEN_KATANA);
    }

}
