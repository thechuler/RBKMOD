package net.rbkstudios.modrbk.Entidades.Custom;
import net.minecraft.core.BlockPos;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;


public class FrogManEntity extends Monster {


    public FrogManEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }




    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState gruñirAnimationState = new AnimationState();
    public final AnimationState atacarAnimationState = new AnimationState();
    private boolean estaGruñendo = false;
    private int idleAnimationTimeout = 0;
    private int gruñirAnimationTimeout = 0;



    @Override
    public boolean addEffect(MobEffectInstance pEffectInstance, @Nullable Entity pEntity) {
        if(pEffectInstance.getEffect() == MobEffects.POISON){
            return false;
        }
        return super.addEffect(pEffectInstance, pEntity);
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel pLevel, DamageSource pDamageSource, boolean pRecentlyHit) {

        super.dropCustomDeathLoot(pLevel, pDamageSource, pRecentlyHit);
    }


//---------------------------------SONIDOS--------------------------------------------------//




    @Override
    public void playAmbientSound() {
        if (this.level().isClientSide() && !this.estaGruñendo) {
            this.estaGruñendo = true;
            gruñirAnimationState.start(this.tickCount);
        }
    }




    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if(!this.level().isClientSide()&& pEntity instanceof LivingEntity){
            ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.POISON,50));
        }
        return super.doHurtTarget(pEntity);
    }











  //-------------------------------TICK-------------------------------------//
  @Override
  public void tick() {

      if(this.level().isClientSide()){
          setUpAnimationStates();
      }
      super.tick();
  }








//-------------------------------------ATRIBUTOS----------------------------------//
public static AttributeSupplier.Builder createAttributes() {
    return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10.0)
            .add(Attributes.MOVEMENT_SPEED, 0.4)
            .add(Attributes.ATTACK_DAMAGE, 8.5);
}


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2,new MeleeAttackGoal(this,1,true));
        // this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.4));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[0])).setAlertOthers(new Class[]{ZombifiedPiglin.class}));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));

    }








//-------------------------------------------ANIMACIONES--------------------------------------//

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f,1f);
        }else{
            f=0f;
        }

        this.walkAnimation.update(f,0.2f);
    }


    //Setup Estados Animacion
    private void setUpAnimationStates(){

        if(idleAnimationTimeout<= 0){
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }


        if(this.estaGruñendo && gruñirAnimationTimeout <= 0){
            this.estaGruñendo = false;
            this.gruñirAnimationTimeout = 40;

            this.gruñirAnimationState.start(this.tickCount);
        }else{
            --this.gruñirAnimationTimeout;
        }

        if(!this.estaGruñendo && gruñirAnimationTimeout <= 0){
            this.gruñirAnimationState.stop();
        }











    }















    public static boolean PuedeSpawnear(EntityType<FrogManEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return true ;
    }


}
