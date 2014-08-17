package riskyken.armourersWorkshop.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import riskyken.armourersWorkshop.common.items.block.ModItemBlockWithMetadata;
import riskyken.armourersWorkshop.common.lib.LibBlockNames;
import riskyken.armourersWorkshop.common.lib.LibModInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArmourerMultiBlock extends AbstractModBlock {

    public BlockArmourerMultiBlock() {
        super(LibBlockNames.ARMOURER_MULTI_BLOCK);
    }
    
    @SideOnly(Side.CLIENT)
    private IIcon[] blockIcons;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        blockIcons = new IIcon[2];
        blockIcon = register.registerIcon(LibModInfo.ID.toLowerCase() + ":"
                + "frame-side");
        blockIcons[0] = register.registerIcon(LibModInfo.ID.toLowerCase() + ":"
                + "frame-wall");
        blockIcons[1] = register.registerIcon(LibModInfo.ID.toLowerCase() + ":"
                + "frame-corner");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side < 2) {
            return blockIcon;
        }
        if (meta > 1) {
            return blockIcon;
        }
        return blockIcons[meta];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < 2; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public Block setBlockName(String name) {
        GameRegistry.registerBlock(this, ModItemBlockWithMetadata.class, "block." + name);
        return super.setBlockName(name);
    }
    
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}