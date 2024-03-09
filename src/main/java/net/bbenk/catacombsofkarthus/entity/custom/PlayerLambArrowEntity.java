package net.bbenk.catacombsofkarthus.entity.custom;

import net.bbenk.catacombsofkarthus.entity.variant.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class PlayerLambArrowEntity extends Projectile {
    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(PlayerLambArrowEntity.class, EntityDataSerializers.BOOLEAN);
    private int counter = 0;

    public PlayerLambArrowEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public PlayerLambArrowEntity(Level pLevel, Player player) {
        super(ModEntities.PLAYER_LAMB_ARROW.get(), pLevel);
        setOwner(player);
        BlockPos blockpos = player.blockPosition();
        double d0 = (double)blockpos.getX() +0.50;
        double d1 = (double)blockpos.getY() +1.750;
        double d2 = (double)blockpos.getZ() +0.50;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
        //offset & spawns proj at the position of the player
        //governs rotation
    }

//    @Override
    protected void onHit(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity hitEntity = hitResult.getEntity();
        Entity owner = this.getOwner();

        if(hitEntity == owner && this.level().isClientSide) {
            return;
        }

        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 2f;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingentity), damage);
        if (hurt) {
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2), owner);
            }
        }

    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        //can spawn particles here
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount >= 450) {
            this.remove(RemovalReason.DISCARDED);
            //deletes entity after given period

            Vec3 vec3 = this.getDeltaMovement();
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
                this.onHit(hitresult);

            double d0 = getX() + vec3.x;
            double d1 = getY() + vec3.y;
            double d2 = getZ() + vec3.z;
            this.updateRotation();

            double d5 = vec3.x;
            double d6 = vec3.y;
            double d7 = vec3.z;

            if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
                this.discard();
            } else if(this.isInWaterOrBubble()) {
                this.discard();
            } else {
                this.setDeltaMovement(vec3.scale(0.99F));
                this.setPos(d0, d1, d2);
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIT, false);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
        //Req or proj will display invisible
    }
}
