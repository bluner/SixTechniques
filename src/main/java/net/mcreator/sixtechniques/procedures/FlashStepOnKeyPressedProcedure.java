package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class FlashStepOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown == 0) {
			SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown = 60;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 0.5, 1, 0.5, 0);
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
							_ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 0.5, 1, 0.5, 0);
		}
		if (SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown > 0) {
			SixtechniquesMod.queueServerWork(60, () -> {
				SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown = 0;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
