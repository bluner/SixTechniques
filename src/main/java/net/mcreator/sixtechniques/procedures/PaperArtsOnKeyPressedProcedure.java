package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.init.SixtechniquesModMobEffects;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class PaperArtsOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double direction = 0;
		double px = 0;
		double py = 0;
		double pz = 0;
		double temphealth = 0;
		if (SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown < 6) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 5, false, false));
			direction = Mth.nextInt(RandomSource.create(), 1, 4);
			px = entity.getX();
			py = entity.getY();
			pz = entity.getZ();
			if (direction == 1) {
				px = px + 3;
			} else if (direction == 2) {
				px = px - 3;
			} else if (direction == 3) {
				pz = pz + 3;
			} else {
				pz = pz - 3;
			}
			{
				Entity _ent = entity;
				_ent.teleportTo(px, py, pz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(px, py, pz, _ent.getYRot(), _ent.getXRot());
			}
			SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown + 1;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SixtechniquesModMobEffects.PAPER_ARTS_COOLDOWN.get(), 600, 1, false, false));
			SixtechniquesMod.queueServerWork(600, () -> {
				SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 0;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
