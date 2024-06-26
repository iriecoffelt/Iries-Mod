package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;

public class KilledTrigger extends SimpleCriterionTrigger<KilledTrigger.TriggerInstance> {
   final ResourceLocation f_48100_;

   public KilledTrigger(ResourceLocation p_48102_) {
      this.f_48100_ = p_48102_;
   }

   public ResourceLocation m_7295_() {
      return this.f_48100_;
   }

   public KilledTrigger.TriggerInstance createInstance(JsonObject p_286718_, ContextAwarePredicate p_286909_, DeserializationContext p_286514_) {
      return new KilledTrigger.TriggerInstance(this.f_48100_, p_286909_, EntityPredicate.fromJson(p_286718_, "entity", p_286514_), DamageSourcePredicate.fromJson(p_286718_.get("killing_blow")));
   }

   public void trigger(ServerPlayer pPlayer, Entity pEntity, DamageSource pSource) {
      LootContext lootcontext = EntityPredicate.createContext(pPlayer, pEntity);
      this.trigger(pPlayer, (p_48112_) -> {
         return p_48112_.matches(pPlayer, lootcontext, pSource);
      });
   }

   public static class TriggerInstance extends AbstractCriterionTriggerInstance {
      private final ContextAwarePredicate entityPredicate;
      private final DamageSourcePredicate killingBlow;

      public TriggerInstance(ResourceLocation p_286471_, ContextAwarePredicate p_286673_, ContextAwarePredicate p_286390_, DamageSourcePredicate p_286643_) {
         super(p_286471_, p_286673_);
         this.entityPredicate = p_286390_;
         this.killingBlow = p_286643_;
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate p_152109_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152109_), DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate.Builder p_48135_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_48135_.build()), DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity() {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, ContextAwarePredicate.f_285567_, DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate p_152114_, DamageSourcePredicate p_152115_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152114_), p_152115_);
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate.Builder pEntityPredicate, DamageSourcePredicate p_152107_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(pEntityPredicate.build()), p_152107_);
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate p_152111_, DamageSourcePredicate.Builder p_152112_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152111_), p_152112_.build());
      }

      public static KilledTrigger.TriggerInstance playerKilledEntity(EntityPredicate.Builder pEntityPredicate, DamageSourcePredicate.Builder p_48138_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.PLAYER_KILLED_ENTITY.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(pEntityPredicate.build()), p_48138_.build());
      }

      public static KilledTrigger.TriggerInstance playerKilledEntityNearSculkCatalyst() {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST.f_48100_, ContextAwarePredicate.f_285567_, ContextAwarePredicate.f_285567_, DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate p_152125_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152125_), DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate.Builder p_152117_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152117_.build()), DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer() {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, ContextAwarePredicate.f_285567_, DamageSourcePredicate.f_25420_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate p_152130_, DamageSourcePredicate p_152131_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152130_), p_152131_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate.Builder pEntityPredicate, DamageSourcePredicate p_152123_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(pEntityPredicate.build()), p_152123_);
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate p_152127_, DamageSourcePredicate.Builder p_152128_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152127_), p_152128_.build());
      }

      public static KilledTrigger.TriggerInstance entityKilledPlayer(EntityPredicate.Builder p_152119_, DamageSourcePredicate.Builder p_152120_) {
         return new KilledTrigger.TriggerInstance(CriteriaTriggers.ENTITY_KILLED_PLAYER.f_48100_, ContextAwarePredicate.f_285567_, EntityPredicate.wrap(p_152119_.build()), p_152120_.build());
      }

      public boolean matches(ServerPlayer pPlayer, LootContext pContext, DamageSource pSource) {
         return !this.killingBlow.matches(pPlayer, pSource) ? false : this.entityPredicate.matches(pContext);
      }

      public JsonObject serializeToJson(SerializationContext p_48140_) {
         JsonObject jsonobject = super.serializeToJson(p_48140_);
         jsonobject.add("entity", this.entityPredicate.toJson(p_48140_));
         jsonobject.add("killing_blow", this.killingBlow.serializeToJson());
         return jsonobject;
      }
   }
}