package net.voided.util;

import net.voided.celestialequipment.CelestialEquipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_CELESTIAL_TOOL = tag("needs_celestial_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CelestialEquipment.MOD_ID, name));
        }
    }

    public static class Items {
        // Example of how to define an item tag
        public static final TagKey<Item> CELESTIAL_INGREDIENT = tag("celestial_ingredient");

        private static TagKey tag(String name) {

            return null;
        }
    }
}
