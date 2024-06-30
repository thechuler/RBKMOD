package net.rbkstudios.modrbk;

import com.mojang.logging.LogUtils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rbkstudios.modrbk.items.InicializarItems;
import org.slf4j.Logger;


@Mod(Modrbk.MODID)
public class Modrbk
{

    public static final String MODID = "rbk";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Modrbk()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        InicializarItems.registrar(modEventBus); // <---Llamo a la funcion para registrarlo.



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);



    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {


    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
