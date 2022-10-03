package winterfox.advancedagriculture.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import winterfox.advancedagriculture.AdvancedAgriculture;
import winterfox.advancedagriculture.block.AASimpleCropBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedAgriculture.MODID);

    public static final RegistryObject<Block> COAL_CROP = BLOCKS.register("coal_crop",
            () -> new AASimpleCropBlock(Block.Properties.of(Material.STONE).instabreak().noCollission().randomTicks().sound(SoundType.STONE), 7, IntegerProperty.create("age", 0, 6), Blocks.STONE, ItemRegistry.COAL_SEEDS.get()));

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if(event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            List<Block> noCreativeTab = new ArrayList<Block>() {
                {
                    add(COAL_CROP.get());
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
