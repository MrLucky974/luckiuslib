package net.luckius.luckiuslib.registration;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class StatusEffectRegistryContainer implements AutoRegistryContainer<StatusEffect> {

	@Override
	public Registry<StatusEffect> getRegistry() {
		return Registries.STATUS_EFFECT;
	}

	@Override
	public Class<StatusEffect> getRegistryContentType() {
		return StatusEffect.class;
	}
}
