package net.rbkstudios.modrbk.datagen;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
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
        simpleItem(InicializarItems.PRUEBA);
        simpleItem(InicializarItems.FRUTA);
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(Modrbk.MODID, "item/" + item.getId().getPath()));
    }
}
