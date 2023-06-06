import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoLists {
    public List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null && list1.size() == 0 || list2.size() == 0) {
            return new ArrayList<>();
        }
        //compare two lists and sort them while storing in list1
        //if two lists are sorted then we need one for loop
        for (int i = 0, j = 0; j < list2.size(); i++) { //i=0,1,2,3,4,5 // j= 0,1,2,3 //l1 = [1,1,2,3,4], l2 = [1,3,4]
            if (i == list1.size() || list1.get(i) > list2.get(j)) {
                list1.add(i, list2.get(j)); // list1 = [1,2,4]-> [1,1,2,3,4,5] // list1 size increases = 3,4,5,6
                j++;
            }
        }
        return list1;
    }
    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);

        List<Integer> res = m.mergeList(list1, list2);
        for(int k = 0; k < res.size(); k++) { // list1.size() = 6
            System.out.println("Two merged sorted list : " + res.get(k));
        }
    }
}

// TC - O(n)
// SC - O(1)