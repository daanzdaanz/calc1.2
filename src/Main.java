import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
            "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
            "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) {
        System.out.println("Введите выражение без пробелов двух арабских чисел до 10 или двух римских чисел от I до X,");
        Scanner scanner = new Scanner(System.in);
        String userStringInput = scanner.nextLine();
        System.out.println(calc(userStringInput));

    }
    public static String calc(String input) {
        String result = "";
        String[] blacks = input.split("[+-/*]");
        String numberOneString = "";
        String numberTwoString = "";
        char[] userCharInput = input.toCharArray();
        char operatorChar='0';

        if (blacks.length == 2) {
            numberOneString = blacks[0];
            numberTwoString = blacks[1];
        } else throw new IllegalArgumentException("Не верный знак операции");
        boolean numberRoman1 = romanBool(numberOneString);
        boolean numberRoman2 = romanBool(numberTwoString);
        int number1=0;
        int number2=0;
        for (char c : userCharInput) {
            switch (c) {
                case '*':
                    operatorChar = c;
                    break;
                case '+':
                    operatorChar = c;
                    break;
                case '-':
                    operatorChar = c;
                    break;
                case '/':
                    operatorChar = c;
                    break;
            }
        }

            if (numberRoman1 && numberRoman2) {
                number1 = romanToTnt(numberOneString);
                number2 = romanToTnt(numberTwoString);

            }
            if (numberRoman1 && numberRoman2 && (operatorChar == '-')) {
                if (number1 < number2) {
                    throw new IllegalArgumentException("Выражение в римских цифрах не может быть отрицательным");
                }
            }
            if ((numberRoman1 && !numberRoman2) || (!numberRoman1 && numberRoman2)) {
                throw new IllegalArgumentException("Вы ввели не допустимое выражение");
            }  if (numberRoman1 && numberRoman2){
                result = (roman[calculate(number1, number2, operatorChar)]);
            } else if (!numberRoman1 && !numberRoman2) {
            number1 = Integer.parseInt(numberOneString);
            number2 = Integer.parseInt(numberTwoString);

                if (!(1<=number1 && number1<=10 && 1<=number2 && number2<=10))
                    throw new IllegalArgumentException("вы ввели число больше или меньше допустимого");

                int sum = calculate(number1, number2, operatorChar);
                result = String.valueOf(sum);
            }
        return result;
    }


        public static int romanToTnt (String input){
            int result1 = 0;


            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(input)) {
                    result1 = i;

                }
            }
            if (result1 > 10) {
                throw new IllegalArgumentException("Число больше 10 или меньше 1");
            }

            return result1;
        }
        public static boolean romanBool (String input){
            boolean result = false;

            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(input)) {
                    result = true;
                }
            }
            return result;
        }

        public static int calculate (int input, int input2, char operator) {
        int result = -111111;
        switch (operator) {
            case('-'):
                result = input - input2;
                break;
            case('+'):
                result = input + input2;
                break;
            case('*'):
                result = input * input2;
                break;
            case('/'):
                result = input / input2;
                break;
        }
            return result;
        }
    }









