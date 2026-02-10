package com.morris__.simplekatanas;

import com.morris__.simplekatanas.custom.ModItemProperties;
import com.morris__.simplekatanas.custom.ParryHudOverlay;
import net.fabricmc.api.ClientModInitializer;

public class SimpleKatanasClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItemProperties.register();
        ParryHudOverlay.register();
    }
}
