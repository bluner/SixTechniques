package net.mcreator.sixtechniques.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PaperArtsOnKeyPressedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity) {
		execute(null, world, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		double direction = 0;
		double px = 0;
		double py = 0;
		double pz = 0;
		double temphealth = 0;
		if (entity instanceof Player) {
			if (("" + damagesource).endsWith("(mob)") == true || ("" + damagesource).endsWith("(arrow)") == true || ("" + damagesource).endsWith("(trident)") == true || ("" + damagesource).endsWith("(anvil)") == true
					|| ("" + damagesource).endsWith("(fallingblock)") == true || ("" + damagesource).endsWith("(player)") == true || ("" + damagesource).endsWith("(sting)") == true || ("" + damagesource).endsWith("(thrown)") == true
					|| ("" + damagesource).endsWith("(witherSkull)") == true || ("" + damagesource).endsWith("(stalagmite)") == true) {
				if (SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown == 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 5, false, false));
					direction = Mth.nextInt(RandomSource.create(), 1, 4);
					px = entity.getX();
					py = entity.getY();
					pz = entity.getZ();
					if (direction == 1) {
						px = px + 2;
					} else if (direction == 2) {
						px = px - 2;
					} else if (direction == 3) {
						pz = pz + 2;
					} else {
						pz = pz - 2;
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FIREWORK, (entity.getX()), (entity.getY()), (entity.getZ()), 25, 0.5, 1, 0.5, 0);
					{
						Entity _ent = entity;
						_ent.teleportTo(px, py, pz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(px, py, pz, _ent.getYRot(), _ent.getXRot());
					}
					SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 0;
					SixtechniquesModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
