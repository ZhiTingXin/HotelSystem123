package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javafx.util.StringConverter;

public class DateUtil {
	// ���ڸ�ʽ
	private static final String DATE_PATTERN = "yyyy-MM-dd";

	// ����+ʱ�� ��ʽ
	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

	// ����
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	// ����+ʱ��
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

	 public static LocalDateTime parse_2(String dateTimeString) {
	 try {
	 return DATETIME_FORMATTER.parse(dateTimeString, LocalDateTime::from);
	 } catch (DateTimeParseException e) {
	 return null;
	 }
	 }

	// ת�� DatePicker converter
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

	// �ж������Ƿ���ϸ�ʽ
	public static boolean validDate(String dateString) {
		return DateUtil.parse_1(dateString) != null;
	}
}
