package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.item.custom.Aviator_Helmet;
import net.bbenk.catacombsofkarthus.item.custom.SpiritBowItem;
import net.bbenk.catacombsofkarthus.item.custom.shadowsword;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CatacombsofKarthus.MODID);


    //INGREDIENTS
    public static final RegistryObject<Item> SOULPOWDER = ITEMS.register("soulpowder",
                () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SOULGEODE = ITEMS.register("soulgeode",
            () -> new Item(new Item.Properties().stacksTo(8)));
    public static final RegistryObject<Item> SOULSTONE = ITEMS.register("soulstone",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> PAINITE = ITEMS.register("painite",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> WITHERSPEC = ITEMS.register("witherspec",
            () -> new Item(new Item.Properties().stacksTo(64)));
    //MISC
    public static final RegistryObject<Item> MALLET = ITEMS.register("mallet",
            () -> new Item(new Item.Properties().durability(10)));
    //CONSUMABLES
    public static final RegistryObject<Item> MOLDY_BOTTLE = ITEMS.register("moldy_bottle",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MOLDY_BOTTLE)));
    //TOOLS & WEAPONS
    public static final RegistryObject<Item> SPIRIT_BOW = ITEMS.register("spirit_bow",
            () -> new BowItem(new Item.Properties().durability(888)));
    public static final RegistryObject<Item> GEM_PICK = ITEMS.register("gem_pick", () -> new PickaxeItem(ModToolsTiers.GEMPICK,
            0, -2.8F, new Item.Properties().durability(2000)) {
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
            if(Screen.hasShiftDown()) {
                pTooltipComponents.add(Component.literal("Enough precision for mining jade, sapphire, opal, and painite! \\n One pick to mine them all,§r"));
            } else {
                pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
            }
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    });
    public static final RegistryObject<Item> SHADOW_SWORD = ITEMS.register("shadow_sword",
            () -> new shadowsword(ModToolsTiers.GEMPICK, 2, 1, new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.literal("Tier 4 Sword. \n §oRealiy warps around its grip.§r"));
                    } else {
                        pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
                    }
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }

            });
        //ARMORS
        public static final RegistryObject<Item> AVIATOR_HELMET = ITEMS.register("aviator_helmet",
                () -> new Aviator_Helmet(ModArmorMaterials.Aviator, ArmorItem.Type.HELMET, new Item.Properties().durability(150)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
