package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class GeppoOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SixtechniquesModVariables.MapVariables.get(world).Geppo_Cooldown > 0) {
			SixtechniquesModVariables.MapVariables.get(world).Geppo_Cooldown = SixtechniquesModVariables.MapVariables.get(world).Geppo_Cooldown - 1;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			entity.setDeltaMovement(new Vec3(0, 1, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 0.1, 0.1, 0.1, 0.1);
		} else {
			SixtechniquesMod.queueServerWork(200, () -> {
				SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown = 5;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
