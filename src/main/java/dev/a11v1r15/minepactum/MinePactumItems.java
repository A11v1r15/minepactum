package dev.a11v1r15.minepactum;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class MinePactumItems {
	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, MinePactum.id(name));
		T item = itemFactory.apply(settings.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}
	public static final ResourceKey<CreativeModeTab> MINEPACTUM_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), MinePactum.id("minepactum_tab")
	);
	public static final CreativeModeTab MINEPACTUM_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(MinePactumItems.STAMP))
		.title(Component.translatable("creativeTab.minepactum"))
		.displayItems((params, output) -> {
			output.accept(Items.WRITABLE_BOOK);
			output.accept(MinePactumItems.STAMP);
			output.accept(MinePactumItems.PACT);
			output.accept(MinePactumItems.SEALED_PACT);
			output.accept(MinePactumItems.OFFICIAL_PACT);
		})
		.build();

	public static final Item STAMP = register("stamp", Item::new,
		new Item.Properties()
			.durability(30)
			.stacksTo(1)
			.repairable(Items.LAPIS_LAZULI)
	);
	public static final WrittenBookItem PACT = register("pact", WrittenBookItem::new,
		new Item.Properties()
			.stacksTo(16)
	);
	public static final WrittenBookItem SEALED_PACT = register("sealed_pact", WrittenBookItem::new,
		new Item.Properties()
			.stacksTo(16)
	);
	public static final WrittenBookItem OFFICIAL_PACT = register("official_pact", WrittenBookItem::new,
		new Item.Properties()
			.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
			.stacksTo(16)
	);


	public static void initialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MINEPACTUM_TAB_KEY, MINEPACTUM_TAB);
	}
}
