package com.morris__.simplekatanas.custom;

import com.morris__.simplekatanas.Item.custom.KatanaItem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.MathHelper;


public class ParryHudOverlay {

    private static final int PARRY_WINDOW_TICKS = 6;

    public static void register() {
        HudRenderCallback.EVENT.register(ParryHudOverlay::render);
    }

    private static void render(DrawContext context, RenderTickCounter tickCounter) {

        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        var player = client.player;

        if (!player.isUsingItem()) return;
        if (!(player.getActiveItem().getItem() instanceof KatanaItem)) return;

        int usedTicks = player.getItemUseTime();
        if (usedTicks > PARRY_WINDOW_TICKS) return;

        // ───── Balk berekening ─────
        float progress = usedTicks / (float) PARRY_WINDOW_TICKS;
        progress = MathHelper.clamp(progress, 0f, 1f);

        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();

        int barWidth = 20;
        int barHeight = 2;

        int x = screenWidth / 2 - barWidth / 2;
        int y = screenHeight / 2 + 16; // onder crosshair

        int filledWidth = (int) (barWidth * (1f - progress));

        // achtergrond
        context.fill(x, y, x + barWidth, y + barHeight, 0x4D000000);

        // parry window (wit)
        context.fill(
                x,
                y,
                x + filledWidth,
                y + barHeight,
                0xFFB0B0B0
        );
    }
}
