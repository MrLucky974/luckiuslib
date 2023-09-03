package net.luckius.luckiuslib.registration;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EnchantmentRegistryContainer implements AutoRegistryContainer<Enchantment> {

	@Override
	public Registry<Enchantment> getRegistry() {
		return Registries.ENCHANTMENT;
	}

	@Override
	public Class<Enchantment> getRegistryContentType() {
		return Enchantment.class;
	}
}
