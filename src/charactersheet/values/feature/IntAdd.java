package charactersheet.values.feature;

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

}
