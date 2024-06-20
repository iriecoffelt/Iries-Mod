package net.irie.iriesmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.irie.iriesmod.IriesMod;
import net.irie.iriesmod.block.ModBlocks;
import net.irie.iriesmod.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = IriesMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1 trade
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    new ItemStack(ModItems.STRAWBERRY_SEEDS.get(), 3),
                    1,15,0.02f));
            //Level 2 trade
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 4),
                    new ItemStack(ModItems.CORN_SEEDS.get(), 6),
                    1,20,0.035f));
            //Level 3 trade
            //Level 4 trade
            //Level 5 trade
        }

        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 5 trade
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get(), 10),
                    new ItemStack(ModItems.ORE_DETECTOR.get(), 1),
                    1,50,0.075f));
        }

        if (event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
            //Enchantments to add to the book
            enchantedBook.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
            enchantedBook.enchant(Enchantments.THORNS, 2);
            enchantedBook.enchant(Enchantments.FALL_PROTECTION, 4);

            //Level 5 trade
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get(), 30),
                    enchantedBook,
                    4,50,0.075f));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE_CHESTPLATE.get(),1),
                10, 2, 0.2f));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(),1),
                10, 2, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 20),
                new ItemStack(ModItems.ORE_DETECTOR.get(),1),
                1, 21, 0.2f));

    }

}
