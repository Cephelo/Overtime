package net.mcreator.overtime.configuration;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class BetterConfigConfiguration {
   public static final Builder BUILDER = new Builder();
   public static final ForgeConfigSpec SPEC;
   public static final ConfigValue<Boolean> OVERTIMEFORALL;
   public static final ConfigValue<Boolean> SLOW;
   public static final ConfigValue<Boolean> STUN;
   public static final ConfigValue<Double> MIN;
   public static final ConfigValue<Double> MAX;
   public static final ConfigValue<Double> SPEEDAMPLIFIER;

   static {
      BUILDER.push("overtime");
      OVERTIMEFORALL = BUILDER.comment("Overtime will be applied to all entities in the Overtime entity types tag").define("Overtime for All", true);
      SLOW = BUILDER.comment("Mobs lose a level of speed after getting hit").define("Mobs Get Slowed on Hit", true);
      STUN = BUILDER.comment("Mobs can't move at all after getting hit").define("Mobs Get Stunned on Hit", false);
      MIN = BUILDER.comment("Lower values mean Overtime activates sooner").define("Minimum amount of time before a mob's Overtime activates", 120.0D);
      MAX = BUILDER.comment("Higher values mean Overtime activates later").define("Maximum amount of time before a mob's Overtime activates", 200.0D);
      SPEEDAMPLIFIER = BUILDER.comment("0 means Speed I, 1 means Speed II, etc").define("Max Speed Effect level amplifier", 2.0D);
      BUILDER.pop();
      SPEC = BUILDER.build();
   }
}