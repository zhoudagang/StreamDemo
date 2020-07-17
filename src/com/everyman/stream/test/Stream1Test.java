package com.everyman.stream.test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhougang
 */
public class Stream1Test
{
    @Test
    public void test1()
    {
        // 计算空字符串
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("strings = " + strings);

        // allMatch：检查是否匹配所有元素
        System.out.println("allMatch = " + strings.stream().allMatch(s -> s.equals("abc")));
        // anyMatch：检查是否至少匹配一个元素
        System.out.println("anyMatch = " + strings.stream().anyMatch(s -> s.equals("abc")));
        // noneMatch：检查是否没有匹配所有元素
        System.out.println("anyMatch = " + strings.stream().noneMatch(s -> s.equals("abc")));
        // findFirst：返回第一个元素
        System.out.println("findFirst = " + strings.stream().findFirst());
        // findAny：返回当前流中的任意元素
        System.out.println("findAny = " + strings.stream().findAny());
        // count：返回流中元素的总个数
        System.out.println("count = " + strings.stream().count());

        System.out.println("空字符数量为: " + strings.stream().filter(String::isEmpty).count());
        System.out.println("字符串长度为 3 的数量为: " + strings.stream().filter(s -> s.length() == 3).count());
        // 删除空字符串
        System.out.println("筛选后的列表: " + strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()));
        // 删除空字符串，并使用逗号把它们合并起来
        System.out.println("合并字符串: " + strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",")));


        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        IntSummaryStatistics statistics = integers.stream().mapToInt(value -> value).summaryStatistics();
        System.out.println("列表中最大的数 : " + statistics.getMax());
        System.out.println("列表中最小的数 : " + statistics.getMin());
        System.out.println("所有数之和 : " + statistics.getSum());
        System.out.println("平均数 : " + statistics.getAverage());

        System.out.println("排序 " + integers.stream().sorted().collect(Collectors.toList()));
        System.out.println("max = " + integers.stream().max(Integer::compareTo));


        Integer reduce = integers.stream().reduce(0, Integer::max);
        System.out.println("reduce求最大值 = " + reduce);



    }
}
