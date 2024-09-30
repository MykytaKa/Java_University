import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RomanNumber{
    public static final String[] NUMBERS = {
            "I", "V", "X", "L", "C", "D", "M"
    };

    public static boolean isValid(String romanNumber) {
        String[] romanNumeralArray = romanNumber.trim().split("");
        HashMap<String, Integer> numberRepetition = new HashMap<>(Map.of(
                "I", 0,
                "V", 0,
                "X", 0,
                "L", 0,
                "C", 0,
                "D", 0,
                "M", 0
        ));
        HashMap<String, Integer> numberRepetitionLimit = new HashMap<>(Map.of(
                "I", 3,
                "V", 1,
                "X", 3,
                "L", 1,
                "C", 3,
                "D", 1,
                "M", 3
        ));

        List<String> NUMBERS_LIST = Arrays.asList(NUMBERS);

        for (int i = 0; i < romanNumeralArray.length; i++) {
            // Перевірка, чи є символ римським числом
            if (!NUMBERS_LIST.contains(romanNumeralArray[i])) {
                return false;
            }

            // Лічильник повторень
            numberRepetition.put(romanNumeralArray[i], numberRepetition.get(romanNumeralArray[i]) + 1);

            // Обмеження повторень
            if (numberRepetition.get(romanNumeralArray[i]) > numberRepetitionLimit.get(romanNumeralArray[i])) {
                return false;
            }

            // Перевірка правила віднімання
            if (i < romanNumeralArray.length - 1) {
                int currentIndex = NUMBERS_LIST.indexOf(romanNumeralArray[i]);
                int nextIndex = NUMBERS_LIST.indexOf(romanNumeralArray[i + 1]);

                if (currentIndex < nextIndex) {
                    // Якщо символ стоїть перед більшим, перевірка на допустимі пари
                    if (!isPairException(romanNumeralArray[i], romanNumeralArray[i + 1])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isPairException(String number1, String number2) {
        if (number1.equals("I") && (number2.equals("V") || number2.equals("X"))) {
            return true;
        }
        if (number1.equals("X") && (number2.equals("L") || number2.equals("C"))) {
            return true;
        }
        if (number1.equals("C") && (number2.equals("D") || number2.equals("M"))) {
            return true;
        }
        return false;
    }
}
