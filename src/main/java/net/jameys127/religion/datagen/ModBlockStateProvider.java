package net.jameys127.religion.datagen;

import net.jameys127.religion.block.ModBlocks;
import net.jameys127.religion.myReligionMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, myReligionMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(ModBlocks.MITHRIL_BLOCK);

        blockWithItem(ModBlocks.MITHRIL_ORE_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK);

        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
