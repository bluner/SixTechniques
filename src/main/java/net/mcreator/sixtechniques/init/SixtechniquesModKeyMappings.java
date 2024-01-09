
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.sixtechniques.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.sixtechniques.network.MetalBodyMessage;
import net.mcreator.sixtechniques.network.GeppoMessage;
import net.mcreator.sixtechniques.network.FlashStepMessage;
import net.mcreator.sixtechniques.SixtechniquesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SixtechniquesModKeyMappings {
	public static final KeyMapping FLASH_STEP = new KeyMapping("key.sixtechniques.flash_step", GLFW.GLFW_KEY_V, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SixtechniquesMod.PACKET_HANDLER.sendToServer(new FlashStepMessage(0, 0));
				FlashStepMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GEPPO = new KeyMapping("key.sixtechniques.geppo", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SixtechniquesMod.PACKET_HANDLER.sendToServer(new GeppoMessage(0, 0));
				GeppoMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping METAL_BODY = new KeyMapping("key.sixtechniques.metal_body", GLFW.GLFW_KEY_C, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SixtechniquesMod.PACKET_HANDLER.sendToServer(new MetalBodyMessage(0, 0));
				MetalBodyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FLASH_STEP);
		event.register(GEPPO);
		event.register(METAL_BODY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				FLASH_STEP.consumeClick();
				GEPPO.consumeClick();
				METAL_BODY.consumeClick();
			}
		}
	}
}
