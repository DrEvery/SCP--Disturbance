package io.github.connortron110.connorsapi.datagen;

import com.drevery.scpdisturbance.SCPDisturbance;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SoundsProvider extends SoundDefinitionsProvider {

    private static final Map<Lazy<SoundEvent>, ModSoundDefinition> soundDefinitions = new HashMap<>();

    public static void addSoundDefinition(RegistryObject<SoundEvent> reg, ModSoundDefinition definition) {
        soundDefinitions.put(reg::get, definition);
    }

    /**
     * Creates a new instance of this data provider.
     *
     * @param generator The data generator instance provided by the event you are initializing this provider in.
     * @param helper    The existing file helper provided by the event you are initializing this provider in.
     */
    protected SoundsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, SCPDisturbance.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        soundDefinitions.forEach((soundEvent, definition) -> add(soundEvent.get().getLocation(), definition.build()));
    }

    public static class ModSoundDefinition {
        private final SoundDefinition definition = definition();
        private final String relativePath;

        public ModSoundDefinition(String relativePath) {
            this.relativePath = relativePath;
        }
        public ModSoundDefinition() {
            this("");
        }

        /**
         * Adds a subtitle to the sound.
         * Currently, have to manually add the translation
         * @param subtitle the translation text for the sound
         * @return this instance
         */
        public ModSoundDefinition subtitle(String subtitle) {
            definition.subtitle(subtitle);
            return this;
        }

        /**
         * Used for sounds with more than one variant,
         * Sounds using this method should start with a 1
         * The number is appended after name E.G. hurt1, hurt2 etc..
         */
        public ModSoundDefinition sound(String location, int amount) {
            if (amount < 2) {
                SCPDisturbance.LOGGER.warn("Invalid Amount on Sound name: " + location);
                SCPDisturbance.LOGGER.warn("Adding one sound and proceeding");
                sound(location, false);
                return this;
            }

            for (int i = 1; i != amount+1; i++) {
                sound(location+i, false);
            }

            return this;
        }

        /**
         * Adds a single sound with a stream variable
         * @param location location of the sound in relation to relativePath
         * @param stream sets if the sound should be a stream (Steams are meant for long sounds like music discs, please limit to how many we do)
         * @return this Instance
         */
        public ModSoundDefinition sound(String location, boolean stream) {
            definition.with(SoundsProvider.sound(new ResourceLocation(SCPDisturbance.MOD_ID, (relativePath.equals("") ? location : "scp/"+relativePath+"/"+location))).stream(stream));
            return this;
        }

        /**
         * Alternative to number version however doesn't add numbers and adds list of Strings as-is provided
         */
        public ModSoundDefinition sound(String... location) {
            Arrays.asList(location).forEach(s -> sound(s, false));
            return this;
        }

        /**
         * Adds a sound, no questions asked
         * @param location location of the file (in relation to the relative path)
         * @return this instance
         */
        public ModSoundDefinition sound(String location) {
            this.sound(location, false);
            return this;
        }

        public SoundDefinition build() {
            //TODO detect if definition made without any sounds
            return definition;
        }
    }
}
