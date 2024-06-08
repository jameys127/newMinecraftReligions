package net.jameys127.religion.item;

import net.jameys127.religion.item.custom.MetalDetectorItem;
import net.jameys127.religion.myReligionMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, myReligionMod.MODID);


    public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100).fireResistant()));

    public static final RegistryObject<Item> SWEET_FLESH = ITEMS.register("sweet_flesh",
            () -> new Item(new Item.Properties().food(ModFoods.SWEET_FLESH)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
