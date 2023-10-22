package yamahari.ilikewood.plugin.twilightforest;

import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ModelProvider;
import yamahari.ilikewood.plugin.twilightforest.util.Constants;
import yamahari.ilikewood.plugin.twilightforest.util.Util;
import yamahari.ilikewood.plugin.twilightforest.util.resources.WoodenLogResource;
import yamahari.ilikewood.plugin.twilightforest.util.resources.WoodenPlanksResource;
import yamahari.ilikewood.plugin.twilightforest.util.resources.WoodenSlabResource;
import yamahari.ilikewood.plugin.twilightforest.util.resources.WoodenStrippedLogResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenLogResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenPlanksResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenSlabResource;
import yamahari.ilikewood.registry.resource.resources.IWoodenStrippedLogResource;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class TwilightForestWoodenResources {
    public static final Map<IWoodType, IWoodenPlanksResource> PLANKS;
    public static final Map<IWoodType, IWoodenLogResource> LOGS;
    public static final Map<IWoodType, IWoodenStrippedLogResource> STRIPPED_LOGS;
    public static final Map<IWoodType, IWoodenSlabResource> SLABS;

    private static final Map<IWoodType, BlockBehaviour.Properties> PLANKS_PROPERTIES = new ImmutableMap.Builder<IWoodType, BlockBehaviour.Properties>().put(TwilightForestWoodTypes.CANOPY,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.DARK,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.MANGROVE,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.MINING,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.SORTING,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.TIME,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.TRANSFORMATION,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS))
        .put(TwilightForestWoodTypes.TWILIGHT_OAK,
            BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS))
        .build();

    static {
        final Map<IWoodType, IWoodenPlanksResource> planks = new HashMap<>();
        final Map<IWoodType, IWoodenLogResource> logs = new HashMap<>();
        final Map<IWoodType, IWoodenStrippedLogResource> strippedLogs = new HashMap<>();
        final Map<IWoodType, IWoodenSlabResource> slabs = new HashMap<>();

        TwilightForestWoodTypes.get().forEach(woodType -> {
            final var planksResource = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toRegistryName(woodType.getName(), "planks"));


            final var logResource = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toRegistryName(woodType.getName(), "log"));
            final var strippedLogResource = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toRegistryName("stripped", woodType.getName(), "log"));
            final var slabResource = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toRegistryName(woodType.getName(), "slab"));

            final ResourceLocation planksTexture;

            if (woodType.equals(TwilightForestWoodTypes.DARK)) {
                planksTexture = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID,
                    Util.toPath(ModelProvider.BLOCK_FOLDER, "wood", Util.toRegistryName("planks", "darkwood", "0")));
            }
            else if (woodType.equals(TwilightForestWoodTypes.MINING)) {
                planksTexture = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toPath(ModelProvider.BLOCK_FOLDER, "wood", Util.toRegistryName("planks", "mine", "0")));
            }
            else if (woodType.equals(TwilightForestWoodTypes.SORTING)) {
                planksTexture = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID, Util.toPath(ModelProvider.BLOCK_FOLDER, "wood", Util.toRegistryName("planks", "sort", "0")));
            }
            else if (woodType.equals(TwilightForestWoodTypes.TRANSFORMATION)) {
                planksTexture = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID,
                    Util.toPath(ModelProvider.BLOCK_FOLDER, "wood", Util.toRegistryName("planks", "trans", "0")));
            }
            else {
                planksTexture = new ResourceLocation(Constants.TWILIGHT_FOREST_MOD_ID,
                    Util.toPath(ModelProvider.BLOCK_FOLDER, "wood", Util.toRegistryName("planks", woodType.getName(), "0")));
            }


            planks.put(woodType, new WoodenPlanksResource(planksTexture, planksResource, PLANKS_PROPERTIES.get(woodType)));

            logs.put(woodType,
                new WoodenLogResource(new ResourceLocation(logResource.getNamespace(), Util.toPath(ModelProvider.BLOCK_FOLDER, Util.toRegistryName(logResource.getPath(), "top"))),
                    new ResourceLocation(logResource.getNamespace(), Util.toPath(ModelProvider.BLOCK_FOLDER, logResource.getPath())),
                    logResource));

            strippedLogs.put(woodType,
                new WoodenStrippedLogResource(new ResourceLocation(strippedLogResource.getNamespace(),
                    Util.toPath(ModelProvider.BLOCK_FOLDER, Util.toRegistryName(strippedLogResource.getPath(), "top"))),
                    new ResourceLocation(strippedLogResource.getNamespace(), Util.toPath(ModelProvider.BLOCK_FOLDER, strippedLogResource.getPath())),
                    strippedLogResource));

            slabs.put(woodType, new WoodenSlabResource(planksTexture, planksTexture, planksTexture, slabResource));
        });

        PLANKS = Collections.unmodifiableMap(planks);
        LOGS = Collections.unmodifiableMap(logs);
        STRIPPED_LOGS = Collections.unmodifiableMap(strippedLogs);
        SLABS = Collections.unmodifiableMap(slabs);
    }

    private TwilightForestWoodenResources() {
    }
}
