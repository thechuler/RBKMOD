package net.rbkstudios.modrbk.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.items.custom.CristalDeTierra;
import net.rbkstudios.modrbk.items.custom.cristalDeCambio;
import net.rbkstudios.modrbk.items.custom.geodaItem;




public class InicializarItems {

     //DefferedRegister = clase que permite registrar cosas en Forge. <Items> es el tipo

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modrbk.MODID);



    //Inicializar El item en cuestion

    public static final RegistryObject<Item> GEODA = ITEMS.register("geoda",()->
            new geodaItem(new Item.Properties()));

    public static final RegistryObject<Item> CRISTAL_DE_CAMBIO = ITEMS.register("cristal_de_cambio",()->
            new cristalDeCambio(new Item.Properties()));


    public static final RegistryObject<Item> BANANITE = ITEMS.register("bananite",()->
            new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .effect(new MobEffectInstance(InicializarEfectos.POTTASIUM_RUSH.getHolder().get(),42),100)
                            .alwaysEdible()
                                    .build()

            )));


    public static final RegistryObject<Item> FROG_MAN_SPAWN_EGG = ITEMS.register("frogman_spawn_egg",
            () -> new ForgeSpawnEggItem(InicializarEntidades.FROGMAN_ENTITY, 0x428430, 0xa8a84e, new Item.Properties()));



    public static final RegistryObject<Item> POISON_DUST = ITEMS.register("poison_dust",()->
            new Item(new Item.Properties()));






    //IeventBus es una interfaz que detecta cuando el juego esta en pantalla de carga y ahi registra el item
    public static void registrar(IEventBus bus){
        ITEMS.register(bus);
    }






}
