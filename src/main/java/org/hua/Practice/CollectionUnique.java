package org.hua.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionUnique {
    public static void main(String[] args) {

    }


 /*   // Set 去重代码示例
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    // List 去重代码示例
    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }*/


}
