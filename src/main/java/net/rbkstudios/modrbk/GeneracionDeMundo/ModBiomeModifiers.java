package net.rbkstudios.modrbk.GeneracionDeMundo;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.Modrbk;

import java.util.Collections;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> AGREGAR_PIEDRA_CARGADA = registerKey("agregar_piedra_cargada");
    public static final ResourceKey<BiomeModifier> SPAWNEAR_FROGMAN = registerKey("spawn_frogman");
    public static final ResourceKey<BiomeModifier> SPAWNEAR_NITROMOSCA = registerKey("spawn_nitromosca");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(AGREGAR_PIEDRA_CARGADA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PIEDRA_CARGADA_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));







        HolderSet<Biome> BIOMASFROGMAN = HolderSet.direct(
                biomes.getOrThrow(Biomes.SWAMP),
                biomes.getOrThrow(Biomes.MANGROVE_SWAMP)  // Agrega otro bioma, por ejemplo, el bioma FOREST
        );


        context.register(SPAWNEAR_FROGMAN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                BIOMASFROGMAN,

                Collections.singletonList(new MobSpawnSettings.SpawnerData(
                        InicializarEntidades.FROGMAN_ENTITY.get(),
                        100,  // Peso de generación
                        4,
                        6
                ))
        ));




        HolderSet<Biome> BIOMANITROMOSCA = HolderSet.direct(biomes.getOrThrow(Biomes.WARPED_FOREST));


        context.register(SPAWNEAR_NITROMOSCA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                BIOMANITROMOSCA,

                Collections.singletonList(new MobSpawnSettings.SpawnerData(
                        InicializarEntidades.MOSKABUM_ENTITY.get(),
                        80,  // Peso de generación
                        6,
                        10
                ))
        ));








    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Modrbk.MODID, name));
    }

}
