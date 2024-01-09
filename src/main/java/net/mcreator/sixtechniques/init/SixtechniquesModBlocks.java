
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sixtechniques.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.sixtechniques.block.SuperDirtBlock;
import net.mcreator.sixtechniques.SixtechniquesMod;

public class SixtechniquesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SixtechniquesMod.MODID);
	public static final RegistryObject<Block> SUPER_DIRT = REGISTRY.register("super_dirt", () -> new SuperDirtBlock());
}
