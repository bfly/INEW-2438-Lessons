package edu.dcccd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Functional1 {
    private void go() {
        System.out.println(subsets(List.of(1, 4, 9)));
    }

    private List<List<Integer>> subsets(List<Integer> list) {
        if ( list.isEmpty() ) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.EMPTY_LIST);
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for ( List<Integer> list : lists ) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    public static void main(String[] args) {
        new Functional1().go();
    }
}
