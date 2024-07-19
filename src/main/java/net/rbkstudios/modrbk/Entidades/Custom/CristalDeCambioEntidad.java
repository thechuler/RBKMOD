package net.rbkstudios.modrbk.Entidades.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.rbkstudios.modrbk.Entidades.InicializarEntidades;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;
import net.rbkstudios.modrbk.Sonidos.InicializarSonidos;
import net.rbkstudios.modrbk.items.InicializarItems;

public class CristalDeCambioEntidad extends ThrowableItemProjectile {



    public CristalDeCambioEntidad(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public CristalDeCambioEntidad(Level pLevel) {
        super(InicializarEntidades.CRISTAL_DE_CAMBIO_PROYECTIL.get(),pLevel);
    }

    public CristalDeCambioEntidad(Level pLevel, LivingEntity livingEntity) {
        super(InicializarEntidades.CRISTAL_DE_CAMBIO_PROYECTIL.get(),livingEntity,pLevel);
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

         pResult.getEntity().setYHeadRot(35);
        if(!this.level().isClientSide()){
            Entity objetivo =  pResult.getEntity();
            Entity lanazador =  this.getOwner();
            BlockPos posObjetivo = objetivo.blockPosition();
            BlockPos posLanzador = lanazador.blockPosition();

            SpawnearParticulas(posObjetivo);
            SpawnearParticulas(posLanzador);

            lanazador.teleportTo(posObjetivo.getX(),posObjetivo.getY(),posObjetivo.getZ());
            objetivo.teleportTo(posLanzador.getX(),posLanzador.getY(),posLanzador.getZ());

            this.level().playSound((Player)null, lanazador.getX(), lanazador.getY(), lanazador.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.NEUTRAL, 3F, 8F );



        }







     this.discard();
    }


    private  void SpawnearParticulas(BlockPos Pos){

        ServerLevel serverLevel = (ServerLevel) this.level();
        for (int i = 0; i < 30; i++) {  // Spawnear 20 partículas, por ejemplo
            double offsetX = this.random.nextGaussian() * 0.5;
            double offsetY = this.random.nextGaussian() * 0.5;
            double offsetZ = this.random.nextGaussian() * 0.5;
            serverLevel.sendParticles(InicializarParticulas.PARTICULAS_DE_CRISTAL.get(),
                    Pos.getX() + 0.5 + offsetX,
                    Pos.getY() + 0.5 + offsetY,
                    Pos.getZ() + 0.5 + offsetZ,
                    1,  // Número de partículas a spawnear en esta llamada
                    0, 0, 0, 0);  // Velocidad en las direcciones X, Y, Z
        }
    }



    @Override
    protected Item getDefaultItem() {
        return InicializarItems.CRISTAL_DE_CAMBIO.get();
    }



}
