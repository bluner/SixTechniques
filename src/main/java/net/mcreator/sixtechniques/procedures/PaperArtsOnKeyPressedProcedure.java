package net.mcreator.sixtechniques.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PaperArtsOnKeyPressedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		double direction = 0;
		double px = 0;
		double py = 0;
		double pz = 0;
		double temphealth = 0;
	}
}
