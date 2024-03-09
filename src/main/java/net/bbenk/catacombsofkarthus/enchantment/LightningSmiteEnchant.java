package net.bbenk.catacombsofkarthus.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningSmiteEnchant extends Enchantment {
    protected LightningSmiteEnchant(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            ServerLevel level = (ServerLevel) pAttacker.level();
            BlockPos position = pTarget.blockPosition();

            if (pLevel == 1 && pTarget instanceof LivingEntity livingEntity) {
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                livingEntity.setDeltaMovement(0, 0.2, 0);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 140, 1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1));
            }
            if (pLevel == 2 && pTarget instanceof LivingEntity livingEntity) {
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                livingEntity.setDeltaMovement(0, 0.4, 0);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 160, 1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
            }
            if (pLevel == 3 && pTarget instanceof LivingEntity livingEntity) {
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position, MobSpawnType.TRIGGERED,
                        true, true);
                livingEntity.setDeltaMovement(0, 0.6, 0);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 180, 1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
            }
        }
    }
        @Override
        public int getMaxLevel () {
            return 3;
    }
}

