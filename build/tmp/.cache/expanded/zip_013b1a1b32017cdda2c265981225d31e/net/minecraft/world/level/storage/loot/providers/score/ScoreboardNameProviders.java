package net.minecraft.world.level.storage.loot.providers.score;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.GsonAdapterFactory;
import net.minecraft.world.level.storage.loot.Serializer;

/**
 * Registration for {@link ScoreboardNameProvider}.
 */
public class ScoreboardNameProviders {
   public static final LootScoreProviderType FIXED = register("fixed", new FixedScoreboardNameProvider.Serializer());
   public static final LootScoreProviderType CONTEXT = register("context", new ContextScoreboardNameProvider.Serializer());

   private static LootScoreProviderType register(String pName, Serializer<? extends ScoreboardNameProvider> p_165875_) {
      return Registry.register(BuiltInRegistries.LOOT_SCORE_PROVIDER_TYPE, new ResourceLocation(pName), new LootScoreProviderType(p_165875_));
   }

   public static Object m_165872_() {
      return GsonAdapterFactory.m_78801_(BuiltInRegistries.LOOT_SCORE_PROVIDER_TYPE, "provider", "type", ScoreboardNameProvider::getType).m_164986_(CONTEXT, new ContextScoreboardNameProvider.InlineSerializer()).m_78822_();
   }
}