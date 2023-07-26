package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.items.ModCrops;
import com.mtcleo05.qualitycrops.items.ModItems;
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
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
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
 */

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
