package com.everyman.stream.test;

import com.everyman.stream.entity.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhougang
 */
public class Stream2Test
{
    Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
    Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
    Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
    Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
    Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
    Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
    Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
    Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
    Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
    Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");
    List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

    @Test
    public void test1()
    {
        // 求年龄之和
        Integer totalAge = employees.stream().map(Employee::getAge).reduce(0, Integer::sum);
        System.out.println("年龄之和 = " + totalAge);

    }


    @Test
    public void test2()
    {
        // **案例一：**给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？(如：给定【1，2，3，4，5】，返回【1，4，9，16，25】
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // **案例二：**怎样使用 map 和 reduce 数一数流中有多少个 Employee 呢？

    }

    @Test
    public void test3()
    {
        // 年龄大于20 并且小于50
        List<Employee> collect =
                employees.stream().filter(employee -> employee.getAge() > 20 && employee.getAge() < 50).collect(Collectors.toList());
        collect.forEach(System.err::println);

        // 使用谓词实现 年龄大于20
        List<Employee> collect1 = employees.stream().filter(Employee.ageThen).collect(Collectors.toList());
        collect1.forEach(System.err::println);
    }

    @Test
    public void test4()
    {
        // 把firstName 全部转为大写
        List<String> collect2 =
                employees.stream().map(employee -> employee.getFirstName().toUpperCase()).collect(Collectors.toList());
        collect2.forEach(System.err::println);
    }

    @Test
    public void test5()
    {
        // 把firstName 全部转为大写
        List<Employee> collect4 =
                employees.stream().peek(employee -> employee.setFirstName(employee.getFirstName().toUpperCase())).collect(Collectors.toList());
        collect4.forEach(System.out::println);
    }

    @Test
    public void test6()
    {
        // 把所有的年龄都加一岁 并别性别M 改为：male F ：female
        List<Employee> collect3 = employees.stream().peek(employee ->
        {
            employee.setAge(employee.getAge() + 1);
            employee.setGender("M".equals(employee.getGender()) ? "male" : "female");
        }).collect(Collectors.toList());
        collect3.forEach(System.out::println);
    }

    @Test
    public void test7()
    {
        // 求平均年龄
        double average =
                employees.stream()
                        .map(Employee::getAge)
                        .mapToInt(value -> value)
                        .summaryStatistics()
                        .getAverage();
        System.out.println("average = " + average);
    }

    @Test
    public void test8()
    {
        // 年龄最大值
        int max = employees.stream().mapToInt(Employee::getAge).summaryStatistics().getMax();
        System.out.println("max = " + max);
    }

    @Test
    public void test9()
    {
        // 年龄总和
        long sum = employees.stream().mapToInt(Employee::getAge).summaryStatistics().getSum();
        System.out.println("sum = " + sum);
    }

    @Test
    public void test10()
    {
        // 按年龄排序
        List<Employee> collect =
                employees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test11()
    {
        // 取出 ID 为 2和3的值
        List<Employee> collect = employees.stream().skip(1).limit(2).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test12()
    {
        // 创建一个Map，并填入数据
        Map<String, Integer> codes = new HashMap<>();
        codes.put("United States", 1);
        codes.put("Germany", 49);
        codes.put("France", 33);
        codes.put("China", 86);
        codes.put("Pakistan", 92);

        codes.forEach((s, integer) -> System.out.println("s = " + s + "    v=" + integer));


        // 按照Map的键进行排序
        LinkedHashMap<String, Integer> collect = codes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        ));
// 将排序后的Map打印
        collect.entrySet().forEach(System.out::println);

    }
}
