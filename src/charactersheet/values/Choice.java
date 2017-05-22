package charactersheet.values;

public interface Choice<T> {

	public T[] getOptions();

	public default int getNumSelections() {
		return 1;
	}

}
