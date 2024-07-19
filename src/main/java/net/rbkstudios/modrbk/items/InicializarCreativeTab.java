package net.rbkstudios.modrbk.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Bloques.InicializarBloques;
import net.rbkstudios.modrbk.Modrbk;

public class InicializarCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Modrbk.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(InicializarItems.CRISTAL_DE_CAMBIO.get()))
                    .title(Component.translatable("creativetab.main_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(InicializarItems.GEODA.get());
                        pOutput.accept(InicializarBloques.PIEDRACARGADA.get().asItem());
                        pOutput.accept(InicializarItems.BANANITE.get());
                        pOutput.accept(InicializarBloques.BANANITE_ORE.get().asItem());
                        pOutput.accept(InicializarItems.CRISTAL_DE_CAMBIO.get());
                        pOutput.accept(InicializarBloques.POISON_ORE.get().asItem());
                        pOutput.accept(InicializarItems.POISON_DUST.get());


                    })
                    .build());


    public static void registrar(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
