package net.luckius.luckiuslib.util;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Arrays;
import java.util.List;

public class TooltipHelper {
    public static void expandableTooltip(List<Text> tooltip, Text... texts) {
        if (Screen.hasShiftDown()) {
            tooltip.addAll(Arrays.asList(texts));
        } else {
            tooltip.add(Text.translatable("tooltip.luckiuslib.hold_shift").formatted(Formatting.ITALIC, Formatting.DARK_GRAY));
        }
    }
}
