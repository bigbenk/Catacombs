package net.bbenk.catacombsofkarthus.item.custom;

import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Aviator_Helmet extends ArmorItem {
    public Aviator_Helmet(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }
    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (!level.isClientSide() && isCorrectHelmet(player) && !player.hasEffect(MobEffects.SLOW_FALLING)) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 1));
        }
    }

    private boolean isCorrectHelmet(Player player) {
        for (ItemStack ignored : player.getArmorSlots()) {
            if (player.getInventory().getArmor(3).getItem() == ModItems.AVIATOR_HELMET.get()) {
                return true;
            }
        }
        return false;
    }
}
