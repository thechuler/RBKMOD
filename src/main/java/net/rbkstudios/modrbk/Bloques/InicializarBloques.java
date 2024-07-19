package net.rbkstudios.modrbk.Bloques;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Bloques.custom.PoisonOre;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.items.InicializarItems;

import java.util.function.Supplier;

public class InicializarBloques {

    public static final DeferredRegister<Block> BLOQUES =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modrbk.MODID);




//----Registro de bloques
public static final RegistryObject<Block> PIEDRACARGADA = registerBlock("piedra_cargada",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
);


public static final RegistryObject<Block> BANANITE_ORE = registerBlock("bananite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE))
    );

    public static final RegistryObject<Block> POISON_ORE = registerBlock("poison_ore",
            () -> new PoisonOre(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
    );






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
