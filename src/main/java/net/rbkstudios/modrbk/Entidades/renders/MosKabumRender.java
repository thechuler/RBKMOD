package net.rbkstudios.modrbk.Entidades.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.rbkstudios.modrbk.Entidades.Custom.MoskabumEntity;
import net.rbkstudios.modrbk.Entidades.modelos.MosKabumModel;
import net.rbkstudios.modrbk.Entidades.renders.customlayers.FrogmanEyesLayer;
import net.rbkstudios.modrbk.Modrbk;

public class MosKabumRender<T extends MoskabumEntity> extends MobRenderer<T, MosKabumModel<T>> {

    private static final ResourceLocation TEXTURAS = ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,"textures/entity/moskabumtexture.png");

    public MosKabumRender(EntityRendererProvider.Context pContext) {
        super(pContext, new MosKabumModel<>(pContext.bakeLayer(MosKabumModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
      return TEXTURAS;
    }
}
