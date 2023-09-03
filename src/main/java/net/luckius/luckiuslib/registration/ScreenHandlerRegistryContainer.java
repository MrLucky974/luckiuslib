package net.luckius.luckiuslib.registration;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlerRegistryContainer implements AutoRegistryContainer<ScreenHandlerType<?>> {
    @Override
    public Registry<ScreenHandlerType<?>> getRegistry() {
        return Registries.SCREEN_HANDLER;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<ScreenHandlerType<?>> getRegistryContentType() {
        return (Class<ScreenHandlerType<?>>) (Class<?>) ScreenHandlerType.class;
    }
}
