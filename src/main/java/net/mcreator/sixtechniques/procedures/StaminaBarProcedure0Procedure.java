package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;

public class StaminaBarProcedure0Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(SixtechniquesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SixtechniquesModVariables.PlayerVariables())).STAMINA == 0) {
			return true;
		}
		return false;
	}
}