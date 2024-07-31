package net.rbkstudios.modrbk.items;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.rbkstudios.modrbk.items.custom.*;


public class InicializarItems {

     //DefferedRegister = clase que permite registrar cosas en Forge. <Items> es el tipo

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modrbk.MODID);



    //Inicializar El item en cuestion

    public static final RegistryObject<Item> GEODA = ITEMS.register("geoda",()->
            new geodaItem(new Item.Properties()));

    public static final RegistryObject<Item> CRISTAL_DE_CAMBIO = ITEMS.register("cristal_de_cambio",()->
            new cristalDeCambio(new Item.Properties()));

    public static final RegistryObject<Item> BAG_OF_FLIES = ITEMS.register("bag_of_flies",()->
            new BagOfFlies(new Item.Properties()));








    public static final RegistryObject<Item> FROG_MAN_SPAWN_EGG = ITEMS.register("frogman_spawn_egg",
            () -> new ForgeSpawnEggItem(InicializarEntidades.FROGMAN_ENTITY, 0x428430, 0xa8a84e, new Item.Properties()));


    public static final RegistryObject<Item> POISON_GLAND = ITEMS.register("poison_gland",()->
            new Item(new Item.Properties()));


    public static final RegistryObject<Item> RAW_FROG_MEAT = ITEMS.register("raw_frog_meat",()->
            new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(1.2f)
                            .effect(new MobEffectInstance(MobEffects.POISON,100),30)
                    .build())));


    public static final RegistryObject<Item> COOKED_FROG_MEAT = ITEMS.register("cooked_frog_meat",()->
            new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(5.2f)
                    .build())));



    public static final RegistryObject<Item> POISON_DUST = ITEMS.register("poison_dust",()->
            new Item(new Item.Properties()));









    public static final RegistryObject<Item> MOSKABUM_SPAWN_EGG = ITEMS.register("moskabum_spawn_egg",
            () -> new ForgeSpawnEggItem(InicializarEntidades.MOSKABUM_ENTITY, 0x701717, 0x2ca3a3, new Item.Properties()));



    public static final RegistryObject<Item> ARMA = ITEMS.register("arma",()->
            new armaitem(new Item.Properties().stacksTo(1)));




    //IeventBus es una interfaz que detecta cuando el juego esta en pantalla de carga y ahi registra el item
    public static void registrar(IEventBus bus){
        ITEMS.register(bus);
    }






}
