package net.rbkstudios.modrbk;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EmptyMapItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class Utilidades {


    public static List<LivingEntity> ObtenerEntidadesEnArea(Level level, BlockPos centro, int radio) {
        // Calcular los límites del AABB en función del punto central y el radio
        double minX = centro.getX() - radio;
        double minY = centro.getY() - radio;
        double minZ = centro.getZ() - radio;
        double maxX = centro.getX() + radio;
        double maxY = centro.getY() + radio;
        double maxZ = centro.getZ() + radio;

        // Crear el AABB
        AABB area = new AABB(minX, minY, minZ, maxX, maxY, maxZ);

        // Obtener y devolver la lista de entidades vivientes dentro del AABB
        return level.getEntitiesOfClass(LivingEntity.class, area);
    }





    public static ItemStack EncontrarItemEnJugador(Player player, Item item){
        for(ItemStack itemStack : player.getInventory().items){
            if(!itemStack.isEmpty() && itemStack.getItem() == item){
                return itemStack;
            }
        }
        return  ItemStack.EMPTY;
    }

}
