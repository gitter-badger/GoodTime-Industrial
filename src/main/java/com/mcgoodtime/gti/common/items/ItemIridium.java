package com.mcgoodtime.gti.common.items;

//import com.mcgoodtime.gti.common.core.CreativeTabGti;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIridium extends Item {
	
	public static Item CrushedIR = new Item()
	.setUnlocalizedName("CrushedIriridium")
	.setCreativeTab(CreativeTabs.tabFood)
	.setTextureName("gti:itemCrushedIR");
	public static Item DustIR = new Item()
	.setUnlocalizedName("DustIriridium")
	.setCreativeTab(CreativeTabs.tabFood)
	.setTextureName("gti:itemDustIR");
	public static Item IngotIR = new Item()
	.setUnlocalizedName("IngotIriridium")
	.setCreativeTab(CreativeTabs.tabFood)
	.setTextureName("gti:itemIngotIR");
	public static Item CleanedIridium = new Item()
	.setUnlocalizedName("IngotIriridium")
	.setCreativeTab(CreativeTabs.tabFood)
	.setTextureName("gti:itemWashedIridium");
	
	public static ItemStack CrushedIRs = new ItemStack(CrushedIR); 
	public static ItemStack DustIRs = new ItemStack(DustIR);
	public static ItemStack IngotIRs = new ItemStack(IngotIR);
	
    public static void preInit() {
    	GameRegistry.registerItem(CrushedIR, "CrushedIriridium");
    	GameRegistry.registerItem(DustIR, "DustIriridium");
    	GameRegistry.registerItem(IngotIR, "IngotIriridium");
	}
	
}