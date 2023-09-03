package net.luckius.luckiuslib.util;

import net.minecraft.util.Pair;

import java.util.List;
import java.util.function.Predicate;

public class InventoryHelper {
    public static <T> Pair<Integer, Integer> getItemGridSize(List<T> stacks, Predicate<T> isEmpty) {
        int width = 0;
        int height = 0;

        for (int col = 0; col < 3; col++) {
            boolean columnEmpty = true;
            for (int row = 0; row < 3; row++) {
                T stack = stacks.get(row * 3 + col);
                if (!isEmpty.test(stack)) {
                    columnEmpty = false;
                    break;
                }
            }
            if (!columnEmpty) {
                width++;
            }
        }

        for (int row = 0; row < 3; row++) {
            boolean rowEmpty = true;
            for (int col = 0; col < 3; col++) {
                T stack = stacks.get(row * 3 + col);
                if (!isEmpty.test(stack)) {
                    rowEmpty = false;
                    break;
                }
            }
            if (!rowEmpty) {
                height++;
            }
        }

        return new Pair<>(width, height);
    }
}
