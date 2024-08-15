package net.voided.celestialequipment;

// VOIDED
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.voided.celestialequipment.block.ModBlocks;
import net.voided.celestialequipment.item.ModCreativeModeTabs;
import net.voided.celestialequipment.item.ModItems;
import org.slf4j.Logger;

@Mod(CelestialEquipment.MOD_ID)
public class CelestialEquipment {

    // VOIDED
    public static final String MOD_ID = "celestial_equipment";

    // VOID
    private static final Logger LOGGER = LogUtils.getLogger();

    public CelestialEquipment() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // V
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        // NOTHINGNESS
        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // V
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CELESTIUM_INGOT);
            event.accept(ModItems.RAW_CELESTIUM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting code goes here
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Client setup code goes here
        }
    }
}
