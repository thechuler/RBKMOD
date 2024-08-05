package net.rbkstudios.modrbk.Entidades;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Entidades.Custom.NitroMoscaEntity;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.BagOfFliesEntity;


import net.rbkstudios.modrbk.Entidades.Custom.FrogManEntity;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.BalaDeCannonEntity;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.BalaDeCannonInestableEntity;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.BalaDeCannonPutrefactaEntity;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarEntidades {


    public static final DeferredRegister<EntityType<?>> ENTIDADES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Modrbk.MODID);



    public static final RegistryObject<EntityType<BalaDeCannonEntity>> BALA_DE_CANNON_ENTITY =
            ENTIDADES.register("bala_de_cannon_entity", () -> EntityType.Builder.<BalaDeCannonEntity>of(BalaDeCannonEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("bala_de_cannon_entity"));


    public static final RegistryObject<EntityType<BalaDeCannonEntity>> BALA_DE_CANNON_PUTREFACTA_ENTITY =
            ENTIDADES.register("bala_de_cannon_putrefacta_entity", () -> EntityType.Builder.<BalaDeCannonEntity>of(BalaDeCannonPutrefactaEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("bala_de_cannon_putrefacta_entity"));



    public static final RegistryObject<EntityType<BagOfFliesEntity>> BAG_OF_FLIES_ENTITY =
            ENTIDADES.register("bag_of_flies_entity", () -> EntityType.Builder.<BagOfFliesEntity>of(BagOfFliesEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("bag_of_flies_entity"));





    public static final RegistryObject<EntityType<FrogManEntity>> FROGMAN_ENTITY = ENTIDADES.register("frogman_entity",
            () -> EntityType.Builder.of(FrogManEntity::new, MobCategory.CREATURE).sized(1f,1.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,"frogman_entity").toString()));



    public  static  final RegistryObject<EntityType<NitroMoscaEntity>> MOSKABUM_ENTITY =ENTIDADES.register("moskabum_entity",
            ()->EntityType.Builder.of(NitroMoscaEntity::new,MobCategory.MONSTER).sized(1.2f,1f)
                    .build(ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,"moskabum_entity").toString()));




    public static void registrar(IEventBus eventBus) {
        ENTIDADES.register(eventBus);
    }



}
