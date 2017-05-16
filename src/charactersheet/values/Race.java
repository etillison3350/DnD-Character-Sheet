package charactersheet.values;

import charactersheet.values.feature.Feature;
import charactersheet.values.feature.IntAdd;
import charactersheet.values.feature.LanguageAdd;
import charactersheet.values.feature.ProficiencyAdd;
import charactersheet.values.feature.ProficiencyAdd.ChoiceProficiencyAdd;
import charactersheet.values.feature.SkillAdd;
import charactersheet.values.item.ArmorType;
import charactersheet.values.item.Tool;
import charactersheet.values.item.Weapon;

public class Race {

	public static final Race DWARF = new Race("Dwarf", //
			new Race[] { //
					new Race("Hill Dwarf", //
							new Feature("Ability Score Increase", false, new IntAdd(Ability.WISDOM, 1)), //
							new Feature("Dwarven Toughness", false, new IntAdd("HP/LVL", 1))), //
					new Race("Mountain Dwarf", //
							new Feature("Ability Score Increase", false, new IntAdd(Ability.STRENGTH, 2)), //
							new Feature("Dwarven Armor Training", false, new ProficiencyAdd(new Proficiencies(a -> a.type == ArmorType.LIGHT || a.type == ArmorType.MEDIUM, null, null)))//
					) //
			}, //
			new Feature("Ability Score Increase", false, new IntAdd(Ability.CONSTITUTION, 2)), //
			new Feature("Age", false), //
			new Feature("Size", false), //
			new Feature("Speed", false, new IntAdd("SPEED", 25)), //
			new Feature("Darkvision"), //
			new Feature("Dwarven Resilience"), //
			new Feature("Dwarven Combat Training", new ProficiencyAdd(new Proficiencies(null, w -> w == Weapon.BATTLEAXE || w == Weapon.HANDAXE || w == Weapon.LIGHT_HAMMER || w == Weapon.WARHAMMER, null))), //
			new Feature("Tool Proficiency", false, new ChoiceProficiencyAdd(new Proficiencies(null, null, t -> t == Tool.SMITHS_TOOLS || t == Tool.BREWERS_SUPPLIES || t == Tool.MASONS_TOOLS))), //
			new Feature("Stonecunning"), //
			new Feature("Languages", false, new LanguageAdd(Language.COMMON), new LanguageAdd(Language.DWARVISH))//
	);
	public static final Race ELF = new Race("Elf", //
			new Race[] { //
					new Race("High Elf", //
							new Feature("Ability Score Increase", false, new IntAdd(Ability.INTELLIGENCE, 1)), //
							new Feature("Elf Weapon Training", false, new ProficiencyAdd(new Proficiencies(null, w -> w == Weapon.LONGSWORD || w == Weapon.SHORTSWORD || w == Weapon.SHORTBOW || w == Weapon.LONGBOW, null))) //
					), //
					new Race("Wood Elf"), //
					new Race("Dark Elf (Drow)") //
			}, //
			new Feature("Ability Score Increase", false, new IntAdd(Ability.DEXTERITY, 2)), //
			new Feature("Age", false), //
			new Feature("Size", false), //
			new Feature("Speed", false, new IntAdd("SPEED", 30)), //
			new Feature("Darkvision"), //
			new Feature("Keen Senses", new SkillAdd(Skill.PERCEPTION)), //
			new Feature("Fey Ancestry"), //
			new Feature("Trance"), //
			new Feature("Languages", false, new LanguageAdd(Language.COMMON), new LanguageAdd(Language.ELVISH)) //
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
