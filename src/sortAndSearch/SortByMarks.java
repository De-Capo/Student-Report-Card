package sortAndSearch;

import records.RecordInfo;

import java.util.ArrayList;

public class SortByMarks {

    public void quickSort(ArrayList<RecordInfo> list, int low, int high){
        if (low < high){
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);

            quickSort(list, pi + 1, high);
        }
    }

    private int partition(ArrayList<RecordInfo> list, int low, int high){
        RecordInfo pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++){
            if (list.get(j).getMarks() <= pivot.getMarks()){
                i++;

                RecordInfo temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        RecordInfo temp = list.get(i + 1);
        list.set(i+1, list.get(high));
        list.set(high, temp);
        return (i + 1);
    }
}
