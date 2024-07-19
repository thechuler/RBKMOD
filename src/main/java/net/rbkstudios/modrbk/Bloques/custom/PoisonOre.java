package net.rbkstudios.modrbk.Bloques.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;

import java.util.List;

public class PoisonOre extends Block {
    public PoisonOre(Properties p_49795_) {
        super(p_49795_);
    }


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        List<LivingEntity> entidades = DetectarEntidadesEnArea(pos,5,level);
        for (int i = 0; i < 3; i++) {
            level.addParticle(InicializarParticulas.PARTICULAS_DE_CRISTAL.get(),pos.getX(),pos.getY()+1,pos.getZ(),0,0,0);
        }

        for (LivingEntity entidad : entidades){
            entidad.addEffect(new MobEffectInstance(MobEffects.POISON,200,2));
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    private List<LivingEntity> DetectarEntidadesEnArea(BlockPos centro,int radio,Level level){
        AABB area = new AABB(
                centro.getX() - radio, centro.getY() - radio, centro.getZ() - radio,
                centro.getX() + radio, centro.getY() + radio, centro.getZ() + radio
        );

        // Obtener la lista de entidades dentro del área
        return level.getEntitiesOfClass(LivingEntity.class, area);
    }
}
