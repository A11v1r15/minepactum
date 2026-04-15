package dev.a11v1r15.minepactum.Items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.network.Filterable;
import net.minecraft.server.network.FilteredText;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.item.component.WritableBookContent;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.Level;

public class StampItem extends Item {
	public StampItem(Properties properties) {
		super(properties);
	}

	public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
		if (hand == InteractionHand.MAIN_HAND) {
			ItemStack itemStack = player.getItemInHand(hand);
			ItemStack otherItemStack = player.getItemInHand(InteractionHand.OFF_HAND);
			if (otherItemStack.getItem() instanceof WritableBookItem book) {
				WritableBookContent writable_component = book.components().get(DataComponents.WRITABLE_BOOK_CONTENT);
				if (writable_component != null) {
					player.setItemInHand(InteractionHand.OFF_HAND, otherItemStack.transmuteCopy(MinePactumItems.PACT));
					itemStack.hurtWithoutBreaking(1, player);
					player.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.PASS;
	}
}
