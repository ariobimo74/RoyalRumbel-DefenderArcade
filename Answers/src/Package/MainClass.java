package Package;

import java.util.LinkedList;
import java.util.List;

public class MainClass
{
    public static void main(String[] args)
    {
        RoyalRumbel royalRumbel = new RoyalRumbel();
        List list1 = new LinkedList();

        list1.add("Louis IX");
        list1.add("Louis VIII");
        list1.add("David II");

        System.out.println(royalRumbel.getSortedList(list1));

        System.out.println("=========================");

        DefenderArcade defenderArcade = new DefenderArcade();

        List list2 = new LinkedList();

        list2.add("900 910");
        list2.add("940 1200");
        list2.add("950 1120");
        list2.add("1100 1130");
        list2.add("1300 1400");
        list2.add("1350 1420");

        System.out.println(defenderArcade.countArcades(list2));
    }
}
