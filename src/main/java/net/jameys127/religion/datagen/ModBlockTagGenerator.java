package net.jameys127.religion.datagen;

import net.jameys127.religion.block.ModBlocks;
import net.jameys127.religion.myReligionMod;
import net.jameys127.religion.tag.ModTags;
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
        super(output, lookupProvider, myReligionMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider){

        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).add(ModBlocks.MITHRIL_ORE_BLOCK.get())
                .add(ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MITHRIL_BLOCK.get(),
                    ModBlocks.MITHRIL_ORE_BLOCK.get(),
                    ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get(),
                    ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.MITHRIL_ORE_BLOCK.get(),
                ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get(),
                ModBlocks.MITHRIL_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
    }
}
