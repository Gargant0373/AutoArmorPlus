package gargant.armor.classes;

import org.bukkit.Material;

public enum MaterialType {
	LEATHER(0), CHAIN(1), GOLD(2), IRON(3), DIAMOND(4), NETHERITE(5);

	/**
	 * An integer providing the value of the armor.
	 */
	private int materialStrength;

	MaterialType(int strength) {
		this.materialStrength = strength;
	}

	public int getStrength() {
		return this.materialStrength;
	}

	/**
	 * Method used to compare the current type of armor to the provided one.
	 * 
	 * @param the type of armor to compare to
	 * @return whether the current armor is better than the provided type
	 */
	public boolean isBetter(MaterialType type) {
		if (this.materialStrength >= type.getStrength())
			return true;
		return false;
	}

	/**
	 * Method used to fetch a MaterialType from a material.
	 * 
	 * @param Material to fetch from.
	 * @return MaterialType or null if not found.
	 */
	public static MaterialType fromMaterial(Material m) {
		if (m.name().contains("LEATHER"))
			return MaterialType.LEATHER;
		if (m.name().contains("CHAINMAIL"))
			return MaterialType.CHAIN;
		if (m.name().contains("GOLD"))
			return MaterialType.GOLD;
		if (m.name().contains("IRON_"))
			return MaterialType.IRON;
		if (m.name().contains("DIAMOND"))
			return MaterialType.DIAMOND;
		if (m.name().contains("NETHERITE"))
			return MaterialType.NETHERITE;
		return null;
	}
}
