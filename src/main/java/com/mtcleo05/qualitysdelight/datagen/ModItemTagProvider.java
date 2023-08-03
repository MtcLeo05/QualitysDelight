package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import com.mtcleo05.qualitysdelight.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, QualitysDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {


        Iterable<Item> newItems = DelightItems.QUALITY_DELIGHT.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem qualityItem){
                if(qualityItem.cropQuality == 1){
                    this.tag(ModTags.QUALITY_IRON).add(item);
                }else if(qualityItem.cropQuality == 2){
                    this.tag(ModTags.QUALITY_GOLD).add(item);
                }else{
                    this.tag(ModTags.QUALITY_DIAMOND).add(item);
                }
            }else if(item instanceof QualityBowlFoodItem qualityItem){
                if(qualityItem.cropQuality == 1){
                    this.tag(ModTags.QUALITY_IRON).add(item);
                }else if(qualityItem.cropQuality == 2){
                    this.tag(ModTags.QUALITY_GOLD).add(item);
                }else{
                    this.tag(ModTags.QUALITY_DIAMOND).add(item);
                }
            }
        });

        newItems = NetherItems.NETHER_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;

        newItems.forEach(item -> {
            if(item instanceof QualityItem qualityItem){
                if(qualityItem.cropQuality == 1){
                    this.tag(ModTags.QUALITY_IRON).add(item);
                }else if(qualityItem.cropQuality == 2){
                    this.tag(ModTags.QUALITY_GOLD).add(item);
                }else{
                    this.tag(ModTags.QUALITY_DIAMOND).add(item);
                }
            }else if(item instanceof QualityBowlFoodItem qualityItem){
                if(qualityItem.cropQuality == 1){
                    this.tag(ModTags.QUALITY_IRON).add(item);
                }else if(qualityItem.cropQuality == 2){
                    this.tag(ModTags.QUALITY_GOLD).add(item);
                }else{
                    this.tag(ModTags.QUALITY_DIAMOND).add(item);
                }
            }
        });

/*
        this.tag(ModTags.IRON_COOKED_BACON).add(getItemFromID("cooked_bacon_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_BACON).add(getItemFromID("cooked_bacon_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_BACON).add(getItemFromID("cooked_bacon_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_BEEF).add(getItemFromID("beef_patty_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_BEEF).add(getItemFromID("beef_patty_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_BEEF).add(getItemFromID("beef_patty_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_CHICKEN).add(getItemFromID("cooked_chicken_cuts_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_CHICKEN).add(getItemFromID("cooked_chicken_cuts_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_CHICKEN).add(getItemFromID("cooked_chicken_cuts_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_FISHES).add(getItemFromID("cooked_cod_slice_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_FISHES).add(getItemFromID("cooked_cod_slice_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_FISHES).add(getItemFromID("cooked_cod_slice_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_FISHES).add(getItemFromID("cooked_salmon_slice_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_FISHES).add(getItemFromID("cooked_salmon_slice_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_FISHES).add(getItemFromID("cooked_salmon_slice_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_MUTTON).add(getItemFromID("cooked_mutton_chops_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_MUTTON).add(getItemFromID("cooked_mutton_chops_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_MUTTON).add(getItemFromID("cooked_mutton_chops_diamond", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.IRON_SALAD_INGREDIENTS).add(getItemFromID("cabbage_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_SALAD_INGREDIENTS).add(getItemFromID("cabbage_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_SALAD_INGREDIENTS).add(getItemFromID("cabbage_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_SALAD_INGREDIENTS).add(getItemFromID("cabbage_leaf_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_SALAD_INGREDIENTS).add(getItemFromID("cabbage_leaf_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_SALAD_INGREDIENTS).add(getItemFromID("cabbage_leaf_diamond", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.IRON_COOKED_COD).add(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_COD).add(getItemFromID("cooked_cod_iron", ModItems.VANILLA_QUALITY));
        this.tag(ModTags.GOLD_COOKED_COD).add(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_COD).add(getItemFromID("cooked_cod_gold", ModItems.VANILLA_QUALITY));
        this.tag(ModTags.DIAMOND_COOKED_COD).add(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_COD).add(getItemFromID("cooked_cod_diamond", ModItems.VANILLA_QUALITY));
        this.tag(ModTags.IRON_COOKED_SALMON).add(getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_COOKED_SALMON).add(getItemFromID("cooked_salmon_iron", ModItems.VANILLA_QUALITY));
        this.tag(ModTags.GOLD_COOKED_SALMON).add(getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_COOKED_SALMON).add(getItemFromID("cooked_salmon_gold", ModItems.VANILLA_QUALITY));
        this.tag(ModTags.DIAMOND_COOKED_SALMON).add(getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_COOKED_SALMON).add(getItemFromID("cooked_salmon_diamond", ModItems.VANILLA_QUALITY));

        this.tag(ModTags.IRON_RAW_PORK).add(getItemFromID("bacon_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_RAW_PORK).add(getItemFromID("bacon_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_RAW_PORK).add(getItemFromID("bacon_diamond", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.IRON_RAW_FISHES).add(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT), getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.GOLD_RAW_FISHES).add(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT), getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.DIAMOND_RAW_FISHES).add(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT), getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.IRON_RAW_COD).add(getItemFromID("cod_slice_iron", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.IRON_RAW_SALMON).add(getItemFromID("salmon_slice_iron", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.GOLD_RAW_COD).add(getItemFromID("cod_slice_gold", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.GOLD_RAW_SALMON).add(getItemFromID("salmon_slice_gold", DelightItems.QUALITY_DELIGHT));

        this.tag(ModTags.DIAMOND_RAW_COD).add(getItemFromID("cod_slice_diamond", DelightItems.QUALITY_DELIGHT));
        this.tag(ModTags.DIAMOND_RAW_SALMON).add(getItemFromID("salmon_slice_diamond", DelightItems.QUALITY_DELIGHT));

 */
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
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
