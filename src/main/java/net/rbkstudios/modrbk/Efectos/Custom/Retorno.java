package net.rbkstudios.modrbk.Efectos.Custom;

import com.jcraft.jorbis.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Retorno extends InstantenousMobEffect {


    public Retorno(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity instanceof ServerPlayer && !pLivingEntity.level().isClientSide()){
            BlockPos posicion = ((ServerPlayer) pLivingEntity).getRespawnPosition();
            BlockPos spawnOverworld = ((ServerPlayer) pLivingEntity).server.overworld().getSharedSpawnPos();
            if(posicion != null){
                pLivingEntity.teleportTo(posicion.getX(),posicion.getY(),posicion.getZ());
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,20,10));

            }else{
                pLivingEntity.teleportTo(spawnOverworld.getX(),spawnOverworld.getY(),spawnOverworld.getZ());
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,20,10));

            }


        }


        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }


}
