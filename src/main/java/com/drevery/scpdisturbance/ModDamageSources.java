package com.drevery.scpdisturbance;

import net.minecraft.util.DamageSource;

public class ModDamageSources {
    public static final DamageSource SCP_002_BED = new DamageSource("002_bed").setDamageIsAbsolute().setDamageBypassesArmor();
    public static final DamageSource SCP_002_TRAP = new DamageSource("002_trap").setDamageIsAbsolute();
    public static final DamageSource SCP_002_SINK = new DamageSource("002_sink").setDamageIsAbsolute().setDamageBypassesArmor();
}
