package winterfox.advancedagriculture.datagen;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import winterfox.advancedagriculture.AdvancedAgriculture;

@Mod.EventBusSubscriber(modid = AdvancedAgriculture.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void registerDataProviders(GatherDataEvent event) {
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        ExistingFileHelper fh = event.getExistingFileHelper();
        boolean forClient = event.includeClient();
        boolean forServer = event.includeServer();
        gen.addProvider(forClient, new ModBlockstateProvider(gen, AdvancedAgriculture.MODID, fh));
        gen.addProvider(forClient, new ModLanguageProvider(gen, AdvancedAgriculture.MODID, "en_us"));
        gen.addProvider(forClient, new ModRecipeProvider(gen));
        gen.addProvider(forClient, new ModItemModelProvider(gen, AdvancedAgriculture.MODID, fh));

    }
}
