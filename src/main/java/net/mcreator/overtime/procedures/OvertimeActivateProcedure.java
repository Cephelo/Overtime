package net.mcreator.overtime.procedures;

import net.mcreator.overtime.configuration.BetterConfigConfiguration;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OvertimeActivateProcedure {
   public static void execute(Entity enentity) {
      if (enentity != null && enentity instanceof LivingEntity && !enentity.getCommandSenderWorld().isClientSide()) {
        LivingEntity entity = (LivingEntity)enentity;
		if (entity.hasEffect(MobEffects.MOVEMENT_SPEED)) {
		   int effectAmplifier = entity.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier();

		   if ((double)effectAmplifier < (Double)BetterConfigConfiguration.SPEEDAMPLIFIER.get()) {
			  int effectAmplifierTwo = entity.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier();
			  entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, effectAmplifierTwo + 1, false, false));
		   }
		} else {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0, false, false));
		}
      }
   }
}
