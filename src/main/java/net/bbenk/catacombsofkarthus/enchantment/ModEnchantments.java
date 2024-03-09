package net.bbenk.catacombsofkarthus.enchantment;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, CatacombsofKarthus.MODID);

    public static final RegistryObject<Enchantment> LIGHTNING_SMITE_ENCHANT =
            ENCHANTMENTS.register("lightning_smite_enchant", () -> new LightningSmiteEnchant(Enchantment.Rarity.RARE,
                    EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}