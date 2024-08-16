package net.voided.celestialequipment.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.celestialequipment.item.custom.FuelItem;
import net.voided.celestialequipment.item.custom.ModArmorMaterials;

public class ModItems {
    // Deferred Register for Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CelestialEquipment.MOD_ID);

    // Item Definitions
    public static final RegistryObject<Item> CELESTIUM_ROD = ITEMS.register("celestium_rod",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CELESTIUM_INGOT = ITEMS.register("celestium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CELESTIUM = ITEMS.register("raw_celestium",
            () -> new Item(new Item.Properties()));

    // Tool Definitions with Custom Attack Speeds
    public static final RegistryObject<Item> CELESTIAL_SWORD = ITEMS.register("celestial_sword",
            () -> new SwordItem(ModToolTiers.CELESTIAL, 4, -1F, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_PICKAXE = ITEMS.register("celestial_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CELESTIAL, -3, -3F, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_AXE = ITEMS.register("celestial_axe",
            () -> new AxeItem(ModToolTiers.CELESTIAL, 6, -3.25F, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_SHOVEL = ITEMS.register("celestial_shovel",
            () -> new ShovelItem(ModToolTiers.CELESTIAL, -5, -3F, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_HOE = ITEMS.register("celestial_hoe",
            () -> new HoeItem(ModToolTiers.CELESTIAL, -5,  9F, new Item.Properties()));

    // Modded Armor
    public static final RegistryObject<Item> CELESTIAL_HELMET = ITEMS.register("celestial_helmet",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_CHESTPLATE = ITEMS.register("celestial_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_LEGGINGS = ITEMS.register("celestial_leggings",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_BOOTS = ITEMS.register("celestial_boots",
            () -> new ArmorItem(ModArmorMaterials.CELESTIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Fuel Item Definition
    public static final RegistryObject<Item> CELESTIAL_COAL = ITEMS.register("celestial_coal",
            () -> new FuelItem(new Item.Properties(), 3200));

    // Celestial Upgrade Smithing Template
    public static final RegistryObject<Item> CELESTIAL_UPGRADE_TEMPLATE = ITEMS.register("celestial_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    // Register Items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}