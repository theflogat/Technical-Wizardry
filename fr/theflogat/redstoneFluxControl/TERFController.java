package fr.theflogat.redstoneFluxControl;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cofh.api.energy.IEnergyHandler;
import fr.theflogat.redstoneFluxControl.lib.Ids;

public class TERFController extends TileEntity{

	private int cooldown = 0;
	
	@Override
	public void updateEntity() {
		if(cooldown==0){
			TileEntity tile = getTileFromOrientation();
			if(tile!=null&&tile instanceof IEnergyHandler){
				IEnergyHandler teen = (IEnergyHandler) tile;
				switch(this.blockMetadata){
				case 0:
					if(teen.getEnergyStored(getDirFromOrientation())==teen.getMaxEnergyStored(getDirFromOrientation())){
						setRedstoneOutput(true);
					} else {
						setRedstoneOutput(false);
					}
					break;
				case 1:
					if(teen.getEnergyStored(getDirFromOrientation())==0){
						setRedstoneOutput(true);
					} else {
						setRedstoneOutput(false);
					}
					break;
				case 2:
					if(teen.getEnergyStored(getDirFromOrientation())<=(teen.getMaxEnergyStored(getDirFromOrientation()))*0.8F){
						setRedstoneOutput(true);
					} else {
						setRedstoneOutput(false);
					}
					break;
				case 3:
					if(teen.getEnergyStored(getDirFromOrientation())<=(teen.getMaxEnergyStored(getDirFromOrientation()))*0.2F){
						setRedstoneOutput(true);
					} else {
						setRedstoneOutput(false);
					}
					break;
				}
			}
			cooldown = 20;
		} else if(cooldown==5){
			int id = getBlockIdOppositeFromOrientation();
			if(id!=Ids.actualPowerBlock){
				if(id<0){
					setBlockIdOppositeFromOrientation(Ids.actualPowerBlock);
				} else {
					
				}
			}
		} else {
			cooldown--;
		}
		
		
	}
	
	public boolean canInteractWith(EntityPlayer player){
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}
	
	public int getBlockIdOppositeFromOrientation(){
    	int meta = this.getBlockMetadata()%10;
    	
		if(meta==1){
			return worldObj.getBlockId(xCoord, yCoord-1, zCoord);
		} else if(meta==0){
			return worldObj.getBlockId(xCoord, yCoord+1, zCoord);
		} else if(meta==3){
			return worldObj.getBlockId(xCoord, yCoord, zCoord-1);
		} else if(meta==2){
			return worldObj.getBlockId(xCoord, yCoord, zCoord+1);
		} else if(meta==5){
			return worldObj.getBlockId(xCoord-1, yCoord, zCoord);
		} else if(meta==4){
			return worldObj.getBlockId(xCoord+1, yCoord, zCoord);
		}
		return -1;
	}
	
	public void setBlockIdOppositeFromOrientation(int id){
    	int meta = this.getBlockMetadata()%10;
    	
		if(meta==1){
			worldObj.setBlock(xCoord, yCoord-1, zCoord, id);
		} else if(meta==0){
			worldObj.setBlock(xCoord, yCoord+1, zCoord, id);
		} else if(meta==3){
			worldObj.setBlock(xCoord, yCoord, zCoord-1, id);
		} else if(meta==2){
			worldObj.setBlock(xCoord, yCoord, zCoord+1, id);
		} else if(meta==5){
			worldObj.setBlock(xCoord-1, yCoord, zCoord, id);
		} else if(meta==4){
			worldObj.setBlock(xCoord+1, yCoord, zCoord, id);
		}
	}
	
	public void setBlockMetaOppositeFromOrientation(int metadata){
    	int meta = this.getBlockMetadata()%10;
    	
		if(meta==1){
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord-1, zCoord, metadata, 3);
		} else if(meta==0){
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord+1, zCoord, metadata, 3);
		} else if(meta==3){
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord-1, metadata, 3);
		} else if(meta==2){
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord+1, metadata, 3);
		} else if(meta==5){
			worldObj.setBlockMetadataWithNotify(xCoord-1, yCoord, zCoord, metadata, 3);
		} else if(meta==4){
			worldObj.setBlockMetadataWithNotify(xCoord+1, yCoord, zCoord, metadata, 3);
		}
	}
	
	public void breakBlockOppositeFromOrientation(int id){
    	int meta = this.getBlockMetadata()%10;
    	
		if(meta==1){
			worldObj.destroyBlock(xCoord, yCoord-1, zCoord, true);
		} else if(meta==0){
			worldObj.destroyBlock(xCoord, yCoord+1, zCoord, true);
		} else if(meta==3){
			worldObj.destroyBlock(xCoord, yCoord, zCoord-1, true);
		} else if(meta==2){
			worldObj.destroyBlock(xCoord, yCoord, zCoord+1, true);
		} else if(meta==5){
			worldObj.destroyBlock(xCoord-1, yCoord, zCoord, true);
		} else if(meta==4){
			worldObj.destroyBlock(xCoord+1, yCoord, zCoord, true);
		}
	}
	
	public TileEntity getTileFromOrientation(){
    	int meta = this.getBlockMetadata()%10;
    	
		if(meta==0){
			return worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord);
		} else if(meta==1){
			return worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
		} else if(meta==2){
			return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord-1);
		} else if(meta==3){
			return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord+1);
		} else if(meta==4){
			return worldObj.getBlockTileEntity(xCoord-1, yCoord, zCoord);
		} else if(meta==5){
			return worldObj.getBlockTileEntity(xCoord+1, yCoord, zCoord);
		}
		return null;
	}
	
	public ForgeDirection getDirFromOrientation(){
		int meta = this.getBlockMetadata()%10;
		
		if(meta==0){
			return ForgeDirection.DOWN.getOpposite();
		} else if(meta==1){
			return ForgeDirection.UP.getOpposite();
		} else if(meta==2){
			return ForgeDirection.NORTH.getOpposite();
		} else if(meta==3){
			return ForgeDirection.SOUTH.getOpposite();
		} else if(meta==4){
			return ForgeDirection.WEST.getOpposite();
		} else if(meta==5){
			return ForgeDirection.EAST.getOpposite();
		}
		return null;
	}
	
	public void setRedstoneOutput(boolean state){
		if(state){
			setBlockMetaOppositeFromOrientation(1);
		} else {
			setBlockMetaOppositeFromOrientation(0);
		}
	}
	
	public boolean[] state;
	
	public void receiveButtonEvent(int button){
		if(button<6){
			this.state[button] = !this.state[button];
			System.out.println(this.state[button]);
		}
	}
}
