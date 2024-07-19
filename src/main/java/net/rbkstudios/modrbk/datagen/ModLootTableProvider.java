package net.rbkstudios.modrbk.datagen;
import net.minecraft.core.HolderLookup;
import net.rbkstudios.modrbk.datagen.loot.EntityLootTables;
import net.rbkstudios.modrbk.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(EntityLootTables::new, LootContextParamSets.ENTITY)
        ), lookupProvider);
    }
}