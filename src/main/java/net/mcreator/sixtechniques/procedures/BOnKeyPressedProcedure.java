package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModEntities;
import net.mcreator.sixtechniques.entity.TempestEntity;

public class BOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA >= 3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX()), (entity.getY() + 1.5), (entity.getZ()), 15, 0.1, 0.1, 0.1, 0);
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new TempestEntity(SixtechniquesModEntities.TEMPEST.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 5, 0, (byte) 10);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 2);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			{
				double _setval = (entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA - 3;
				entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.STAMINA = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
