package net.mcreator.overtime.procedures;

import javax.annotation.Nullable;
import net.mcreator.overtime.configuration.BetterConfigConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OvertimeInterruptedProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity());
      }
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity enentity) {
      if (enentity != null && enentity instanceof LivingEntity && !enentity.getCommandSenderWorld().isClientSide()) {
      	 LivingEntity entity = (LivingEntity)enentity;
         if ((Boolean)BetterConfigConfiguration.OVERTIMEFORALL.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("overtime:overtime")))) {
            entity.removeEffect(MobEffects.MOVEMENT_SPEED);
         }

         if ((Boolean)BetterConfigConfiguration.STUN.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("overtime:overtime")))) {
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 4, false, true));
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 4, false, false));
         }

         if ((Boolean)BetterConfigConfiguration.SLOW.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("overtime:overtime")))) {
            if (entity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            	int effectAmplifier = entity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, effectAmplifier + 1, false, true));
            } else {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 0, false, true));
            }
               
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 4, false, false));
         }

      }
   }
}
