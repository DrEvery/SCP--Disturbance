package com.drevery.scpdisturbance;

import net.minecraft.util.DamageSource;

public class ModDamageSources {
    public static final DamageSource SCP_002_BED = new DamageSource("002_bed").bypassMagic().bypassArmor();
    public static final DamageSource SCP_002_TRAP = new DamageSource("002_trap").bypassMagic();
    public static final DamageSource SCP_002_SINK = new DamageSource("002_sink").bypassMagic().bypassArmor();
}
