package src.Sorting;

import src.SortingAssignment;

public class SortingMethods extends SortingAssignment{
    public static void bubbleSort(int[] a){
        jpb.setMaximum(a.length);
        jpb.setMinimum(0);
        int progress=0;
   	int k = 0;
   	boolean exchangeMade = true;
	// Make up to n - 1 passes through array, exit 
	//early if no exchanges are made on previous pass
  
 	while ((k < a.length - 1) && exchangeMade){
      		exchangeMade = false;
      		k++;
      		for (int j = 0; j < a.length - k; j++) { 
         		if (a[j] > a[j + 1]){
            			swap(a, j, j + 1);		 
            			exchangeMade = true;
         		}//end if
		}//end for
                progress=k;
                jpb.setValue(progress);
	}//end while
        jpb.setMaximum(50);
        jpb.setValue(50);
}
////////////////////////////////////////////////////////////////

public static void selectionSort(int[] a){
    jpb.setMaximum(a.length);
    jpb.setMinimum(0);
    int progress=0;
    for (int i = 0; i < a.length - 1; i++){
      int minIndex = findMinimum(a, i);
      if (minIndex != i)
	//if lowest is not already in place
         swap(a, i, minIndex);
      progress=i;
      jpb.setValue(progress);
   } //end for
    jpb.setMaximum(50);
    jpb.setValue(50);
}  

//supporting findMinimum method

public static int findMinimum(int[] a, int first){
   //first=where to start looking from
   //assume first is also the smallest for now
    int minIndex = first; 
    for (int i = first + 1; i < a.length; i++)
       if (a[i] < a[minIndex])
          minIndex = i;
    return minIndex;
}

//supporting swap method (same as bubble sort swap)

public static void swap(int[] a, int x, int y){
   int temp = a[x];
   a[x] = a[y];
   a[y] = temp;
}


/////////////////////////////////////////////////////////////

public static void insertionSort(int a[]){
	int itemToInsert, j;
	boolean stillLooking;
        jpb.setMaximum(a.length);
        jpb.setMinimum(0);
        int progress=0;
	//on the kth pass, pass item k upwards in list
	//and insert it in its proper place amoung the
	//first k entries in an array

	for (int k=1; k<a.length; k++){
	//move backwards through list, looking for
	//the right place to insert a[k];
		itemToInsert = a[k];
		j=k-1;
		stillLooking=true;
		while(j >=0 && stillLooking){
			if (itemToInsert < a[j]){
				//move item higher
				a[j+1] = a[j];
				j--;
			}else{
				//we have found new home for a[k];
				stillLooking=false;
			}//end else// j+1 is where the item goes
			a[j+1]=itemToInsert;
		}//end while
            progress=k;
            jpb.setValue(progress);
  	}//end for
        jpb.setMaximum(50);
        jpb.setValue(50);
}//end method
}
