package fr.theflogat.technicalWizardry.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@Event.HasResult
public class ItemTWUEvent extends PlayerEvent{

    public final ItemStack current;
    public final World world;
    public final MovingObjectPosition target;

    public ItemStack result;

    public ItemTWUEvent(EntityPlayer player, ItemStack current, World world, MovingObjectPosition target)
    {
        super(player);
        this.current = current;
        this.world = world;
        this.target = target;
    }
}