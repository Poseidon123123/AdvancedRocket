package de.poseidon.advancedrocket.item.custom;

import de.poseidon.advancedrocket.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class OreScannerItem extends Item {
    public OreScannerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if(!context.getLevel().isClientSide()){
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();
            if(player == null){
                return InteractionResult.FAIL;
            }
            boolean found = false;
            for (int i = 0; i < pos.getY() + 64 ; i++) {
                BlockState state = context.getLevel().getBlockState(pos.below(i));
                if(isValueBlock(state)){
                    outputValuableCoordinates(pos.below(i), player, state.getBlock());
                    found = true;
                }
            }
            if(!found){
                player.sendSystemMessage(Component.literal("No Ore found"));
            }
        }

        context.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(context.getPlayer()), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + block.getDescriptionId() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValueBlock(BlockState state) {
        return state.is(ModTags.Blocks.ORE_SCANNER_VALUABLES);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        components.add(Component.translatable("tooltip.advancedrocket.ore_scanner_tooltip"));
        super.appendHoverText(itemStack, level, components, flag);
    }
}
