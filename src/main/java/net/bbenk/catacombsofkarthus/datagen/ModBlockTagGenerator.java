package net.bbenk.catacombsofkarthus.datagen;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.bbenk.catacombsofkarthus.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CatacombsofKarthus.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(ModTags.Blocks.METALDETECTOR).add(ModBlocks.OPAL_ORE.get()).addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SOULSTONE_BLOCK.get(),
                        ModBlocks.OPAL_ORE.get(),
                        ModBlocks.DEEPSLATE_OPAL_ORE.get(),
                        ModBlocks.JADE_ORE.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.PAINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_PAINITE_ORE.get());

        this.tag(ModTags.Blocks.NEEDS_GEMPICK_TOOL)
                .add(ModBlocks.OPAL_ORE.get(),
                        ModBlocks.DEEPSLATE_OPAL_ORE.get(),
                        ModBlocks.JADE_ORE.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.PAINITE_ORE.get(),
                        ModBlocks.DEEPSLATE_PAINITE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SOULSTONE_BLOCK.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
