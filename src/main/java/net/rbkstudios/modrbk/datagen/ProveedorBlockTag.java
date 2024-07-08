package net.rbkstudios.modrbk.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Modrbk;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ProveedorBlockTag extends BlockTagsProvider {

    public ProveedorBlockTag(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Modrbk.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(InicializarBloques.ENDERIUM.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(InicializarBloques.ENDERIUM.get());

    }


}
