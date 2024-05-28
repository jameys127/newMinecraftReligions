package net.jameys127.religion.item;

import net.jameys127.religion.ModBlocks;
import net.jameys127.religion.myReligionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, myReligionMod.MODID);

    public static final RegistryObject<CreativeModeTab> RELIGION_TAB = CREATIVE_MODE_TABS.register("religion_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL.get()))
                    .title(Component.translatable("creativetab.religion_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //items
                        pOutput.accept(ModItems.MITHRIL.get());
                        pOutput.accept(ModItems.RAW_MITHRIL.get());
                        //blocks
                        pOutput.accept(ModBlocks.MITHRIL_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_DEEPSLATE_ORE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
