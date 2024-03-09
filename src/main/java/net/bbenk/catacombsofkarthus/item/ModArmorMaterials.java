package net.bbenk.catacombsofkarthus.item;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    Witherspec("witherspec", 25, Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 5);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 8);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 11);
        p_266655_.put(ArmorItem.Type.HELMET, 6);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> {
        return Ingredient.of(new ItemLike[]{ModItems.WITHERSPEC.get()});
    }),
    Aviator("aviator", 25, Util.make(new EnumMap(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.HELMET, 4);
    }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 1.5F, 0.1F, () -> {
        return Ingredient.of(new ItemLike[]{Items.LEATHER});
    });

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private ModArmorMaterials(String name, int durabilityMultiplier,
                           EnumMap protectionTypeMap, int enchantmentValue, SoundEvent sound, float toughness,
                           float knockbackResistance, Supplier repairMaterial) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionTypeMap;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairMaterial;
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return (Integer)HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return (Integer)this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    public String getName() {
        return CatacombsofKarthus.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return CatacombsofKarthus.MODID + ":" + this.name;
    }
}
