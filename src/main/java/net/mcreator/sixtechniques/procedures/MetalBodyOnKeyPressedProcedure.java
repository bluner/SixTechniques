package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModMobEffects;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class MetalBodyOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SixtechniquesModVariables.MapVariables.get(world).Metal_Body_Cooldown == 0) {
			SixtechniquesModVariables.MapVariables.get(world).Metal_Body_Cooldown = 1200;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SixtechniquesModMobEffects.METAL_BODY_COOLDOWN.get(), 1200, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SixtechniquesModMobEffects.METAL_BODY_EFFECT.get(), 200, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false));
		}
		if (SixtechniquesModVariables.MapVariables.get(world).Metal_Body_Cooldown > 0) {
			SixtechniquesMod.queueServerWork(1200, () -> {
				SixtechniquesModVariables.MapVariables.get(world).Metal_Body_Cooldown = 0;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
