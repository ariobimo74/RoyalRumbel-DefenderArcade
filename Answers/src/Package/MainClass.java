package Package;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass
{
    public static void main(String[] args)
    {
        List <String> list1 = new LinkedList();

        list1.add("Louis X");
        list1.add("Louis VIII");
        list1.add("David IX");
        list1.add("Elizabeth XI");
        list1.add("David II");
        list1.add("Fauzi II");
        list1.add("Fauzi I");
        list1.add("Elizabeth IX");
        list1.add("Rio V");
        list1.add("Rio IV");
        list1.add("Elizabeth IV");

        List<Person> personList = list1.stream().map(item -> new Person(item.split(" ")[0],item.split(" ")[1])
        ).collect(Collectors.toList());

        personList.stream().map(person -> person.getFirstName()).distinct().sorted(Comparator.naturalOrder()).forEach( name -> {
            personList.stream().filter(person -> person.getFirstName().equals(name)).sorted((p1, p2) -> {
                if (decode(p1.getLastName()) > decode(p2.getLastName())) {
                return 1;
                } else {
                    return -1;
                }
            }).forEach(System.out::println);
        });

        System.out.println("=========================");

//        DefenderArcade defenderArcade = new DefenderArcade();
//
//        List list2 = new LinkedList();
//
//        list2.add("900 910");
//        list2.add("940 1200");
//        list2.add("950 1120");
//        list2.add("1100 1130");
//        list2.add("1300 1400");
//        list2.add("1350 1420");
//
//        System.out.println(defenderArcade.countArcades(list2));
    }

    private static int decode(char roman) {
        switch (roman) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default : return 0;
        }
    }

    private static int decode(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase();

        for (int i = 0; i < uRoman.length() -1; i++) {
            if (decode(uRoman.charAt(i)) < decode(uRoman.charAt(i + 1))) {
                result -= decode(uRoman.charAt(i));
            } else {
                result += decode(uRoman.charAt(i));
            }
        }

        result += decode(uRoman.charAt(uRoman.length() -1));

        return result;
    }

    public static class Person {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
}
