package net.mcreator.overtime.procedures;

import javax.annotation.Nullable;
import net.mcreator.overtime.configuration.BetterConfigConfiguration;
import net.mcreator.overtime.init.OvertimeModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OvertimeStartProcedure {
   @SubscribeEvent
   public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity sourceentity) {
      execute((Event)null, sourceentity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null && entity instanceof LivingEntity) {
         LivingEntity sourceentity = (LivingEntity)entity;
         if ((Boolean)BetterConfigConfiguration.OVERTIMEFORALL.get() && sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("overtime:overtime")))) {
            if (sourceentity.isBaby()) return;
            if (sourceentity.hasEffect((MobEffect)OvertimeModMobEffects.OVERTIME.get())) return;

			if (!sourceentity.getCommandSenderWorld().isClientSide()) {
                sourceentity.addEffect(new MobEffectInstance((MobEffect)OvertimeModMobEffects.OVERTIME.get(), (int)Mth.nextDouble(RandomSource.create(), (Double)BetterConfigConfiguration.MIN.get(), (Double)BetterConfigConfiguration.MAX.get()), 0, false, false));
            }
         }

      }
   }
}
