package net.irie.iriesmod;

import com.mojang.logging.LogUtils;
import net.irie.iriesmod.block.ModBlocks;
import net.irie.iriesmod.item.ModCreativeModeTabs;
import net.irie.iriesmod.item.ModItems;
import net.irie.iriesmod.item.custom.OreDetectorItem;
import net.irie.iriesmod.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IriesMod.MOD_ID)
public class IriesMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "iriesmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public IriesMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
            event.accept(ModItems.PINE_CONE);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ORE_DETECTOR);
            event.accept(ModItems.SAPPHIRE_STAFF);
            event.accept(ModItems.SAPPHIRE_PICKAXE);
            event.accept(ModItems.SAPPHIRE_AXE);
            event.accept(ModItems.SAPPHIRE_HOE);
            event.accept(ModItems.SAPPHIRE_SHOVEL);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.STRAWBERRY);
            event.accept(ModItems.STRAWBERRY_SEEDS);
            event.accept(ModItems.CORN);
            event.accept(ModItems.CORN_SEEDS);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.SAPPHIRE_SWORD);
            event.accept(ModItems.SAPPHIRE_AXE);
            event.accept(ModItems.SAPPHIRE_HELMET);
            event.accept(ModItems.SAPPHIRE_CHESTPLATE);
            event.accept(ModItems.SAPPHIRE_LEGGINGS);
            event.accept(ModItems.SAPPHIRE_BOOTS);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_BUTTON);
            event.accept(ModBlocks.SAPPHIRE_DOOR);
            event.accept(ModBlocks.SAPPHIRE_SLAB);
            event.accept(ModBlocks.SAPPHIRE_FENCE);
            event.accept(ModBlocks.SAPPHIRE_FENCE_GATE);
            event.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
            event.accept(ModBlocks.SAPPHIRE_STAIRS);
            event.accept(ModBlocks.SAPPHIRE_TRAPDOOR);
            event.accept(ModBlocks.SAPPHIRE_WALL);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
