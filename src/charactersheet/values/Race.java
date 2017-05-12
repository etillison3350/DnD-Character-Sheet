package charactersheet.values;

import charactersheet.values.ProficiencyAdd.ChoiceProficiencyAdd;
import charactersheet.values.item.Tool;
import charactersheet.values.item.Weapon;

public class Race {

	public static final Race DWARF = new Race("Dwarf", new Race[] {new Race("Hill Dwarf"), new Race("Mountain Dwarf")}, //
			new Feature("Ability Score Increase", false, new IntAdd(Ability.CONSTITUTION, 2)), //
			new Feature("Age", false), //
			new Feature("Size", false), //
			new Feature("Speed", false, new IntAdd("SPEED", 25)), //
			new Feature("Darkvision"), //
			new Feature("Dwarven Resilience"), //
			new Feature("Dwarven Combat Training", new ProficiencyAdd(new Proficiencies(null, w -> w == Weapon.BATTLEAXE || w == Weapon.HANDAXE || w == Weapon.LIGHT_HAMMER || w == Weapon.WARHAMMER, null))), //
			new Feature("Tool Proficiency", false, new ChoiceProficiencyAdd(new Proficiencies(null, null, t -> t == Tool.SMITHS_TOOLS || t == Tool.BREWERS_SUPPLIES || t == Tool.MASONS_TOOLS))), //
			new Feature("Stonecunning"), //
			new Feature("Languages")//
	);

	public final String name;
	public final Race[] subraces;
	public final Feature[] features;

	public Race(final String name, final Feature... features) {
		this(name, new Race[0], features);
	}

	public Race(final String name, final Race[] subraces, final Feature... features) {
		this.name = name;
		this.subraces = subraces;
		this.features = features;
	}

}
