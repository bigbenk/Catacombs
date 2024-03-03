package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CatacombsofKarthus.MODID);



        //REGISTER ITEMS HERE
    public static final RegistryObject<Item> SOULPOWDER = ITEMS.register("soulpowder",
                () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SOULGEODE = ITEMS.register("soulgeode",
            () -> new Item(new Item.Properties().stacksTo(8)));
    public static final RegistryObject<Item> SSOULCRYSTAL = ITEMS.register("ssoulcrystal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MSOULCRYSTAL = ITEMS.register("msoulcrystal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> LSOULCRYSTAL = ITEMS.register("lsoulcrystal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RAWOPAL = ITEMS.register("rawopal",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MALLET = ITEMS.register("mallet",
            () -> new Item(new Item.Properties().setNoRepair().durability(10)));

        //REGISTER ITEMS HERE


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
