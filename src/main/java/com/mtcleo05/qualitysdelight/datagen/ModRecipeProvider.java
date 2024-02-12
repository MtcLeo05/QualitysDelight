package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.quality.IQuality;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.utils.Utils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        Iterator<Map.Entry<ResourceKey<Item>, Item>> items = ForgeRegistries.ITEMS.getEntries().stream().iterator();

        items.forEachRemaining((entry) -> {
            Item item = entry.getValue();
            if(item instanceof IQuality qItem){
                switch(qItem.getQuality()){
                    case 3 -> ShapelessRecipeBuilder.shapeless(Utils.getItemFromID(getItemName(item), 2)).unlockedBy("hasQuality", has(item)).requires(item).save(pFinishedRecipeConsumer);
                    case 2 -> ShapelessRecipeBuilder.shapeless(Utils.getItemFromID(getItemName(item), 1)).unlockedBy("hasQuality", has(item)).requires(item).save(pFinishedRecipeConsumer);
                }
            }
        });


    }


    public static void simpleQualityCuttingRecipe(String inputID, String outputID, int outputCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(inputID,"iron")), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(outputID, "iron"), outputCount).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(inputID,"gold")), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(outputID, "gold"), outputCount).build(pFinishedRecipeConsumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(getItemFromID(inputID,"diamond")), Ingredient.of(ForgeTags.TOOLS_KNIVES), getItemFromID(outputID, "diamond"), outputCount).build(pFinishedRecipeConsumer);
    }

    public static void simpleQualityCuttingRecipeWithExtra(String inputID, String outputID, int outputCount, String extraID, float extraChance, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(getItemFromID(inputID,"iron")),
                Ingredient.of(ForgeTags.TOOLS_KNIVES),
                getItemFromID(outputID, "iron"),
                outputCount)
                .addResultWithChance(getItemFromID(extraID), extraChance * 1.25f)
                .build(pFinishedRecipeConsumer);

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(getItemFromID(inputID,"gold")),
                Ingredient.of(ForgeTags.TOOLS_KNIVES),
                getItemFromID(outputID, "gold"),
                outputCount)
                .addResultWithChance(getItemFromID(extraID), extraChance * 1.5f)
                .build(pFinishedRecipeConsumer);

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(
                getItemFromID(inputID,"diamond")),
                Ingredient.of(ForgeTags.TOOLS_KNIVES),
                getItemFromID(outputID, "diamond"),
                outputCount)
                .addResultWithChance(getItemFromID(extraID), extraChance * 2f)
                .build(pFinishedRecipeConsumer);
    }

}
