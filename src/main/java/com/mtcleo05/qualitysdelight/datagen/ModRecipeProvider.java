package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.items.ModCrops;
import com.mtcleo05.qualitycrops.items.ModItems;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
/*
        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("rice_panicle_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRicePanicle", has(getItemFromID("rice_panicle_iron", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("rice_panicle_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRicePanicle", has(getItemFromID("rice_panicle_gold", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("rice_panicle_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRicePanicle", has(getItemFromID("rice_panicle_diamond", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        simpleQualityFoodRecipe("egg", ModItems.VANILLA_QUALITY, "fried_egg", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);

        simpleQualityCuttingRecipe("beef", ModItems.VANILLA_QUALITY, "minced_beef", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("chicken", ModItems.VANILLA_QUALITY, "chicken_cuts", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("porkchop", ModItems.VANILLA_QUALITY, "bacon", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("salmon", ModItems.VANILLA_QUALITY, "salmon_slice", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("cod", ModItems.VANILLA_QUALITY, "cod_slice", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);

 */

        //TODO GEN THIS
        simpleQualityCuttingRecipe("mutton", ModItems.VANILLA_QUALITY, "mutton_chops", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("dough", ModItems.NEW_ITEMS, "raw_pasta", DelightItems.QUALITY_DELIGHT, 1, pFinishedRecipeConsumer);
    }

    public static void simpleFoodRecipe(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        simpleCookingRecipe(pFinishedRecipeConsumer, "smelting", RecipeSerializer.SMELTING_RECIPE, 200, input, output, 0.35F);
        simpleCookingRecipe(pFinishedRecipeConsumer, "smoking", RecipeSerializer.SMOKING_RECIPE, 100, input, output, 0.35F);
        simpleCookingRecipe(pFinishedRecipeConsumer, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600, input, output, 0.35F);
    }

    public static void simpleQualityCuttingRecipe(String input, DeferredRegister<Item> inputRegister, String output, DeferredRegister<Item> outputRegister,int outputCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_iron", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_iron", outputRegister), outputCount).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_gold", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_gold", outputRegister), outputCount).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_diamond", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_diamond", outputRegister), outputCount).build(pFinishedRecipeConsumer);
    }

    public static void simpleQualityFoodRecipe(String input, DeferredRegister<Item> inputRegister, String output, DeferredRegister<Item> outputRegister, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        simpleFoodRecipe(getItemFromID(input + "_iron", inputRegister), getItemFromID(output + "_iron", outputRegister), pFinishedRecipeConsumer);
        simpleFoodRecipe(getItemFromID(input + "_gold", inputRegister), getItemFromID(output + "_gold", outputRegister), pFinishedRecipeConsumer);
        simpleFoodRecipe(getItemFromID(input + "_diamond", inputRegister), getItemFromID(output + "_diamond", outputRegister), pFinishedRecipeConsumer);
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    public static Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> items = register.getEntries().stream().map(RegistryObject::get)::iterator;

        for (Item item : items) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }

        return Items.BARRIER;
    }
}
