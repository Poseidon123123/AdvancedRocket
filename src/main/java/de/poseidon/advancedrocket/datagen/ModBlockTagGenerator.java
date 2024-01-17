package de.poseidon.advancedrocket.datagen;

import de.poseidon.advancedrocket.AdvancedRocket;
import de.poseidon.advancedrocket.block.ModBlocks;
import de.poseidon.advancedrocket.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AdvancedRocket.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(ModTags.Blocks.ORE_SCANNER_VALUABLES).add(ModBlocks.TIN_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.TIN_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.TIN_ORE.get(), ModBlocks.ROCKET_BUILDER.get());
    }
}
