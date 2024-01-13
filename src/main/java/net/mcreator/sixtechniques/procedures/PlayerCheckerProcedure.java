package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;

public class PlayerCheckerProcedure {
	public static void execute(LevelAccessor world) {
		if (SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown == 0) {
			SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 1;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
		} else {
			SixtechniquesModVariables.MapVariables.get(world).Paper_Arts_Cooldown = 0;
			SixtechniquesModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
