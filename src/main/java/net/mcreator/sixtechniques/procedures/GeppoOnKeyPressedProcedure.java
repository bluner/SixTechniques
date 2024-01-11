package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModMobEffects;

public class GeppoOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA >= 2) {
			if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ()))) {
				{
					double _setval = (entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA - 2;
					entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.STAMINA = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(SixtechniquesModMobEffects.FALL_DAMAGE_IMMUNITY.get(), 60, 1, false, false));
				entity.setDeltaMovement(new Vec3(0, 1, 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.25, 0.25, 0.25, 0);
			}
		}
	}
}
