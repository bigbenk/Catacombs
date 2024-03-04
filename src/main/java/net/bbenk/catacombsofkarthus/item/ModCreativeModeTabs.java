package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CatacombsofKarthus.MODID);
    //Register creative mode tabs!!!
    public static final RegistryObject<CreativeModeTab> ALLITEMS_TAB = CREATIVE_MODE_TABS.register("allitems_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOULGEODE.get()))
                    .title(Component.translatable("creativetab.allitems_tab")).displayItems((displayParameters, output) -> {
                        //Add items to tab here!!!
            //Ingredients
                        output.accept(ModItems.SOULGEODE.get());
                        output.accept(ModItems.SOULPOWDER.get());
                        output.accept(ModItems.SSOULCRYSTAL.get());
                        output.accept(ModItems.MSOULCRYSTAL.get());
                        output.accept(ModItems.LSOULCRYSTAL.get());
                        output.accept(ModItems.RAWOPAL.get());
            //Tools&Misc
                        output.accept(ModItems.MALLET.get());
            //Foods
                        output.accept(ModItems.MOLDY_BOTTLE.get());
            //Blocks
                        output.accept(ModBlocks.SOULCRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.OPAL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_OPAL_ORE.get());
                        //Add items to tab here!!!
    }).build());
    //Register creative mode tabs!!!
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
