package com.mtcleo05.qualitysdelight.block;

import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class GoldRiceRollMedleyBlock extends FeastBlock {

    public static final IntegerProperty ROLL_SERVINGS = IntegerProperty.create("servings", 0, 8);
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape FOOD_SHAPE;
    public final List<Supplier<Item>> riceRollServings;

    public GoldRiceRollMedleyBlock(Properties properties) {
        super(properties, DelightItems.SALMON_ROLL[1], true);
        this.riceRollServings = Arrays.asList(DelightItems.COD_ROLL[1], DelightItems.COD_ROLL[1], DelightItems.SALMON_ROLL[1], DelightItems.SALMON_ROLL[1], DelightItems.SALMON_ROLL[1], DelightItems.KELP_ROLL_SLICE[1], DelightItems.KELP_ROLL_SLICE[1], DelightItems.KELP_ROLL_SLICE[1]);
    }

    public @NotNull IntegerProperty getServingsProperty() {
        return ROLL_SERVINGS;
    }

    public int getMaxServings() {
        return 8;
    }

    public @NotNull ItemStack getServingItem(BlockState state) {
        return new ItemStack((ItemLike)((Supplier<?>)this.riceRollServings.get(state.getValue(this.getServingsProperty()) - 1)).get());
    }

    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return state.getValue(this.getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ROLL_SERVINGS);
    }

    static {
        FOOD_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0, 2.0, 2.0, 14.0, 4.0, 14.0), BooleanOp.OR);
    }

}
