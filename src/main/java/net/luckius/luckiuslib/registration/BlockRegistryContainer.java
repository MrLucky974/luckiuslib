package net.luckius.luckiuslib.registration;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockRegistryContainer implements AutoRegistryContainer<Block> {

	@Override
	public Registry<Block> getRegistry() {
		return Registries.BLOCK;
	}

	@Override
	public Class<Block> getRegistryContentType() {
		return Block.class;
	}
}
