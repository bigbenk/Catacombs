package net.bbenk.catacombsofkarthus.block.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ShadowSword extends SwordItem {
    public ShadowSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {

        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 1), player);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 2, 1),player);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 2, 1), player);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
