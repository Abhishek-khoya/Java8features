import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String gg[])
    {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        //employees.forEach(e->System.out.println(e.getName()+" : "+e.getSalary()));
        //employees.stream().forEach(System.out::println);
        //filter and collect
        Map<Integer,String> devs=employees.stream()
                .filter(e->e.getDept().equals("Development") && e.getSalary()>80000)
                .collect(Collectors.toMap(Employee::getId,Employee::getName));
        //System.out.println(devs);

        //map
        List<String> depts = employees.stream().map(e -> e.getDept()).distinct().collect(Collectors.toList());
        //System.out.println(depts);
        List<List<Project>> projs = employees.stream().map(e -> e.getProjects()).collect(Collectors.toList());
        //flatmap
        List<String> projs2 = employees.stream().flatMap(e -> e.getProjects().stream()).map(p->p.getName()).distinct().collect(Collectors.toList());
        //System.out.println(projs2);
        List<Employee> sorted = employees.stream().sorted(Comparator.comparing(e -> e.getName())).collect(Collectors.toList());
        //System.out.println(sorted);
        //sorted.forEach(System.out::println);
        List<Employee> sorted2 = employees.stream().sorted(Collections.reverseOrder(Comparator.comparing(e -> e.getName()))).collect(Collectors.toList());
        //sorted2.forEach(System.out::println);
        Optional<Employee> optionalEmployee = employees.stream().collect(Collectors.maxBy(Comparator.comparing(e -> e.getSalary())));
        // Employee e=optionalEmployee.get();
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        //System.out.println(max.get());
        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::getSalary));
        //System.out.println(min.get());

        Map<String, List<String>> empGMap = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList())));
//        System.out.println(empGMap);
        Map<String, Long> ss = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(ss);
        Optional<Employee> first = employees.stream().filter( e->e.getDept().equals("Development")).findFirst();
//        System.out.println(first);
        Optional<Employee> any = employees.stream().filter( e->e.getDept().equals("Development")).findAny();
        //System.out.println(any);
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(a -> a.getSalary()>60000));
        //System.out.println(collect);
        Long collect1 = employees.stream().collect(Collectors.counting());
        System.out.println(collect1);



    }
}

