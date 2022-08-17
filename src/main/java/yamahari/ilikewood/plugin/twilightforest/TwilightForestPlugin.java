package yamahari.ilikewood.plugin.twilightforest;

import net.minecraft.world.level.block.Block;
import yamahari.ilikewood.ILikeWoodPlugin;
import yamahari.ilikewood.IModPlugin;
import yamahari.ilikewood.plugin.twilightforest.util.Constants;
import yamahari.ilikewood.registry.IWoodenObjectRegistry;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.resource.IWoodenResourceRegistry;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTierRegistry;
import yamahari.ilikewood.registry.woodtype.IWoodTypeRegistry;

@ILikeWoodPlugin
public final class TwilightForestPlugin
    implements IModPlugin
{
    public static IWoodenObjectRegistry<Block, WoodenBlockType> BLOCK_REGISTRY;

    @Override
    public String getModId()
    {
        return Constants.TWILIGHT_FOREST_MOD_ID;
    }

    @Override
    public String getPluginModId()
    {
        return Constants.MOD_ID;
    }

    @Override
    public void registerWoodTypes(final IWoodTypeRegistry registry)
    {
        TwilightForestWoodTypes.get().forEach(registry::register);
    }

    @Override
    public void registerWoodenItemTiers(final IWoodenItemTierRegistry registry)
    {
        TwilightForestWoodenItemTiers.get().forEach(registry::register);
    }

    @Override
    public void registerWoodenResources(final IWoodenResourceRegistry registry)
    {
        TwilightForestWoodTypes.get().forEach(woodType ->
        {
            registry.registerPlanksResource(woodType, TwilightForestWoodenResources.PLANKS.get(woodType));
            registry.registerLogResource(woodType, TwilightForestWoodenResources.LOGS.get(woodType));
            registry.registerStrippedLogResource(woodType, TwilightForestWoodenResources.STRIPPED_LOGS.get(woodType));
            registry.registerSlabResource(woodType, TwilightForestWoodenResources.SLABS.get(woodType));
        });
    }

    @Override
    public void acceptBlockRegistry(final IWoodenObjectRegistry<Block, WoodenBlockType> registry)
    {
        BLOCK_REGISTRY = registry;
    }
}
