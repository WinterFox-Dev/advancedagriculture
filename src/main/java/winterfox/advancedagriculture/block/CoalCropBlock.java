package winterfox.advancedagriculture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import winterfox.advancedagriculture.registry.ItemRegistry;

public class CoalCropBlock extends CropBlock {

    public static int MAX_AGE = 7;
    public static IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    public CoalCropBlock() {
        super(Block.Properties.of(Material.STONE).instabreak().noCollission().randomTicks().sound(SoundType.STONE));
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.COAL_SEEDS.get();
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
        return state.is(Tags.Blocks.STONE);
    }
}
