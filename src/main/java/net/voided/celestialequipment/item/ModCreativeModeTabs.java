package net.voided.celestialequipment.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.celestialequipment.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CelestialEquipment.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CELESTIAL_TAB = CREATIVE_MODE_TABS.register("celestial_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CELESTIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.celestial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CELESTIUM_INGOT.get());
                        pOutput.accept(ModItems.RAW_CELESTIUM.get());
                        pOutput.accept(ModItems.CELESTIUM_ROD.get());
                        pOutput.accept(ModItems.CELESTIAL_COAL.get());
                        pOutput.accept(ModItems.CELESTIAL_SWORD.get());
                        pOutput.accept(ModItems.CELESTIAL_PICKAXE.get());
                        pOutput.accept(ModItems.CELESTIAL_AXE.get());
                        pOutput.accept(ModItems.CELESTIAL_SHOVEL.get());
                        pOutput.accept(ModItems.CELESTIAL_HOE.get());

                        pOutput.accept(ModItems.CELESTIAL_HELMET.get());
                        pOutput.accept(ModItems.CELESTIAL_CHESTPLATE.get());
                        pOutput.accept(ModItems.CELESTIAL_LEGGINGS.get());
                        pOutput.accept(ModItems.CELESTIAL_BOOTS.get());


                        pOutput.accept(ModBlocks.CELESTIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_CELESTIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CELESTIUM_ORE.get());
                        pOutput.accept(ModBlocks.CELESTIAL_GRAVEL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
