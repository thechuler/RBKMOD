package net.rbkstudios.modrbk.datagen.loot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;

import java.util.Set;
public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return InicializarBloques.BLOQUES.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}