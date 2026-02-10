package com.morris__.simplekatanas.datagen;

import com.morris__.simplekatanas.SimpleKatanas;
import com.morris__.simplekatanas.Item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {

        registerKatana(generator, ModItems.WOODEN_KATANA, "wooden_katana");
        registerKatana(generator, ModItems.STONE_KATANA, "stone_katana");
        registerKatana(generator, ModItems.GOLD_KATANA, "gold_katana");
        registerKatana(generator, ModItems.IRON_KATANA, "iron_katana");
        registerKatana(generator, ModItems.DIAMOND_KATANA, "diamond_katana");
        registerKatana(generator, ModItems.NETHERITE_KATANA, "netherite_katana");
    }

    private void registerKatana(ItemModelGenerator generator, Item item, String name) {

        Identifier baseModel =
                Identifier.of(SimpleKatanas.MOD_ID, "item/" + name);

        Identifier blockingModel =
                Identifier.of(SimpleKatanas.MOD_ID, "item/" + name + "_blocking");

        // ⭐ Normale handheld model met override
        Models.HANDHELD.upload(
                baseModel,
                TextureMap.layer0(baseModel),
                generator.writer
        );

        // ⭐ Blocking model
        Models.HANDHELD.upload(
                blockingModel,
                TextureMap.layer0(blockingModel),
                generator.writer
        );
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {}
}