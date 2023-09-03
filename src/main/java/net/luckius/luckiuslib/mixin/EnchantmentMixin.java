package net.luckius.luckiuslib.mixin;

import net.luckius.luckiuslib.event.EnchantmentEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
abstract class EnchantmentMixin {
    @Mutable
    @Final
    @Shadow
    public final EnchantmentTarget target;

    EnchantmentMixin(EnchantmentTarget target) {
        this.target = target;
    }

    @Inject(
            method = "isAcceptableItem(Lnet/minecraft/item/ItemStack;)Z",
            at = @At("RETURN"),
            cancellable = true
    )
    public void luckiuslib$isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        boolean bl = EnchantmentEvents.ENCHANTMENT_TARGET_CHECK.invoker().isAcceptableItem(((Enchantment) (Object) this), stack);
        cir.setReturnValue(cir.getReturnValue() || bl);
    }
}