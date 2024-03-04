package net.bbenk.catacombsofkarthus.entity;

import net.bbenk.catacombsofkarthus.entity.variant.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class PlayerLambEntity extends Projectile {

    public PlayerLambEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public PlayerLambEntity(Level pLevel, Player player) {
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

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount >= 450) {
            this.remove(RemovalReason.DISCARDED);
            //deletes entity after given period

            Vec3 vec3 = this.getDeltaMovement();
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this:canHitEntity();
            if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
                this.onHit(hitresult);

            double d0 = getX() + vec3.x;
            double d1 = getY() + vec3.y;
            double d2 = getZ() + vec3.Z;
            this.updateRotation();

            double d5 = vec3.x;
            double d6 = vec3.y;
            double d7 = vec3.z;

            for(int i = 1; i < 5; ++1) {
                this.level().addParticle(ModParticles.LAMB_MARK.get(), d0-(d5*2), d1-(d6*2), d2-(d7*2)-d5,
                        -6d - 0.10, -d7);
            }
            )
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
        //Req or proj will display invisible
    }
}
