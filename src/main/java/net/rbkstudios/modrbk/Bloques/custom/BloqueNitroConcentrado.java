package net.rbkstudios.modrbk.Bloques.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;

import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.Utilidades;

public class BloqueNitroConcentrado extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");


    public BloqueNitroConcentrado(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false)); // Estado inicial
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED); // Agregar la propiedad 'powered'
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity); // Llama al método original

        if(!level.isClientSide()) {

            if (entity instanceof LivingEntity && state.getValue(POWERED)) {
                double upwardPush = ObtenerPoder(level, pos);

                entity.sendSystemMessage(Component.literal(String.valueOf(upwardPush)));
                entity.setDeltaMovement(entity.getDeltaMovement().add(0, upwardPush, 0));



            }
        }
    }


    @Override
    protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (!pLevel.isClientSide) {
            boolean isPowered = pLevel.hasNeighborSignal(pPos);
            if (isPowered != pState.getValue(POWERED)) {
                pLevel.setBlock(pPos, pState.setValue(POWERED, isPowered), 3);

            }
        }
    }





    public  double ObtenerPoder(Level level, BlockPos pos){
        double poder = 1;


        for (int i = 1; i < 5; i++) {
            BlockPos posicion = new BlockPos(pos.getX(),pos.getY() - i,pos.getZ() );
            if(level.getBlockState(posicion).is(InicializarBloques.BLOQUE_NITRO_CONCENTRADO.get())){
                poder+=0.5f;
            }else {
                return poder;
            }
        }

        return 1;
    }

}
