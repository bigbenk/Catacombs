package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.minecraft.client.gui.screens.Screen;
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



        //REGISTER ITEMS HERE
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
    public static final RegistryObject<Item> MALLET = ITEMS.register("mallet",
            () -> new Item(new Item.Properties().durability(10)));

    public static final RegistryObject<Item> MOLDY_BOTTLE = ITEMS.register("moldy_bottle",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MOLDY_BOTTLE)));
    public static final RegistryObject<Item> GEM_PICK = ITEMS.register("gem_pick", () -> new PickaxeItem(ModToolsTiers.GEMPICK,
            1, 1, new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
            if(Screen.hasShiftDown()) {
                pTooltipComponents.add(Component.literal("Enough precision for mining jade, sapphire, opal, and painite! \n One pick to mine them all,§r"));
            } else {
                pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
            }
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }

    });
    public static final RegistryObject<Item> GEM_AXE = ITEMS.register("gem_axe",
            () -> new AxeItem(ModToolsTiers.GEMPICK, 2, 4, new Item.Properties().durability(1500)) {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.literal("Really cost effective! \n One axe to cut them all,§r"));
                    } else {
                        pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
                    }
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }

            });
    public static final RegistryObject<Item> GEM_SHOVEL = ITEMS.register("gem_shovel",
            () -> new ShovelItem(ModToolsTiers.GEMPICK, 1, 3, new Item.Properties().durability(1500)) {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.literal("Really cost effective! \n One shovel to dig them,§r"));
                    } else {
                        pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
                    }
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }

            });
    public static final RegistryObject<Item> GEM_HOE = ITEMS.register("gem_hoe",
            () -> new HoeItem(ModToolsTiers.GEMPICK, 2, 1, new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component>pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal("Really cost effective! \n And in the farms till them;§r"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.catacombsofkarthus.gem_axe.tooltip.shift"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    });

    public static final RegistryObject<Item> SHADOW_SWORD = ITEMS.register("shadow_sword",
            () -> new HoeItem(ModToolsTiers.SHADOW, 2, 1, new Item.Properties()) {
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
        //REGISTER ITEMS HERE


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
