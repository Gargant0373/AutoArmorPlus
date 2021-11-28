package gargant.armor.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import gargant.armor.classes.Armor;
import gargant.armor.main.AutoArmorPlus;
import masecla.mlib.classes.Registerable;
import masecla.mlib.main.MLib;

public class RightClickEvent extends Registerable {

	private AutoArmorPlus autoArmor;

	public RightClickEvent(MLib lib, AutoArmorPlus autoArmor) {
		super(lib);
		this.autoArmor = autoArmor;
	}

	@EventHandler
	public void onRightClick(PlayerInteractEvent ev) {
		if (!autoArmor.enabled())
			return;
		if (ev.getItem() == null)
			return;
		Armor armor = new Armor(ev.getItem());
		if (!armor.isArmor())
			return;
		ItemStack currentArmor = armor.getArmorType().getEquipped(ev.getPlayer());
		if (currentArmor == null)
			return;
		Armor equipped = new Armor(currentArmor);
		if (!equipped.isArmor())
			return;
		if (armor.isBetter(equipped)) {
			armor.switchArmor(ev.getPlayer(), currentArmor);
			lib.getMessagesAPI().sendMessage("armor-equipped", ev.getPlayer());
		}
	}

}
