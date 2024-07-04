package net.rbkstudios.modrbk.Bloques;



import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.items.InicializarItems;

import java.util.function.Supplier;

public class InicializarBloques {

    public static final DeferredRegister<Block> BLOQUES =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modrbk.MODID);












    // Se registra el bloque y se llama a registrar item del bloque
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOQUES.register(name, block);
        RegistrarItemDelBloque(name, toReturn);
        return toReturn;
    }



    // Se registra el item del bloque obteniendolo desde el mismo bloque
    private static <T extends Block> RegistryObject<Item> RegistrarItemDelBloque(String name, RegistryObject<T> block) {
        return InicializarItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void registrar(IEventBus bus){
        BLOQUES.register(bus);
    }

}
