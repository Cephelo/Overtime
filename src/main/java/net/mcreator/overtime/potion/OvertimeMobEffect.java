package net.mcreator.overtime.potion;

import java.util.function.Consumer;
import net.mcreator.overtime.potion.OvertimeMobEffect$1;
import net.mcreator.overtime.procedures.OvertimeActivateProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class OvertimeMobEffect extends MobEffect {
   public OvertimeMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      OvertimeActivateProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(new OvertimeMobEffect$1(this));
   }
}
