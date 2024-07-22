package net.rbkstudios.modrbk.Efectos;


import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.rbkstudios.modrbk.Efectos.Custom.Plague;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;


public class InicializarEfectos {

    public static final DeferredRegister<MobEffect> EFECTOS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Modrbk.MODID);



    public static final RegistryObject<MobEffect> PLAGUE = EFECTOS.register("plague",
            () -> new Plague(MobEffectCategory.HARMFUL, 0x000000));







    public static void registrar(IEventBus bus){
        EFECTOS.register(bus);
    }

}
