package winterfox.advancedagriculture.util;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import winterfox.advancedagriculture.registry.BlockRegistry;

public class ModProperties {

    public static void setRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.COAL_CROP.get(), RenderType.cutout());
    }
}
