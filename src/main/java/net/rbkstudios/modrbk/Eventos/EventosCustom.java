package net.rbkstudios.modrbk.Eventos;


import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rbkstudios.modrbk.Entidades.Custom.FrogManEntity;
import net.rbkstudios.modrbk.Entidades.Custom.MoskabumEntity;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.Particulas.Custom.ParticulaDeCristal;
import net.rbkstudios.modrbk.Particulas.Custom.ParticulaMoscas;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;


public class EventosCustom {

    @Mod.EventBusSubscriber(modid = Modrbk.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventosForge{


        @SubscribeEvent
        public  static void  RegistrarLugardeSpawn(SpawnPlacementRegisterEvent event){

            event.register(InicializarEntidades.FROGMAN_ENTITY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE,FrogManEntity::PuedeSpawnear,SpawnPlacementRegisterEvent.Operation.OR);
            event.register(InicializarEntidades.MOSKABUM_ENTITY.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,MoskabumEntity::PuedeSpawnear,SpawnPlacementRegisterEvent.Operation.REPLACE);


        }


        @SubscribeEvent
        public static void RegistrarAtributos(EntityAttributeCreationEvent event){
            event.put(InicializarEntidades.FROGMAN_ENTITY.get(), FrogManEntity.createAttributes().build());
            event.put(InicializarEntidades.MOSKABUM_ENTITY.get(), MoskabumEntity.createAttributes().build());
        }


        @SubscribeEvent
        public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
            Minecraft.getInstance().particleEngine.register(InicializarParticulas.PARTICULAS_DE_CRISTAL.get(), ParticulaDeCristal.Provider::new);
            Minecraft.getInstance().particleEngine.register(InicializarParticulas.MOSCAS.get(), ParticulaMoscas.Provider::new);
        }


    }
}
