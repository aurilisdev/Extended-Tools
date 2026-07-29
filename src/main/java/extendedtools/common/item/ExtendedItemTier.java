package extendedtools.common.item;

import java.util.Locale;

import org.jetbrains.annotations.NotNull;

import extendedtools.Tags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public enum ExtendedItemTier implements Tier {

    STEEL(2, (int) (Tiers.IRON.getUses() * 2.7), Tiers.IRON.getSpeed(), Tiers.IRON.getAttackDamageBonus() * 1.2F, 5,
	    Tags.INGOT_STEEL, 0.00F),
    BRONZE(2, Tiers.IRON.getUses(), Tiers.IRON.getSpeed(), Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_BRONZE,
	    -0.05F),
    TIN(1, Tiers.STONE.getUses(), Tiers.STONE.getSpeed(), Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_TIN, 0.10F),
    COPPER(1, Tiers.STONE.getUses() * 2, Tiers.STONE.getSpeed(), Tiers.STONE.getAttackDamageBonus(), 5,
	    net.minecraftforge.common.Tags.Items.INGOTS_COPPER, 0.05F),
    LEAD(2, Tiers.DIAMOND.getUses() * 2, Tiers.STONE.getSpeed(), Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_LEAD,
	    -0.20F),
    VANADIUM(2, Tiers.STONE.getUses(), Tiers.IRON.getSpeed(), Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_VANADIUM,
	    0.05F),
    SILVER(2, (int) (Tiers.IRON.getUses() * 1.3), Tiers.GOLD.getSpeed(), Tiers.GOLD.getAttackDamageBonus(), 5,
	    Tags.INGOT_SILVER, 0.15F),
    TITANIUM(3, Tiers.IRON.getUses() * 4, Tiers.IRON.getSpeed() * 1.1F, Tiers.IRON.getAttackDamageBonus() * 1.3F, 5,
	    Tags.INGOT_TITANIUM, 0.10F);

    private final float attackSpeedOffset;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final TagKey<Item> repairTag;

    ExtendedItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
	    TagKey<Item> repairTag, float attackSpeedOffset) {
	this.harvestLevel = harvestLevel;
	this.maxUses = maxUses;
	this.efficiency = efficiency;
	this.attackDamage = attackDamage;
	this.enchantability = enchantability;
	this.repairTag = repairTag;
	this.attackSpeedOffset = attackSpeedOffset;
    }

    @Override
    public int getUses() {
	return maxUses;
    }

    @Override
    public float getSpeed() {
	return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
	return attackDamage;
    }

    public float getAttackSpeedOffset() {
	return attackSpeedOffset;
    }

    @Override
    public int getLevel() {
	return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
	return enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
	return Ingredient.of(repairTag);
    }

    public String tag() {
	return name().toLowerCase(Locale.ROOT);
    }
}