package yamahari.ilikewood.plugin.twilightforest;

import yamahari.ilikewood.plugin.twilightforest.util.Constants;
import yamahari.ilikewood.registry.woodtype.DefaultWoodType;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.stream.Stream;

public final class TwilightForestWoodTypes
{
    public static final IWoodType CANOPY = makeWoodType(Constants.CANOPY, new int[]{
        color(51, 30, 17),
        color(64, 43, 21),
        color(73, 47, 30),
        color(77, 56, 38),
        color(82, 58, 40),
        color(86, 60, 43),
        color(95, 69, 43),
        color(103, 77, 47)
    });

    public static final IWoodType DARK = makeWoodType(Constants.DARK, new int[]{
        color(82, 56, 32),
        color(106, 68, 41),
        color(115, 72, 41),
        color(131, 89, 49),
        color(140, 91, 53),
        color(148, 93, 57),
        color(172, 101, 57),
        color(180, 109, 57)
    });

    public static final IWoodType MANGROVE = makeWoodType(Constants.MANGROVE, new int[]{
        color(143, 117, 83),
        color(155, 133, 100),
        color(165, 145, 109),
        color(193, 152, 113),
        color(198, 160, 119),
        color(202, 168, 125),
        color(214, 180, 132),
        color(207, 191, 141)
    });

    public static final IWoodType MINING = makeWoodType(Constants.MINING, new int[]{
        color(127, 115, 98),
        color(133, 121, 104),
        color(150, 133, 115),
        color(162, 144, 127),
        color(169, 150, 130),
        color(173, 156, 133),
        color(179, 162, 139),
        color(185, 168, 139)
    });

    public static final IWoodType SORTING = makeWoodType(Constants.SORTING, new int[]{
        color(56, 31, 15),
        color(64, 40, 20),
        color(76, 44, 24),
        color(80, 52, 32),
        color(87, 56, 34),
        color(93, 60, 36),
        color(103, 63, 31),
        color(109, 68, 36)
    });

    public static final IWoodType TIME = makeWoodType(Constants.TIME, new int[]{
        color(75, 48, 28),
        color(86, 53, 40),
        color(98, 65, 46),
        color(110, 71, 57),
        color(116, 76, 60),
        color(121, 81, 63),
        color(133, 86, 63),
        color(139, 92, 63)
    });

    public static final IWoodType TRANSFORMATION = makeWoodType(Constants.TRANSFORMATION, new int[]{
        color(96, 86, 84),
        color(110, 98, 86),
        color(127, 110, 92),
        color(144, 127, 110),
        color(147, 133, 116),
        color(150, 139, 121),
        color(162, 144, 115),
        color(173, 156, 128)
    });

    public static final IWoodType TWILIGHT_OAK = makeWoodType(Constants.TWILIGHT_OAK, new int[]{
        color(97, 76, 52),
        color(105, 85, 60),
        color(125, 97, 68),
        color(141, 113, 80),
        color(147, 119, 87),
        color(153, 125, 93),
        color(161, 129, 89),
        color(170, 133, 89)
    });


    private TwilightForestWoodTypes()
    {
    }

    private static int color(
        int r,
        int g,
        int b
    )
    {
        return 0xFF << 24 | (b & 0xFF) << 16 | (g & 0xFF) << 8 | (r & 0xFF);
    }

    private static IWoodType makeWoodType(
        final String name,
        final int[] colors
    )
    {
        return new DefaultWoodType(Constants.TWILIGHT_FOREST_MOD_ID, name, new IWoodType.Colors(colors));
    }

    public static Stream<IWoodType> get()
    {
        return Stream.of(CANOPY, DARK, MANGROVE, MINING, SORTING, TIME, TRANSFORMATION, TWILIGHT_OAK);
    }
}