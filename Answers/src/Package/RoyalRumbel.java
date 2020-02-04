package Package;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class RoyalRumbel
{
    LinkedList<String> romanList = new LinkedList<>();
    LinkedList<String> decimalList = new LinkedList<>();
    LinkedList<String> nameList = new LinkedList<>();
    LinkedList<String> mixedList = new LinkedList<>();
    LinkedList<String> mixedListSorted = new LinkedList<>();

    public List<String> getSortedList(List<String> names)
    {
        getSeparatedList(names, nameList, romanList);

        int result = 0;
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String test;

        for (int j = 0; j < romanList.size(); j++)
        {
            test = romanList.get(j);
            for (int i = 0; i < decimal.length; i++ )
            {
                while (test.indexOf(roman[i]) == 0)
                {
                    result += decimal[i];
                    test = test.substring(roman[i].length());
                }
            }
            decimalList.add(""+result);
            result = 0;
        }

        for (int i = 0; i < names.size(); i++)
        {
            mixedList.add(nameList.get(i) + " " + decimalList.get(i));
        }

        Collections.sort(mixedList);
        nameList.clear();
        decimalList.clear();
        romanList.clear();

        getSeparatedList(mixedList, nameList, decimalList);

        String x = "";
        for (int i = 0; i < decimalList.size(); i++)
        {
            x = decimalList.get(i);
            int y = Integer.parseInt(x.trim());
            romanList.add(toRoman(y));
        }

        for (int i = 0; i < mixedList.size(); i++)
        {
            mixedListSorted.add(nameList.get(i) + " " + romanList.get(i));
        }
        return mixedListSorted;
    }

    private List<String> getSeparatedList(List<String> list1, List<String> list2, List<String> list3)
    {
        String temp = "";
        for (int i = 0; i < list1.size(); i++)
        {
            for (int j = 0; j < list1.get(i).length(); j++)
            {
                if(list1.get(i).charAt(j) == ' ')
                {
                    temp = list1.get(i).substring(j+1);
                    list2.add(list1.get(i).substring(0, j));
                }
            }
            list3.add(temp);
        }

        return list1;
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}
