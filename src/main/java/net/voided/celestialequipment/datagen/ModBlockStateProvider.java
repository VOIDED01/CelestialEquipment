package net.voided.celestialequipment.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.celestialequipment.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CelestialEquipment.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CELESTIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_CELESTIUM_BLOCK);
        blockWithItem(ModBlocks.CELESTIAL_GRAVEL);
        blockWithItem(ModBlocks.DEEPSLATE_CELESTIUM_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
