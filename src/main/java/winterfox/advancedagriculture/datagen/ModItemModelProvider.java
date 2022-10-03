package winterfox.advancedagriculture.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator gen, String modid, ExistingFileHelper efh) {
        super(gen, modid, efh);
    }

    @Override
    protected void registerModels() {

    }
}
