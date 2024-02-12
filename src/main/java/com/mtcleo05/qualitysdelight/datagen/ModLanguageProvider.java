package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.QualityCrops;
import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabItems;
import com.mtcleo05.qualitysdelight.integration.endersdelight.item.EndersItems;
import com.mtcleo05.qualitysdelight.integration.farmersrespite.item.RespiteItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemName;


public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, QualitysDelight.MODID, locale);
    }

    @Override
    protected void addTranslations() {

        this.add("itemGroup.qualitysdelight.crab_items", "Crabber's Delight Items");

        Iterable<Item> newItems = CrabItems.CRAB_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;

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

    public static String removeQualityID(String input) {
        int lastUnderscoreIndex = input.lastIndexOf("_");
        if (lastUnderscoreIndex != -1) {
            return input.substring(0, lastUnderscoreIndex);
        } else {
            return input;
        }
    }
}
