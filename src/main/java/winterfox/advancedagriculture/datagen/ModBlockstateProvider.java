package winterfox.advancedagriculture.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockstateProvider extends BlockStateProvider {

    public ModBlockstateProvider(DataGenerator gen, String modid, ExistingFileHelper efh) {
        super(gen, modid, efh);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
