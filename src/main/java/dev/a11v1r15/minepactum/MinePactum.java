package dev.a11v1r15.minepactum;

import dev.a11v1r15.minepactum.Items.MinePactumItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinePactum implements ModInitializer {
	public static final String ID = "minepactum";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		MinePactumItems.initialize();
		LOGGER.info("Pacta sunt servanda");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(ID, path);
	}
}
