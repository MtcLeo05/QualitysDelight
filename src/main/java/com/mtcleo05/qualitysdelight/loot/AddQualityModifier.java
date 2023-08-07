package com.mtcleo05.qualitysdelight.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddQualityModifier extends LootModifier {

    private final Item ironItem;
    private final Item goldItem;
    private final Item diamondItem;

    protected AddQualityModifier(LootItemCondition[] conditionsIn, Item ironItem, Item goldItem, Item diamondItem) {
        super(conditionsIn);
        this.ironItem = ironItem;
        this.goldItem = goldItem;
        this.diamondItem = diamondItem;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() >= 0.95f) {
            generatedLoot.add(new ItemStack(diamondItem));
        } else if (context.getRandom().nextFloat() >= 0.90f) {
            generatedLoot.add(new ItemStack(goldItem));
        } else if (context.getRandom().nextFloat() >= 0.85f) {
            generatedLoot.add(new ItemStack(ironItem));
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AddQualityModifier> {
        public Serializer() {
        }

        public AddQualityModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            Item addedIronItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "ironItem")));
            Item addedGoldItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "goldItem")));
            Item addedDiamondItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "diamondItem")));
            return new AddQualityModifier(ailootcondition, addedIronItem, addedGoldItem, addedDiamondItem);
        }

        public JsonObject write(AddQualityModifier instance) {
            return new JsonObject();
        }
    }
}
