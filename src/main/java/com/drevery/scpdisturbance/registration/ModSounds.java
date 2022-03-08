package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.utils.Utils;
import io.github.connortron110.connorsapi.datagen.SoundsProvider;
import io.github.connortron110.connorsapi.datagen.SoundsProvider.ModSoundDefinition;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * When you add a sound here, remember to runData before you run the client, otherwise the sound would be registered, but no way of minecraft knowing where the sound is.
 */
public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SCPDisturbance.MOD_ID);

    //Start registration code here


    //Here is some explanation on what to do with this registry, here is one example
    //public static final RegistryObject<SoundEvent> VENDING_AMBIENCE = register("vending_machine_ambience", new ModSoundDefinition().sound("vending_machine_ambience"));

    //public static final RegistryObject<SoundEvent> VENDING_AMBIENCE    Should be Quite obvious on what it's meant to be and why
    //register(String, ModSoundDefinition)                               Takes in two parameters, the first param being a string which is what we will use in game to reference that sound.
    //                                                                   With the example above the param is "vending_machine_ambience" so in-game we would do "/playsound scpdisturbance:vending_machine_ambience"
    //                                                                   The Second Param is a custom class I made, I tried putting as much documentation in there however basics are...
    //new ModSoundsDefinition() <-- Whatever is in the brackets, is the relative path, if you leave this empty the path would be assets/scpdisturbance/sounds/...
    //However new ModSoundsDefinition("lol") will then change it to assets/scpdisturbance/sounds/lol/...
    //
    //Next is the .sound() coming off the definition, this defines a sound location, so the location of the .oog in relation to the relative path, so...
    //new ModSoundsDefinition().sound("test") <-- Would be "assets/scpdisturbance/sounds/test.oog" Note that you don't need to add the .oog at the end like you don't have to with textures
    //And then new ModSoundsDefinition("scp").sound("test") <-- Would be "assets/scpdisturbance/sounds/scp/test.oog"
    //
    //Here are some other examples with multiple possible configurations
    //public static final RegistryObject<SoundEvent> GENERIC_STEP = register("generic_step", new ModSoundDefinition().sound("generic_step", 4));
    //public static final RegistryObject<SoundEvent> SCP066_IDLE = register("066_idle", new ModSoundDefinition("066").sound("eric", 3).sound("notes", 6));
    //public static final RegistryObject<SoundEvent> SCP131_WALK = register("131_walk", new ModSoundDefinition("131").sound("walkshort", "walkmedium", "walklong"));
    //
    //For .sound("generic_step", 4) means that there will be 4 of that sound, what I mean is the location is still "assets/scpdisturbance/sounds/generic_step.oog" -
    //however we are appending and adding how many there are, so instead of the single sound we now have generic_step1, generic_step2, generic_step3, generic_step4, and this increases with the higher number you put. Remember, these files have to exist.
    //
    //For .sound("eric", 3).sound("notes", 6) It is the same principle, but we are now adding eric1, eric2, eric3 AND notes1, notes2 etc... (Remember its all in the same location of "assets/scpdisturbance/sounds/066/<name>.oog")
    //
    //And Finally for .sound("walkshort", "walkmedium", "walklong") mean its a hard coded version of the number iteration except without numbers, so we are adding multiple sounds, but with one method.
    //.sound("walkshort").sound("walkmedium").sound("walklong") == .sound("walkshort", "walkmedium", "walklong")


    private static RegistryObject<SoundEvent> register(String name, ModSoundDefinition soundDefinition) {
        RegistryObject<SoundEvent> reg =  SOUNDS.register(name, () -> new SoundEvent(Utils.rl(name)));
        SoundsProvider.addSoundDefinition(reg, soundDefinition);
        return reg;
    }
}
