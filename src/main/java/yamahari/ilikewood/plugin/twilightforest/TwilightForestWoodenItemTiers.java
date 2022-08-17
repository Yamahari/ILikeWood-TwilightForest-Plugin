package yamahari.ilikewood.plugin.twilightforest;

import net.minecraft.world.item.crafting.Ingredient;
import yamahari.ilikewood.plugin.twilightforest.util.Constants;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.woodenitemtier.DefaultWoodenItemTier;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTier;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.stream.Stream;

public final class TwilightForestWoodenItemTiers
{
    public static final IWoodenItemTier CANOPY = makeItemTier(TwilightForestWoodTypes.CANOPY, Constants.CANOPY);
    public static final IWoodenItemTier DARK = makeItemTier(TwilightForestWoodTypes.DARK, Constants.DARK);
    public static final IWoodenItemTier MANGROVE = makeItemTier(TwilightForestWoodTypes.MANGROVE, Constants.MANGROVE);
    public static final IWoodenItemTier MINING = makeItemTier(TwilightForestWoodTypes.MINING, Constants.MINING);
    public static final IWoodenItemTier SORTING = makeItemTier(TwilightForestWoodTypes.SORTING, Constants.SORTING);
    public static final IWoodenItemTier TIME = makeItemTier(TwilightForestWoodTypes.TIME, Constants.TIME);
    public static final IWoodenItemTier TRANSFORMATION = makeItemTier(TwilightForestWoodTypes.TRANSFORMATION, Constants.TRANSFORMATION);
    public static final IWoodenItemTier TWILIGHT_OAK = makeItemTier(TwilightForestWoodTypes.TWILIGHT_OAK, Constants.TWILIGHT_OAK);

    private TwilightForestWoodenItemTiers()
    {
    }

    private static IWoodenItemTier makeItemTier(
        final IWoodType woodType,
        final String name
    )
    {
        return new DefaultWoodenItemTier(woodType, Constants.TWILIGHT_FOREST_MOD_ID, name,
            () -> Ingredient.of(TwilightForestPlugin.BLOCK_REGISTRY.getObject(woodType, WoodenBlockType.PANELS))
        );
    }

    public static Stream<IWoodenItemTier> get()
    {
        return Stream.of(CANOPY, DARK, MANGROVE, MINING, SORTING, TIME, TRANSFORMATION, TWILIGHT_OAK);
    }
}
