package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.util.StringConverter;

public class DateUtil {
	// 日期格式
	private static final String DATE_PATTERN = "yyyy-MM-dd";

	// 日期+时间 格式
	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

	// 日期
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	// 日期+时间
	private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

	// LocalDate to string
	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}

	public static String format(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		return DATETIME_FORMATTER.format(dateTime);
	}

	// string to LocalDate
	public static LocalDate parse_1(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	// public static LocalDateTime parse_2(String dateTimeString) {
	// try {
	// return DATETIME_FORMATTER.parse(dateTimeString, LocalDateTime::from);
	// } catch (DateTimeParseException e) {
	// return null;
	// }
	// }

	// 转换 DatePicker converter
	public static StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {

		@Override
		public String toString(LocalDate date) {
			if (date != null) {
				return DATE_FORMATTER.format(date);
			} else {
				return "";
			}
		}

		@Override
		public LocalDate fromString(String string) {
			if (string != null && !string.isEmpty()) {
				return LocalDate.parse(string, DATE_FORMATTER);
			} else {
				return null;
			}
		}
	};

	// 判断输入是否符合格式
	public static boolean validDate(String dateString) {
		return DateUtil.parse_1(dateString) != null;
	}
}
