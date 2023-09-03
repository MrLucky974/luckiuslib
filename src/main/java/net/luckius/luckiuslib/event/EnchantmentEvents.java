package net.luckius.luckiuslib.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public final class EnchantmentEvents {
    public static final Event<EnchantmentEvents.EnchantmentTargetCheck> ENCHANTMENT_TARGET_CHECK = EventFactory.createArrayBacked(EnchantmentEvents.EnchantmentTargetCheck.class, callbacks -> (enchantment, stack) -> {
        boolean hasAcceptableItem = false;
        for (EnchantmentEvents.EnchantmentTargetCheck callback : callbacks) {
            if (!callback.isAcceptableItem(enchantment, stack)) continue;

            hasAcceptableItem = true;
            break;
        }
        return hasAcceptableItem;
    });

    @FunctionalInterface
    public interface EnchantmentTargetCheck {
        /**
         * Called when {@code isAcceptableItem} is called in {@code Enchantment}
         *
         * @param enchantment the enchantment
         * @param stack the stack
         */
        boolean isAcceptableItem(Enchantment enchantment, ItemStack stack);
    }

    private EnchantmentEvents() {
    }
}
