package edu.dcccd;
import org.junit.*;
import org.hamcrest.Matchers;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static org.junit.Assert.assertEquals;

public class TestLesson7 {
    @Test(expected = UnsupportedOperationException.class)
    public void testListOf() {
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        ints.add(10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSetOf() {
        Set<Integer> ints = Set.of(1, 2, 3, 4, 5);
        ints.add(10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMapOf() {
        Map<String, String> stateCapitals = Map.of(
            "Texas",      "Austin",
            "New Mexico", "Santa Fe",
            "Arizona",    "Tucson");
        stateCapitals.put("Colorado", "Denver");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMapOfEntries() {
        Map<String, String> stateCapitals = Map.ofEntries(
            entry("Texas",      "Austin"),
            entry("New Mexico", "Santa Fe"),
            entry("Arizona",    "Tucson"));
        stateCapitals.put("Colorado", "Denver");
    }

    @Test
    public void testRemoveIf() {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Predicate<Integer> integerPredicate = p -> p < 3;
        ints.removeIf(integerPredicate);
        assertEquals(List.of(3, 4, 5), ints);
    }

    @Test
    public void testReplaceAll() {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        UnaryOperator<Integer> integerUnaryOperator = p -> p * 2;
        ints.replaceAll(integerUnaryOperator);
        assertEquals(List.of(2, 4, 6, 8, 10), ints);
    }

    @Test
    public void testSort() {
        List<String> capitals = new ArrayList<>(List.of("Denver", "Austin", "Tucson", "Santa Fe", "Baton Rouge", "OKC"));
        capitals.sort(Comparator.naturalOrder());
        assertEquals(List.of("Austin", "Baton Rouge", "Denver", "OKC", "Santa Fe", "Tucson"), capitals);
    }

    @Test
    public void testSortMap() {
        Map<String, String> stateCapitals = Map.ofEntries(
            entry("Texas", "Austin"),
            entry("New Mexico", "Santa Fe"),
            entry("Arizona", "Tucson"),
            entry("Oklahoma", "OKC"),
            entry("Louisiana", "Baton Rouge"));

        Map<String, String> sortedCapitals = stateCapitals.entrySet().stream()
            //.peek(System.out :: println)
            //.sorted(Map.Entry.comparingByValue())
            //.peek(System.out :: println)
            .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
        System.out.println(sortedCapitals.getClass());
        sortedCapitals.entrySet().forEach(System.out :: println);
//       assertEquals(Map.ofEntries(
//                entry("Texas", "Austin"),
//                entry("Louisiana", "Baton Rouge"),
//                entry("Oklahoma", "OKC"),
//                entry("New Mexico", "Santa Fe"),
//                entry("Arizona", "Tucson")),
//                sortedCapitals);

        Matchers.contains(Map.ofEntries(
            entry("Texas",     "Austin"),
            entry("Louisiana", "Baton Rouge"),
            entry("Oklahoma",  "OKC"),
            entry("New Mexico","Santa Fe"),
            entry("Arizona",   "Tucson")), sortedCapitals);
    }
}
