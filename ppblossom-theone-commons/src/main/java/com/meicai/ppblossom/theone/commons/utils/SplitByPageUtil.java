package com.meicai.ppblossom.theone.commons.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitByPageUtil {

    public static <T> List<List<T>> splitByPage(List<T> list, int pageNumber) {
        if (list == null) {
            return null;
        }
        int pageCounter = list.size() / pageNumber + (list.size() % pageNumber > 0 ? 1 : 0);
        return Stream.iterate(0, n -> n + 1).limit(pageCounter).map(p ->
                list.stream().skip(p * pageNumber).limit(pageNumber).collect(Collectors.toList())
        ).collect(Collectors.toList());
    }
}
