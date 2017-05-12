package charactersheet.values;

public class IntAdd implements Addition {

	public final Object property;
	public final int change;

	public IntAdd(final Object property, final int change) {
		this.property = property;
		this.change = change;
	}

	@Override
	public Object getProperty() {
		return property;
	}

	@Override
	public Integer getChange() {
		return change;
	}

	public static class ChoiceIntAdd extends IntAdd implements SelectableAddition<IntAdd> {

		public ChoiceIntAdd(final int change, final Object... selections) {
			super(selections, change);
		}

		@Override
		public Object[] getOptions() {
			return (Object[]) property;
		}

		@Override
		public IntAdd createWithOption(final int index) {
			return new IntAdd(((Object[]) property)[index], change);
		}

	}

}
