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
 * A general recipe for {@link CarbonizeFurnaceRecipes}.
 * @see ic2.api.recipe.IRecipeInput
 * @author liach
 * @since 0.0.1
 */
public interface ICarbonizeFurnaceRecipeInput extends IRecipeInput {
    /**
     * Check if subject matches this recipe input, ignoring the amount.
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
     * List all required inputs.
     *
     * The stack size is defined, use getAmount to get the correct one.
     *
     * @return list of inputs
     */
    @Override
    List<ItemStack> getInputs();

    /**
     * The fuels that can be used by this {@link ICarbonizeFurnaceRecipeInput}.
     * This list includes all special fuel required for the recipe.
     * @return the list of special fuel
     */
    List<ICarbonizeFurnaceFuel> getSpecialFuels();

    /**
     * Returns the time it took to finish the process of this recipe, including
     * the time spent by the special fuels, in ticks (1/20 second).
     * @return the time of the recipe
     */
    int getTotalTime();
}
