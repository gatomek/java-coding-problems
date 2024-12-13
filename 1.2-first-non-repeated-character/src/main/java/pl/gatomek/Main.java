package pl.gatomek;

public class Main {
    private static final int MAX_CHAR = 256;

    public static void main(String[] args) {
        System.out.println("First Non - Repeated Character");

        String str = "dsatawghbreybw35e6w35vybbd hevtve yqta0;s";

        Character c = findByArray(str);

        System.out.println("FNRC in '" + str + "' is '" + c + "'");
    }

    private static Character findByArray(String str) {
        int[] occurances = new int[MAX_CHAR];
        for (int i = 0; i < MAX_CHAR; i++) {
            occurances[i] = -1;
        }

        char[] chars = str.toCharArray();
        int counter = 0;
        for (char c : chars) {
            int index = (int) c;
            int v = occurances[index];
            if (v == -1) occurances[index] = counter;
            else occurances[index] = -2;
            ++counter;
        }

        Integer cIndex = str.length();
        for (int i = 0; i < MAX_CHAR; i++) {
            int val = occurances[i];
            if (val > -1) {
                cIndex = Math.min(val, cIndex);
            }
        }

        if (cIndex < str.length()) return str.charAt(cIndex);

        return null;
    }
}