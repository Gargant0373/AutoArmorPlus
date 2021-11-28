package gargant.armor.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import gargant.armor.classes.Armor;
import gargant.armor.main.AutoArmorPlus;
import masecla.mlib.classes.Registerable;
import masecla.mlib.main.MLib;

public class ArmorPickupEvent extends Registerable {

	private AutoArmorPlus autoArmor;

	public ArmorPickupEvent(MLib lib, AutoArmorPlus autoArmor) {
		super(lib);
		this.autoArmor = autoArmor;
	}

	@EventHandler
	public void onPickup(EntityPickupItemEvent ev) {
		if (!autoArmor.isEnabled())
			return;
		if (!(ev.getEntity() instanceof Player))
			return;
		Player p = (Player) ev.getEntity();

		Armor pickedUp = new Armor(ev.getItem().getItemStack());
		if (!pickedUp.isArmor())
			return;
		ItemStack currentArmor = pickedUp.getArmorType().getEquipped(p);
		if (currentArmor == null) {
			lib.getMessagesAPI().sendMessage("armor-equipped", p);
			pickedUp.equipArmor(p);
			ev.getItem().remove();
			ev.setCancelled(true);
			return;
		}
		Armor equipped = new Armor(currentArmor);
		if (!equipped.isArmor())
			return;
		if (pickedUp.isBetter(equipped)) {
			pickedUp.switchArmor(p, currentArmor);
			lib.getMessagesAPI().sendMessage("armor-equipped", p);
			ev.getItem().remove();
			ev.setCancelled(true);
		}
	}

}
