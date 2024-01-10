package lol.revolt.blight;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlightMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("blight");
	public static Enchantment BLIGHT_ENCHANTMENT = new BlightEnchantment();
	public static final StatusEffect BLIGHT_STATUS_EFFECT = new BlightStatusEffect(1f);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ENCHANTMENT, new Identifier("blight", "blight_enchantment"), BLIGHT_ENCHANTMENT);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("blight", "blight"), BLIGHT_STATUS_EFFECT);
	}
}