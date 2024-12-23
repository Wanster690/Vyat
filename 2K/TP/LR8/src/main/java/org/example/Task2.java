package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<T2Employee> employees = Arrays.asList(
                new T2Employee("Alice", "Manager", 5000),
                new T2Employee("Bob", "Developer", 6000),
                new T2Employee("Charlie", "Manager", 7000),
                new T2Employee("David", "Developer", 5500),
                new T2Employee("Evee", "Developer", 6500),
                new T2Employee("John", "Developer", 5000)
        );

        String positionToSearch = "Developer";
        //String positionToSearch = "Manager";
        int N = 3;
        System.out.println(employees.stream()
                .filter(emp -> emp.getPosition().equals(positionToSearch))
                .sorted(Comparator.comparingDouble(T2Employee::getSalary).reversed())
                .limit(N)
                .map(T2Employee::getName)
                .sorted((name1, name2) -> name2 .length() - name1.length())
                .collect(Collectors.joining(", ", N + " самых высокооплачиваемых сотрудников зовут: ", "."))
);
    }
}