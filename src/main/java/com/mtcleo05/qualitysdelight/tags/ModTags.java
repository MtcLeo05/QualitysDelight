package com.mtcleo05.qualitysdelight.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static TagKey<Item> QUALITY_IRON = forgeItemTag("quality/iron");
    public static TagKey<Item> QUALITY_GOLD = forgeItemTag("quality/gold");
    public static TagKey<Item> QUALITY_DIAMOND = forgeItemTag("quality/diamond");
    public static TagKey<Item> IRON_COOKED_BACON = forgeItemTag("iron/cooked_bacon");
    public static TagKey<Item> GOLD_COOKED_BACON = forgeItemTag("gold/cooked_bacon");
    public static TagKey<Item> DIAMOND_COOKED_BACON = forgeItemTag("diamond/cooked_bacon");
    public static TagKey<Item> IRON_COOKED_BEEF = forgeItemTag("iron/cooked_beef");
    public static TagKey<Item> GOLD_COOKED_BEEF = forgeItemTag("gold/cooked_beef");
    public static TagKey<Item> DIAMOND_COOKED_BEEF = forgeItemTag("diamond/cooked_beef");
    public static TagKey<Item> IRON_COOKED_CHICKEN = forgeItemTag("iron/cooked_chicken");
    public static TagKey<Item> GOLD_COOKED_CHICKEN = forgeItemTag("gold/cooked_chicken");
    public static TagKey<Item> DIAMOND_COOKED_CHICKEN = forgeItemTag("diamond/cooked_chicken");
    public static TagKey<Item> IRON_COOKED_FISHES = forgeItemTag("iron/cooked_fishes");
    public static TagKey<Item> GOLD_COOKED_FISHES = forgeItemTag("gold/cooked_fishes");
    public static TagKey<Item> DIAMOND_COOKED_FISHES = forgeItemTag("diamond/cooked_fishes");
    public static TagKey<Item> IRON_COOKED_MUTTON = forgeItemTag("iron/cooked_mutton");
    public static TagKey<Item> GOLD_COOKED_MUTTON = forgeItemTag("gold/cooked_mutton");
    public static TagKey<Item> DIAMOND_COOKED_MUTTON = forgeItemTag("diamond/cooked_mutton");
    public static TagKey<Item> IRON_COOKED_PORK = forgeItemTag("iron/cooked_pork");
    public static TagKey<Item> GOLD_COOKED_PORK = forgeItemTag("gold/cooked_pork");
    public static TagKey<Item> DIAMOND_COOKED_PORK = forgeItemTag("diamond/cooked_pork");
    public static TagKey<Item> IRON_RAW_PORK = forgeItemTag("iron/raw_pork");
    public static TagKey<Item> GOLD_RAW_PORK = forgeItemTag("gold/raw_pork");
    public static TagKey<Item> DIAMOND_RAW_PORK = forgeItemTag("diamond/raw_pork");
    public static TagKey<Item> IRON_SALAD_INGREDIENTS = forgeItemTag("iron/crops/cabbage");
    public static TagKey<Item> GOLD_SALAD_INGREDIENTS = forgeItemTag("gold/crops/cabbage");
    public static TagKey<Item> DIAMOND_SALAD_INGREDIENTS = forgeItemTag("diamond/crops/cabbage");
    public static TagKey<Item> IRON_COOKED_COD = forgeItemTag("iron/cooked_fishes/cod");
    public static TagKey<Item> GOLD_COOKED_COD = forgeItemTag("gold/cooked_fishes/cod");
    public static TagKey<Item> DIAMOND_COOKED_COD = forgeItemTag("diamond/cooked_fishes/cod");
    public static TagKey<Item> IRON_COOKED_SALMON = forgeItemTag("iron/cooked_fishes/salmon");
    public static TagKey<Item> GOLD_COOKED_SALMON =  forgeItemTag("gold/cooked_fishes/salmon");
    public static TagKey<Item> DIAMOND_COOKED_SALMON = forgeItemTag("diamond/cooked_fishes/salmon");
    public static TagKey<Item> IRON_RAW_FISHES = forgeItemTag("iron/raw_fishes");
    public static TagKey<Item> GOLD_RAW_FISHES =  forgeItemTag("gold/raw_fishes");
    public static TagKey<Item> DIAMOND_RAW_FISHES = forgeItemTag("diamond/raw_fishes");
    public static TagKey<Item> IRON_RAW_COD = forgeItemTag("iron/raw_fishes/cod");
    public static TagKey<Item> GOLD_RAW_COD =  forgeItemTag("gold/raw_fishes/cod");
    public static TagKey<Item> DIAMOND_RAW_COD = forgeItemTag("diamond/raw_fishes/cod");
    public static TagKey<Item> IRON_RAW_SALMON = forgeItemTag("iron/raw_fishes/salmon");
    public static TagKey<Item> GOLD_RAW_SALMON =  forgeItemTag("gold/raw_fishes/salmon");
    public static TagKey<Item> DIAMOND_RAW_SALMON = forgeItemTag("diamond/raw_fishes/salmon");


    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}
