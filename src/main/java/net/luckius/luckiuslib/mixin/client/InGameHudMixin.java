package net.luckius.luckiuslib.mixin.client;

import net.luckius.luckiuslib.rendering.HudRenderBeforeChatCallback;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
abstract class InGameHudMixin {
    @Inject(
            method = "render",
            at = @At(value = "INVOKE",
                    shift = At.Shift.BEFORE,
                    target = "Lnet/minecraft/client/gui/hud/ChatHud;render(Lnet/minecraft/client/gui/DrawContext;III)V"
            )
    )
    public void luckiuslib$render(DrawContext drawContext, float tickDelta, CallbackInfo callbackInfo) {
        HudRenderBeforeChatCallback.EVENT.invoker().onHudRender(drawContext, tickDelta);
    }
}
