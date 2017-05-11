package charactersheet.values;

import charactersheet.values.item.ArmorType;
import charactersheet.values.item.Weapon;

public class CharacterClass {

	public static final CharacterClass BARBARIAN = new CharacterClass(new Dice(12, 1), Ability.STRENGTH, Ability.CONSTITUTION, new Proficiencies(a -> a.type != ArmorType.HEAVY, w -> true, null));
	public static final CharacterClass BARD = new CharacterClass(new Dice(8, 1), Ability.DEXTERITY, Ability.CHARISMA, new Proficiencies(a -> a.type == ArmorType.LIGHT, w -> !w.martial || w == Weapon.HAND_CROSSBOW || w == Weapon.LONGSWORD || w == Weapon.RAPIER || w == Weapon.SHORTSWORD, null));
	public static final CharacterClass CLERIC = new CharacterClass(new Dice(8, 1), Ability.WISDOM, Ability.CHARISMA, new Proficiencies(a -> a.type != ArmorType.HEAVY, w -> !w.martial, null));
	public static final CharacterClass DRUID = new CharacterClass(new Dice(8, 1), Ability.INTELLIGENCE, Ability.WISDOM, new Proficiencies(a -> a.type != ArmorType.HEAVY && !a.isMetal, w -> w == Weapon.CLUB || w == Weapon.DAGGER || w == Weapon.DART || w == Weapon.JAVELIN || w == Weapon.MACE || w == Weapon.QUARTERSTAFF || w == Weapon.SCIMITAR || w == Weapon.SICKLE || w == Weapon.SLING || w == Weapon.SPEAR, null));
	public static final CharacterClass FIGHTER = new CharacterClass(new Dice(10, 1), Ability.STRENGTH, Ability.CONSTITUTION, new Proficiencies(a -> true, w -> true, null));
	public static final CharacterClass MONK = new CharacterClass(new Dice(8, 1), Ability.STRENGTH, Ability.DEXTERITY, new Proficiencies(null, w -> !w.martial || w == Weapon.SHORTSWORD, null));
	public static final CharacterClass PALADIN = new CharacterClass(new Dice(10, 1), Ability.WISDOM, Ability.CHARISMA, new Proficiencies(a -> true, w -> true, null));
	public static final CharacterClass RANGER = new CharacterClass(new Dice(10, 1), Ability.STRENGTH, Ability.DEXTERITY, new Proficiencies(a -> a.type != ArmorType.HEAVY, w -> true, null));
	public static final CharacterClass ROGUE = new CharacterClass(new Dice(8, 1), Ability.DEXTERITY, Ability.INTELLIGENCE, new Proficiencies(a -> a.type == ArmorType.LIGHT, w -> !w.martial || w == Weapon.HAND_CROSSBOW || w == Weapon.LONGSWORD || w == Weapon.RAPIER || w == Weapon.SHORTSWORD, null));
	public static final CharacterClass SORCERER = new CharacterClass(new Dice(6, 1), Ability.CONSTITUTION, Ability.CHARISMA, new Proficiencies(null, w -> w == Weapon.DAGGER || w == Weapon.DART || w == Weapon.SLING || w == Weapon.QUARTERSTAFF || w == Weapon.LIGHT_CROSSBOW, null));
	public static final CharacterClass WARLOCK = new CharacterClass(new Dice(8, 1), Ability.WISDOM, Ability.CHARISMA, new Proficiencies(a -> a.type == ArmorType.LIGHT, w -> !w.martial, null));
	public static final CharacterClass WIZARD = new CharacterClass(new Dice(6, 1), Ability.INTELLIGENCE, Ability.WISDOM, new Proficiencies(null, w -> w == Weapon.DAGGER || w == Weapon.DART || w == Weapon.SLING || w == Weapon.QUARTERSTAFF || w == Weapon.LIGHT_CROSSBOW, null));

	public final Dice hitDice;
	public final Ability savingThrow1, savingThrow2;
	public final Proficiencies proficiencies;

	public CharacterClass(final Dice hitDice, final Ability savingThrow1, final Ability savingThrow2, final Proficiencies proficiencies) {
		this.hitDice = hitDice;
		this.savingThrow1 = savingThrow1;
		this.savingThrow2 = savingThrow2;
		this.proficiencies = proficiencies;
	}

}
