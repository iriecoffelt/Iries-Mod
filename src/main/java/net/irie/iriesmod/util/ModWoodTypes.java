package net.irie.iriesmod.util;

import net.irie.iriesmod.IriesMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(IriesMod.MOD_ID + ":pine", BlockSetType.OAK));
}
