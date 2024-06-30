package net.rbkstudios.modrbk.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Modrbk;

import javax.swing.plaf.PanelUI;

public class InicializarItems {

     //DefferedRegister = clase que permite registrar cosas en Forge. <Items> es el tipo

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Modrbk.MODID);



    //Inicializar El item en cuestion
    public static final RegistryObject<Item> PRUEBA = ITEMS.register("prueba",()->
            new Item(new Item.Properties()));



    //IeventBus es una interfaz que detecta cuando el juego esta en pantalla de carga y ahi registra el item
    public static void registrar(IEventBus bus){
        ITEMS.register(bus);
    }






}
