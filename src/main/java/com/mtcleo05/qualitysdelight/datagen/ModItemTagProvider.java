package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.utils.ModTags;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, QualitysDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ForgeRegistries.ITEMS.getValues().forEach(
                (item) -> {
                    if(item instanceof QualityItem qualityItem) {
                        switch (qualityItem.cropQuality) {
                            case 2 -> this.tag(ModTags.QUALITY_GOLD).add(item);
                            case 3 -> this.tag(ModTags.QUALITY_DIAMOND).add(item);
                            default -> this.tag(ModTags.QUALITY_IRON).add(item);
                        }
                    } else if (item instanceof QualityBowlFoodItem qualityItem) {
                        switch (qualityItem.cropQuality) {
                            case 2 -> this.tag(ModTags.QUALITY_GOLD).add(item);
                            case 3 -> this.tag(ModTags.QUALITY_DIAMOND).add(item);
                            default -> this.tag(ModTags.QUALITY_IRON).add(item);
                        }
                    }
                }
        );
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}