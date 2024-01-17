package de.poseidon.advancedrocket.util;

import de.poseidon.advancedrocket.AdvancedRocket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ORE_SCANNER_VALUABLES = tag("ore_scanner_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(AdvancedRocket.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(AdvancedRocket.MODID, name));
        }
    }
}
