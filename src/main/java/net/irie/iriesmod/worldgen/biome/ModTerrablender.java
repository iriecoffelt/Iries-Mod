package net.irie.iriesmod.worldgen.biome;

import net.irie.iriesmod.IriesMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(IriesMod.MOD_ID, "overworld"), 5));
    }
}