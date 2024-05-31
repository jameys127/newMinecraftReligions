package net.jameys127.religion.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


//*** default constructor is enough apparently :) ***
public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    //*** many many many options to override in the item class to make custom items ***
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){    //*** im going to have to follow up on the .isClientSide() ?? no idea why thats important ***
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){    //*** this also is interesting, checks from the bottom up?? ****
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No Valuables Found!"));
            }
        }
        //*** this is how to damage an item when using it ***
        //*** don't really understand it but good to have ***
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand())) ;


        return InteractionResult.SUCCESS;
    }
    //*** sending a message to the chat box requires and "entity" so using the play apparently is a good ***
    //*** way to do that ***
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at (" +
                blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state){
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.EMERALD_ORE) ||
                state.is(Blocks.COAL_ORE) || state.is(Blocks.LAPIS_ORE) || state.is(Blocks.REDSTONE_ORE) || state.is(Blocks.COPPER_ORE);

    }
}
