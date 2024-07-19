package net.rbkstudios.modrbk.items.custom;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.rbkstudios.modrbk.items.InicializarItems;


import java.util.ArrayList;
import java.util.List;


public class CristalDeTierra extends Item {
    public CristalDeTierra(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(!pLevel.isClientSide()){
            BlockPos centro = new BlockPos((int) pPlayer.position().x, (int) pPlayer.position().y, (int) pPlayer.position().z);
            List<BlockPos> posiciones = detectarBloques(pLevel,centro,5);


            for (BlockPos pos : posiciones){
                BlockState bloque = pLevel.getBlockState(pos);
                if(bloque.getBlock() instanceof CropBlock){
                    ((CropBlock) bloque.getBlock()).growCrops(pLevel,pos,bloque);
                }
            }



        }



        return super.use(pLevel, pPlayer, pUsedHand);
    }




    public  List<BlockPos> detectarBloques(Level world, BlockPos center, int range) {
        List<BlockPos> bloques = new ArrayList<>();

        for(int x =-range;x<=range;x++ ){
            for(int y =-range;y<=range;y++){
                for(int z =-range;z<=range;z++){

                    BlockPos pos = center.offset(x, y, z);
                    bloques.add(pos);


                }
            }
        }



        return bloques;
    }

}
