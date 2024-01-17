package de.poseidon.advancedrocket.item;

import de.poseidon.advancedrocket.AdvancedRocket;
import de.poseidon.advancedrocket.item.custom.OreScannerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AdvancedRocket.MODID);

    public static final RegistryObject<Item> DATA_CONTAINER = ITEMS.register("data_container", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIN_RAW = ITEMS.register("tin_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORE_SCANNER = ITEMS.register("ore_scanner", () -> new OreScannerItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
