package net.rbkstudios.modrbk.Efectos.Custom;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.rbkstudios.modrbk.Efectos.InicializarEfectos;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;
import net.rbkstudios.modrbk.Utilidades;
import java.util.List;
import java.util.Random;
public class Plague extends MobEffect {


    private int nextDamage = 0;
    private int timeoutDamage = 50;
    private boolean AplicarEfecto = true;

    public Plague(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }




    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.getHealth() > 1.0F) {
            spawnearParticulas(pLivingEntity,10);
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(), 3.0F);


        }else{
            List<LivingEntity> entidades = Utilidades.ObtenerEntidadesEnArea(pLivingEntity.level(),pLivingEntity.getOnPos(),3);
            for (LivingEntity entidad : entidades){
               entidad.addEffect(new MobEffectInstance(InicializarEfectos.PLAGUE.getHolder().get(),400));
            }
            pLivingEntity.kill();
            spawnearParticulas(pLivingEntity,30);
        }

        return true;
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int $$2 = 45 >> pAmplifier;
        if ($$2 > 0) {
            return pDuration % $$2 == 0;
        } else {
            return true;
        }
    }


    private void spawnearParticulas(LivingEntity entity, int particleCount ) {
        if (!entity.level().isClientSide()) {
            Random random = new Random();
            ServerLevel serverLevel = (ServerLevel) entity.level();
            // Definir el tipo de partículas y su cantidad
            ParticleOptions particleType = InicializarParticulas.MOSCAS.get(); // Puedes cambiar esto al tipo de partículas que desees


            // Generar partículas alrededor de la entidad
            for (int i = 0; i < particleCount; i++) {
                double offsetX = (random.nextDouble() - 0.5) * 2.0;
                double offsetY = random.nextDouble() * 2.0;
                double offsetZ = (random.nextDouble() - 0.5) * 2.0;

                double posX = entity.getX() + offsetX;
                double posY = entity.getY() + offsetY;
                double posZ = entity.getZ() + offsetZ;


                serverLevel.sendParticles(particleType, posX, posY, posZ, 1, 0, 0, 0, 0);

            }

        }
    }
}
