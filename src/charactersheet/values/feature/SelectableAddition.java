package charactersheet.values.feature;

public interface SelectableAddition<B extends Addition> {

	public Object[] getOptions();

	public B createWithOption(int index);

}
