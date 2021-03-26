package sortAndSearch;

import records.RecordInfo;

import java.util.ArrayList;

public class Search {

    public int binarySearch(ArrayList<RecordInfo> list, String name){
        int start = 0;
        int end = list.size() - 1;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(list.get(mid).getName().equals(name)){
                return mid;
            }

            else if(list.get(mid).getName().compareTo(name) < 0){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
