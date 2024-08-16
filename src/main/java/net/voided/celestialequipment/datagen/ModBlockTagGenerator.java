package net.voided.celestialequipment.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.celestialequipment.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CelestialEquipment.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CELESTIUM_BLOCK.get(),
                        ModBlocks.RAW_CELESTIUM_BLOCK.get(),
                        ModBlocks.DEEPSLATE_CELESTIUM_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.RAW_CELESTIUM_BLOCK.get(),
                        ModBlocks.CELESTIUM_BLOCK.get(),
                        ModBlocks.CELESTIAL_GRAVEL.get(),
                        ModBlocks.DEEPSLATE_CELESTIUM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.CELESTIAL_GRAVEL.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CELESTIAL_GRAVEL.get());
    }
}
