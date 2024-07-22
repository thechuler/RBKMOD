package net.rbkstudios.modrbk.items.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rbkstudios.modrbk.Entidades.Custom.BagOfFliesEntity;
import net.rbkstudios.modrbk.Entidades.Custom.CristalDeCambioEntidad;

public class BagOfFlies extends Item {
    public BagOfFlies(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);



        if (!pLevel.isClientSide()) {
            BagOfFliesEntity BagOfFliesEntity = new BagOfFliesEntity(pLevel, pPlayer);
            BagOfFliesEntity.setItem(itemStack);
            BagOfFliesEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 0.8F, 1.0F);
            pLevel.addFreshEntity(BagOfFliesEntity);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemStack.shrink(1);
        }



        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());



    }
}
