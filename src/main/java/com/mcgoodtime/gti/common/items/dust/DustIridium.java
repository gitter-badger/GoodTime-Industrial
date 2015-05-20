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
package com.mcgoodtime.gti.common.items.dust;

import com.mcgoodtime.gti.common.core.CreativeTabGti;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * The iridium dust item.
 *
 * @author Su Hao
 */
public class DustIridium extends Item {
    public DustIridium() {
        setUnlocalizedName("gti.dust.DustIridium");
        setCreativeTab(CreativeTabGti.creativeTabGti);
        setTextureName("gti:itemDustIriridium");
        GameRegistry.registerItem(this, "DustIridium");
    }

    public static class DustIridiumSmall extends Item {
        public DustIridiumSmall() {
            setUnlocalizedName("gti.dust.DustIridiumSmall");
            setCreativeTab(CreativeTabGti.creativeTabGti);
            setTextureName("gti:itemDustIriridiumSmall");
            GameRegistry.registerItem(this, "DustIridiumSmall");
        }
    }
}
