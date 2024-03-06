package net.bbenk.catacombsofkarthus;

import com.mojang.logging.LogUtils;
import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.bbenk.catacombsofkarthus.item.ModCreativeModeTabs;
import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CatacombsofKarthus.MODID)
public class CatacombsofKarthus {
    public static final String MODID = "catacombsofkarthus";
    public static final Logger LOGGER = LogUtils.getLogger();
    public CatacombsofKarthus() { //main class!!!
    //event bus register
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    //event bus register

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to vanilla creative mode tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //add to tab ingredients
            //event.accept(ModItems.SOULPOWDER);
            //event.accept(ModItems.SOULGEODE);
            //event.accept(ModItems.SSOULCRYSTAL);
            //.accept(ModItems.MSOULCRYSTAL);
            //event.accept(ModItems.LSOULCRYSTAL);
            //add to tab ingredients
        }
        //if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //event.accept(ModBlocks.SOULCRYSTAL_BLOCK);
            //event.accept(ModBlocks.SOULFLUX_ORE);
        //}
    //}

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientStartup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
            });
        }
    }

}

