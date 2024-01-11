
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sixtechniques.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.sixtechniques.entity.TempestEntity;
import net.mcreator.sixtechniques.SixtechniquesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SixtechniquesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SixtechniquesMod.MODID);
	public static final RegistryObject<EntityType<TempestEntity>> TEMPEST = register("projectile_tempest",
			EntityType.Builder.<TempestEntity>of(TempestEntity::new, MobCategory.MISC).setCustomClientFactory(TempestEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
