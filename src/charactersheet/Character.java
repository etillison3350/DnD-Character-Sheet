package charactersheet;

import charactersheet.values.Alignment;
import charactersheet.values.Background;
import charactersheet.values.CharacterClass;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Character {

	private StringProperty name;
	private ObjectProperty<CharacterClass> baseClass;
	private IntegerProperty level;
	private MapProperty<CharacterClass, Integer> multiclassLevels;
	private ObjectProperty<Background> background;
	private ObjectProperty<Alignment> alignment;
	private StringProperty playerName;
	private IntegerProperty experiencePoints;
	private IntegerProperty[] abilityScores;
	private IntegerProperty[] abilityModifiers;

}
