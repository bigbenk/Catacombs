package net.bbenk.catacombsofkarthus.util;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CatacombsofKarthus.MODID, name));

        }
        private static TagKey<Item> forgetag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));

        }
    }
    public static class Blocks {
        //public static final TagKey<Block> METALDETECTOR = tag("the");

        //register block related ags here
        public static final TagKey<Block> NEEDS_SHADOW_TOOL = tag("needs_shadow_tool");
        public static final TagKey<Block> NEEDS_GEMPICK_TOOL = tag("needs_gempick_tool");
        //register block related tags here

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CatacombsofKarthus.MODID, name));

        }

        private static TagKey<Block> forgetag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));

        }
    }
}
