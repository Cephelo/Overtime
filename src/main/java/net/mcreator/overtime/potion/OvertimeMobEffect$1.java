package net.mcreator.overtime.potion;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

class OvertimeMobEffect$1 implements IClientMobEffectExtensions {
   // $FF: synthetic field
   final OvertimeMobEffect this$0;

   OvertimeMobEffect$1(OvertimeMobEffect this$0) {
      this.this$0 = this$0;
   }

   public boolean isVisibleInInventory(MobEffectInstance effect) {
      return false;
   }

   public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, PoseStack poseStack, int x, int y, int blitOffset) {
      return false;
   }

   public boolean isVisibleInGui(MobEffectInstance effect) {
      return false;
   }
}
