package com.Warehouse;

import java.util.Comparator;

public class MyComparator implements Comparator<Item>
{
    public int compare(Item name1, Item name2)
    {
        int result = name1.quantity - name2.quantity;
        if (result == 0)
        {
            return name1.compareTo(name2);
        }
        return result;
    }
}
