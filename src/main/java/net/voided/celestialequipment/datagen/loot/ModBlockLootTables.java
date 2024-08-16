package net.voided.celestialequipment.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;
import net.voided.celestialequipment.block.ModBlocks;
import net.voided.celestialequipment.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CELESTIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CELESTIUM_BLOCK.get());

        this.add(ModBlocks.DEEPSLATE_CELESTIUM_ORE.get(),
                block -> createOreDrop(ModItems.RAW_CELESTIUM.get()));
        this.add(ModBlocks.CELESTIAL_GRAVEL.get(),
                block -> createOreDrop(ModItems.CELESTIAL_COAL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    private LootTable.Builder createOreDrop(Item dropItem) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(dropItem)));
    }

}