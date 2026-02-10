package com.morris__.simplekatanas.custom;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent PARRY_CLANG = register(
            "parry.clang"
    );

    public static final SoundEvent PARRY_DULL = register(
            "parry.dull"
    );


    private static SoundEvent register(String id) {
        Identifier identifier = Identifier.of("simple_katanas", id);
        return Registry.register(
                Registries.SOUND_EVENT,
                identifier,
                SoundEvent.of(identifier)
        );
    }
    public static void registerSounds() {}
}
