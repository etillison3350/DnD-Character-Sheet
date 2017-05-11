package charactersheet.values;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import charactersheet.values.item.Armor;
import charactersheet.values.item.Tool;
import charactersheet.values.item.Weapon;

public class Proficiencies {

	public final Predicate<Armor> armor;
	public final Predicate<Weapon> weapon;
	public final Predicate<Tool> tool;

	public Proficiencies(final Predicate<Armor> armor, final Predicate<Weapon> weapon, final Predicate<Tool> tool) {
		this.armor = armor == null ? i -> false : armor;
		this.weapon = weapon == null ? i -> false : weapon;
		this.tool = tool == null ? i -> false : tool;
	}

	public Proficiencies(final Proficiencies... proficiencies) {
		armor = Util.combine(Arrays.stream(proficiencies).map(p -> p.armor).collect(Collectors.toList()));
		weapon = Util.combine(Arrays.stream(proficiencies).map(p -> p.weapon).collect(Collectors.toList()));
		tool = Util.combine(Arrays.stream(proficiencies).map(p -> p.tool).collect(Collectors.toList()));
	}

	public static final class Util {
		public static <T> Predicate<T> combine(final Collection<Predicate<T>> proficiencies) {
			return proficiencies.stream().reduce(i -> false, Predicate::or);
		}
	}

}
