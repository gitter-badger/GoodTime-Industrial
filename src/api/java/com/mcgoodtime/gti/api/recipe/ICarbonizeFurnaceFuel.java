/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 Minecraft-GoodTime <http://github.com/Minecraft-GoodTime>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcgoodtime.gti.api.recipe;

import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * The interface for the fuel of carbonize furnace.
 * @see ic2.api.recipe.IRecipeInput
 * @author liach
 * @since 0.0.1
 */
public interface ICarbonizeFurnaceFuel extends IRecipeInput {
    /**
     * Check if subject matches this recipe input, ignoring the amount.
     * Match the ore dictionary please!
     *
     * @param subject ItemStack to check
     * @return true if it matches the requirement
     */
    @Override
    boolean matches(ItemStack subject);

    /**
     * Determine the minimum input stack size.
     *
     * @return input amount required
     */
    @Override
    int getAmount();

    /**
     * List all possible inputs (best effort).
     *
     * The stack size is undefined, use getAmount to get the correct one.
     *
     * @return list of inputs, may be incomplete
     */
    @Override
    List<ItemStack> getInputs();

    /**
     * Returns the time the stack of fuel could burn.
     * @return the time
     */
    int getFuelPower();
}
