package net.rbkstudios.modrbk.Entidades.renders.customlayers;




import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rbkstudios.modrbk.Entidades.Custom.FrogManEntity;
import net.rbkstudios.modrbk.Entidades.modelos.FrogManModel;
import net.rbkstudios.modrbk.Modrbk;

@OnlyIn(Dist.CLIENT)
public class FrogmanEyesLayer<T extends FrogManEntity> extends EyesLayer<T, FrogManModel<T>> {
    private static final RenderType FROGMAN_EYES = RenderType.eyes(ResourceLocation
            .fromNamespaceAndPath(Modrbk.MODID,"textures/entity/frogman_eyes.png"));

    public FrogmanEyesLayer(RenderLayerParent<T, FrogManModel<T>> pRenderer) {
        super(pRenderer);
    }

    public RenderType renderType() {
        return FROGMAN_EYES;
    }
}
