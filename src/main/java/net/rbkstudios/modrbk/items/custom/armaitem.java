package net.rbkstudios.modrbk.items.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.rbkstudios.modrbk.Entidades.Custom.Proyectiles.explosivoEntity;
import net.rbkstudios.modrbk.Sonidos.InicializarSonidos;
import net.rbkstudios.modrbk.Utilidades;
import java.util.ArrayList;
import java.util.List;

public class armaitem extends Item {
    public armaitem(Properties pProperties) {
        super(pProperties);
    }



    // Cargar un proyectil específico en el ItemStack
    public void loadProjectile(ItemStack itemStack, ItemStack projectile) {
        if (!projectile.isEmpty()) {
            ChargedProjectiles chargedProjectiles = getChargedProjectiles(itemStack);
            List<ItemStack> currentItems = new ArrayList<>(chargedProjectiles.getItems());
            currentItems.add(projectile.copy());
            itemStack.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(currentItems));
        }
    }



    // Verificar si hay proyectiles cargados en el ItemStack
    public boolean isLoaded(ItemStack itemStack) {
        ChargedProjectiles chargedProjectiles = getChargedProjectiles(itemStack);
        return !chargedProjectiles.isEmpty();
    }




    // Descargar un proyectil específico del ItemStack
    public ItemStack unloadProjectile(ItemStack itemStack) {
        ChargedProjectiles chargedProjectiles = getChargedProjectiles(itemStack);
        List<ItemStack> currentItems = new ArrayList<>(chargedProjectiles.getItems());

        // Verifica si hay proyectiles cargados
        if (currentItems.isEmpty()) {
            return ItemStack.EMPTY; // No hay proyectiles para descargar
        }

        // Quita el último proyectil de la lista
        ItemStack unloadedProjectile = currentItems.remove(currentItems.size() - 1);

        // Actualiza los proyectiles cargados en el ItemStack
        itemStack.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(currentItems));

        return unloadedProjectile; // Devuelve el proyectil descargado
    }




    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(pLevel.isClientSide()){
            if(isLoaded(itemStack)){
                pPlayer.playSound(InicializarSonidos.DISPARO_DE_CANNON.get(),1,1);
            }else {
                ItemStack municion = Utilidades.EncontrarItemEnJugador(pPlayer, Items.FIRE_CHARGE);
                if (municion != null && !municion.isEmpty()) {
                    pPlayer.playSound(InicializarSonidos.CANNON_RELOAD.get(),1,1);
                }else{
                    pPlayer.playSound(InicializarSonidos.EMPTY_CANNON.get(),1,1);
                }

                }

            }


        if (!pLevel.isClientSide()) {
            if (isLoaded(itemStack)) {
                Disparar(pLevel, pPlayer);
                unloadProjectile(itemStack);
                return InteractionResultHolder.pass(itemStack);
            } else {
                ItemStack municion = Utilidades.EncontrarItemEnJugador(pPlayer, Items.FIRE_CHARGE);
                if (municion != null && !municion.isEmpty()) {
                    loadProjectile(itemStack, municion);
                    municion.shrink(1);
                    return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
                }
            }
        } else {
            return InteractionResultHolder.pass(itemStack);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }



    public void Disparar(Level pLevel, Player pPlayer) {

        if (!pLevel.isClientSide()) {
            explosivoEntity explosivoEntity = new explosivoEntity(pLevel, pPlayer);
            explosivoEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.8F, 1.0F);
            pLevel.addFreshEntity(explosivoEntity);
        }
      // Cambia SoundEvents.GENERIC_EXPLODE por tu propio sonido
        Vec3 lookDirection = pPlayer.getLookAngle();
        Vec3 pushDirection = lookDirection.scale(-1);
        pPlayer.setDeltaMovement(pushDirection.x * 1, pushDirection.y * 1, pushDirection.z * 1);
        pPlayer.hurtMarked = true;
    }




    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        if (this.isLoaded(pStack)) {
            pTooltipComponents.add(Component.literal("Cargado: Sí"));
        } else {
            pTooltipComponents.add(Component.literal("Cargado: NO"));
        }
    }




    // Método auxiliar para obtener ChargedProjectiles del ItemStack
    private ChargedProjectiles getChargedProjectiles(ItemStack itemStack) {
        return itemStack.getOrDefault(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
    }






/*
    private void vibrarPantalla(Player pPlayer) {
        if (pPlayer instanceof LocalPlayer localPlayer) {
            Minecraft minecraft = Minecraft.getInstance();
            for (int i = 0; i < 5; i++) { // La cantidad de ciclos de vibración
                minecraft.gameRenderer.getMainCamera().move()
            }
        }
    }

*/
}
