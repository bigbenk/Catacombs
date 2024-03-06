package net.bbenk.catacombsofkarthus.datagen;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CatacombsofKarthus.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //1 layer item generators
        simpleItem(ModItems.SOULSTONE);
        simpleItem(ModItems.SOULGEODE);
        simpleItem(ModItems.SOULPOWDER);
        simpleItem(ModItems.OPAL);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.PAINITE);


        handheldItem(ModItems.MALLET);
        handheldItem(ModItems.GEM_AXE);
        handheldItem(ModItems.GEM_HOE);
        handheldItem(ModItems.GEM_PICK);
        handheldItem(ModItems.GEM_SHOVEL);
        //1 layer item generators
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(CatacombsofKarthus.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CatacombsofKarthus.MODID, "item/" + item.getId().getPath()));
    }
}
