package charactersheet.values;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Skill {

	ACROBATICS(Ability.DEXTERITY),
	ANIMAL_HANDLING(Ability.WISDOM),
	ARCANA(Ability.INTELLIGENCE),
	ATHLETICS(Ability.STRENGTH),
	DECEPTION(Ability.CHARISMA),
	HISTORY(Ability.INTELLIGENCE),
	INSIGHT(Ability.WISDOM),
	INTIMIDATION(Ability.CHARISMA),
	INVESTIGATION(Ability.INTELLIGENCE),
	MEDICINE(Ability.WISDOM),
	NATURE(Ability.INTELLIGENCE),
	PERCEPTION(Ability.WISDOM),
	PERFORMANCE(Ability.CHARISMA),
	PERSUASION(Ability.CHARISMA),
	RELIGION(Ability.INTELLIGENCE),
	SLEIGHT_OF_HAND(Ability.DEXTERITY),
	STEALTH(Ability.DEXTERITY),
	SURVIVAL(Ability.WISDOM);

	public final Ability ability;

	private Skill(final Ability ability) {
		this.ability = ability;
	}

	@Override
	public String toString() {
		return Arrays.stream(name().split("_")).map(s -> s.charAt(0) + s.substring(1).toLowerCase()).collect(Collectors.joining(" "));
	}

}
