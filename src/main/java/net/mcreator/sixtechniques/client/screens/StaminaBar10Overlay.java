
package net.mcreator.sixtechniques.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.sixtechniques.procedures.StaminaBarProcedure10Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class StaminaBar10Overlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (StaminaBarProcedure10Procedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 80, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 75, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 70, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 65, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 35, h - 34, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 60, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 55, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 50, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 45, h / 2 + 86, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(new ResourceLocation("sixtechniques:textures/screens/smaller_stamina_bar.png"), w / 2 + 40, h / 2 + 86, 0, 0, 16, 16, 16, 16);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
