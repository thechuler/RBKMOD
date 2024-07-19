package net.rbkstudios.modrbk.Entidades.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.rbkstudios.modrbk.Entidades.Custom.FrogManEntity;
import net.rbkstudios.modrbk.Entidades.modelos.FrogManModel;
import net.rbkstudios.modrbk.Modrbk;

import java.lang.reflect.Type;

public class FrogManRender <type extends FrogManEntity> extends MobRenderer<type, FrogManModel<type>> {


    private static final ResourceLocation TEXTURAS = ResourceLocation.fromNamespaceAndPath(Modrbk.MODID,"textures/entity/frogmantexture.png");

    public FrogManRender(EntityRendererProvider.Context pContext) {
        super(pContext, new FrogManModel<>(pContext.bakeLayer(FrogManModel.LAYER_LOCATION)), 0.5f);
    }




    @Override
    public void render(FrogManEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.3f, 0.3f, 0.3f);
        }
        super.render((type) pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(type type) {
        return TEXTURAS;
    }
}
