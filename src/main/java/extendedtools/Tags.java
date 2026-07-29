package extendedtools;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class Tags {

    public static final TagKey<Item> INGOT_BRONZE = forgeItemTag("ingots/bronze");
    public static final TagKey<Item> INGOT_LEAD = forgeItemTag("ingots/lead");
    public static final TagKey<Item> INGOT_SILVER = forgeItemTag("ingots/silver");
    public static final TagKey<Item> INGOT_STEEL = forgeItemTag("ingots/steel");
    public static final TagKey<Item> INGOT_TIN = forgeItemTag("ingots/tin");
    public static final TagKey<Item> INGOT_TITANIUM = forgeItemTag("ingots/titanium");
    public static final TagKey<Item> INGOT_VANADIUM = forgeItemTag("ingots/vanadium");

    private Tags() {
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }
}