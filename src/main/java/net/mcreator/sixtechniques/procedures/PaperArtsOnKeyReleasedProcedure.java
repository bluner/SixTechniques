package net.mcreator.sixtechniques.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.sixtechniques.network.SixtechniquesModVariables;

public class PaperArtsOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world) {
		SixtechniquesModVariables.MapVariables.get(world).Flash_Step_Cooldown = 0;
		SixtechniquesModVariables.MapVariables.get(world).syncData(world);
	}
}
