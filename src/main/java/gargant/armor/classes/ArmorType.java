package gargant.armor.classes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public enum ArmorType {
	BOOTS(), LEGGINGS(), CHESTPLATE(), HELMET();

	/**
	 * Method used to fetch an ArmorType from a material.
	 * 
	 * @param Material to fetch from.
	 * @return ArmorType or null if not found.
	 */
	public static ArmorType fromMaterial(Material material) {
		if (material.name().contains("BOOTS"))
			return ArmorType.BOOTS;
		if (material.name().contains("LEG"))
			return ArmorType.LEGGINGS;
		if (material.name().contains("CHEST"))
			return ArmorType.CHESTPLATE;
		if (material.name().contains("HELMET"))
			return ArmorType.HELMET;
		return null;
	}

	public ItemStack getEquipped(Player p) {
		switch (this) {
		case BOOTS:
			return p.getInventory().getBoots();
		case LEGGINGS:
			return p.getInventory().getLeggings();
		case CHESTPLATE:
			return p.getInventory().getChestplate();
		case HELMET:
			return p.getInventory().getHelmet();
		default:
			return null;
		}
	}
}
