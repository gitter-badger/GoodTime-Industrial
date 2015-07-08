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
package com.mcgoodtime.gti.common.items;

import com.mcgoodtime.gti.common.core.Gti;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.util.List;

import static com.mcgoodtime.gti.common.core.Gti.MOD_ID;

/**
 * Created by suhao on 2015.6.29.
 * @author suhao 
 */
public class ItemGtiRecord extends ItemRecord {

    private String name;

    public ItemGtiRecord(String name) {
        super(name);
        this.name = name;
        this.setCreativeTab(Gti.TAB_GTI);
        this.setUnlocalizedName(MOD_ID + "." + "record" + "." + name);
        this.setTextureName(Gti.RESOURCE_DOMAIN + ":" + name);
        GameRegistry.registerItem(this, name, MOD_ID);
    }

    @Override
    public String getRecordNameLocal() {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".desc");
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation(Gti.RESOURCE_DOMAIN + ":" + this.name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltipList, boolean boo) {
        tooltipList.add(I18n.format(Gti.MOD_ID + ".tooltip.item.record" + "." + this.name + "." + "desc1"));
        tooltipList.add(I18n.format(Gti.MOD_ID + ".tooltip.item.record" + "." + this.name + "." + "desc2"));
    }

}
