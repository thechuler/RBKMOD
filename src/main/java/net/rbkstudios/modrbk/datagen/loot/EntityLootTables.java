package net.rbkstudios.modrbk.datagen.loot;

import net.minecraft.core.HolderLookup;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;

import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.items.InicializarItems;
import java.util.stream.Stream;

public class EntityLootTables extends EntityLootSubProvider {


    public EntityLootTables(HolderLookup.Provider provider) {
        super(FeatureFlags.REGISTRY.allFlags(), provider);
    }


    @Override
    public void generate() {
       add(InicializarEntidades.FROGMAN_ENTITY.get(), LootTable.lootTable()
               .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                       .add(LootItem.lootTableItem(InicializarItems.RAW_FROG_MEAT.get()))
                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))


               )
               .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                       .add(LootItem.lootTableItem(InicializarItems.POISON_GLAND.get()))
                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                       .when(LootItemRandomChanceCondition.randomChance(0.5f)) // Probabilidad de 50%

               )


       );


        add(InicializarEntidades.MOSKABUM_ENTITY.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))


                )
        );


    }


    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return InicializarEntidades.ENTIDADES.getEntries().stream().map(RegistryObject::get);
    }
}
