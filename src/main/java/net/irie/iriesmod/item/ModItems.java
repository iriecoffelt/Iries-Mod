package net.irie.iriesmod.item;

import net.irie.iriesmod.IriesMod;
import net.irie.iriesmod.block.ModBlocks;
import net.irie.iriesmod.item.custom.FuelItem;
import net.irie.iriesmod.item.custom.ModArmorItem;
import net.irie.iriesmod.item.custom.OreDetectorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.irie.iriesmod.entity.ModEntities;
import net.irie.iriesmod.entity.custom.ModBoatEntity;
import net.irie.iriesmod.item.custom.*;
import net.minecraftforge.common.ForgeSpawnEggItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IriesMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register( "sapphire",
            () -> new Item(new Item.Properties()) );
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register( "raw_sapphire",
            () -> new Item(new Item.Properties()) );

    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register( "ore_detector",
                () -> new OreDetectorItem(new Item.Properties().durability(1000)) );

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register( "strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> CORN = ITEMS.register( "corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));

    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register( "sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register( "pine_cone",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register( "sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 10, 5, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register( "sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 5, 3, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register( "sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 20, 10, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register( "sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 1, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register( "sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, 1, 0, new Item.Properties()));


    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register( "sapphire_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register( "sapphire_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register( "sapphire_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register( "sapphire_boots",
            () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register( "strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register( "corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5, new Item.Properties()));

    public static final RegistryObject<Item> PINE_SIGN = ITEMS.register("pine_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PINE_SIGN.get(), ModBlocks.PINE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PINE_HANGING_SIGN = ITEMS.register("pine_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PINE_HANGING_SIGN.get(), ModBlocks.PINE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.PINE, new Item.Properties()));
    public static final RegistryObject<Item> PINE_CHEST_BOAT = ITEMS.register("pine_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.PINE, new Item.Properties()));

    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
