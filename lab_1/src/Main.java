
public class Main {
    public static void main(String[] args) {
        Object[][] romanNumbers = {
                {"I", true},
                {"II", true},
                {"III", true},
                {"IV", true},
                {"V", true},
                {"VI", true},
                {"VII", true},
                {"VIII", true},
                {"IX", true},
                {"X", true},
                {"XX", true},
                {"XL", true},
                {"XC", true},
                {"C", true},
                {"CC", true},
                {"CCC", true},
                {"CD", true},
                {"D", true},
                {"M", true},
                {"MM", true},
                {"MMM", true},
                {"MMXXIV", true},
                {"IIII", false},
                {"VV", false},
                {"XXXX", false},
                {"LL", false},
                {"DD", false},
                {"IL", false},
                {"IC", false},
                {"XM", false},
                {"LXL", false},
                {"LXLIX", false},
                {"CIC", false},
                {"LXLIX", false},
                {"XCIX", true},
                {"CDXLIV", true},
                {"DCCC", true},
                {"MCMXC", true},
                {"CMXCIX", true}
        };

        for (Object[] roman : romanNumbers) {
            String romanNumeral = (String) roman[0];
            boolean isValid = (boolean) roman[1];
            System.out.printf("Roman numeral: \"%s\" Expected: %b, Actual: %b%n",
                    romanNumeral, isValid, RomanNumber.isValid(romanNumeral));
        }
    }
}