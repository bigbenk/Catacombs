package net.bbenk.catacombsofkarthus.item.custom;

import net.bbenk.catacombsofkarthus.entity.ModEntities;
import net.bbenk.catacombsofkarthus.entity.custom.projectile.SpiritArrow;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.sound.SoundEvent;

import java.util.function.Predicate;

public class SpiritBowItem extends BowItem {

    public SpiritBowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        pPlayer.getCooldowns().addCooldown(this, 80);

        if(!pLevel.isClientSide()) {
            SpiritArrow spiritArrow = new SpiritArrow(ModEntities.SPIRIT_ARROW.get(), pLevel);
            spiritArrow.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0.25F);
            pLevel.addFreshEntity(spiritArrow);
        }
        return super.use(pLevel, pPlayer, pHand);


    }
}
