package charactersheet.values;

public class ProficiencyAdd implements Addition {

	public final Proficiencies additionalProficiencies;

	public ProficiencyAdd(final Proficiencies additionalProficiencies) {
		this.additionalProficiencies = additionalProficiencies;
	}

	@Override
	public Object getProperty() {
		return "Proficiencies";
	}

	@Override
	public Proficiencies getChange() {
		return additionalProficiencies;
	}

	public static class ChoiceProficiencyAdd implements Addition, SelectableAddition<ProficiencyAdd> {

		public final Proficiencies[] options;

		public ChoiceProficiencyAdd(final Proficiencies... options) {
			this.options = options;
		}

		@Override
		public Proficiencies[] getOptions() {
			return options;
		}

		@Override
		public ProficiencyAdd createWithOption(final int index) {
			return new ProficiencyAdd(options[index]);
		}

		@Override
		public Object getProperty() {
			return "Proficiencies";
		}

		@Override
		public Object getChange() {
			return null;
		}

	}

}
