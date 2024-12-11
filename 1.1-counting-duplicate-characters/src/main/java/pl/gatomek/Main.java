package pl.gatomek;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        String str = "gag awtgawtgergvsdgsevyesvhs  lpg";

        {
            Map<Character, Integer> result1 = calcOccurances(str);
            for (Map.Entry<Character, Integer> entry : result1.entrySet())
                System.out.printf("%c:%d, ", entry.getKey(), entry.getValue());
        }

        System.out.println();

        {
            Map<Character, Integer> result2 = calcOccurancesByMapComputing(str);
            for (Map.Entry<Character, Integer> entry : result2.entrySet())
                System.out.printf("%c:%d, ", entry.getKey(), entry.getValue());
        }

        System.out.println();

        {
            Map<Character, Long> result3 = calcOccurancesByStreams(str);
            for (Map.Entry<Character, Long> entry : result3.entrySet())
                System.out.printf("%c:%d, ", entry.getKey(), entry.getValue());
        }

        System.out.println();
    }

    private static Map<Character, Integer> calcOccurances(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (char ch : str.toCharArray()) {
            Integer i = result.get(ch);
            if (i == null) result.put(ch, 1);
            else result.put(ch, ++i);
        }
        return result;
    }

    private static Map<Character, Integer> calcOccurancesByMapComputing(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (char ch : str.toCharArray())
            result.compute(ch, (k, v) -> v == null ? 1 : ++v);
        return result;
    }

    private static Map<Character, Long> calcOccurancesByStreams(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}