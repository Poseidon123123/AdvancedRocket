package de.poseidon.advancedrocket.tabs;

import de.poseidon.advancedrocket.AdvancedRocket;
import de.poseidon.advancedrocket.block.ModBlocks;
import de.poseidon.advancedrocket.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvancedRocket.MODID);

    public static final RegistryObject<CreativeModeTab> BASE_ITEM_TAB = CREATIVE_MODE_TABS.register("base_item_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
            .title(Component.translatable("creativetab.base_item_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.TIN_INGOT.get());
                pOutput.accept(ModBlocks.TIN_ORE.get());
                pOutput.accept(ModItems.TIN_RAW.get());
            })
            .build());

    public static final RegistryObject<CreativeModeTab> ADVANCED_ITEM_TAB = CREATIVE_MODE_TABS.register("advanced_item_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DATA_CONTAINER.get()))
            .title(Component.translatable("creativetab.advanced_item_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.DATA_CONTAINER.get());
                pOutput.accept(ModItems.ORE_SCANNER.get());
            })
            .build());

    public static final RegistryObject<CreativeModeTab> MACHINE_TAB = CREATIVE_MODE_TABS.register("machine_tab", () -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModBlocks.ROCKET_BUILDER.get()))
            .displayItems((pParameters, pOutput) ->{
                pOutput.accept(ModBlocks.ROCKET_BUILDER.get());
            })
            .build());

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab", () -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.STRAWBERRY.get()))
            .displayItems((pParameters, pOutput) ->{
                pOutput.accept(ModItems.STRAWBERRY.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
