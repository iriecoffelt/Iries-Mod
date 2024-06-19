package net.irie.iriesmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.effect.MobEffects;
import com.google.common.collect.ImmutableMap;
import net.irie.iriesmod.item.ModArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new HashMap<>();

    static {
        // Initialize the effects for SAPPHIRE armor
        List<MobEffectInstance> sapphireEffects = new ArrayList<>();
        sapphireEffects.add(new MobEffectInstance(MobEffects.NIGHT_VISION, 20000, 1, false, false, true));
        sapphireEffects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20000, 1, false, false, true));
        sapphireEffects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20000, 5,false,false,true));
        sapphireEffects.add(new MobEffectInstance(MobEffects.WATER_BREATHING, 20000, 5,false,false,true));

        MATERIAL_TO_EFFECT_MAP.put(ModArmorMaterials.SAPPHIRE, sapphireEffects);
    }

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapStatusEffects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (MobEffectInstance effect : mapStatusEffects) {
                    addStatusEffectForMaterial(player, mapArmorMaterial, effect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
