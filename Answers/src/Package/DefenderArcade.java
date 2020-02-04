package Package;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DefenderArcade
{
    LinkedList<Integer> startParseIntList = new LinkedList();
    LinkedList<Integer> endParseIntList = new LinkedList();
    LinkedList<String> startTimeList = new LinkedList();
    LinkedList<String> endTimeList = new LinkedList();
    LinkedList<LinkedList<Integer>> packLists = new LinkedList<LinkedList<Integer>>();
    LinkedList<Integer> totalList = new LinkedList<>();

    public int countArcades(List<String> times)
    {
        int x, y, a, b;
        int total = 1;

        for (int i = 0; i < times.size(); i++)
        {
            for (int j = 0; j < times.get(i).length(); j++)
            {
                if(times.get(i).charAt(j) == ' ')
                {
                    startTimeList.add(times.get(i).substring(0, j));
                    endTimeList.add(times.get(i).substring(j+1));
                }
            }
        }

//        System.out.println(startTimeList);
//        System.out.println(endTimeList);

        for (int i = 0; i < startTimeList.size(); i++)
        {
            x = Integer.parseInt("" + startTimeList.get(i));
            startParseIntList.add(x);
            y = Integer.parseInt("" + endTimeList.get(i));
            endParseIntList.add(y);
        }

//        System.out.println(startParseIntList);
//        System.out.println(endParseIntList);

        for (int i = 0; i < times.size(); i++)
        {
            LinkedList<Integer> packList = new LinkedList<>();
            packLists.add(packList);

            for (int j = startParseIntList.get(i); j <= endParseIntList.get(i); j = j + 5)
            {
                packList.add(j);
            }
        }
//        System.out.println(packLists);

        for (int i = 0; i < packLists.size()-1; i++)
        {
            outer : for (int j = i + 1; j < packLists.size(); j++)
            {
                for (int k = 0; k < packLists.get(i).size(); k++)
                {
                    a = packLists.get(i).get(k);
//                    System.out.println(packLists.get(i).get(k));
                    for (int l = 0; l < packLists.get(j).size(); l++)
                    {
                        b = packLists.get(j).get(l);
//                        System.out.println(packLists.get(j).get(l));
                        if (a == b)
                        {
                            total += 1;
                            totalList.add(total);
                            break outer;
                        }
                    }
                }
                total = 1;
            }
        }
        totalList.add(total);

//        System.out.println(totalList);

        return Collections.max(totalList);
    }
}
