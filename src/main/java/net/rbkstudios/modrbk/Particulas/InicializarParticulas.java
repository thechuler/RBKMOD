package net.rbkstudios.modrbk.Particulas;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarParticulas {

    public static final DeferredRegister<ParticleType<?>> PARTICULAS =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Modrbk.MODID);



    public static final RegistryObject<SimpleParticleType> PARTICULAS_DE_CRISTAL =
            PARTICULAS.register("particulas_de_cristal", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> MOSCAS =
            PARTICULAS.register("moscas", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICULAS.register(eventBus);
    }


}
