package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModEntities;
import net.mcreator.sixtechniques.entity.TempestEntity;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class BOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (SixtechniquesModVariables.MapVariables.get(world).Tempest_Kick_Cooldown == 0) {
			SixtechniquesModVariables.MapVariables.get(world).Tempest_Kick_Cooldown = 1;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
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
			SixtechniquesMod.queueServerWork(60, () -> {
				SixtechniquesModVariables.MapVariables.get(world).Tempest_Kick_Cooldown = 0;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
