package winterfox.advancedagriculture.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import winterfox.advancedagriculture.AdvancedAgriculture;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedAgriculture.MODID);

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if(event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            List<Block> noCreativeTab = new ArrayList<Block>() {
                {
                }
            };
            BLOCKS.getEntries().forEach((blockRegistryObject) -> {
                Block block = blockRegistryObject.get();
                Item.Properties properties = new Item.Properties();
                if(!noCreativeTab.contains(block)) {
                    properties.tab(ItemRegistry.ModCreativeTab.instance);
                }
                Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }
}
