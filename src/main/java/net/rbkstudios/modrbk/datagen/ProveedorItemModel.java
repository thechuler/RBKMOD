package net.rbkstudios.modrbk.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.items.InicializarItems;


public class ProveedorItemModel extends ItemModelProvider {

    public ProveedorItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Modrbk.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        simpleItem(InicializarItems.GEODA);

        simpleItem(InicializarItems.POISON_DUST);
        simpleItem(InicializarItems.BAG_OF_FLIES);


        withExistingParent(InicializarItems.FROG_MAN_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        simpleItem(InicializarItems.COOKED_FROG_MEAT);
        simpleItem(InicializarItems.RAW_FROG_MEAT);
        simpleItem(InicializarItems.POISON_GLAND);


        simpleItem(InicializarItems.BALA);
        simpleItem(InicializarItems.BALA_INESTABLE);
        simpleItem(InicializarItems.BALA_VENENOSA);
        simpleItem(InicializarItems.NITRO_FLUIDO);
        withExistingParent(InicializarItems.MOSKABUM_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));

    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(Modrbk.MODID, "item/" + item.getId().getPath()));
    }
}
