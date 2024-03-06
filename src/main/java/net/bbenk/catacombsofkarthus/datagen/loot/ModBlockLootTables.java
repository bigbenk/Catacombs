package net.bbenk.catacombsofkarthus.datagen.loot;

import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SOULSTONE_BLOCK.get());

        //ores
        this.add(ModBlocks.OPAL_ORE.get(), block ->
                createOreDrop(ModBlocks.OPAL_ORE.get(), ModItems.OPAL.get()));
        this.add(ModBlocks.DEEPSLATE_OPAL_ORE.get(), block ->
                createOreDrop(ModBlocks.DEEPSLATE_OPAL_ORE.get(), ModItems.OPAL.get()));
        this.add(ModBlocks.JADE_ORE.get(), block ->
                createOreDrop(ModBlocks.JADE_ORE.get(), ModItems.JADE.get()));
        this.add(ModBlocks.DEEPSLATE_JADE_ORE.get(), block ->
                createOreDrop(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.JADE.get()));
        this.add(ModBlocks.SAPPHIRE_ORE.get(), block ->
                createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block ->
                createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.PAINITE_ORE.get(), block ->
                createOreDrop(ModBlocks.PAINITE_ORE.get(), ModItems.PAINITE.get()));
        this.add(ModBlocks.DEEPSLATE_PAINITE_ORE.get(), block ->
                createOreDrop(ModBlocks.DEEPSLATE_PAINITE_ORE.get(), ModItems.PAINITE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
