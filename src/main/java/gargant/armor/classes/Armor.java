package gargant.armor.classes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Armor {
	private ArmorType armorType;
	private MaterialType materialType;
	private ItemStack toSwitch;

	public Armor(ItemStack armor) {
		this.toSwitch = armor;
		this.armorType = ArmorType.fromMaterial(armor.getType());
		this.materialType = MaterialType.fromMaterial(armor.getType());
	}

	/**
	 * Method used to check whether or not the class is a correct instance of an
	 * armor.
	 * 
	 * @return whether the class is a proper armor or not.
	 */
	public boolean isArmor() {
		if (this.armorType == null || materialType == null || materialType.equals(Material.AIR))
			return false;
		return true;
	}

	public ArmorType getArmorType() {
		return this.armorType;
	}

	public MaterialType getMaterialType() {
		return this.materialType;
	}

	public boolean isBetter(Armor compared) {
		if (!this.armorType.equals(compared.getArmorType()))
			return false;
		if (this.materialType.getStrength() >= compared.getMaterialType().getStrength())
			return true;
		return false;
	}

	/**
	 * Method used to switch armor on a player.
	 * 
	 * @param Player  to switch the armor on.
	 * @param Current armor equipped.
	 */
	public void switchArmor(Player p, ItemStack currentArmor) {
		switch (ArmorType.fromMaterial(currentArmor.getType())) {
		case BOOTS:
			p.getInventory().setBoots(toSwitch);
			break;
		case LEGGINGS:
			p.getInventory().setLeggings(toSwitch);
			break;
		case CHESTPLATE:
			p.getInventory().setChestplate(toSwitch);
			break;
		case HELMET:
			p.getInventory().setHelmet(toSwitch);
			break;
		}
		p.getInventory().addItem(currentArmor);
		p.getInventory().setItem(p.getInventory().getHeldItemSlot(), new ItemStack(Material.AIR));
	}

	public void equipArmor(Player p) {
		switch (ArmorType.fromMaterial(this.toSwitch.getType())) {
		case BOOTS:
			p.getInventory().setBoots(toSwitch);
			break;
		case LEGGINGS:
			p.getInventory().setLeggings(toSwitch);
			break;
		case CHESTPLATE:
			p.getInventory().setChestplate(toSwitch);
			break;
		case HELMET:
			p.getInventory().setHelmet(toSwitch);
			break;
		}
	}
}
