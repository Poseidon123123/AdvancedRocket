package de.poseidon.advancedrocket.datagen;

import de.poseidon.advancedrocket.AdvancedRocket;
import de.poseidon.advancedrocket.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdvancedRocket.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DATA_CONTAINER);
        simpleItem(ModItems.ORE_SCANNER);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.TIN_RAW);

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(AdvancedRocket.MODID, "item/" + item.getId().getPath()));
    }
}
