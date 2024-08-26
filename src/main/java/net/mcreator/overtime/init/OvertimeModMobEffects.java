package net.mcreator.overtime.init;

import net.mcreator.overtime.potion.OvertimeMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OvertimeModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY;
   public static final RegistryObject<MobEffect> OVERTIME;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "overtime");
      OVERTIME = REGISTRY.register("overtime", () -> {
         return new OvertimeMobEffect();
      });
   }
}
