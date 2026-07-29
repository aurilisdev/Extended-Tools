package extendedtools.common.item;

import java.util.Locale;

import extendedtools.References;
import extendedtools.Tags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public enum ArmorMaterialList implements ArmorMaterial {

    STEEL(40, new int[] { 3, 5, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, Tags.INGOT_STEEL),
    BRONZE(20, new int[] { 2, 5, 6, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Tags.INGOT_BRONZE),
    TIN(12, new int[] { 2, 4, 5, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Tags.INGOT_TIN),
    COPPER(17, new int[] { 2, 4, 5, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
	    net.minecraftforge.common.Tags.Items.INGOTS_COPPER),
    LEAD(33, new int[] { 2, 4, 5, 2 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 3.0F, Tags.INGOT_LEAD),
    VANADIUM(22, new int[] { 3, 4, 5, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Tags.INGOT_VANADIUM),
    SILVER(27, new int[] { 3, 5, 7, 3 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, Tags.INGOT_SILVER),
    TITANIUM(75, new int[] { 4, 6, 8, 4 }, 10, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.0F, Tags.INGOT_TITANIUM);

    private static final int[] MAX_DAMAGE_ARRAY = { 11, 16, 15, 13 };

    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final TagKey<Item> repairTag;

    ArmorMaterialList(int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent,
	    float toughness, float knockbackResistance, TagKey<Item> repairTag) {
	this.maxDamageFactor = maxDamageFactor;
	this.damageReductionAmountArray = damageReductionAmountArray;
	this.enchantability = enchantability;
	this.soundEvent = soundEvent;
	this.toughness = toughness;
	this.knockbackResistance = knockbackResistance;
	this.repairTag = repairTag;
    }

    @Override
    public int getDurabilityForType(Type type) {
	return MAX_DAMAGE_ARRAY[type.ordinal()] * maxDamageFactor;
    }

    @Override
    public int getDefenseForType(Type type) {
	return damageReductionAmountArray[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
	return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
	return soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
	return Ingredient.of(repairTag);
    }

    @Override
    public String getName() {
	return References.ID + ":" + name().toLowerCase(Locale.ROOT);
    }

    @Override
    public float getToughness() {
	return toughness;
    }

    @Override
    public float getKnockbackResistance() {
	return knockbackResistance;
    }
}