package net.rbkstudios.modrbk.Bloques;



import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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




//----Registro de bloques
public static final RegistryObject<Block> ENDERIUM = registerBlock("enderium",
        () -> new DropExperienceBlock(
                UniformInt.of(5,6),BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).strength(1.2f).requiresCorrectToolForDrops().sound(SoundType.STONE)
        )



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
