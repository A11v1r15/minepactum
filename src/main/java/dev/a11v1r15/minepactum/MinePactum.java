package dev.a11v1r15.minepactum;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinePactum implements ModInitializer {
	public static final String ID = "minepactum";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Pacta sunt servanda");
	}
}
