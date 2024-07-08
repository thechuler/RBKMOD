package net.rbkstudios.modrbk.Pociones;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Modrbk;

public class InicializadorPociones {

    public static final DeferredRegister<Potion> POCIONES = DeferredRegister.create(ForgeRegistries.POTIONS, Modrbk.MODID);

   public static final RegistryObject<Potion> POCIONRETORNO = POCIONES.register("pocionretorno",
           ()-> new Potion(new MobEffectInstance(InicializarEfectos.RETORNO.getHolder().get())));

    public static final RegistryObject<Potion> POCIONHELLTOUCH = POCIONES.register("pocionhelltouch",
            ()-> new Potion(new MobEffectInstance(InicializarEfectos.HELLTOUCH.getHolder().get(),20,1)));


    public static void registrar(IEventBus bus){
        POCIONES.register(bus);
    }


}
