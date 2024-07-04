package net.rbkstudios.modrbk.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rbkstudios.modrbk.Modrbk;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ProveedorItemTag extends ItemTagsProvider {

    public ProveedorItemTag(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Modrbk.MODID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }


}
