package winterfox.advancedagriculture.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import winterfox.advancedagriculture.registry.ItemRegistry;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String modid, String locale) {super(gen, modid, locale);}

    @Override
    protected void addTranslations() {
        this.addItem(ItemRegistry.COAL_SEEDS, "Coal Seeds");
    }
}
