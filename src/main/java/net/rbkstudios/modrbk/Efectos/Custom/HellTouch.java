package net.rbkstudios.modrbk.Efectos.Custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;


public class HellTouch extends MobEffect {



    public HellTouch(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }




    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.level().isClientSide()) {
            BlockPos entityPos = pLivingEntity.blockPosition();
            List<Entity> entitiesInRange = detectEntities(pLivingEntity.level(), entityPos, 5.0);
             for(Entity entity : entitiesInRange){
                 if (entity instanceof LivingEntity) {
                     if(entity != pLivingEntity){
                     ((LivingEntity) entity).igniteForTicks(200);
                     }
                 }
             }





        }
        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }




    public static List<Entity> detectEntities(Level world, BlockPos center, double range) {
        AABB boundingBox = new AABB(
                center.getX() - range, center.getY() - range, center.getZ() - range,
                center.getX() + range, center.getY() + range, center.getZ() + range
        );
        return world.getEntities(null, boundingBox);
    }

}

