package net.rbkstudios.modrbk.Sonidos;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarSonidos {

    public static final DeferredRegister<SoundEvent> SONIDOS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Modrbk.MODID);




    public static final RegistryObject<SoundEvent> TEST = registerSoundEvents("test");
    public static final RegistryObject<SoundEvent> CRISTAL_TELEPORT = registerSoundEvents("cristal_teleport");



    public static final RegistryObject<SoundEvent> FROGMANAMBIENT = registerSoundEvents("frogmanambient");
    public static final RegistryObject<SoundEvent> FROGMANHURT = registerSoundEvents("frogmanhurt");
    public static final RegistryObject<SoundEvent> FROGMANDEATH= registerSoundEvents("frogmandeath");
    public static final RegistryObject<SoundEvent> FROGMANEASTEREGG= registerSoundEvents("frogmaneasteregg");


    public static final RegistryObject<SoundEvent> MOSCAS = registerSoundEvents("moscas");






    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SONIDOS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,name)));
    }


    public static void register(IEventBus eventBus) {
        SONIDOS.register(eventBus);
    }

}
