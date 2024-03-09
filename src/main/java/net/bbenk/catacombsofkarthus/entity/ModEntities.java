package net.bbenk.catacombsofkarthus.entity;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.entity.custom.projectile.SpiritArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CatacombsofKarthus.MODID);

    public static final RegistryObject<EntityType<SpiritArrow>> SPIRIT_ARROW =
            ENTITY_TYPES.register("spirit_arrow",
                    () -> EntityType.Builder.of(SpiritArrow::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("spirit_arrow"));

    public static void register(IEventBus eventBus) { ENTITY_TYPES.register(eventBus); }
}
