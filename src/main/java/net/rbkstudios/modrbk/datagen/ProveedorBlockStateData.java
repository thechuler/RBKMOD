package net.rbkstudios.modrbk.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.Modrbk;

public class ProveedorBlockStateData extends BlockStateProvider {

    public ProveedorBlockStateData(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Modrbk.MODID, exFileHelper);
    }



    // Aca se van a registrar los modelos de los bloques.
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(InicializarBloques.ENDERIUM);

    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


}
