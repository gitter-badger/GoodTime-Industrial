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
package com.mcgoodtime.gti.common.blocks;

import com.mcgoodtime.gti.common.core.Gti;
import com.mcgoodtime.gti.common.core.GuiHandler;
import com.mcgoodtime.gti.common.tiles.TileCarbonizeFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.core.block.TileEntityBlock;
import ic2.core.util.StackUtil;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by suhao on 2015.6.23.
 *
 * @author suhao
 */
public class BlockCarbonizeFurnace extends BlockContainerGti {

    private String name;
    private boolean isBurn;

    @SideOnly(Side.CLIENT)
    private IIcon top;
    private IIcon low;
    private IIcon front;
    private IIcon left;

    public BlockCarbonizeFurnace(Material material, String name) {
        super(material, name);
        this.name = name;
    }

    /**
     * Hand only
     *
     * side:
     * 1:top  5:east  3:south
     * 0:low  4:west  2:north
     *
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        switch(side){
            case 0: return this.low;
            case 1: return this.top;
            case 3: return this.front;
            case 4: return this.left;
            default: return this.blockIcon;
        }
    }

    /**
     * World only
     *
     * side:
     * 1:top  5:east  3:south
     * 0:low  4:west  2:north
     *
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
        TileEntity tile = iBlockAccess.getTileEntity(x, y, z);
        if (tile instanceof TileEntityBlock) {
            switch (new Short(((TileEntityBlock)tile).getFacing()).intValue()) {
                case 2://South
                    switch (side) {
                        case 0: return this.low;
                        case 1: return this.top;
                        case 2: return this.front;
                        case 5: return this.left;
                        default: return this.blockIcon;
                    }
                case 3://North
                    switch (side) {
                        case 0: return this.low;
                        case 1: return this.top;
                        case 3: return this.front;
                        case 4: return this.left;
                        default: return this.blockIcon;
                    }
                case 4://East
                    switch (side) {
                        case 0: return this.low;
                        case 1: return this.top;
                        case 4: return this.front;
                        case 2: return this.left;
                        default: return this.blockIcon;
                    }
                case 5://West
                    switch (side) {
                        case 0: return this.low;
                        case 1: return this.top;
                        case 5: return this.front;
                        case 3: return this.left;
                        default: return this.blockIcon;
                    }
                default://Unknown
                    return this.blockIcon;
            }
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iir) {
        this.top = iir.registerIcon(Gti.RESOURCE_DOMAIN + ":" + "block" + this.name + "_top_" + (isBurn ? "on" : "off"));
        this.low = iir.registerIcon(Gti.RESOURCE_DOMAIN + ":" + "block" + this.name + "_low");
        this.front = iir.registerIcon(Gti.RESOURCE_DOMAIN + ":" + "block" + this.name + "_front_" + (isBurn ? "on" : "off"));
        this.left = iir.registerIcon(Gti.RESOURCE_DOMAIN + ":" + "block" + this.name + "_left_"  + (isBurn ? "on" : "off"));
        this.blockIcon = iir.registerIcon(Gti.RESOURCE_DOMAIN + ":" + "block" + this.name);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            entityPlayer.openGui(Gti.instance, GuiHandler.EnumGui.CarbonizeFurnace.ordinal(), world, x, y, z);
        } else {
            entityPlayer.isInvisibleToPlayer(entityPlayer);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileCarbonizeFurnace();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack){
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof TileCarbonizeFurnace) {
            TileCarbonizeFurnace furnace = (TileCarbonizeFurnace)tile;
            NBTTagCompound nbt = StackUtil.getOrCreateNbtData(itemStack);
            if (entityliving == null) {
                furnace.setFacing(convertIntegerToShort(1));
            } else {
                furnace.setFacing(convertIntegerToShort(BlockPistonBase.determineOrientation(world, x, y, z, entityliving)));
            }
        }
    }

    private static short convertIntegerToShort(int integer_n) {
        return new Integer(integer_n).shortValue();
    }
}
