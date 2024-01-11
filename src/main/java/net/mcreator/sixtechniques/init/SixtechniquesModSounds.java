
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sixtechniques.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.sixtechniques.SixtechniquesMod;

public class SixtechniquesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SixtechniquesMod.MODID);
	public static final RegistryObject<SoundEvent> TEMPESTSOUND = REGISTRY.register("tempestsound", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("sixtechniques", "tempestsound")));
}
