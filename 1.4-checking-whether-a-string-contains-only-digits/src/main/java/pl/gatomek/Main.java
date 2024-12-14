package pl.gatomek;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Checking whether a string contains only digits");

        test( "52549358");
        test( "525g49358");
        test( "");
    }

    private static void test( String str) {
        System.out.println(String.valueOf(checkString(str)) + ": " + str);
        System.out.println(String.valueOf(checkString2(str)) + ": " + str);
        System.out.println(String.valueOf(checkStringByAnyMatch(str)) + ": " + str);
        System.out.println(String.valueOf(checkStringByAllMatch(str)) + ": " + str);
    }

    private static boolean checkString(String str) {
        boolean vld = false;
        for( char c : str.toCharArray()) {
            vld = true;
            if( ! Character.isDigit( c))
                return false;
        }

        return vld;
    }

    // Apache Commons Lang
    private static boolean checkString2(String str) {
        return StringUtils.isNumeric( str);
    }

    private static boolean checkStringByAnyMatch(String str) {
        return ! str.chars().anyMatch( n -> ! Character.isDigit( n));
    }

    private static boolean checkStringByAllMatch(String str) {
        return str.chars().allMatch( Character::isDigit);
    }
}