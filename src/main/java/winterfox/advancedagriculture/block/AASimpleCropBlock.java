package winterfox.advancedagriculture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AASimpleCropBlock extends CropBlock {

    public static int MAX_AGE;
    public static IntegerProperty AGE;
    public static Block farmland;
    public static Item seeds;

    public AASimpleCropBlock(Properties props, int maxAge, IntegerProperty age, Block farmland, Item seeds) {
        super(props);
        this.MAX_AGE = maxAge;
        this.AGE = age;
        this.farmland = farmland;
        this.seeds = seeds;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seeds;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(farmland);
    }
}
