import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String gg[])
    {
        List<Student> studentList= Stream.of(
                new Student(1,"John Doe",30,"male","Computer Engineering","Mumbai",122,Arrays.asList("7412589633","4523698741")),
                new Student(2,"Tony Stark",56,"male","Mechanical Engineering","Delhi",67,Arrays.asList("9632587410","4569871236")),
                new Student(3,"Steve Rogers",25,"male","Mechanical Engineering","Kerala",164,Arrays.asList("7456321890","7458963210")),
                new Student(4,"Jane Foster",30,"female","Mechanical Engineering","Kerala",26,Arrays.asList("7896412563","9632587410")),
                new Student(5,"Logan Wolverine",23,"male","Biotech Engineering","Mumbai",12,Arrays.asList("7412589630","3214569870")),
                new Student(6,"Bruce Wayne",24,"male","Mechanical Engineering","Karnataka",90,Arrays.asList("9632587410","1236547809")),
                new Student(7,"Wonder Women",26,"female","Electronics Engineering","Karnataka",324,Arrays.asList("7896541253","1597536842")),
                new Student(8,"Black Widow",31,"female","Computer Engineering","Karnataka",433,Arrays.asList("7458963210","9632514780")),
                new Student(9,"Mack Miller",27,"male","Computer Engineering","Karnataka",7,Arrays.asList("7412589630","7896321045")),
                new Student(10,"Jeremy Runner",26,"male","Instrumentation Engineering","Mumbai",98,Arrays.asList("7896302145","4521789630"))
        ).collect(Collectors.toList());
        // 1. find the list of students whose rank is between 50 and 100
        List<Student> studentsByRank = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .collect(Collectors.toList());
        //System.out.println(studentsByRank);
        // 2. find the list of student who lives in specific city and sort them according to their names
        List<Student> studentsByCity = studentList.stream().filter(student -> student.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder()))
                .toList();
        //System.out.println(studentsByCity);
        // 3. get all the department names
        List<String> departmentsList = studentList.stream().map(student -> student.getDepartment()).distinct().toList();
        Set<String> departmentsList2 = studentList.stream().map(Student::getDepartment).collect(Collectors.toSet());
        //System.out.println(departmentsList);
        // 4. Find all the contact numbers
        List<List<String>> contactsList = studentList.stream().map(Student::getContacts).toList();
        //System.out.println(contactsList);
        List<String> contactList2 = studentList.stream().flatMap(student -> student.getContacts().stream()).toList();
        //System.out.println(contactList2);
        // 5. Group the students by department name
        Map<String, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
        //System.out.println(studentMap);
        // 6. find the numbers of the student each department have
        Map<String, Long> studentMap2 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        //System.out.println(studentMap2);
        // 7. find the department which have largest number of students
        Map.Entry<String, Long> largestDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        //System.out.println(largestDepartment);
        // 8. find the average age of male and female students
        Map<String, Double> averageStudent = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        //System.out.println(averageStudent);
        // 9. Find the highest rank in all departments
        Map<String, Optional<Student>> highestRankOfStudent = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.minBy(Comparator.comparing(Student::getRank))));
        //System.out.println(highestRankOfStudent);
        // Find the student whose rank is second
        List<Student> sortByRank = studentList.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        //System.out.println(sortByRank);
        Student secondRankStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();
        Student ThirdRankStudent = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(2)
                .findFirst().get();
        System.out.println(secondRankStudent);

        Map<String, Long> collect = studentList.stream().collect(Collectors.groupingBy(student -> student.getGender(), Collectors.counting()));
        //System.out.println(collect);
        String inputString = "Java Concept Of The Day";
        char[] chararr=inputString.toCharArray();
        List<Character> charList=new ArrayList<>();
        for (char c : chararr) {
            charList.add(c);
        }
        Map<Character, Long> collect7 = charList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(collect7);


        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> collect1 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect1);
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<Double> collect2 = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(collect2);

        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String collect3 = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
       // System.out.println(collect3);
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        List<Integer> collect4 = listOfIntegers.stream().filter(a -> a % 5 == 0).collect(Collectors.toList());
//        System.out.println(collect4);
        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Optional<Integer> collect5 = listOfIntegers1.stream().collect(Collectors.maxBy(Comparator.comparing(Function.identity())));
        //System.out.println(collect5.get());
        int[] a = new int[] {4, 2, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};
        List<List<Integer>> list1 = Arrays.asList(Arrays.asList(4, 2, 7, 1), Arrays.asList(8, 1, 9, 5));
        List<Integer> collect6 = list1.stream().flatMap(Collection::stream).collect(Collectors.toList());
        //System.out.println(collect6);
        List<Integer> collect8=  list1.stream().flatMap(i->i.stream()).sorted().distinct().collect(Collectors.toList());
//        System.out.println(collect8);
        List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        List<Integer> collect9 = listOfIntegers2.stream().sorted().limit(3).collect(Collectors.toList());
        //System.out.println(collect9);
        List<Integer> collect10 = listOfIntegers2.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        //System.out.println(collect10);
        List<Integer> listOfIntegers3 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer i = listOfIntegers3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        //System.out.println(i);
        List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        List<String> collect11=listOfStrings2.stream().sorted(Comparator.comparing(c->c.length())).collect(Collectors.toList());
        System.out.println(collect11);
        int[] k = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        List<Integer> list2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer i1 = list2.stream().reduce((d, c) -> d + c).get();
//        System.out.println(i1);
        double avg=i1/list2.size();
//        System.out.println(avg);
        List<Integer> list3 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list4 = Arrays.asList(12, 56, 17, 21, 94, 34);
        List<Integer> collect12 = list3.stream().filter(list4::contains).distinct().collect(Collectors.toList());
        System.out.println(collect12);
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum);
        int[] array = new int[] {5, 1, 7, 3, 9, 6};
        List<Integer> list = Arrays.asList(5, 1, 7, 3, 9, 6);
        Collections.reverse(list);
        System.out.println(list);
        List<String> listOfStrings3 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String s = listOfStrings3.stream().skip(listOfStrings3.size() - 1).findFirst().get();
        System.out.println(s);

    }
}



