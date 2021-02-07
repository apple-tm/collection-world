package com.example.collection.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    /**
     * 实体的状态使用内部枚举属性
     */
    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    public static void main(String[] args) {
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        // 枚举是常量，内存地址相同，可以使用 == 比较
        // 1.过滤 filter（lambda 表达式）
        // 2.collect 组装 list 集合
        List<Task> list1 = tasks.stream().filter(e -> e.getStatus() == Status.OPEN).collect(Collectors.toList());
        // 3.collect 组装 map 集合
        Map<Integer, Status> map1 = tasks.stream().filter(e -> e.getStatus() == Status.OPEN)
                .collect(Collectors.toMap(Task::getPoints,Task::getStatus, (oldValue, newValue) -> newValue));
        // 4.Duplicate key OPEN : 组装 map 时 key 相同会报错，而不是像 HashMap 直接覆盖 ，使用 (oldValue,newValue) -> newValue 表达式使用新的value替换原有value。
        // 5.计算
        int sum = tasks.stream().filter(e -> e.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints).sum();
        // 6.并行计算  parallel
        int sum2 = tasks.stream().parallel().filter(e -> e.getStatus() == Status.OPEN)
                .map(Task::getPoints).reduce(0, Integer::sum);
        System.out.println(sum2);
        // 7.分组成 map
        Map<Streams.Status, List<Streams.Task>> map2 = tasks.stream().parallel().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println();
    }
}
