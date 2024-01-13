package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModMobEffects;

public class PlayerCheckerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown == 0) {
			SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 1;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SixtechniquesModMobEffects.PAPER_ARTS_EFFECT.get(), 7200000, 1, false, false));
		} else {
			SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(SixtechniquesModMobEffects.PAPER_ARTS_EFFECT.get());
		}
	}
}
