package com.mtcleo05.qualitysdelight.mixin;

import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import com.nethersdelight.common.block.PropelplantBerryCaneBlock;
import com.nethersdelight.core.registry.NDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.Objects;
import java.util.Random;

@Mixin(PropelplantBerryCaneBlock.class)
public class PropelplantBerryStemMixin extends Block implements BonemealableBlock {

    @Shadow
    @Final
    public static final BooleanProperty PEARL = BooleanProperty.create("pearl");
    public PropelplantBerryStemMixin(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult context) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item usedItem = itemstack.getItem();
        if (state.getValue(PEARL)) {
            int j = 1 + level.random.nextInt(2);
            popPearl(level, pos, j);
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(PEARL, Boolean.FALSE), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, context);
        }
    }

    @Unique
    void popPearl(Level level, BlockPos pos, int count){
        float random = level.random.nextFloat();

        if(random >= 0.95f){
            popResource(level, pos, new ItemStack(getItemFromID("propelpearl_diamond", NetherItems.NETHER_QUALITY), count));
        } else if(random >= 0.90f){
            popResource(level, pos, new ItemStack(getItemFromID("propelpearl_gold", NetherItems.NETHER_QUALITY), count));
        } else if(random >= 0.85f){
            popResource(level, pos, new ItemStack(getItemFromID("propelpearl_iron", NetherItems.NETHER_QUALITY), count));
        } else {
            popResource(level, pos, new ItemStack(NDItems.PROPELPEARL.get(), count));
        }
    }

    public boolean isValidBonemealTarget(BlockGetter p_57260_, BlockPos p_57261_, BlockState state, boolean p_57263_) {
        return !(Boolean)state.getValue(PEARL);
    }

    public boolean isBonemealSuccess(Level p_57265_, Random p_57266_, BlockPos p_57267_, BlockState p_57268_) {
        return true;
    }

    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
        level.setBlock(pos, (BlockState)state.setValue(PEARL, true), 2);
    }

    @Unique
    String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    @Unique
    Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> items = register.getEntries().stream().map(RegistryObject::get)::iterator;

        for (Item item : items) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }

        return Items.BARRIER;
    }
}
