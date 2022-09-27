import java.util.Arrays;

public class Merge {

    static int [] MergeSort(int LIST[], int lb, int ub) {
        int mid;
        int[]a=new int[ub];
        if (lb < ub) {
            mid = (lb + ub) / 2;
            MergeSort(LIST, lb, mid);
            MergeSort(LIST, mid + 1, ub);
          a=  ListMerger(LIST, lb, mid, ub);
        }
        
        return a;
    }

    static int [] ListMerger(int List[], int lb, int mid, int ub) {
        int TempList[];
        TempList = new int[ub-lb+1];
        						
        int i = lb, j = mid + 1;			       
        int k = 0;									
        while (i <= mid && j <= ub) {
            if (List[i] <= List[j]) {
                TempList[k++] = List[i++];
            } else {
                TempList[k++] = List[j++];
            }
        }
        
        //remaining elements of left-half
        while (i <= mid) {
            TempList[k++] = List[i++];
        }

        //remaining elements of right-half
        while (j <= ub) {
            TempList[k++] = List[j++];
        }

        //copy the mergered temporary List to the original List
        for (k = 0, i = lb; i <= ub; ++i, ++k) {
            List[i] = TempList[k];
        }

        return List;
    }
    

    public static void main(String[] args) {

        
        int List []={55,100,30,20,50,90,80,40,10};
        
        System.out.println("Unsorted array:     "+Arrays.toString(List));

        int n=List.length;
        int [] nList = new int[n];
        nList=MergeSort(List, 0, n-1);
        System.out.println("Sorted array:       "+Arrays.toString(nList));

    }

}
