package net.mcreator.sixtechniques.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;
import net.mcreator.sixtechniques.SixtechniquesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StaminaRegenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA < 10) {
			if (SixtechniquesModVariables.MapVariables.get(world).Stamina_Regen == 0) {
				SixtechniquesModVariables.MapVariables.get(world).Stamina_Regen = 1;
				SixtechniquesModVariables.MapVariables.get(world).syncData(world);
				{
					double _setval = (entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA + 1;
					entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.STAMINA = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				SixtechniquesMod.queueServerWork(20, () -> {
					SixtechniquesModVariables.MapVariables.get(world).Stamina_Regen = 0;
					SixtechniquesModVariables.MapVariables.get(world).syncData(world);
				});
			}
		}
	}
}
