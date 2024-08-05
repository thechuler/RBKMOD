package net.rbkstudios.modrbk.datagen.loot;
import net.minecraft.core.HolderLookup;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.items.InicializarItems;

import java.util.Set;
public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
        this.add(InicializarBloques.PIEDRACARGADA.get(),
               block -> createOreDrop(InicializarBloques.PIEDRACARGADA.get(),InicializarItems.GEODA.get())
                );


        this.add(InicializarBloques.POISON_ORE.get(),
                block -> createOreDrop(InicializarBloques.POISON_ORE.get(),InicializarItems.POISON_DUST.get())
        );


        this.add(InicializarBloques.BLOQUE_NITRO_FLUIDO.get(),
                block -> createRedstoneOreDrops(InicializarBloques.BLOQUE_NITRO_FLUIDO.get()));


        this.dropSelf(InicializarBloques.BLOQUE_NITRO_CONCENTRADO.get());

    }



    protected LootTable.Builder createRedstoneOreDrops(Block pBlock) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock, LootItem.lootTableItem(InicializarItems.NITRO_FLUIDO.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return InicializarBloques.BLOQUES.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}