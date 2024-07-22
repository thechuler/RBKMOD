package net.rbkstudios.modrbk.Entidades;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Entidades.Custom.BagOfFliesEntity;
import net.rbkstudios.modrbk.Entidades.Custom.CristalDeCambioEntidad;

import net.rbkstudios.modrbk.Entidades.Custom.FrogManEntity;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarEntidades {


    public static final DeferredRegister<EntityType<?>> ENTIDADES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Modrbk.MODID);


    public static final RegistryObject<EntityType<CristalDeCambioEntidad>> CRISTAL_DE_CAMBIO_PROYECTIL =
            ENTIDADES.register("cristal_de_cambio_proyectil", () -> EntityType.Builder.<CristalDeCambioEntidad>of(CristalDeCambioEntidad::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("cristal_de_cambio_proyectil"));


    public static final RegistryObject<EntityType<BagOfFliesEntity>> BAG_OF_FLIES_ENTITY =
            ENTIDADES.register("bag_of_flies_entity", () -> EntityType.Builder.<BagOfFliesEntity>of(BagOfFliesEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("bag_of_flies_entity"));






    public static final RegistryObject<EntityType<FrogManEntity>> FROGMAN_ENTITY = ENTIDADES.register("frogman_entity",
            () -> EntityType.Builder.of(FrogManEntity::new, MobCategory.CREATURE).sized(1f,1.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,"frogman_entity").toString()));







    public static void registrar(IEventBus eventBus) {
        ENTIDADES.register(eventBus);
    }



}
