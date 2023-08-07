package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.items.ModCrops;
import com.mtcleo05.qualitycrops.items.ModItems;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.item.OceanItems;
import com.mtcleo05.qualitysdelight.item.DelightFoods;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import com.mtcleo05.qualitysdelight.tags.ModTags;
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
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.nethersdelight.common.registry.NDItems;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.awt.*;
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
        simpleQualityCuttingRecipe("mutton", ModItems.VANILLA_QUALITY, "mutton_chops", DelightItems.QUALITY_DELIGHT, 2, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipe("dough", ModItems.NEW_ITEMS, "raw_pasta", DelightItems.QUALITY_DELIGHT, 1, pFinishedRecipeConsumer);

        simpleQualityCuttingRecipeVanillaAddition("cabbage", DelightItems.QUALITY_DELIGHT, "cabbage_leaf", DelightItems.QUALITY_DELIGHT, 2, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("cooked_chicken", ModItems.VANILLA_QUALITY, "cooked_chicken_cuts", DelightItems.QUALITY_DELIGHT, 2, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("cooked_cod", ModItems.VANILLA_QUALITY, "cooked_cod_slice", DelightItems.QUALITY_DELIGHT, 2, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("cooked_salmon", ModItems.VANILLA_QUALITY, "cooked_salmon_slice", DelightItems.QUALITY_DELIGHT, 2, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("cooked_mutton", ModItems.VANILLA_QUALITY, "cooked_mutton_chops", DelightItems.QUALITY_DELIGHT, 2, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);

        simpleQualityFoodRecipe("minced_beef", DelightItems.QUALITY_DELIGHT, "beef_patty", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("bacon", DelightItems.QUALITY_DELIGHT, "cooked_bacon", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("chicken_cuts", DelightItems.QUALITY_DELIGHT, "cooked_chicken_cuts", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("cod_slice", DelightItems.QUALITY_DELIGHT, "cooked_cod_slice", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("salmon_slice", DelightItems.QUALITY_DELIGHT, "cooked_salmon_slice", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("mutton_chops", DelightItems.QUALITY_DELIGHT, "cooked_mutton_chops", DelightItems.QUALITY_DELIGHT, pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCabbageLeaf", has(getItemFromID("cabbage_leaf_iron", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCabbageLeaf", has(getItemFromID("cabbage_leaf_gold", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cabbage_leaf_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCabbageLeaf", has(getItemFromID("cabbage_leaf_diamond", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mixed_salad_iron", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_sandwich_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("hamburger_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("beef_patty_iron", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mutton_wrap_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(ModTags.IRON_COOKED_MUTTON)
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("chicken_sandwich_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(ModTags.IRON_COOKED_CHICKEN)
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("carrot_iron", ModCrops.CROPS))
                .unlockedBy("hasIron", has(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("grilled_salmon_iron", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.IRON_COOKED_SALMON)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.BOWL)
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mixed_salad_gold", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_sandwich_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("hamburger_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("beef_patty_gold", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mutton_wrap_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(ModTags.GOLD_COOKED_MUTTON)
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("chicken_sandwich_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(ModTags.GOLD_COOKED_CHICKEN)
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("carrot_gold", ModCrops.CROPS))
                .unlockedBy("hasIron", has(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("grilled_salmon_gold", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.GOLD_COOKED_SALMON)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.BOWL)
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mixed_salad_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_sandwich_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("hamburger_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("beef_patty_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("mutton_wrap_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(ModTags.DIAMOND_COOKED_MUTTON)
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasIron", has(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("chicken_sandwich_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(ModTags.DIAMOND_COOKED_CHICKEN)
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .unlockedBy("hasIron", has(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("grilled_salmon_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(ModTags.DIAMOND_COOKED_SALMON)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.BOWL)
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

                ShapelessRecipeBuilder.shapeless(getItemFromID("sweet_berry_cookie_iron", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("wheat_iron", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasSweet", has(Items.SWEET_BERRIES))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_cookie_iron", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.HONEY_BOTTLE)
                .requires(getItemFromID("wheat_iron", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasHoney", has(Items.HONEY_BOTTLE))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fruit_salad_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("apple_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_iron", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.BERRIES)
                .requires(ForgeTags.BERRIES)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("egg_sandwich_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("fried_egg_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBread", has(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_and_eggs_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("fried_egg_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_potato_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .requires(ModTags.IRON_COOKED_BEEF)
                .requires(ForgeTags.MILK)
                .unlockedBy("hasMilk", has(ForgeTags.MILK))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("barbecue_stick_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("melon_popsicle_iron", DelightItems.QUALITY_DELIGHT))
                .define('M', getItemFromID("melon_slice_iron", ModItems.VANILLA_QUALITY))
                .define('S', Items.STICK)
                .define('I', Items.ICE)
                .pattern(" MM")
                .pattern("IMM")
                .pattern("SI ")
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("sweet_berry_cookie_gold", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("wheat_gold", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasSweet", has(Items.SWEET_BERRIES))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_cookie_gold", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.HONEY_BOTTLE)
                .requires(getItemFromID("wheat_gold", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasHoney", has(Items.HONEY_BOTTLE))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fruit_salad_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("apple_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_gold", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.BERRIES)
                .requires(ForgeTags.BERRIES)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("egg_sandwich_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("fried_egg_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBread", has(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_and_eggs_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("fried_egg_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_potato_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .requires(ModTags.GOLD_COOKED_BEEF)
                .requires(ForgeTags.MILK)
                .unlockedBy("hasMilk", has(ForgeTags.MILK))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("barbecue_stick_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("melon_popsicle_gold", DelightItems.QUALITY_DELIGHT))
                .define('M', getItemFromID("melon_slice_gold", ModItems.VANILLA_QUALITY))
                .define('S', Items.STICK)
                .define('I', Items.ICE)
                .pattern(" MM")
                .pattern("IMM")
                .pattern("SI ")
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("sweet_berry_cookie_diamond", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("wheat_diamond", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasSweet", has(Items.SWEET_BERRIES))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_cookie_diamond", DelightItems.QUALITY_DELIGHT), 8)
                .requires(Items.HONEY_BOTTLE)
                .requires(getItemFromID("wheat_diamond", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasHoney", has(Items.HONEY_BOTTLE))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fruit_salad_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("apple_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("melon_slice_diamond", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.BERRIES)
                .requires(ForgeTags.BERRIES)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("egg_sandwich_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("fried_egg_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBread", has(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("bacon_and_eggs_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("fried_egg_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("fried_egg_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_potato_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .requires(ModTags.DIAMOND_COOKED_BEEF)
                .requires(ForgeTags.MILK)
                .unlockedBy("hasMilk", has(ForgeTags.MILK))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("barbecue_stick_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("melon_popsicle_diamond", DelightItems.QUALITY_DELIGHT))
                .define('M', getItemFromID("melon_slice_diamond", ModItems.VANILLA_QUALITY))
                .define('S', Items.STICK)
                .define('I', Items.ICE)
                .pattern(" MM")
                .pattern("IMM")
                .pattern("SI ")
                .unlockedBy("hasStick", has(Items.STICK))
                .save(pFinishedRecipeConsumer);



        ShapelessRecipeBuilder.shapeless(getItemFromID("salmon_roll_iron", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSalmon", has(getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cod_roll_iron", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("steak_and_potatoes_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("cooked_beef_iron", ModItems.VANILLA_QUALITY))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);



        ShapedRecipeBuilder.shaped(getItemFromID("kelp_roll_iron", DelightItems.QUALITY_DELIGHT))
                .define('R', getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .define('C', getItemFromID("carrot_iron", ModCrops.CROPS))
                .define('K', getItemFromID("dried_kelp_iron", ModItems.VANILLA_QUALITY))
                .pattern("RCR")
                .pattern("KKK")
                .unlockedBy("hasRice", has(getItemFromID("cooked_rice_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("salmon_roll_gold", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSalmon", has(getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cod_roll_gold", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("steak_and_potatoes_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("cooked_beef_gold", ModItems.VANILLA_QUALITY))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);



        ShapedRecipeBuilder.shaped(getItemFromID("kelp_roll_gold", DelightItems.QUALITY_DELIGHT))
                .define('R', getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .define('C', getItemFromID("carrot_gold", ModCrops.CROPS))
                .define('K', getItemFromID("dried_kelp_gold", ModItems.VANILLA_QUALITY))
                .pattern("RCR")
                .pattern("KKK")
                .unlockedBy("hasRice", has(getItemFromID("cooked_rice_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("salmon_roll_diamond", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSalmon", has(getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cod_roll_diamond", DelightItems.QUALITY_DELIGHT), 2)
                .requires(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("steak_and_potatoes_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("cooked_beef_diamond", ModItems.VANILLA_QUALITY))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);



        ShapedRecipeBuilder.shaped(getItemFromID("kelp_roll_diamond", DelightItems.QUALITY_DELIGHT))
                .define('R', getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .define('C', getItemFromID("carrot_diamond", ModCrops.CROPS))
                .define('K', getItemFromID("dried_kelp_diamond", ModItems.VANILLA_QUALITY))
                .pattern("RCR")
                .pattern("KKK")
                .unlockedBy("hasRice", has(getItemFromID("cooked_rice_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        simpleQualityCuttingRecipe("kelp_roll", DelightItems.QUALITY_DELIGHT, "kelp_roll_slice", DelightItems.QUALITY_DELIGHT, 3, pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT), 1, 100, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRice", has(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT), 1, 100, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRice", has(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT), 1, 100, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRice", has(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("roasted_mutton_chops_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_mutton_chops_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("roasted_mutton_chops_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_mutton_chops_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("roasted_mutton_chops_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_mutton_chops_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

                CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("tomato_sauce_iron", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("bone_broth_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Items.BONE)
                .addIngredient(Ingredient.of(getItemFromID("red_mushroom_iron", ModCrops.CROPS), getItemFromID("brown_mushroom_iron", ModCrops.CROPS)))
                .unlockedBy("hasBone", has(Items.BONE))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beef_stew_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("beef_iron", ModItems.VANILLA_QUALITY), getItemFromID("minced_beef_iron", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_iron", ModCrops.CROPS))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("chicken_soup_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("chicken_iron", ModItems.VANILLA_QUALITY), getItemFromID("chicken_cuts_iron", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("beetroot_iron", ModCrops.CROPS),
                        getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_soup_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

                CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("tomato_sauce_gold", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("bone_broth_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Items.BONE)
                .addIngredient(Ingredient.of(getItemFromID("red_mushroom_gold", ModCrops.CROPS), getItemFromID("brown_mushroom_gold", ModCrops.CROPS)))
                .unlockedBy("hasBone", has(Items.BONE))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beef_stew_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("beef_gold", ModItems.VANILLA_QUALITY), getItemFromID("minced_beef_gold", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_gold", ModCrops.CROPS))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("chicken_soup_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("chicken_gold", ModItems.VANILLA_QUALITY), getItemFromID("chicken_cuts_gold", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("beetroot_gold", ModCrops.CROPS),
                        getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_soup_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("tomato_sauce_diamond", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("bone_broth_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Items.BONE)
                .addIngredient(Ingredient.of(getItemFromID("red_mushroom_diamond", ModCrops.CROPS), getItemFromID("brown_mushroom_diamond", ModCrops.CROPS)))
                .unlockedBy("hasBone", has(Items.BONE))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beef_stew_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("beef_diamond", ModItems.VANILLA_QUALITY), getItemFromID("minced_beef_diamond", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_diamond", ModCrops.CROPS))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("chicken_soup_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("chicken_diamond", ModItems.VANILLA_QUALITY), getItemFromID("chicken_cuts_diamond", DelightItems.QUALITY_DELIGHT)))
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("beetroot_diamond", ModCrops.CROPS),
                        getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_soup_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 0.35f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .unlockedBy("hasCarrot", has(getItemFromID("carrot_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

                CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fish_stew_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.IRON_RAW_FISHES)
                .addIngredient(getItemFromID("tomato_sauce_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRawFish", has(ModTags.IRON_RAW_FISHES))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fried_rice_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasEgg", has(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pumpkin_soup_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .addIngredient(ModTags.IRON_RAW_PORK)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("hasPumpkinSlice", has(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get()))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("baked_cod_stew_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.IRON_RAW_COD)
                .addIngredient(getItemFromID("potato_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(ModTags.IRON_RAW_COD))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("noodle_soup_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("fried_egg_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("dried_kelp_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(ModTags.IRON_RAW_PORK)
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fish_stew_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.GOLD_RAW_FISHES)
                .addIngredient(getItemFromID("tomato_sauce_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRawFishes", has(ModTags.GOLD_RAW_FISHES))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fried_rice_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasEgg", has(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pumpkin_soup_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .addIngredient(ModTags.GOLD_RAW_PORK)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("hasPumpkinSlice", has(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get()))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("baked_cod_stew_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.GOLD_RAW_COD)
                .addIngredient(getItemFromID("potato_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(ModTags.GOLD_RAW_COD))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("noodle_soup_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("fried_egg_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("dried_kelp_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(ModTags.GOLD_RAW_PORK)
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fish_stew_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.DIAMOND_RAW_FISHES)
                .addIngredient(getItemFromID("tomato_sauce_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasRawFishes", has(ModTags.DIAMOND_RAW_FISHES))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("fried_rice_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasEgg", has(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pumpkin_soup_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get())
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .addIngredient(ModTags.DIAMOND_RAW_PORK)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("hasPumpkinSlice", has(vectorwing.farmersdelight.common.registry.ModItems.PUMPKIN_SLICE.get()))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("baked_cod_stew_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(ModTags.DIAMOND_RAW_COD)
                .addIngredient(getItemFromID("potato_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasCod", has(ModTags.DIAMOND_RAW_COD))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("noodle_soup_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1.0f, Items.BOWL)
                .addIngredient(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("fried_egg_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("dried_kelp_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(ModTags.DIAMOND_RAW_PORK)
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

                CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_meatballs_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("minced_beef_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMincedBeef", has(getItemFromID("minced_beef_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_mutton_chop_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("mutton_chops_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_iron", ModItems.VANILLA_QUALITY)))
                .addIngredient(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMuttonChops", has(getItemFromID("mutton_chops_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_rice_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Ingredient.of(getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS)))
                .unlockedBy("hasRice", has(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_noodles_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("ratatouille_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .addIngredient(Ingredient.of(getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("squid_ink_pasta_iron", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(ModTags.IRON_RAW_FISHES)
                .addIngredient(getItemFromID("raw_pasta_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Items.INK_SAC)
                .unlockedBy("hasInk", has(Items.INK_SAC))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_meatballs_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("minced_beef_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMincedBeef", has(getItemFromID("minced_beef_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_mutton_chop_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("mutton_chops_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_gold", ModItems.VANILLA_QUALITY)))
                .addIngredient(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMuttonChops", has(getItemFromID("mutton_chops_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_rice_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Ingredient.of(getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS)))
                .unlockedBy("hasRice", has(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_noodles_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("ratatouille_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .addIngredient(Ingredient.of(getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("squid_ink_pasta_gold", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(ModTags.GOLD_RAW_FISHES)
                .addIngredient(getItemFromID("raw_pasta_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Items.INK_SAC)
                .unlockedBy("hasInk", has(Items.INK_SAC))
                .build(pFinishedRecipeConsumer);
        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_meatballs_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("minced_beef_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMincedBeef", has(getItemFromID("minced_beef_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("pasta_with_mutton_chop_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("mutton_chops_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_diamond", ModItems.VANILLA_QUALITY)))
                .addIngredient(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_sauce_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasMuttonChops", has(getItemFromID("mutton_chops_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_rice_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Ingredient.of(getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS)))
                .unlockedBy("hasRice", has(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("vegetable_noodles_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasPasta", has(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("ratatouille_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .addIngredient(Ingredient.of(getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasTomato", has(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("squid_ink_pasta_diamond", DelightItems.QUALITY_DELIGHT), 1, 600, 1f, Items.BOWL)
                .addIngredient(ModTags.DIAMOND_RAW_FISHES)
                .addIngredient(getItemFromID("raw_pasta_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(Items.INK_SAC)
                .unlockedBy("hasInk", has(Items.INK_SAC))
                .build(pFinishedRecipeConsumer);


        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("dumplings_iron", DelightItems.QUALITY_DELIGHT), 2, 600, 1f)
                .addIngredient(getItemFromID("dough_iron", ModItems.NEW_ITEMS))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("beetroot_iron", ModCrops.CROPS),
                        getItemFromID("beef_iron", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_iron", ModItems.VANILLA_QUALITY), getItemFromID("chicken_iron", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_iron", ModItems.VANILLA_QUALITY), getItemFromID("brown_mushroom_iron", ModCrops.CROPS),
                        getItemFromID("minced_beef_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_iron", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_iron", DelightItems.QUALITY_DELIGHT)
                ))
                .unlockedBy("hasCabbage", has(ModTags.IRON_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beetroot_soup_iron", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_iron", ModCrops.CROPS))
                .unlockedBy("hasBeetroot", has(getItemFromID("beetroot_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_stew_iron", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_iron", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("rabbit_stew_iron", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("rabbit_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_iron", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);



        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("dumplings_gold", DelightItems.QUALITY_DELIGHT), 2, 600, 1f)
                .addIngredient(getItemFromID("dough_gold", ModItems.NEW_ITEMS))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("beetroot_gold", ModCrops.CROPS),
                        getItemFromID("beef_gold", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_gold", ModItems.VANILLA_QUALITY), getItemFromID("chicken_gold", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_gold", ModItems.VANILLA_QUALITY), getItemFromID("brown_mushroom_gold", ModCrops.CROPS),
                        getItemFromID("minced_beef_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_gold", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_gold", DelightItems.QUALITY_DELIGHT)
                ))
                .unlockedBy("hasCabbage", has(ModTags.GOLD_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beetroot_soup_gold", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_gold", ModCrops.CROPS))
                .unlockedBy("hasBeetroot", has(getItemFromID("beetroot_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_stew_gold", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_gold", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("rabbit_stew_gold", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("rabbit_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_gold", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);



        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("dumplings_diamond", DelightItems.QUALITY_DELIGHT), 2, 600, 1f)
                .addIngredient(getItemFromID("dough_diamond", ModItems.NEW_ITEMS))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("beetroot_diamond", ModCrops.CROPS),
                        getItemFromID("beef_diamond", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_diamond", ModItems.VANILLA_QUALITY), getItemFromID("chicken_diamond", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_diamond", ModItems.VANILLA_QUALITY), getItemFromID("brown_mushroom_diamond", ModCrops.CROPS),
                        getItemFromID("minced_beef_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_diamond", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_diamond", DelightItems.QUALITY_DELIGHT)
                ))
                .unlockedBy("hasCabbage", has(ModTags.DIAMOND_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("beetroot_soup_diamond", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("beetroot_diamond", ModCrops.CROPS))
                .unlockedBy("hasBeetroot", has(getItemFromID("beetroot_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("mushroom_stew_diamond", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("red_mushroom_diamond", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("rabbit_stew_diamond", ModItems.VANILLA_QUALITY), 1, 600, 1f, Items.BOWL)
                .addIngredient(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("rabbit_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .unlockedBy("hasMushroom", has(getItemFromID("red_mushroom_diamond", ModCrops.CROPS)))
                .build(pFinishedRecipeConsumer);

                ShapelessRecipeBuilder.shapeless(getItemFromID("roast_chicken_block_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bread_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_iron", ModCrops.CROPS))
                .requires(getItemFromID("cooked_chicken_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_iron", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_pumpkin_block_iron", DelightItems.QUALITY_DELIGHT), 1, 20, 2.0f, Items.PUMPKIN)
                .addIngredient(getItemFromID("rice_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_iron", ModCrops.CROPS))
                .addIngredient(ForgeTags.BERRIES)
                .addIngredient(Ingredient.of(getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("beetroot_iron", ModCrops.CROPS), getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasBerries", has(ForgeTags.BERRIES))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("shepherds_pie_block_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.MILK)
                .requires(getItemFromID("baked_potato_iron", ModItems.VANILLA_QUALITY))
                .requires(ModTags.IRON_COOKED_MUTTON)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_roll_medley_block_iron", DelightItems.QUALITY_DELIGHT))
                .requires(DelightItems.KELP_ROLL_SLICE[0].get())
                .requires(DelightItems.KELP_ROLL_SLICE[0].get())
                .requires(DelightItems.KELP_ROLL_SLICE[0].get())
                .requires(DelightItems.SALMON_ROLL[0].get())
                .requires(DelightItems.SALMON_ROLL[0].get())
                .requires(DelightItems.SALMON_ROLL[0].get())
                .requires(DelightItems.COD_ROLL[0].get())
                .requires(Items.BOWL)
                .requires(DelightItems.COD_ROLL[0].get())
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("roast_chicken_block_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bread_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_gold", ModCrops.CROPS))
                .requires(getItemFromID("cooked_chicken_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_gold", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_pumpkin_block_gold", DelightItems.QUALITY_DELIGHT), 1, 20, 2.0f, Items.PUMPKIN)
                .addIngredient(getItemFromID("rice_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_gold", ModCrops.CROPS))
                .addIngredient(ForgeTags.BERRIES)
                .addIngredient(Ingredient.of(getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("beetroot_gold", ModCrops.CROPS), getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasBerries", has(ForgeTags.BERRIES))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("shepherds_pie_block_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.MILK)
                .requires(getItemFromID("baked_potato_gold", ModItems.VANILLA_QUALITY))
                .requires(ModTags.GOLD_COOKED_MUTTON)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_roll_medley_block_gold", DelightItems.QUALITY_DELIGHT))
                .requires(DelightItems.KELP_ROLL_SLICE[1].get())
                .requires(DelightItems.KELP_ROLL_SLICE[1].get())
                .requires(DelightItems.KELP_ROLL_SLICE[1].get())
                .requires(DelightItems.SALMON_ROLL[1].get())
                .requires(DelightItems.SALMON_ROLL[1].get())
                .requires(DelightItems.SALMON_ROLL[1].get())
                .requires(DelightItems.COD_ROLL[1].get())
                .requires(Items.BOWL)
                .requires(DelightItems.COD_ROLL[1].get())
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("roast_chicken_block_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("bread_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .requires(getItemFromID("cooked_chicken_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .requires(getItemFromID("carrot_diamond", ModCrops.CROPS))
                .requires(Items.BOWL)
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_pumpkin_block_diamond", DelightItems.QUALITY_DELIGHT), 1, 20, 2.0f, Items.PUMPKIN)
                .addIngredient(getItemFromID("rice_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("potato_diamond", ModCrops.CROPS))
                .addIngredient(ForgeTags.BERRIES)
                .addIngredient(Ingredient.of(getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("beetroot_diamond", ModCrops.CROPS), getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("cabbage_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT)))
                .unlockedBy("hasBerries", has(ForgeTags.BERRIES))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("shepherds_pie_block_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .requires(ForgeTags.MILK)
                .requires(getItemFromID("baked_potato_diamond", ModItems.VANILLA_QUALITY))
                .requires(ModTags.DIAMOND_COOKED_MUTTON)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("rice_roll_medley_block_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(DelightItems.KELP_ROLL_SLICE[2].get())
                .requires(DelightItems.KELP_ROLL_SLICE[2].get())
                .requires(DelightItems.KELP_ROLL_SLICE[2].get())
                .requires(DelightItems.SALMON_ROLL[2].get())
                .requires(DelightItems.SALMON_ROLL[2].get())
                .requires(DelightItems.SALMON_ROLL[2].get())
                .requires(DelightItems.COD_ROLL[2].get())
                .requires(Items.BOWL)
                .requires(DelightItems.COD_ROLL[2].get())
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        simpleCookingRecipe(pFinishedRecipeConsumer, "smoking", RecipeSerializer.SMOKING_RECIPE, 200, getItemFromID("ham_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("smoked_ham_iron", DelightItems.QUALITY_DELIGHT), 0.35F);
        simpleCookingRecipe(pFinishedRecipeConsumer, "smoking", RecipeSerializer.SMOKING_RECIPE, 200, getItemFromID("ham_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("smoked_ham_gold", DelightItems.QUALITY_DELIGHT), 0.35F);
        simpleCookingRecipe(pFinishedRecipeConsumer, "smoking", RecipeSerializer.SMOKING_RECIPE, 200, getItemFromID("ham_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("smoked_ham_diamond", DelightItems.QUALITY_DELIGHT), 0.35F);

        simpleQualityFoodRecipe("hoglin_loin", OceanItems.NETHER_QUALITY, "hoglin_sirloin", OceanItems.NETHER_QUALITY, pFinishedRecipeConsumer);

        simpleQualityCuttingRecipeVanillaAddition("ham", DelightItems.QUALITY_DELIGHT, "porkchop", ModItems.VANILLA_QUALITY, 2, Items.BONE, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("smoked_ham", DelightItems.QUALITY_DELIGHT, "cooked_porkchop", ModItems.VANILLA_QUALITY, 2, Items.BONE, 1, pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_glazed_ham_block_iron", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("ham_iron", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_glazed_ham_block_gold", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("ham_gold", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("honey_glazed_ham_block_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(Items.HONEY_BOTTLE)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("ham_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(Items.SWEET_BERRIES)
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(Items.BOWL)
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cabbage_rolls_iron", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f)
                .addIngredient(ModTags.IRON_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_iron", ModCrops.CROPS), getItemFromID("carrot_iron", ModCrops.CROPS), getItemFromID("beetroot_iron", ModCrops.CROPS),
                        getItemFromID("beef_iron", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_iron", ModItems.VANILLA_QUALITY), getItemFromID("chicken_iron", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_iron", ModItems.VANILLA_QUALITY), getItemFromID("egg_iron", ModItems.VANILLA_QUALITY), getItemFromID("tropical_fish_iron", ModItems.VANILLA_QUALITY),
                        getItemFromID("salmon_iron", ModItems.VANILLA_QUALITY), getItemFromID("cod_iron", ModItems.VANILLA_QUALITY),
                        getItemFromID("minced_beef_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_iron", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_iron", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("hoglin_loin_iron", OceanItems.NETHER_QUALITY)
                ))
                .unlockedBy("hasCabbage", has(ModTags.IRON_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cabbage_rolls_gold", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f)
                .addIngredient(ModTags.GOLD_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_gold", ModCrops.CROPS), getItemFromID("carrot_gold", ModCrops.CROPS), getItemFromID("beetroot_gold", ModCrops.CROPS),
                        getItemFromID("beef_gold", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_gold", ModItems.VANILLA_QUALITY), getItemFromID("chicken_gold", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_gold", ModItems.VANILLA_QUALITY), getItemFromID("egg_gold", ModItems.VANILLA_QUALITY), getItemFromID("tropical_fish_gold", ModItems.VANILLA_QUALITY),
                        getItemFromID("salmon_gold", ModItems.VANILLA_QUALITY), getItemFromID("cod_gold", ModItems.VANILLA_QUALITY),
                        getItemFromID("minced_beef_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_gold", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_gold", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("hoglin_loin_gold", OceanItems.NETHER_QUALITY)
                ))
                .unlockedBy("hasCabbage", has(ModTags.GOLD_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("cabbage_rolls_diamond", DelightItems.QUALITY_DELIGHT), 1, 300, 0.35f)
                .addIngredient(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .addIngredient(Ingredient.of(getItemFromID("potato_diamond", ModCrops.CROPS), getItemFromID("carrot_diamond", ModCrops.CROPS), getItemFromID("beetroot_diamond", ModCrops.CROPS),
                        getItemFromID("beef_diamond", ModItems.VANILLA_QUALITY), getItemFromID("porkchop_diamond", ModItems.VANILLA_QUALITY), getItemFromID("chicken_diamond", ModItems.VANILLA_QUALITY),
                        getItemFromID("mutton_diamond", ModItems.VANILLA_QUALITY), getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY), getItemFromID("tropical_fish_diamond", ModItems.VANILLA_QUALITY),
                        getItemFromID("salmon_diamond", ModItems.VANILLA_QUALITY), getItemFromID("cod_diamond", ModItems.VANILLA_QUALITY),
                        getItemFromID("minced_beef_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("chicken_cuts_diamond", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("mutton_chops_diamond", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT),
                        getItemFromID("hoglin_loin_diamond", OceanItems.NETHER_QUALITY)
                ))
                .unlockedBy("hasCabbage", has(ModTags.DIAMOND_SALAD_INGREDIENTS))
                .build(pFinishedRecipeConsumer);

            simpleQualityCuttingRecipe("strider_slice", OceanItems.NETHER_QUALITY, "ground_strider", OceanItems.NETHER_QUALITY, 2, pFinishedRecipeConsumer);

            ShapedRecipeBuilder.shaped(getItemFromID("raw_stuffed_hoglin_iron", OceanItems.NETHER_QUALITY))
                .define('W', Items.WARPED_ROOTS)
                .define('C', Items.CRIMSON_ROOTS)
                .define('F', Items.CRIMSON_FUNGUS)
                .define('L', getItemFromID("hoglin_loin_iron", OceanItems.NETHER_QUALITY))
                .define('H', NDItems.HOGLIN_HIDE.get())
                .define('h', getItemFromID("ham_iron", DelightItems.QUALITY_DELIGHT))
                .define('S', ModItems.NETHER_SALAD.get())
                .pattern("WFC")
                .pattern("LHL")
                .pattern("hSh")
                .unlockedBy("hasHide", has(NDItems.HOGLIN_HIDE.get()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("nether_skewer_iron", OceanItems.NETHER_QUALITY))
                .define('P', getItemFromID("propelpearl_iron", OceanItems.NETHER_QUALITY))
                .define('R', Items.BLAZE_ROD)
                .define('S', Ingredient.of(getItemFromID("ground_strider_iron", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_iron", OceanItems.NETHER_QUALITY)))
                .pattern("PS")
                .pattern("R ")
                .unlockedBy("hasRod", has(Items.BLAZE_ROD))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("warped_moldy_meat_iron", OceanItems.NETHER_QUALITY))
                .requires(Items.WARPED_ROOTS)
                .requires(Items.WARPED_ROOTS)
                .requires(getItemFromID("hoglin_sirloin_iron", OceanItems.NETHER_QUALITY))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("grilled_strider_iron", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_iron", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_iron", OceanItems.NETHER_QUALITY)))
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WARPED_ROOTS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_iron", OceanItems.NETHER_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("strider_moss_stew_iron", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_iron", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_iron", OceanItems.NETHER_QUALITY)))
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_iron", OceanItems.NETHER_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("magma_gelatin_iron", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BUCKET)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(getItemFromID("propelpearl_iron", OceanItems.NETHER_QUALITY))
                .build(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("raw_stuffed_hoglin_gold", OceanItems.NETHER_QUALITY))
                .define('W', Items.WARPED_ROOTS)
                .define('C', Items.CRIMSON_ROOTS)
                .define('F', Items.CRIMSON_FUNGUS)
                .define('L', getItemFromID("hoglin_loin_gold", OceanItems.NETHER_QUALITY))
                .define('H', NDItems.HOGLIN_HIDE.get())
                .define('h', getItemFromID("ham_gold", DelightItems.QUALITY_DELIGHT))
                .define('S', ModItems.NETHER_SALAD.get())
                .pattern("WFC")
                .pattern("LHL")
                .pattern("hSh")
                .unlockedBy("hasHide", has(NDItems.HOGLIN_HIDE.get()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("nether_skewer_gold", OceanItems.NETHER_QUALITY))
                .define('P', getItemFromID("propelpearl_gold", OceanItems.NETHER_QUALITY))
                .define('R', Items.BLAZE_ROD)
                .define('S', Ingredient.of(getItemFromID("ground_strider_gold", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_gold", OceanItems.NETHER_QUALITY)))
                .pattern("PS")
                .pattern("R ")
                .unlockedBy("hasRod", has(Items.BLAZE_ROD))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("warped_moldy_meat_gold", OceanItems.NETHER_QUALITY))
                .requires(Items.WARPED_ROOTS)
                .requires(Items.WARPED_ROOTS)
                .requires(getItemFromID("hoglin_sirloin_gold", OceanItems.NETHER_QUALITY))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("grilled_strider_gold", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_gold", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_gold", OceanItems.NETHER_QUALITY)))
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WARPED_ROOTS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_gold", OceanItems.NETHER_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("strider_moss_stew_gold", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_gold", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_gold", OceanItems.NETHER_QUALITY)))
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_gold", OceanItems.NETHER_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("magma_gelatin_gold", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BUCKET)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(getItemFromID("propelpearl_gold", OceanItems.NETHER_QUALITY))
                .build(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("raw_stuffed_hoglin_diamond", OceanItems.NETHER_QUALITY))
                .define('W', Items.WARPED_ROOTS)
                .define('C', Items.CRIMSON_ROOTS)
                .define('F', Items.CRIMSON_FUNGUS)
                .define('L', getItemFromID("hoglin_loin_diamond", OceanItems.NETHER_QUALITY))
                .define('H', NDItems.HOGLIN_HIDE.get())
                .define('h', getItemFromID("ham_diamond", DelightItems.QUALITY_DELIGHT))
                .define('S', ModItems.NETHER_SALAD.get())
                .pattern("WFC")
                .pattern("LHL")
                .pattern("hSh")
                .unlockedBy("hasHide", has(NDItems.HOGLIN_HIDE.get()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(getItemFromID("nether_skewer_diamond", OceanItems.NETHER_QUALITY))
                .define('P', getItemFromID("propelpearl_diamond", OceanItems.NETHER_QUALITY))
                .define('R', Items.BLAZE_ROD)
                .define('S', Ingredient.of(getItemFromID("ground_strider_diamond", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_diamond", OceanItems.NETHER_QUALITY)))
                .pattern("PS")
                .pattern("R ")
                .unlockedBy("hasRod", has(Items.BLAZE_ROD))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("warped_moldy_meat_diamond", OceanItems.NETHER_QUALITY))
                .requires(Items.WARPED_ROOTS)
                .requires(Items.WARPED_ROOTS)
                .requires(getItemFromID("hoglin_sirloin_diamond", OceanItems.NETHER_QUALITY))
                .requires(Items.BOWL)
                .unlockedBy("hasBowl", has(Items.BOWL))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("grilled_strider_diamond", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_diamond", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_diamond", OceanItems.NETHER_QUALITY)))
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_diamond", OceanItems.NETHER_QUALITY)))
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WARPED_ROOTS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("strider_moss_stew_diamond", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(Ingredient.of(getItemFromID("ground_strider_diamond", OceanItems.NETHER_QUALITY), getItemFromID("strider_slice_diamond", OceanItems.NETHER_QUALITY)))
                .unlockedBy("hasStrider", has(getItemFromID("ground_strider_diamond", OceanItems.NETHER_QUALITY)))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("magma_gelatin_diamond", OceanItems.NETHER_QUALITY), 1, 200, 0.35f, Items.BUCKET)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(Items.MAGMA_CREAM)
                .addIngredient(getItemFromID("propelpearl_diamond", OceanItems.NETHER_QUALITY))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_hoglin_iron", NetherItems.NETHER_QUALITY), 1, 200, 0.35f)
                .addIngredient(ModItems.NETHER_SALAD.get())
                .addIngredient(getItemFromID("raw_stuffed_hoglin_iron", NetherItems.NETHER_QUALITY))
                .addIngredient(ModItems.NETHER_SALAD.get())
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_hoglin_gold", NetherItems.NETHER_QUALITY), 1, 200, 0.35f)
                .addIngredient(ModItems.NETHER_SALAD.get())
                .addIngredient(getItemFromID("raw_stuffed_hoglin_gold", NetherItems.NETHER_QUALITY))
                .addIngredient(ModItems.NETHER_SALAD.get())
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("stuffed_hoglin_diamond", NetherItems.NETHER_QUALITY), 1, 200, 0.35f)
                .addIngredient(ModItems.NETHER_SALAD.get())
                .addIngredient(getItemFromID("raw_stuffed_hoglin_diamond", NetherItems.NETHER_QUALITY))
                .addIngredient(ModItems.NETHER_SALAD.get())
                .build(pFinishedRecipeConsumer);

        simpleQualityCuttingRecipe("tentacles", OceanItems.OCEAN_QUALITY, "cut_tentacles", OceanItems.OCEAN_QUALITY, 3, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("elder_guardian_slab", OceanItems.OCEAN_QUALITY, "elder_guardian_slice", OceanItems.OCEAN_QUALITY, 9, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);
        simpleQualityCuttingRecipeVanillaAddition("pufferfish", ModItems.VANILLA_QUALITY, "fugu_slice", OceanItems.OCEAN_QUALITY, 6, Items.BONE_MEAL, 1, pFinishedRecipeConsumer);

        simpleQualityFoodRecipe("guardian_tail", OceanItems.OCEAN_QUALITY, "cooked_guardian_tail", OceanItems.OCEAN_QUALITY, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("elder_guardian_slice", OceanItems.OCEAN_QUALITY, "cooked_elder_guardian_slice", OceanItems.OCEAN_QUALITY, pFinishedRecipeConsumer);
        simpleQualityFoodRecipe("tentacle_on_a_stick", OceanItems.OCEAN_QUALITY, "baked_tentacle_on_a_stick", OceanItems.OCEAN_QUALITY, pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("elder_guardian_roll_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("elder_guardian_slice_iron", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fugu_roll_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_iron", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("fugu_slice_iron", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("tentacle_on_a_stick_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("tentacles_iron", OceanItems.OCEAN_QUALITY))
                .requires(Items.STICK)
                .unlockedBy("hasTentacle",  has(getItemFromID("tentacles_iron", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("elder_guardian_roll_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("elder_guardian_slice_gold", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fugu_roll_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_gold", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("fugu_slice_gold", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("tentacle_on_a_stick_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("tentacles_gold", OceanItems.OCEAN_QUALITY))
                .requires(Items.STICK)
                .unlockedBy("hasTentacle",  has(getItemFromID("tentacles_gold", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("elder_guardian_roll_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("elder_guardian_slice_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("elder_guardian_slice_diamond", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("fugu_roll_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("fugu_slice_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("cooked_rice_diamond", DelightItems.QUALITY_DELIGHT))
                .unlockedBy("hasSlice",  has(getItemFromID("fugu_slice_diamond", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("tentacle_on_a_stick_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("tentacles_diamond", OceanItems.OCEAN_QUALITY))
                .requires(Items.STICK)
                .unlockedBy("hasTentacle",  has(getItemFromID("tentacles_diamond", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("braised_sea_pickle_iron", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.SEA_PICKLE)
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("braised_sea_pickle_gold", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.SEA_PICKLE)
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("braised_sea_pickle_diamond", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f, Items.BOWL)
                .addIngredient(Items.SEA_PICKLE)
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .addIngredient(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .build(pFinishedRecipeConsumer);

        */

        simpleQualityFoodRecipe("stuffed_cod", OceanItems.OCEAN_QUALITY, "cooked_stuffed_cod", OceanItems.OCEAN_QUALITY, pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_wrapped_elder_guardian_iron", OceanItems.OCEAN_QUALITY))
                .requires(ModTags.IRON_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_elder_guardian_slice_iron", OceanItems.OCEAN_QUALITY))
                .unlockedBy("hasSlice", has(getItemFromID("cooked_elder_guardian_slice_iron", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_cod_iron", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("kelp_iron", ModCrops.CROPS))
                .requires(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("brown_mushroom_iron", ModCrops.CROPS))
                .requires(getItemFromID("cod_iron", ModItems.VANILLA_QUALITY))
                .requires(vectorwing.farmersdelight.common.registry.ModItems.ROPE.get())
                .unlockedBy("hasCod", has(getItemFromID("cod_iron", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("honey_fried_kelp_iron", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("dried_kelp_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(Items.HONEY_BOTTLE)
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("guardian_soup_iron", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("guardian_iron", OceanItems.OCEAN_QUALITY))
                .addIngredient(getItemFromID("onion_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("egg_iron", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_wrapped_elder_guardian_gold", OceanItems.OCEAN_QUALITY))
                .requires(ModTags.GOLD_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_elder_guardian_slice_gold", OceanItems.OCEAN_QUALITY))
                .unlockedBy("hasSlice", has(getItemFromID("cooked_elder_guardian_slice_gold", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_cod_gold", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("kelp_gold", ModCrops.CROPS))
                .requires(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("brown_mushroom_gold", ModCrops.CROPS))
                .requires(getItemFromID("cod_gold", ModItems.VANILLA_QUALITY))
                .requires(vectorwing.farmersdelight.common.registry.ModItems.ROPE.get())
                .unlockedBy("hasCod", has(getItemFromID("cod_gold", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("honey_fried_kelp_gold", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("dried_kelp_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(Items.HONEY_BOTTLE)
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("guardian_soup_gold", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("guardian_gold", OceanItems.OCEAN_QUALITY))
                .addIngredient(getItemFromID("onion_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("egg_gold", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT))
                .build(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("cabbage_wrapped_elder_guardian_diamond", OceanItems.OCEAN_QUALITY))
                .requires(ModTags.DIAMOND_SALAD_INGREDIENTS)
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("cooked_elder_guardian_slice_diamond", OceanItems.OCEAN_QUALITY))
                .unlockedBy("hasSlice", has(getItemFromID("cooked_elder_guardian_slice_diamond", OceanItems.OCEAN_QUALITY)))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(getItemFromID("stuffed_cod_diamond", OceanItems.OCEAN_QUALITY))
                .requires(getItemFromID("kelp_diamond", ModCrops.CROPS))
                .requires(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .requires(getItemFromID("brown_mushroom_diamond", ModCrops.CROPS))
                .requires(getItemFromID("cod_diamond", ModItems.VANILLA_QUALITY))
                .requires(vectorwing.farmersdelight.common.registry.ModItems.ROPE.get())
                .unlockedBy("hasCod", has(getItemFromID("cod_diamond", ModItems.VANILLA_QUALITY)))
                .save(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("honey_fried_kelp_diamond", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("dried_kelp_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(Items.HONEY_BOTTLE)
                .build(pFinishedRecipeConsumer);

        CookingPotRecipeBuilder.cookingPotRecipe(getItemFromID("guardian_soup_diamond", OceanItems.OCEAN_QUALITY), 1, 200, 0.35f)
                .addIngredient(getItemFromID("guardian_diamond", OceanItems.OCEAN_QUALITY))
                .addIngredient(getItemFromID("onion_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("egg_diamond", ModItems.VANILLA_QUALITY))
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .addIngredient(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT))
                .build(pFinishedRecipeConsumer);


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

    public static void simpleQualityCuttingRecipeVanillaAddition(String input, DeferredRegister<Item> inputRegister, String output, DeferredRegister<Item> outputRegister, int outputCount, Item output2, int outputCount2, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_iron", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_iron", outputRegister), outputCount).addResult(output2, outputCount2).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_gold", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_gold", outputRegister), outputCount).addResult(output2, outputCount2).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(input + "_diamond", inputRegister)), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(output + "_diamond", outputRegister), outputCount).addResult(output2, outputCount2).build(pFinishedRecipeConsumer);
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
