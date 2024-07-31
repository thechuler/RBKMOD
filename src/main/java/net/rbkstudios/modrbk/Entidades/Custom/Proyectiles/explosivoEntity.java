package net.rbkstudios.modrbk.Entidades.Custom.Proyectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.items.InicializarItems;

public class explosivoEntity extends ThrowableItemProjectile {

    public explosivoEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public explosivoEntity(Level pLevel) {
        super(InicializarEntidades.EXPLOSIVO.get(),pLevel);
    }

    public explosivoEntity(Level pLevel, LivingEntity livingEntity) {
        super(InicializarEntidades.EXPLOSIVO.get(),livingEntity,pLevel);
    }


    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if(!this.level().isClientSide()){
            explotar();
        }


        this.discard();
    }




    private void explotar() {
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float)5, Level.ExplosionInteraction.MOB);
            this.discard();
        }

    }


    @Override
    protected Item getDefaultItem() {
        return InicializarItems.BAG_OF_FLIES.get();
    }





}
