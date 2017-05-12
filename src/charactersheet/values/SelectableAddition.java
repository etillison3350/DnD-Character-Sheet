package charactersheet.values;

public interface SelectableAddition<B extends Addition> {

	public Object[] getOptions();

	public B createWithOption(int index);

}
