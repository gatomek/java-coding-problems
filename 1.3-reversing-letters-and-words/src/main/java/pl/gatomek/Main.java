package pl.gatomek;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reversing letters and words");

        // input: ascii letters, without punctuation marks
        String str = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";

        System.out.println( str);
        System.out.println( reverseString( str));
        System.out.println( reverseString2( str));
        System.out.println( reverseStringByStringUtilsReverse( str));
    }

    private static final String WHITESPACE = " ";

    private static String reverseString(String str) {

        String[] splits = str.split(WHITESPACE);
        StringBuilder out = new StringBuilder();

        for( String s : splits) {
            int len = s.length();
            StringBuilder sb = new StringBuilder( len);
            for( int i = len-1; i >=0 ; --i) {
                sb.append( s.charAt( i));
            }
            out.append( sb.toString()).append(WHITESPACE);
        }

        return out.toString();
    }

    private static String reverseString2(String str) {
        String[] splits = str.split(WHITESPACE);
        StringBuilder out = new StringBuilder();

        for( String s : splits)
            out.append( new StringBuilder( s).reverse()).append(WHITESPACE);

        return out.toString();
    }

    private static String reverseStringByStringUtilsReverse(String str) {
        String[] splits = str.split(WHITESPACE);
        StringBuilder out = new StringBuilder();

        for( String s : splits) {
            out.append(StringUtils.reverse( s)).append(WHITESPACE);
        }

        return out.toString();
    }

}