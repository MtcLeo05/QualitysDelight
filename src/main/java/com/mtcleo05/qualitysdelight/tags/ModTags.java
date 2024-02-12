package com.mtcleo05.qualitysdelight.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static TagKey<Item> IRON_COOKED_BACON = qualityItemTag("iron/cooked_bacon");
    public static TagKey<Item> GOLD_COOKED_BACON = qualityItemTag("gold/cooked_bacon");
    public static TagKey<Item> DIAMOND_COOKED_BACON = qualityItemTag("diamond/cooked_bacon");

    public static TagKey<Item> IRON_COOKED_BEEF = qualityItemTag("iron/cooked_beef");
    public static TagKey<Item> GOLD_COOKED_BEEF = qualityItemTag("gold/cooked_beef");
    public static TagKey<Item> DIAMOND_COOKED_BEEF = qualityItemTag("diamond/cooked_beef");

    public static TagKey<Item> IRON_COOKED_CHICKEN = qualityItemTag("iron/cooked_chicken");
    public static TagKey<Item> GOLD_COOKED_CHICKEN = qualityItemTag("gold/cooked_chicken");
    public static TagKey<Item> DIAMOND_COOKED_CHICKEN = qualityItemTag("diamond/cooked_chicken");

    public static TagKey<Item> IRON_COOKED_FISHES = qualityItemTag("iron/cooked_fishes");
    public static TagKey<Item> GOLD_COOKED_FISHES = qualityItemTag("gold/cooked_fishes");
    public static TagKey<Item> DIAMOND_COOKED_FISHES = qualityItemTag("diamond/cooked_fishes");

    public static TagKey<Item> IRON_COOKED_MUTTON = qualityItemTag("iron/cooked_mutton");
    public static TagKey<Item> GOLD_COOKED_MUTTON = qualityItemTag("gold/cooked_mutton");
    public static TagKey<Item> DIAMOND_COOKED_MUTTON = qualityItemTag("diamond/cooked_mutton");

    public static TagKey<Item> IRON_COOKED_PORK = qualityItemTag("iron/cooked_pork");
    public static TagKey<Item> GOLD_COOKED_PORK = qualityItemTag("gold/cooked_pork");
    public static TagKey<Item> DIAMOND_COOKED_PORK = qualityItemTag("diamond/cooked_pork");

    public static TagKey<Item> IRON_RAW_PORK = qualityItemTag("iron/raw_pork");
    public static TagKey<Item> GOLD_RAW_PORK = qualityItemTag("gold/raw_pork");
    public static TagKey<Item> DIAMOND_RAW_PORK = qualityItemTag("diamond/raw_pork");

    public static TagKey<Item> IRON_RAW_CHICKEN = qualityItemTag("iron/raw_chicken");
    public static TagKey<Item> GOLD_RAW_CHICKEN = qualityItemTag("gold/raw_chicken");
    public static TagKey<Item> DIAMOND_RAW_CHICKEN = qualityItemTag("diamond/raw_chicken");

    public static TagKey<Item> IRON_RAW_BEEF = qualityItemTag("iron/raw_beef");
    public static TagKey<Item> GOLD_RAW_BEEF = qualityItemTag("gold/raw_beef");
    public static TagKey<Item> DIAMOND_RAW_BEEF = qualityItemTag("diamond/raw_beef");

    public static TagKey<Item> IRON_SALAD_INGREDIENTS = qualityItemTag("iron/crops/cabbage");
    public static TagKey<Item> GOLD_SALAD_INGREDIENTS = qualityItemTag("gold/crops/cabbage");
    public static TagKey<Item> DIAMOND_SALAD_INGREDIENTS = qualityItemTag("diamond/crops/cabbage");

    public static TagKey<Item> IRON_COOKED_COD = qualityItemTag("iron/cooked_fishes/cod");
    public static TagKey<Item> GOLD_COOKED_COD = qualityItemTag("gold/cooked_fishes/cod");
    public static TagKey<Item> DIAMOND_COOKED_COD = qualityItemTag("diamond/cooked_fishes/cod");

    public static TagKey<Item> IRON_COOKED_SALMON = qualityItemTag("iron/cooked_fishes/salmon");
    public static TagKey<Item> GOLD_COOKED_SALMON =  qualityItemTag("gold/cooked_fishes/salmon");
    public static TagKey<Item> DIAMOND_COOKED_SALMON = qualityItemTag("diamond/cooked_fishes/salmon");

    public static TagKey<Item> IRON_RAW_FISHES = qualityItemTag("iron/raw_fishes");
    public static TagKey<Item> GOLD_RAW_FISHES =  qualityItemTag("gold/raw_fishes");
    public static TagKey<Item> DIAMOND_RAW_FISHES = qualityItemTag("diamond/raw_fishes");

    public static TagKey<Item> IRON_RAW_COD = qualityItemTag("iron/raw_fishes/cod");
    public static TagKey<Item> GOLD_RAW_COD =  qualityItemTag("gold/raw_fishes/cod");
    public static TagKey<Item> DIAMOND_RAW_COD = qualityItemTag("diamond/raw_fishes/cod");

    public static TagKey<Item> IRON_RAW_SALMON = qualityItemTag("iron/raw_fishes/salmon");
    public static TagKey<Item> GOLD_RAW_SALMON =  qualityItemTag("gold/raw_fishes/salmon");
    public static TagKey<Item> DIAMOND_RAW_SALMON = qualityItemTag("diamond/raw_fishes/salmon");


    private static TagKey<Item> qualityItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("qualitycrops", path));
    }
}
