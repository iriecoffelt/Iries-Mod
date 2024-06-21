package net.irie.iriesmod.item;

import net.irie.iriesmod.IriesMod;
import net.irie.iriesmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IriesMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> IRIES_TAB = CREATIVE_MODE_TABS.register("iries_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.iries_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                        pOutput.accept(ModItems.ORE_DETECTOR.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());

                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());

                        pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                        pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());

                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());

                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());

                        pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());

                        pOutput.accept(ModItems.PINE_SIGN.get());
                        pOutput.accept(ModItems.PINE_HANGING_SIGN.get());

                        pOutput.accept(ModItems.PINE_BOAT.get());
                        pOutput.accept(ModItems.PINE_CHEST_BOAT.get());

                        pOutput.accept(ModItems.DICE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.PINE_LOG.get());
                        pOutput.accept(ModBlocks.PINE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_PINE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_PINE_WOOD.get());

                        pOutput.accept(ModBlocks.PINE_PLANKS.get());
                        pOutput.accept(ModBlocks.PINE_LEAVES.get());

                        pOutput.accept(ModBlocks.PINE_SAPLING.get());
                        pOutput.accept(ModBlocks.MOD_PORTAL.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
