package net.rbkstudios.modrbk.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Modrbk;

import javax.swing.plaf.PanelUI;

public class InicializarItems {

     //DefferedRegister = clase que permite registrar cosas en Forge. <Items> es el tipo

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modrbk.MODID);



    //Inicializar El item en cuestion
    public static final RegistryObject<Item> PRUEBA = ITEMS.register("prueba",()->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> FRAGMENTO_DE_ENDERIUM = ITEMS.register("fragmento_de_enderium",()->
            new Item(new Item.Properties()));



    public static final RegistryObject<Item> FRUTA = ITEMS.register("fruta",()->
            new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .alwaysEdible()
                    .saturationModifier(3)
                    .effect(new MobEffectInstance(InicializarEfectos.HELLTOUCH.getHolder().get(),1000,1),2)
                    .build()
            )));




    //IeventBus es una interfaz que detecta cuando el juego esta en pantalla de carga y ahi registra el item
    public static void registrar(IEventBus bus){
        ITEMS.register(bus);
    }






}
