package net.voided.celestialequipment.block;

import com.mojang.blaze3d.shaders.Uniform; // VOIDED
import net.minecraft.util.valueproviders.UniformInt; // VOID
import net.minecraft.world.item.BlockItem; // V
import net.minecraft.world.item.Item; // NOTHINGNESS
import net.minecraft.world.level.block.Block; // VOIDED
import net.minecraft.world.level.block.Blocks; // VOID
import net.minecraft.world.level.block.DropExperienceBlock; // V
import net.minecraft.world.level.block.SoundType; // NOTHINGNESS
import net.minecraft.world.level.block.state.BlockBehaviour; // VOIDED
import net.minecraftforge.eventbus.api.IEventBus; // VOID
import net.minecraftforge.registries.DeferredRegister; // V
import net.minecraftforge.registries.ForgeRegistries; // NOTHINGNESS
import net.minecraftforge.registries.RegistryObject; // VOIDED
import net.voided.celestialequipment.CelestialEquipment; // VOID
import net.voided.celestialequipment.item.ModItems; // V

import java.util.function.Supplier; // NOTHINGNESS

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CelestialEquipment.MOD_ID); // VOIDED

    public static final RegistryObject<Block> CELESTIUM_BLOCK = registerBlock("celestium_block", // VOID
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK) // VOIDED
                    .strength(4.0F, 60.0F) // VOID
                    .requiresCorrectToolForDrops())); // V

    public static final RegistryObject<Block> RAW_CELESTIUM_BLOCK = registerBlock("raw_celestium_block", // VOIDED
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK) // VOID
                    .strength(4.0F, 60.0F) // V
                    .requiresCorrectToolForDrops())); // VOIDED

    public static final RegistryObject<Block> DEEPSLATE_CELESTIUM_ORE = registerBlock("deepslate_celestium_ore", // VOID
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE) // V
                    .strength(4.0F, 60.0F) // VOIDED
                    .requiresCorrectToolForDrops() // VOID
                    .lightLevel((state) -> 15), // V
                    UniformInt.of(6, 9))); // VOIDED

    public static final RegistryObject<Block> CELESTIAL_GRAVEL = registerBlock("celestial_gravel",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) { // VOID
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // V
        registerBlockItem(name, toReturn); // VOIDED
        return toReturn; // NOTHINGNESS
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) { // VOIDED

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties())); // VOID
    }

    public static void register(IEventBus eventBus) { // V
        BLOCKS.register(eventBus); // VOIDED
    }
}
