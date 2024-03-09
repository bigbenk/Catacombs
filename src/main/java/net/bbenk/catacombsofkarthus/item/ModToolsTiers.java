package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolsTiers {
    public static final Tier GEMPICK = TierSortingRegistry.registerTier(
            new ForgeTier(2, 20, 8.5F, 5.5F, 20,
                    ModTags.Blocks.NEEDS_GEMPICK_TOOL, null),
            new ResourceLocation(CatacombsofKarthus.MODID, "gempick"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier SHADOW = TierSortingRegistry.registerTier(
            new ForgeTier(3, 500, 12f, 7f, 30,
                    ModTags.Blocks.NEEDS_SHADOW_TOOL, null), //shadow
            new ResourceLocation(CatacombsofKarthus.MODID, "shadow"), List.of(ModToolsTiers.GEMPICK), List.of());
}
