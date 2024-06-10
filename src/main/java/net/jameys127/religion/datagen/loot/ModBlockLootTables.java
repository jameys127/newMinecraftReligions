package net.jameys127.religion.datagen.loot;

import net.jameys127.religion.block.ModBlocks;
import net.jameys127.religion.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.MITHRIL_BLOCK.get());

        this.add(ModBlocks.MITHRIL_ORE_BLOCK.get(),
                block -> createOreDrops(ModBlocks.MITHRIL_ORE_BLOCK.get(), ModItems.RAW_MITHRIL.get()));
        this.add(ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get(),
                block -> createOreDrops(ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get(), ModItems.RAW_MITHRIL.get()));

    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
