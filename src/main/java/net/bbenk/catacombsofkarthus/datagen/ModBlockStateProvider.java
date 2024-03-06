package net.bbenk.catacombsofkarthus.datagen;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CatacombsofKarthus.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //generates block model/item/state jsons
        blockWithItem(ModBlocks.SOULSTONE_BLOCK);
        blockWithItem(ModBlocks.OPAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_OPAL_ORE);
        blockWithItem(ModBlocks.JADE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_JADE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.PAINITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PAINITE_ORE);
        //generates block model/item/state jsons
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
