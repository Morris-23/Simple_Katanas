package com.morris__.simplekatanas.datagen;

import com.morris__.simplekatanas.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOODEN_KATANA)
                .pattern("  R")
                .pattern(" R ")
                .pattern("T  ")
                .input('R', ItemTags.PLANKS)
                .input('T', Items.STICK)
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .offerTo(recipeExporter, "wooden_katana");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_KATANA)
                .pattern("  R")
                .pattern(" R ")
                .pattern("T  ")
                .input('R', Items.COBBLESTONE)
                .input('T', Items.STICK)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter, "stone_katana");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GOLD_KATANA)
                .pattern("  R")
                .pattern(" R ")
                .pattern("T  ")
                .input('R', Items.GOLD_INGOT)
                .input('T', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter, "gold_katana");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.IRON_KATANA)
                .pattern("  R")
                .pattern(" R ")
                .pattern("T  ")
                .input('R', Items.IRON_INGOT)
                .input('T', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter, "iron_katana");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DIAMOND_KATANA)
                .pattern("  R")
                .pattern(" R ")
                .pattern("T  ")
                .input('R', Items.DIAMOND)
                .input('T', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter, "diamond_katana");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ModItems.DIAMOND_KATANA),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.NETHERITE_KATANA
                )
                .criterion(hasItem(ModItems.DIAMOND_KATANA),
                        conditionsFromItem(ModItems.DIAMOND_KATANA))
                .offerTo(recipeExporter, "netherite_katana_smithing");

    }
}
