package charactersheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import charactersheet.values.Ability;
import charactersheet.values.Alignment;
import charactersheet.values.Cost.Coin;
import charactersheet.values.Skill;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class CharacterSheet {

	private final StringProperty name = new SimpleStringProperty();
	private final StringProperty classAndLevel = new SimpleStringProperty();
	private final StringProperty background = new SimpleStringProperty();
	private final ObjectProperty<Alignment> alignment = new SimpleObjectProperty<>(Alignment.NEUTRAL);
	private final StringProperty playerName = new SimpleStringProperty();
	private final IntegerProperty experiencePoints = new SimpleIntegerProperty(0);
	private final Map<Ability, IntegerProperty> abilityScores = new TreeMap<>();
	private final Map<Ability, IntegerProperty> abilityModifiers = new TreeMap<>();
	private final BooleanProperty inspiration = new SimpleBooleanProperty(false);
	private final IntegerProperty proficiencyBonus = new SimpleIntegerProperty(2);
	private final Map<Ability, BooleanProperty> savingThrowProficiencies = new TreeMap<>();
	private final Map<Ability, IntegerProperty> savingThrowModifiers = new TreeMap<>();
	private final Map<Skill, BooleanProperty> skillProficiencies = new TreeMap<>();
	private final Map<Skill, IntegerProperty> skillModifiers = new TreeMap<>();
	private final IntegerProperty passivePerception = new SimpleIntegerProperty(10);
	private final StringProperty otherProficienciesAndLanguages = new SimpleStringProperty();
	private final IntegerProperty armorClass = new SimpleIntegerProperty(10);
	private final IntegerProperty initiative = new SimpleIntegerProperty(0);
	private final IntegerProperty speed = new SimpleIntegerProperty(30);
	private final IntegerProperty HPMax = new SimpleIntegerProperty(10);
	private final IntegerProperty currentHP = new SimpleIntegerProperty(10);
	private final IntegerProperty tempHP = new SimpleIntegerProperty(0);
	private final StringProperty hitDiceTotal = new SimpleStringProperty("1d10");
	private final StringProperty hitDice = new SimpleStringProperty("1d10");
	private final BooleanProperty[] deathSaveSuccesses = new BooleanProperty[3];
	private final BooleanProperty[] deathSaveFailures = new BooleanProperty[3];
	private final ReadOnlyListWrapper<StringProperty> weapons = new ReadOnlyListWrapper<>();
	private final ReadOnlyListWrapper<IntegerProperty> attackBonuses = new ReadOnlyListWrapper<>();
	private final ReadOnlyListWrapper<StringProperty> damagesAndTypes = new ReadOnlyListWrapper<>();
	private final StringProperty spellcasting = new SimpleStringProperty();
	private final Map<Coin, IntegerProperty> wealth = new TreeMap<>();
	private final StringProperty equipment = new SimpleStringProperty();
	private final StringProperty personalityTraits = new SimpleStringProperty();
	private final StringProperty ideals = new SimpleStringProperty();
	private final StringProperty bonds = new SimpleStringProperty();
	private final StringProperty flaws = new SimpleStringProperty();
	private final StringProperty featuresAndTraits = new SimpleStringProperty();
	private final StringProperty age = new SimpleStringProperty();
	private final StringProperty height = new SimpleStringProperty();
	private final StringProperty weight = new SimpleStringProperty();
	private final StringProperty eyes = new SimpleStringProperty();
	private final StringProperty skin = new SimpleStringProperty();
	private final StringProperty hair = new SimpleStringProperty();
	private final StringProperty imagePath = new SimpleStringProperty();
	private final StringProperty alliesAndOrganizations = new SimpleStringProperty();
	private final StringProperty organizationName = new SimpleStringProperty();
	private final StringProperty organizationSymbolPath = new SimpleStringProperty();
	private final StringProperty characterBackstory = new SimpleStringProperty();
	private final StringProperty additionalFeaturesAndTraits = new SimpleStringProperty();
	private final StringProperty treasure = new SimpleStringProperty();
	private final StringProperty spellcastingClass = new SimpleStringProperty();
	private final ObjectProperty<Ability> spellcastingAbility = new SimpleObjectProperty<>();
	private final StringProperty spellSaveDC = new SimpleStringProperty();
	private final StringProperty spellAttackBonus = new SimpleStringProperty();
	private final List<MapProperty<String, Boolean>> spells = new ArrayList<>(10);
	private final IntegerProperty[] spellSlots = new IntegerProperty[9];
	private final IntegerProperty[] expendedSlots = new IntegerProperty[9];

	public CharacterSheet() {
		for (final Ability ability : Ability.values()) {
			abilityScores.put(ability, new SimpleIntegerProperty(10));
			abilityModifiers.put(ability, new SimpleIntegerProperty(0));
			savingThrowProficiencies.put(ability, new SimpleBooleanProperty(false));
			savingThrowModifiers.put(ability, new SimpleIntegerProperty(0));
		}

		for (final Skill skill : Skill.values()) {
			skillProficiencies.put(skill, new SimpleBooleanProperty(false));
			skillModifiers.put(skill, new SimpleIntegerProperty(0));
		}

		for (int n = 0; n < 3; n++) {
			deathSaveSuccesses[n] = new SimpleBooleanProperty(false);
			deathSaveFailures[n] = new SimpleBooleanProperty(false);
		}

		for (final Coin coin : Coin.values()) {
			wealth.put(coin, new SimpleIntegerProperty(0));
		}

		for (int n = 0; n < spells.size(); n++) {
			spells.add(new SimpleMapProperty<>());
		}

		for (int n = 0; n < spellSlots.length; n++) {
			spellSlots[n] = new SimpleIntegerProperty(0);
			expendedSlots[n] = new SimpleIntegerProperty(0);
		}
	}

	public String getName() {
		return name.get();
	}

	public void setName(final String value) {
		name.set(value);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public String getClassAndLevel() {
		return classAndLevel.get();
	}

	public void setClassAndLevel(final String value) {
		classAndLevel.set(value);
	}

	public StringProperty classAndLevelProperty() {
		return classAndLevel;
	}

	public String getBackground() {
		return background.get();
	}

	public void setBackground(final String value) {
		background.set(value);
	}

	public StringProperty backgroundProperty() {
		return background;
	}

	public Alignment getAlignment() {
		return alignment.get();
	}

	public void setAlignment(final Alignment value) {
		alignment.set(value);
	}

	public ObjectProperty<Alignment> alignmentProperty() {
		return alignment;
	}

	public String getPlayerName() {
		return playerName.get();
	}

	public void setPlayerName(final String value) {
		playerName.set(value);
	}

	public StringProperty playerNameProperty() {
		return playerName;
	}

	public int getExperiencePoints() {
		return experiencePoints.get();
	}

	public void setExperiencePoints(final int value) {
		experiencePoints.set(value);
	}

	public IntegerProperty experiencePointsProperty() {
		return experiencePoints;
	}

	public int getAbilityScore(final Ability ability) {
		return abilityScores.get(ability).get();
	}

	public void setAbilityScore(final Ability ability, final int score) {
		abilityScores.get(ability).set(score);
	}

	public IntegerProperty abilityScoreProperty(final Ability ability) {
		return abilityScores.get(ability);
	}

	public int getAbilityModifier(final Ability ability) {
		return abilityModifiers.get(ability).get();
	}

	public void setAbilityModifier(final Ability ability, final int modifier) {
		abilityModifiers.get(ability).set(modifier);
	}

	public IntegerProperty abilityModifierProperty(final Ability ability) {
		return abilityModifiers.get(ability);
	}

	public boolean hasInspiration() {
		return inspiration.get();
	}

	public void setInspiration(final boolean value) {
		inspiration.set(value);
	}

	public BooleanProperty inspirationProperty() {
		return inspiration;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus.get();
	}

	public void setProficiencyBonus(final int value) {
		proficiencyBonus.set(value);
	}

	public IntegerProperty proficiencyBonusProperty() {
		return proficiencyBonus;
	}

	public boolean getSavingThrowProficiency(final Ability ability) {
		return savingThrowProficiencies.get(ability).get();
	}

	public void setSavingThrowProficiency(final Ability ability, final boolean proficient) {
		savingThrowProficiencies.get(ability).set(proficient);
	}

	public BooleanProperty savingThrowProficiencyProperty(final Ability ability) {
		return savingThrowProficiencies.get(ability);
	}

	public int getSavingThrowModifier(final Ability ability) {
		return savingThrowModifiers.get(ability).get();
	}

	public void setSavingThrowModifier(final Ability ability, final int score) {
		savingThrowModifiers.get(ability).set(score);
	}

	public IntegerProperty savingThrowModifierProperty(final Ability ability) {
		return savingThrowModifiers.get(ability);
	}

	public boolean getSkillProficiency(final Skill skill) {
		return skillProficiencies.get(skill).get();
	}

	public void setSkillProficiency(final Skill skill, final boolean proficient) {
		skillProficiencies.get(skill).set(proficient);
	}

	public BooleanProperty skillProficiencyProperty(final Ability ability) {
		return skillProficiencies.get(ability);
	}

	public int getSkillModifier(final Skill skill) {
		return skillModifiers.get(skill).get();
	}

	public void setSkillModifier(final Skill skill, final int score) {
		skillModifiers.get(skill).set(score);
	}

	public IntegerProperty skillModifierProperty(final Ability ability) {
		return skillModifiers.get(ability);
	}

	public int getPassivePerception() {
		return passivePerception.get();
	}

	public void setPassivePerception(final int value) {
		passivePerception.set(value);
	}

	public IntegerProperty passivePerceptionProperty() {
		return passivePerception;
	}

	public String getOtherProficienciesAndLanguages() {
		return otherProficienciesAndLanguages.get();
	}

	public void setOtherProficienciesAndLanguages(final String value) {
		otherProficienciesAndLanguages.set(value);
	}

	public StringProperty otherProficienciesAndLanguagesProperty() {
		return otherProficienciesAndLanguages;
	}

	public int getArmorClass() {
		return armorClass.get();
	}

	public void setArmorClass(final int value) {
		armorClass.set(value);
	}

	public IntegerProperty armorClassProperty() {
		return armorClass;
	}

	public int getInitiative() {
		return initiative.get();
	}

	public void setInitiative(final int value) {
		initiative.set(value);
	}

	public IntegerProperty initiativeProperty() {
		return initiative;
	}

	public int getSpeed() {
		return speed.get();
	}

	public void setspeed(final int value) {
		speed.set(value);
	}

	public IntegerProperty speedProperty() {
		return speed;
	}

	public int getHPMax() {
		return HPMax.get();
	}

	public void setHPMax(final int value) {
		HPMax.set(value);
	}

	public IntegerProperty HPMaxProperty() {
		return HPMax;
	}

	public int getCurrentHP() {
		return currentHP.get();
	}

	public void setCurrentHP(final int value) {
		currentHP.set(value);
	}

	public IntegerProperty currentHPProperty() {
		return currentHP;
	}

	public int getTempHP() {
		return tempHP.get();
	}

	public void setTempHP(final int value) {
		tempHP.set(value);
	}

	public IntegerProperty tempHPProperty() {
		return tempHP;
	}

	public String getHitDiceTotal() {
		return hitDiceTotal.get();
	}

	public void setHitDiceTotal(final String value) {
		hitDiceTotal.set(value);
	}

	public StringProperty hitDiceTotalProperty() {
		return hitDiceTotal;
	}

	public String getHitDice() {
		return hitDice.get();
	}

	public void setHitDice(final String value) {
		hitDice.set(value);
	}

	public StringProperty hitDiceProperty() {
		return hitDice;
	}

	public boolean isDeathSaveSuccess(final int index) {
		return deathSaveSuccesses[index].get();
	}

	public void setDeathSaveSuccess(final int index, final boolean success) {
		deathSaveSuccesses[index].set(success);
	}

	public BooleanProperty deathSaveSuccessProperty(final int index) {
		return deathSaveSuccesses[index];
	}

	public boolean isDeathSaveFailure(final int index) {
		return deathSaveFailures[index].get();
	}

	public void setDeathSaveFailure(final int index, final boolean failure) {
		deathSaveFailures[index].set(failure);
	}

	public BooleanProperty deathSaveFailureProperty(final int index) {
		return deathSaveFailures[index];
	}

	public ObservableList<StringProperty> getWeapons() {
		return weapons.get();
	}

	public ReadOnlyListProperty<StringProperty> weaponsProperty() {
		return weapons.getReadOnlyProperty();
	}

	public String getWeapon(final int index) {
		return weapons.get(index).get();
	}

	public void setWeapon(final int index, final String weapon) {
		weapons.get(index).set(weapon);
	}

	public StringProperty weaponProperty(final int index) {
		return weapons.get(index);
	}

	public ObservableList<IntegerProperty> getAttackBonuses() {
		return attackBonuses.get();
	}

	public ReadOnlyListProperty<IntegerProperty> attackBonusesProperty() {
		return attackBonuses.getReadOnlyProperty();
	}

	public int getAttackBonus(final int index) {
		return attackBonuses.get(index).get();
	}

	public void setWeapon(final int index, final int bonus) {
		attackBonuses.get(index).set(bonus);
	}

	public IntegerProperty attackBonusProperty(final int index) {
		return attackBonuses.get(index);
	}

	public ObservableList<StringProperty> getDamagesAndTypes() {
		return damagesAndTypes.get();
	}

	public ReadOnlyListProperty<StringProperty> damagesAndTypesProperty() {
		return damagesAndTypes.getReadOnlyProperty();
	}

	public String getDamageAndType(final int index) {
		return damagesAndTypes.get(index).get();
	}

	public void setDamageAndType(final int index, final String dmgType) {
		damagesAndTypes.get(index).set(dmgType);
	}

	public StringProperty damageAndTypeProperty(final int index) {
		return damagesAndTypes.get(index);
	}

	public String getSpellcasting() {
		return spellcasting.get();
	}

	public void setSpellcasting(final String value) {
		spellcasting.set(value);
	}

	public StringProperty spellcastingProperty() {
		return spellcasting;
	}

	public int getWealth(final Coin type) {
		return wealth.get(type).get();
	}

	public void setWealth(final Coin type, final int value) {
		wealth.get(type).set(value);
	}

	public IntegerProperty wealthProperty(final Coin type) {
		return wealth.get(type);
	}

	public String getEquipment() {
		return equipment.get();
	}

	public void setEquipment(final String value) {
		equipment.set(value);
	}

	public StringProperty equipmentProperty() {
		return equipment;
	}

	public String getPersonalityTraits() {
		return personalityTraits.get();
	}

	public void setPersonalityTraits(final String value) {
		personalityTraits.set(value);
	}

	public StringProperty personalityTraitsProperty() {
		return personalityTraits;
	}

	public String getIdeals() {
		return ideals.get();
	}

	public void setIdeals(final String value) {
		ideals.set(value);
	}

	public StringProperty idealsProperty() {
		return ideals;
	}

	public String getBonds() {
		return bonds.get();
	}

	public void setBonds(final String value) {
		bonds.set(value);
	}

	public StringProperty bondsProperty() {
		return bonds;
	}

	public String getFlaws() {
		return flaws.get();
	}

	public void setFlaws(final String value) {
		flaws.set(value);
	}

	public StringProperty flawsProperty() {
		return flaws;
	}

	public String getFeaturesAndTraits() {
		return featuresAndTraits.get();
	}

	public void setFeaturesAndTraits(final String value) {
		featuresAndTraits.set(value);
	}

	public StringProperty featuresAndTraitsProperty() {
		return featuresAndTraits;
	}

	public String getAge() {
		return age.get();
	}

	public void setAge(final String value) {
		age.set(value);
	}

	public StringProperty ageProperty() {
		return age;
	}

	public String getHeight() {
		return height.get();
	}

	public void setHeight(final String value) {
		height.set(value);
	}

	public StringProperty heightProperty() {
		return height;
	}

	public String getWeight() {
		return weight.get();
	}

	public void setWeight(final String value) {
		weight.set(value);
	}

	public StringProperty weightProperty() {
		return weight;
	}

	public String getEyes() {
		return eyes.get();
	}

	public void setEyes(final String value) {
		eyes.set(value);
	}

	public StringProperty eyesProperty() {
		return eyes;
	}

	public String getSkin() {
		return skin.get();
	}

	public void setSkin(final String value) {
		skin.set(value);
	}

	public StringProperty skinProperty() {
		return skin;
	}

	public String getHair() {
		return hair.get();
	}

	public void setHair(final String value) {
		hair.set(value);
	}

	public StringProperty hairProperty() {
		return hair;
	}

	public String getImagePath() {
		return imagePath.get();
	}

	public void setImagePath(final String value) {
		imagePath.set(value);
	}

	public StringProperty imagePathProperty() {
		return imagePath;
	}

	public String getAlliesAndOrganizations() {
		return alliesAndOrganizations.get();
	}

	public void setAlliesAndOrganizations(final String value) {
		alliesAndOrganizations.set(value);
	}

	public StringProperty alliesAndOrganizationsProperty() {
		return alliesAndOrganizations;
	}

	public String getOrganizationName() {
		return organizationName.get();
	}

	public void setOrganizationName(final String value) {
		organizationName.set(value);
	}

	public StringProperty organizationNameProperty() {
		return organizationName;
	}

	public String getOrganizationSymbolPath() {
		return organizationSymbolPath.get();
	}

	public void setOrganizationSymbolPath(final String value) {
		organizationSymbolPath.set(value);
	}

	public StringProperty organizationSymbolPathProperty() {
		return organizationSymbolPath;
	}

	public String getCharacterBackstory() {
		return characterBackstory.get();
	}

	public void setCharacterBackstory(final String value) {
		characterBackstory.set(value);
	}

	public StringProperty characterBackstoryProperty() {
		return characterBackstory;
	}

	public String getAdditionalFeaturesAndTraits() {
		return additionalFeaturesAndTraits.get();
	}

	public void setAdditionalFeaturesAndTraits(final String value) {
		additionalFeaturesAndTraits.set(value);
	}

	public StringProperty additionalFeaturesAndTraitsProperty() {
		return additionalFeaturesAndTraits;
	}

	public String getTreasure() {
		return treasure.get();
	}

	public void setTreasure(final String value) {
		treasure.set(value);
	}

	public StringProperty treasureProperty() {
		return treasure;
	}

	public String getSpellcastingClass() {
		return spellcastingClass.get();
	}

	public void setSpellcastingClass(final String value) {
		spellcastingClass.set(value);
	}

	public StringProperty spellcastingClassProperty() {
		return spellcastingClass;
	}

	public Ability getSpellcastingAbility() {
		return spellcastingAbility.get();
	}

	public void setSpellcastingAbility(final Ability value) {
		spellcastingAbility.set(value);
	}

	public ObjectProperty<Ability> spellcastingAbilityProperty() {
		return spellcastingAbility;
	}

	public String getSpellSaveDC() {
		return spellSaveDC.get();
	}

	public void setSpellSaveDC(final String value) {
		spellSaveDC.set(value);
	}

	public StringProperty spellSaveDCProperty() {
		return spellSaveDC;
	}

	public String getSpellAttackBonus() {
		return spellAttackBonus.get();
	}

	public void setSpellAttackBonus(final String value) {
		spellAttackBonus.set(value);
	}

	public StringProperty spellAttackBonusProperty() {
		return spellAttackBonus;
	}

	public ObservableMap<String, Boolean> getSpells(final int level) {
		return spells.get(level).get();
	}

	public MapProperty<String, Boolean> spellsProperty(final int level) {
		return spells.get(level);
	}

	public int getSpellSlots(final int level) {
		return spellSlots[level - 1].get();
	}

	public void setSpellSlots(final int level, final int numSlots) {
		spellSlots[level - 1].set(numSlots);
	}

	public IntegerProperty spellSlotsProperty(final int level) {
		return spellSlots[level - 1];
	}

	public int getExpendedSlots(final int level) {
		return expendedSlots[level - 1].get();
	}

	public void setExpendedSlots(final int level, final int numSlots) {
		expendedSlots[level - 1].set(numSlots);
	}

	public IntegerProperty expendedSlotsProperty(final int level) {
		return expendedSlots[level - 1];
	}

}
