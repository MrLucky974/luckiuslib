package net.luckius.luckiuslib.registration;

import net.minecraft.registry.Registry;

public interface AutoRegistryContainer<T> {
	Registry<T> getRegistry();
	Class<T> getRegistryContentType();
}
