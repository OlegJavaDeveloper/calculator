import java.util.Scanner;

public class Calculator {
    public static void main(String [] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }
    public static String calc(String input) throws Exception {

        int num1;
        int num2;
        String operator;
        String result;
        boolean isRoman;
        String [] operands = input.split("\\s");
        if(operands.length == 5) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        operator = operation(input);
        if (operands.length == 1) throw new Exception("строка не являеться математической операцией");
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[2])){
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[2]);
            isRoman = true;
        }
        else if(!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[2])){
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[2]);
            isRoman = false;

        }
        else {
            throw new Exception("используються одновременно разные системы счисления");
        }
        if(num1 > 10 || num2 > 10){
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(num1,num2,operator);
        if(isRoman){
            if(arabian < 0){
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
            return result;

    }

    static String operation(String operands){
        if(operands.contains("+")){
            return "+";
        }else if(operands.contains("-")){
            return "-";
        }else if(operands.contains("*")){
            return "*";
        }else if(operands.contains("/")){
            return "/";
        }else{
            return null;
        }
    }

    static int calc(int a,int b, String operator){
        if(operator.equals("+")) return a+b;
        else if(operator.equals("-")) return  a-b;
        else if(operator.equals("*")) return  a*b;
        else return a/b;
    }

}

class Roman {
    static String[] romanNumbers = new String[]{"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (val.equals(romanNumbers[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (roman.equals(romanNumbers[i])) {
                return i;
            }
        }
        return -1;

    }

    public static String convertToRoman(int arabian){return romanNumbers[arabian];}


}

