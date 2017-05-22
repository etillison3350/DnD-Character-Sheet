package charactersheet.values;

import java.util.HashSet;
import java.util.Set;

import charactersheet.values.item.Armor;
import charactersheet.values.item.ArmorType;
import charactersheet.values.item.Weapon;

public class CharacterClass {

	public static final CharacterClass BARBARIAN = new CharacterClass(new Dice(12, 1), Ability.STRENGTH, Ability.CONSTITUTION, Armor.valuesMatching(a -> a.type != ArmorType.HEAVY), Weapon.values());
	public static final CharacterClass BARD = new CharacterClass(new Dice(8, 1), Ability.DEXTERITY, Ability.CHARISMA, Armor.LIGHT, Weapon.SIMPLE, new Weapon[] {Weapon.HAND_CROSSBOW, Weapon.LONGSWORD, Weapon.RAPIER, Weapon.SHORTSWORD});
	public static final CharacterClass CLERIC = new CharacterClass(new Dice(8, 1), Ability.WISDOM, Ability.CHARISMA, Armor.valuesMatching(a -> a.type != ArmorType.HEAVY), Weapon.SIMPLE);
	public static final CharacterClass DRUID = new CharacterClass(new Dice(8, 1), Ability.INTELLIGENCE, Ability.WISDOM, Armor.valuesMatching(a -> a.type != ArmorType.HEAVY && !a.isMetal), new Weapon[] {Weapon.CLUB, Weapon.DAGGER, Weapon.DART, Weapon.JAVELIN, Weapon.MACE, Weapon.QUARTERSTAFF, Weapon.SCIMITAR, Weapon.SICKLE, Weapon.SLING, Weapon.SPEAR});
	public static final CharacterClass FIGHTER = new CharacterClass(new Dice(10, 1), Ability.STRENGTH, Ability.CONSTITUTION, Armor.values(), Weapon.values());
	public static final CharacterClass MONK = new CharacterClass(new Dice(8, 1), Ability.STRENGTH, Ability.DEXTERITY, Weapon.SIMPLE, new Weapon[] {Weapon.SHORTSWORD});
	public static final CharacterClass PALADIN = new CharacterClass(new Dice(10, 1), Ability.WISDOM, Ability.CHARISMA, Armor.values(), Weapon.values());
	public static final CharacterClass RANGER = new CharacterClass(new Dice(10, 1), Ability.STRENGTH, Ability.DEXTERITY, Armor.valuesMatching(a -> a.type != ArmorType.HEAVY), Weapon.values());
	public static final CharacterClass ROGUE = new CharacterClass(new Dice(8, 1), Ability.DEXTERITY, Ability.INTELLIGENCE, Armor.LIGHT, Weapon.SIMPLE, new Weapon[] {Weapon.HAND_CROSSBOW, Weapon.LONGSWORD, Weapon.RAPIER, Weapon.SHORTSWORD});
	public static final CharacterClass SORCERER = new CharacterClass(new Dice(6, 1), Ability.CONSTITUTION, Ability.CHARISMA, Weapon.DAGGER, Weapon.DART, Weapon.SLING, Weapon.QUARTERSTAFF, Weapon.LIGHT_CROSSBOW);
	public static final CharacterClass WARLOCK = new CharacterClass(new Dice(8, 1), Ability.WISDOM, Ability.CHARISMA, Armor.LIGHT, Weapon.SIMPLE);
	public static final CharacterClass WIZARD = new CharacterClass(new Dice(6, 1), Ability.INTELLIGENCE, Ability.WISDOM, Weapon.DAGGER, Weapon.DART, Weapon.SLING, Weapon.QUARTERSTAFF, Weapon.LIGHT_CROSSBOW);

	public final Dice hitDice;
	public final Ability savingThrow1, savingThrow2;
	public final Set<Proficientable> proficiencies;

	public CharacterClass(final Dice hitDice, final Ability savingThrow1, final Ability savingThrow2, final Proficientable... proficiencies) {
		this.hitDice = hitDice;
		this.savingThrow1 = savingThrow1;
		this.savingThrow2 = savingThrow2;
		this.proficiencies = new HashSet<>(proficiencies.length);
		for (final Proficientable p : proficiencies)
			this.proficiencies.add(p);
	}

	public CharacterClass(final Dice hitDice, final Ability savingThrow1, final Ability savingThrow2, final Proficientable[]... proficiencies) {
		this.hitDice = hitDice;
		this.savingThrow1 = savingThrow1;
		this.savingThrow2 = savingThrow2;
		this.proficiencies = new HashSet<>();
		for (final Proficientable[] pro : proficiencies)
			for (final Proficientable p : pro)
				this.proficiencies.add(p);
	}

}
