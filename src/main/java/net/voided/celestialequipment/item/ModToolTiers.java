package net.voided.celestialequipment.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier CELESTIAL = TierSortingRegistry.registerTier(
            new ForgeTier(6, 3261, 1f, 1f, 30,
                    ModTags.Blocks.NEEDS_CELESTIAL_TOOL, () -> Ingredient.of(ModItems.CELESTIUM_INGOT.get())),
            new ResourceLocation(CelestialEquipment.MOD_ID, "celestium_ingot"), List.of(Tiers.NETHERITE), List.of());
}
