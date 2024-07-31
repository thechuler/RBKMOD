package net.rbkstudios.modrbk.items.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.CristalDeCambioEntidad;

public class cristalDeCambio extends Item {
    public cristalDeCambio(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
       ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);


        if (!pLevel.isClientSide()) {
            CristalDeCambioEntidad cristal = new CristalDeCambioEntidad(pLevel, pPlayer);
            cristal.setItem(itemStack);
            cristal.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(cristal);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemStack.shrink(1);
        }



        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
    }



}
