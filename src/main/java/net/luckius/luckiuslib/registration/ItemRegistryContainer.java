package net.luckius.luckiuslib.registration;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemRegistryContainer implements AutoRegistryContainer<Item> {

	@Override
	public Registry<Item> getRegistry() {
		return Registries.ITEM;
	}

	@Override
	public Class<Item> getRegistryContentType() {
		return Item.class;
	}
}
