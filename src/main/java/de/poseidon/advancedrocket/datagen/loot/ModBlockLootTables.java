package de.poseidon.advancedrocket.datagen.loot;

import de.poseidon.advancedrocket.block.ModBlocks;
import de.poseidon.advancedrocket.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ROCKET_BUILDER.get());
        this.add(ModBlocks.TIN_ORE.get(), block -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.TIN_RAW.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
