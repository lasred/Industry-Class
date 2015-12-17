import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MergeSortedLists {
   /**
       * Assuming the both lists are sorted, return a new list that merges the
       * results and is also sorted. Performance should be in O(n) time. null
       * entries should be placed at the beginning of the list.
       * 
       * @param sortedList1
       *            
       * @param sortedList2
       * @return a sorted list containing all the elements from both lists (of
    *         length sortedList1.size + sortedList2.size)
    */
    public static <T extends Comparable<T>> List<T> mergeSortedList(
    		List<T> sortedList1, List<T> sortedList2) {
        List<T> resultList = new ArrayList<T>();
        if(sortedList1.size() > 0 && sortedList2.size() > 0) {
	        Iterator<T> iterator1 = sortedList1.iterator();
	        Iterator<T> iterator2 = sortedList2.iterator();
	        T value1 = iterator1.next();
	        while(value1 == null) {
	        	value1 = iterator1.next();
	        }
	        T value2 = iterator2.next();
	        while(value2 == null) {
	        	value2 = iterator2.next();
	        }
	        while(iterator1.hasNext() && iterator2.hasNext()) {
	              if(value1.compareTo(value2) <= 0) {
	                  resultList.add(value1);
	                  //move iterator cursor 
	                  if(iterator1.hasNext()) {
	                    value1 = iterator1.next();
	                  }
	              } else {
	                  resultList.add(value2);
	                  if(iterator2.hasNext()) {
	                    value2 = iterator2.next();
	                  }
	              }
	        }
	        //know that both value1 and value2's current value have not been added to the result list bc these things happen in the while loop
	        if(iterator1.hasNext() || iterator2.hasNext()) {
	            //know there is one thing in one list, find out where it fits in the remaining list 
	            if(iterator1.hasNext()) {
	            	addValueFromOneListToOther(value2, value1, iterator1, resultList);
	            } else {
	            	addValueFromOneListToOther(value1, value2, iterator2, resultList);
	            }
	        } else {
	            //need to add both
	            if(value1.compareTo(value2) <= 0) {
	                resultList.add(value1);
	                resultList.add(value2);
	            } else {
	                resultList.add(value2);
	                resultList.add(value1);
	            }
	        }
        }
        if(sortedList1.isEmpty()) {
        	for(T value:sortedList2) {
        		resultList.add(value);
        	}
        } else if(sortedList2.isEmpty()) {
        	for(T value:sortedList1) {
        		resultList.add(value);
        	}
        }
    	return resultList;	    	
    }
    
    private static <T extends Comparable<T>> void addValueFromOneListToOther(T from,
			 T to, Iterator<T> toIterator, List<T> resultList ) {
		 //theres at least two elements in the first list that have not been added. Only one element(value2) needs to be added from list 2
       if(from.compareTo(to) <= 0) {
           resultList.add(from);
           resultList.add(to);
           while(toIterator.hasNext()) {
               resultList.add(toIterator.next());
           }
       } else {
           resultList.add(to);
           boolean hasAddedFrom = false;
           while(toIterator.hasNext()) {
               T nextValue = toIterator.next();
               if(from.compareTo(nextValue) <= 0) {
                   resultList.add(from);
                   hasAddedFrom = true;
               }
               //no matter what, this needs to execute
               resultList.add(nextValue);
           }
           //if not added, add it now(greatest element)
           if(!hasAddedFrom) {
        	   resultList.add(from);
           }
       }
	}
}
