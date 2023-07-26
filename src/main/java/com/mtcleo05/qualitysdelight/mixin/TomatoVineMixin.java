package com.mtcleo05.qualitysdelight.mixin;

import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.*;
import vectorwing.farmersdelight.common.block.TomatoVineBlock;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModSounds;

import java.security.SecureRandom;
import java.util.Objects;

@Mixin(TomatoVineBlock.class)
public class TomatoVineMixin extends CropBlock {

    @Shadow
    @Final
    public static final IntegerProperty VINE_AGE = BlockStateProperties.AGE_3;


    public TomatoVineMixin(Properties p_52247_) {
        super(p_52247_);
    }

    /**
     * @author MtcLeo05
     * @reason Tomato can give quality item
     */
    @Overwrite
    public @NotNull InteractionResult use(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        int age = state.getValue(this.getAgeProperty());
        boolean isMature = age == this.getMaxAge();
        if (!isMature && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            generateRandomItem(level, pos, quantity);
            if ((double)level.random.nextFloat() < 0.05) {
                popResource(level, pos, new ItemStack(ModItems.ROTTEN_TOMATO.get()));
            }
            level.playSound(null, pos, ModSounds.ITEM_TOMATO_PICK_FROM_BUSH.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    @Shadow
    public @NotNull IntegerProperty getAgeProperty() {
        return VINE_AGE;
    }

    @Shadow
    public int getMaxAge() {
        return 3;
    }

    @Unique
    public void generateRandomItem(Level level, BlockPos pos, int quantity){

        SecureRandom random = new SecureRandom();

        float chance = random.nextFloat(1.0f);

        if (chance <= 0.05) {
            popResource(level, pos, new ItemStack(getItemFromID("tomato_diamond", DelightItems.QUALITY_DELIGHT), quantity));
        } else if (chance <= 0.10) {
            popResource(level, pos, new ItemStack(getItemFromID("tomato_gold", DelightItems.QUALITY_DELIGHT), quantity));
        } else if (chance <= 0.15) {
            popResource(level, pos, new ItemStack(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT), quantity));
        } else {
            popResource(level, pos, new ItemStack(ModItems.TOMATO.get(), quantity));
        }
    }

    @Unique
    public Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> qualityCrops = register.getEntries().stream().map(RegistryObject::get)::iterator;
        for (Item item : qualityCrops) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Unique
    private String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

}
