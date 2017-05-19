package charactersheet;

import java.util.function.Function;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;

public final class Util {

	private Util() {}

	public static final int[] XP_PER_LEVEL = {0, 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000, 140000, 165000, 195000, 225000, 265000, 305000, 355000};

	public static GridPane makeRow(final Region... components) {
		return makeRow(true, components);
	}

	public static GridPane makeRow(final boolean expand, final Region... components) {
		if (expand) for (final Region r : components)
			r.setMaxWidth(Double.POSITIVE_INFINITY);

		final GridPane ret = new GridPane();
		ret.addRow(0, components);

		ret.getColumnConstraints().add(percentConstraints(50));
		for (int i = 1; i < components.length; i++) {
			ret.getColumnConstraints().add(percentConstraints(50.0 / (components.length - 1)));
		}

		return ret;
	}

	public static ColumnConstraints percentConstraints(final double percent) {
		final ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(percent);
		return cc;
	}

	public static Spinner<Integer> spinnerWithSuffix(final String suffix, final int min, final int max, final int initial, final int stepSize) {
		final Spinner<Integer> ret = new Spinner<>(min, max, initial, stepSize);

		ret.getValueFactory().setConverter(converterWithDefault(0, i -> String.format("%d%s", i, suffix), s -> Integer.parseInt(s.replaceFirst(String.format("%s%s", Pattern.quote(suffix), "$"), ""))));
		configureEditable(ret);
		return ret;
	}

	public static <T> StringConverter<T> converterWithDefault(final T defaultValue, final Function<T, String> toString, final Function<String, T> fromString) {
		return new StringConverter<T>() {

			@Override
			public String toString(final T object) {
				return toString.apply(object);
			}

			@Override
			public T fromString(final String string) {
				try {
					return fromString.apply(string);
				} catch (final Exception e) {
					return defaultValue;
				}
			}

		};
	}

	public static <T> void configureEditable(final Spinner<T> spinner) {
		spinner.setEditable(true);
		spinner.focusedProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
			if (!newValue) {
				final String text = spinner.getEditor().getText();
				final SpinnerValueFactory<T> valueFactory = spinner.getValueFactory();
				if (valueFactory != null) {
					final StringConverter<T> converter = valueFactory.getConverter();
					if (converter != null) {
						valueFactory.setValue(converter.fromString(text));
					}
				}
			}
		});
	}

	public static void configureNumerical(final TextInputControl textField) {
		textField.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) textField.setText(newValue.replaceAll("\\D+", ""));
		});
	}

}
