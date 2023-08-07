package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.QualityCrops;
import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.items.ModCrops;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.item.OceanItems;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, QualityCrops.MODID, locale);
    }

    @Override
    protected void addTranslations() {

        this.add("itemGroup.qualitysdelight.items", "Quality's Delight Items");
        this.add("itemGroup.qualitysdelight.nether_items", "Nether's Delight Items");
        this.add("itemGroup.qualitysdelight.ocean_items", "Ocean's Delight Items");

        Iterable<Item> newItems = DelightItems.QUALITY_DELIGHT.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else if(item instanceof QualityBowlFoodItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else{
                this.add(item, cTC(getItemName(item)));
            }
        });

        newItems = NetherItems.NETHER_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else if(item instanceof QualityBowlFoodItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else{
                this.add(item, cTC(getItemName(item)));
            }
        });

        newItems = OceanItems.OCEAN_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else if(item instanceof QualityBowlFoodItem){
                this.add(item, cTC(removeQualityID(getItemName(item))));
            }else{
                this.add(item, cTC(getItemName(item)));
            }
        });
    }

    //convert title case: alfa_beta -> Alfa Beta
    public static String cTC(String input) {
        String[] words = input.split("_");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
                result.append(" ");
            }
        }

        return result.toString().trim();
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    public static Item getItemFromID(String id){
        Iterable<Item> qualityCrops = ModCrops.CROPS.getEntries().stream().map(RegistryObject::get)::iterator;

        for (Item item : qualityCrops) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }

        return null;
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
