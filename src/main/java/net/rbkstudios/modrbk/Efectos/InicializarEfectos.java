package net.rbkstudios.modrbk.Efectos;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Efectos.Custom.HellTouch;
import net.rbkstudios.modrbk.Efectos.Custom.Retorno;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarEfectos {

    public static final DeferredRegister<MobEffect> EFECTOS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Modrbk.MODID);




    public static final RegistryObject<MobEffect> HELLTOUCH = EFECTOS.register("helltouch",
            () -> new HellTouch(MobEffectCategory.BENEFICIAL, 0xFF0F00));


    public static final RegistryObject<MobEffect> RETORNO = EFECTOS.register("retorno",
            () -> new Retorno(MobEffectCategory.NEUTRAL, 0x1E90FF));



    public static void registrar(IEventBus bus){
        EFECTOS.register(bus);
    }

}
