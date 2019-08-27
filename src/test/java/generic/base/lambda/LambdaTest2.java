package generic.base.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 11:23 2019-08-25
 */
public class LambdaTest2 {



    public static void method1() {
        new Thread(() -> System.out.println("dafasfa")).start();
    }

    /**
     * 迭代
     */
    public static void method2() {
        List list = Arrays.asList("aa","dd","cc");
        list.forEach(n -> System.out.println(n));
    }

    public static void method3() {
        List<String> languages = Arrays.asList("Java", "c", "c++", "pathon", "Scala");

        System.out.println("languages switch start with J:");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all language");
        filter(languages, (str) -> true);

        System.out.println("Print no language");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4: ");
        filter(languages, (str) -> str.length()>4);

        //
        Predicate<String> p1 = str -> str.length() > 4;
        Predicate<String> p2 = str -> str.startsWith("S");
        List<String> test = languages.stream().filter(p1).collect(Collectors.toList());
        System.out.println("test1: " + test.toString());
        List<String> test2 = languages.stream().filter(p1.and(p2)).collect(Collectors.toList());
        System.out.println("test2: " + test2.toString());

        filter2(languages, str -> str.startsWith("p"));
    }

    /**
     *
     * @param names
     * @param condition 断言条件
     */
    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            //根据传入的条件断言name是否满足条件，例如条件为str.startsWith("J")
            //即看name是不是以"J"开头
            if(condition.test(name)) {
                System.out.println(name + "");
            }
        }

    }

    public static void filter2(List<String> names, Predicate<String> condition) {
        System.out.println("================");
        List<String> test = names.stream().filter((name) -> (condition.test(name))).collect(Collectors.toList());
        System.out.println(test);
        names.stream().filter(name -> condition.test(name)).forEach(name -> {
            System.out.println(name);
        });
    }

    /**
     *  Predicate的使用
     */
    public static void method4() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        //断言条件 断言p1 满足 p1的值i大于5,相当于下面的语句，括号中的值是条件
//        Predicate<Integer> p1 = i -> (i > 5);
        Predicate<Integer> p1 = i -> i > 5;
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        Predicate<Integer> p4 = i -> i % 3 == 0;
        List<Integer> test = list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
        //p3.negate()为对p3条件取反，即 i % 2 != 0
        List<Integer> test2 = list.stream().filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test2.toString());
        List<Integer> test3 = list.stream().filter(p1.negate().and(p3)).collect(Collectors.toList());
        System.out.println(test3.toString());
    }

    public static void method5() {
        List<Integer> list = Arrays.asList(1000,200,300);
        list.stream().map(m -> m + 0.12 * m).forEach(m -> System.out.println(m));
        list.stream().map(m -> m + 0.12 * m).forEach(System.out::println);

        //求和
        double count = list.stream().map(m -> m + m * 0.12).reduce((sum, m) -> sum + m).get();
        System.out.println(count);
    }

    public static void method6() {
        List<String> strList = Arrays.asList("list","for","admin","ok");
        Predicate<String> p = x -> x.length() > 2;
        List<String> filtered = strList.stream().filter(p).collect(Collectors.toList());
        System.out.println(filtered.toString());
        System.out.printf("Original List : %s, filtered list: %s %n", strList, filtered);

    }

    /**
     * 将字符串换成大写并用逗号链接起来
     */
    public static void method7() {
        List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String value = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(value);
        List<String> listValue = list.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(listValue.toString());
    }

    /**
     * 利用流的 distinct() 方法来对集合进行去重
     */
    public static void method8() {
        List<Integer> list = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> value = list.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(value);
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.printf("newList is: %s, oldList is: %s %n", list, newList);
    }

    /**
     * 计算集合元素的最大值、最小值、总和以及平均值
     */
    public static void method9() {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("Highest prime number in List: " + stats.getMax());
        System.out.println("Lowest prime number in List: " + stats.getMin());
        System.out.println("Sum of all prime number: " + stats.getSum());
        System.out.println("Average of all prime number: " + stats.getAverage());
        int max = primes.stream().mapToInt(x -> x).min().getAsInt();
        System.out.println(max);
        int sum = primes.stream().mapToInt(x -> x).sum();
        System.out.println(sum);
        double average = primes.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println(average);

    }

    public static void method10() {
        List<String> lists = Arrays.asList("adf","xyz");
        List<String> list2 = Arrays.asList("ddd","ffff");
        List<String> list3 = Arrays.asList("111","222");
        lists.forEach(x -> System.out.println(x + "*"));
        lists.forEach(System.out::println);


    }

    public static void method11() {
        List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
        int factor = 2;

        primes.forEach(x -> System.out.println(x * factor));
    }

    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        method6();
//        method7();
//        method8();
//        method9();
//        method10();
        method11();


    }

}