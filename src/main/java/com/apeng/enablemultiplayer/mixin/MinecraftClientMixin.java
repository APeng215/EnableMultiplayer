package com.apeng.enablemultiplayer.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Inject(method = "isMultiplayerEnabled()Z", at = @At("HEAD"), cancellable = true)
    private void injectMethod(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(((MinecraftClientAccessor)this).getMultiplayerEnabled());
        cir.cancel();
    }
}
