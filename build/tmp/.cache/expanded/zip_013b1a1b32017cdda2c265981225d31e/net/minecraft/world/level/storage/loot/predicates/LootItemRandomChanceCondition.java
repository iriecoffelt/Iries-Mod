package net.minecraft.world.level.storage.loot.predicates;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;

/**
 * A LootItemCondition that succeeds with a given probability.
 */
public class LootItemRandomChanceCondition implements LootItemCondition {
   final float probability;

   LootItemRandomChanceCondition(float p_81923_) {
      this.probability = p_81923_;
   }

   public LootItemConditionType getType() {
      return LootItemConditions.RANDOM_CHANCE;
   }

   public boolean test(LootContext pContext) {
      return pContext.getRandom().nextFloat() < this.probability;
   }

   public static LootItemCondition.Builder randomChance(float pProbability) {
      return () -> {
         return new LootItemRandomChanceCondition(pProbability);
      };
   }

   public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<LootItemRandomChanceCondition> {
      public void m_6170_(JsonObject p_81943_, LootItemRandomChanceCondition p_81944_, JsonSerializationContext p_81945_) {
         p_81943_.addProperty("chance", p_81944_.probability);
      }

      public LootItemRandomChanceCondition m_7561_(JsonObject p_81951_, JsonDeserializationContext p_81952_) {
         return new LootItemRandomChanceCondition(GsonHelper.getAsFloat(p_81951_, "chance"));
      }
   }
}