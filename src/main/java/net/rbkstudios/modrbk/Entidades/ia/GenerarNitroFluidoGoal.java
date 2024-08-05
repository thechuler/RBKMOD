package net.rbkstudios.modrbk.Entidades.ia;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.Entidades.Custom.NitroMoscaEntity;
import net.rbkstudios.modrbk.Particulas.InicializarParticulas;
import net.rbkstudios.modrbk.Utilidades;

import java.util.EnumSet;

public class GenerarNitroFluidoGoal extends Goal {

    private final NitroMoscaEntity entidad;

    private final int interval;
    private int timer;

    public GenerarNitroFluidoGoal(NitroMoscaEntity entidad, int interval) {
        this.entidad = entidad;
        this.interval = interval;
        this.timer = interval;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {

        if (--timer <= 0) {

            BlockPos blockPos = entidad.blockPosition().below();
            if (entidad.level().isEmptyBlock(blockPos)) {
                Utilidades.spawnearParticulas(this.entidad,10, InicializarParticulas.PARTICULAS_DE_NITRO_FLUIDO.get());
                entidad.level().setBlockAndUpdate(blockPos, InicializarBloques.BLOQUE_NITRO_FLUIDO.get().defaultBlockState());
            }
            timer = interval; // Reinicia el temporizador
        }
    }


    @Override
    public boolean canContinueToUse() {
        return true; // Siempre puede continuar usando este objetivo
    }

}
