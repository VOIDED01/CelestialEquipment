package net.voided.celestialequipment.worldgen;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.voided.celestialequipment.CelestialEquipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.voided.celestialequipment.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_CELESTIUM_ORE_KEY = registerKey("deepslate_celestium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CELESTIUM_COAL_KEY = registerKey("celestium_coal_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> deepslateCelestiumOres = List.of(OreConfiguration.target(deepslateReplaceables,
                ModBlocks.DEEPSLATE_CELESTIUM_ORE.get().defaultBlockState()));
        register(context, DEEPSLATE_CELESTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateCelestiumOres,4));

        List<OreConfiguration.TargetBlockState> celestiumCoalOre = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.CELESTIAL_GRAVEL.get().defaultBlockState()));
        register(context, CELESTIUM_COAL_KEY, Feature.ORE, new OreConfiguration(celestiumCoalOre,8));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CelestialEquipment.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}