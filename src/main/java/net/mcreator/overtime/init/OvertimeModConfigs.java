package net.mcreator.overtime.init;

import net.mcreator.overtime.configuration.BetterConfigConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@EventBusSubscriber(
   modid = "overtime",
   bus = Bus.MOD
)
public class OvertimeModConfigs {
   @SubscribeEvent
   public static void register(FMLConstructModEvent event) {
      event.enqueueWork(() -> {
         ModLoadingContext.get().registerConfig(Type.COMMON, BetterConfigConfiguration.SPEC, "overtime.toml");
      });
   }
}
