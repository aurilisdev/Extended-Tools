package extendedtools.common.item;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum ExtendedItemTier implements Tier {

    STEEL(BlockTags.INCORRECT_FOR_IRON_TOOL, (int) (Tiers.IRON.getUses() * 2.7), Tiers.IRON.getSpeed(),
	    Tiers.IRON.getAttackDamageBonus() * 1.2F, 5, Tags.INGOT_STEEL, 0.00F),

    BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, Tiers.IRON.getUses(), Tiers.IRON.getSpeed(),
	    Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_BRONZE, -0.05F),

    TIN(BlockTags.INCORRECT_FOR_STONE_TOOL, Tiers.STONE.getUses(), Tiers.STONE.getSpeed(),
	    Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_TIN, 0.10F),

    COPPER(BlockTags.INCORRECT_FOR_STONE_TOOL, Tiers.STONE.getUses() * 2, Tiers.STONE.getSpeed(),
	    Tiers.STONE.getAttackDamageBonus(), 5, net.neoforged.neoforge.common.Tags.Items.INGOTS_COPPER, 0.05F),

    LEAD(BlockTags.INCORRECT_FOR_IRON_TOOL, Tiers.DIAMOND.getUses() * 2, Tiers.STONE.getSpeed(),
	    Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_LEAD, -0.20F),

    VANADIUM(BlockTags.INCORRECT_FOR_IRON_TOOL, Tiers.STONE.getUses(), Tiers.IRON.getSpeed(),
	    Tiers.IRON.getAttackDamageBonus(), 5, Tags.INGOT_VANADIUM, 0.05F),

    SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, (int) (Tiers.IRON.getUses() * 1.3), Tiers.GOLD.getSpeed(),
	    Tiers.GOLD.getAttackDamageBonus(), 5, Tags.INGOT_SILVER, 0.15F),

    TITANIUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, Tiers.IRON.getUses() * 4, Tiers.IRON.getSpeed() * 1.1F,
	    Tiers.IRON.getAttackDamageBonus() * 1.3F, 5, Tags.INGOT_TITANIUM, 0.10F);

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int maxUses;
    private final float efficency;
    private final float baseAttackDamage;
    private final float attackSpeedOffset;
    private final int enchantability;
    private final Ingredient repairIngredient;

    ExtendedItemTier(TagKey<Block> incorrectBlocksForDrops, int maxUses, float efficiency, float baseAttackDamage,
	    int enchantability, TagKey<Item> repairTag, float attackSpeedOffset) {
	this.incorrectBlocksForDrops = incorrectBlocksForDrops;
	this.maxUses = maxUses;
	this.efficency = efficiency;
	this.baseAttackDamage = baseAttackDamage;
	this.enchantability = enchantability;
	this.repairIngredient = Ingredient.of(repairTag);
	this.attackSpeedOffset = attackSpeedOffset;
    }

    public float getAttackSpeedOffset() {
	return attackSpeedOffset;
    }

    @Override
    public int getUses() {
	return maxUses;
    }

    @Override
    public float getSpeed() {
	return efficency;
    }

    @Override
    public float getAttackDamageBonus() {
	return baseAttackDamage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
	return incorrectBlocksForDrops;
    }

    @Override
    public Tool createToolProperties(TagKey<Block> pBlock) {
	return new Tool(List.of(Tool.Rule.deniesDrops(this.getIncorrectBlocksForDrops()),
		Tool.Rule.minesAndDrops(pBlock, this.getSpeed())), 1.0F, 1);
    }

    @Override
    public int getEnchantmentValue() {
	return enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
	return repairIngredient;
    }

    public String tag() {
	return name().toLowerCase();
    }

}
