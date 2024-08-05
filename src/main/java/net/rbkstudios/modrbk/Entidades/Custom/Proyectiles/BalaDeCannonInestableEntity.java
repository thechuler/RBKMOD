package net.rbkstudios.modrbk.Entidades.Custom.Proyectiles;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.rbkstudios.modrbk.items.InicializarItems;

public class BalaDeCannonInestableEntity extends BalaDeCannonEntity{


    public BalaDeCannonInestableEntity(LivingEntity pEntityType, Level pLevel) {
        super(pLevel, pEntityType);
    }






    @Override
    public void explotar() {

            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 6.0F, true, Level.ExplosionInteraction.NONE);

            this.discard();
        }



    @Override
    protected Item getDefaultItem() {
        return InicializarItems.BALA_INESTABLE.get();
    }
}
