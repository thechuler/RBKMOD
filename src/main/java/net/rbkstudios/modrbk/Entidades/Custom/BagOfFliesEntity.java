package net.rbkstudios.modrbk.Entidades.Custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.items.InicializarItems;

import java.awt.*;

public class BagOfFliesEntity extends ThrowableItemProjectile {

    public BagOfFliesEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public BagOfFliesEntity(Level pLevel) {
        super(InicializarEntidades.CRISTAL_DE_CAMBIO_PROYECTIL.get(),pLevel);
    }

    public BagOfFliesEntity(Level pLevel, LivingEntity livingEntity) {
        super(InicializarEntidades.CRISTAL_DE_CAMBIO_PROYECTIL.get(),livingEntity,pLevel);
    }


    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if(!this.level().isClientSide()){
            if(pResult.getType() == HitResult.Type.ENTITY){
                EntityHitResult entityHitResult = (EntityHitResult) pResult;
                Entity hitEntity = entityHitResult.getEntity();
                if(hitEntity instanceof LivingEntity){
                    ((LivingEntity) hitEntity).addEffect(new MobEffectInstance(InicializarEfectos.PLAGUE.getHolder().get(),400));


                }

            } else if (pResult.getType() == HitResult.Type.BLOCK) {

               // AplicarEfecto A entidades en area
            }

        }


        this.discard();
    }






    @Override
    protected Item getDefaultItem() {
        return InicializarItems.BAG_OF_FLIES.get();
    }





}
