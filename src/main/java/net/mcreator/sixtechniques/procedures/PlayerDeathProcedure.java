package net.mcreator.sixtechniques.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			SixtechniquesModVariables.MapVariables.get(world).Metal_Body_Cooldown = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			SixtechniquesModVariables.MapVariables.get(world).Geppo_Cooldown = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			SixtechniquesModVariables.MapVariables.get(world).Geppo_Delay = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
			{
				double _setval = 10;
				entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.STAMINA = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			SixtechniquesModVariables.MapVariables.get(world).Stamina_Regen = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
