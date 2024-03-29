
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sixtechniques.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.sixtechniques.potion.PaperArtsEffectMobEffect;
import net.mcreator.sixtechniques.potion.PaperArtsCooldownMobEffect;
import net.mcreator.sixtechniques.potion.MetalBodyEffectMobEffect;
import net.mcreator.sixtechniques.potion.MetalBodyCooldownMobEffect;
import net.mcreator.sixtechniques.potion.FallDamageImmunityMobEffect;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class SixtechniquesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SixtechniquesMod.MODID);
	public static final RegistryObject<MobEffect> METAL_BODY_EFFECT = REGISTRY.register("metal_body_effect", () -> new MetalBodyEffectMobEffect());
	public static final RegistryObject<MobEffect> METAL_BODY_COOLDOWN = REGISTRY.register("metal_body_cooldown", () -> new MetalBodyCooldownMobEffect());
	public static final RegistryObject<MobEffect> PAPER_ARTS_COOLDOWN = REGISTRY.register("paper_arts_cooldown", () -> new PaperArtsCooldownMobEffect());
	public static final RegistryObject<MobEffect> FALL_DAMAGE_IMMUNITY = REGISTRY.register("fall_damage_immunity", () -> new FallDamageImmunityMobEffect());
	public static final RegistryObject<MobEffect> PAPER_ARTS_EFFECT = REGISTRY.register("paper_arts_effect", () -> new PaperArtsEffectMobEffect());
}
