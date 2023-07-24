package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.items.ModCrops;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, QualitysDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        Iterable<Item> newItems = DelightItems.QUALITY_DELIGHT.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem qualityItem){
                qualityItem(item, qualityItem.cropQuality, "farmersdelight");
            }else if(item instanceof QualityBowlFoodItem qualityBowlFoodItem){
                qualityItem(item, qualityBowlFoodItem.cropQuality, "farmersdelight");
            }else{
                simpleItem(item);
            }
        });

    }

    private ItemModelBuilder simpleItem(Item item){
        return withExistingParent(getItemName(item),
                new ResourceLocation("items/generated")).texture("layer0",
                new ResourceLocation(QualitysDelight.MODID, "items/"+ getItemName(item)));
    }

    private ItemModelBuilder handheldItem(Item item){
        return withExistingParent(getItemName(item),
                new ResourceLocation("items/handheld")).texture("layer0",
                new ResourceLocation(QualitysDelight.MODID, "items/"+ getItemName(item)));
    }

    private ItemModelBuilder qualityItem(Item item, int cropQuality, String originalId){
        return withExistingParent(getItemName(item),
                new ResourceLocation("items/generated"))
                .texture(
                        "layer0",
                        new ResourceLocation(originalId, "items/"+ removeQualityID(getItemName(item)))
                )
                .texture(
                        "layer1",
                        switch (cropQuality){
                            case 1 -> new ResourceLocation(QualitysDelight.MODID, "items/iron_overlay");
                            case 2 -> new ResourceLocation(QualitysDelight.MODID, "items/gold_overlay");
                            case 3 -> new ResourceLocation(QualitysDelight.MODID, "items/diamond_overlay");
                            default -> null;
                        }
                );
    }

    private ItemModelBuilder blockItem(Block block) {
        return withExistingParent(getBlockName(block),modid + ":blocks/" + getBlockName(block));
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    private String getBlockName(Block block){
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    public static String removeQualityID(String input) {
        int lastUnderscoreIndex = input.lastIndexOf("_");
        if (lastUnderscoreIndex != -1) {
            return input.substring(0, lastUnderscoreIndex);
        } else {
            // No underscore found, return the original input
            return input;
        }
    }

}
