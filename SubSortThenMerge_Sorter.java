/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter {
	ArrayList<String> localCopy;

    /**
      Construct an instance to process the user's data
     */
    public SubSortThenMerge_Sorter(  ArrayList< String> usersData) {
        super(usersData);
    }
	
	public void mySort(){
		int start = 0; 
		int end = elements.size();
		mySortHelper(start, end); //Passed in one list which will be split
	}
	
	private int mySortHelper(int start,int end){
		// System.out.println(start + " " + end);
		if (end - start <= 1){ //baseCase
			return start; //The function should return the index of the one element.
		}
		else{ //Recursive Case
			merge(mySortHelper(start, (start +end)/2 ),mySortHelper((start +end)/2, end), end);
			return start;
		}
	}
	
	
	/*
	Recursive Merge Function from Holmes.
	Takes as input the starts and ends of a list and uses a helper function mergeRange to do the work.

	Assumes that the two consecutive lists are in the same list and 
	that there exists unnessary data for one iteration.
	*/
	public void merge(int start0, int start1, int end1){ 
		localCopy = new ArrayList<String>( end1 - start0); //Copys the two lists we want from the data
		for( int index = start0; index < end1; index++) 
		    localCopy.add( elements.get( index));
		// temp for debugging
		// System.out.println( "localCopy: " + localCopy);
		// System.out.println("start0 " + start0 + " start1 " + start1 + " end1 " + end1);
		mergeRange( start0, 0, start1 - start0, start1 - start0, end1 - start0); //Start of Recursive
		//MergeRange is passed in the two lists within the localized method which start
		//and end at different indexes from the userlist. 
	}
	/*
	
	The helper function mergeRange is used to do work on the localized two lists. 
	Initially, 
	Each of the parameters signifies the start and end of the two lists.
	LocalEnd0 should be equal to localStart1, since the range is [localStart0, localEnd0)
	and [localStart1, localEnd1) of the two lists.
	localEnd1 would also be equal to the size of the local list. 
	localStart0 would be equal to 0 in the local list. 
	
	Each recursive call of mergeRange (after the initial call) would increment the starts of 
	the two lists unless your at the base case.
	
	Target references the posistion of list0 within the userData instead of the localized data.
	
	*/
	
	private void mergeRange(int target, int localStart0, int localEnd0, int localStart1,int localEnd1){
		// System.out.println(
		    // " target = "      + target  
		  // + " localStart0 = " + localStart0
		  // + " localEnd0 = "   + localEnd0  
		  // + " localStart1 = " + localStart1
		  // + " localEnd1 = "   + localEnd1  
		  // );
		if( localStart0 == localEnd0 && localStart1 == localEnd1 ){
			// both ranges are exhausted -> Base Case
	        return;  // merge is done
		}
        else{ // there is at least 1 item remaining to merge
           if( localStart0 == localEnd0 ){ //Exhausted list0
               // take an item from list1
                elements.set( target++, localCopy.get( localStart1++));
		   }
            // similarly for exhausted list1
            else if( localStart1 == localEnd1){
                elements.set( target++, localCopy.get( localStart0++));
            }
            else { // items remain in both lists
                // copy the smaller item
                if( localCopy.get( localStart0).compareTo( localCopy.get( localStart1)) < 0){
                    elements.set( target++, localCopy.get( localStart0++));
				}
                else{
                    elements.set( target++, localCopy.get( localStart1++));
				}
			}
            mergeRange( target, localStart0, localEnd0, localStart1, localEnd1);
			//In this new call, localStart0, localStart1, and target should have 
			//been incremented through post increments.
        }
	}
}
	