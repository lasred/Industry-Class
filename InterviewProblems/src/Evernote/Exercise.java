import java.io.*;
import java.util.*;


public class Exercise {

    static class WordFrequency implements Comparable<WordFrequency> {
        int frequency;
        String word;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public int compareTo(WordFrequency other) {
            return other.frequency - frequency;
        }
    }

   /*
     Return a list of the n most words in a file
   */
    public static List<String> getNMostFrequentWords(String contents, int n) {
        Map<String, Integer> wordToCount = getWordCounts(contents);
        Set<String> words = wordToCount.keySet();
        //need to store data in a data structure that can be accessed by index(top n)
        List<WordFrequency> indexedWordFrequency = new ArrayList<WordFrequency>();
        for(String word: words) {
            indexedWordFrequency.add(new WordFrequency(word, wordToCount.get(word)));
        }
        int leastFreqToMeetReq = quickSelectLargest(indexedWordFrequency, n, 0, indexedWordFrequency.size() - 1);
        //only contain words that meet the min freq requirement
        List<WordFrequency> afterProcessed = new ArrayList<WordFrequency>();
        for(int j=0;j<indexedWordFrequency.size();j++) {
            WordFrequency currWord = indexedWordFrequency.get(j);
            if(currWord.frequency >= leastFreqToMeetReq) {
                afterProcessed.add(currWord);
            }
        }
        Collections.sort(afterProcessed);
        List<String> wordsToReturn = new ArrayList<String>();
        for(int j=0;j<n;j++) {
            wordsToReturn.add(afterProcessed.get(j).word);
        }
        return wordsToReturn;
    }

    /*
      Return a map that maps a word to its frequency.
    */
    private static Map<String, Integer> getWordCounts(String contents) {
        String[] wordsToProcess = contents.split(" ");
        //counting occurrences of words
        Map<String, Integer> wordToCount = new HashMap<String, Integer>();
        for(String word: wordsToProcess) {
            if(wordToCount.containsKey(word)) {
                wordToCount.put(word, wordToCount.get(word) + 1);
            } else {
              wordToCount.put(word, 1);
            }
        }
        return wordToCount;
    }

    /*
      Returns the frequency of the kth most frequent word
    */
    private static int quickSelectLargest(List<WordFrequency> wordToFreq, int k, int start, int end) {
      int partitionIndex = partition(wordToFreq, start, end);
      if(end - partitionIndex == k - 1) {
        return wordToFreq.get(partitionIndex).frequency;
      } else if (end - partitionIndex < k - 1) {
        return quickSelectLargest(wordToFreq, k - (end - partitionIndex + 1), start, partitionIndex - 1);
      } else {
        return quickSelectLargest(wordToFreq, k, partitionIndex + 1, end);
      }
    }

    /*
      Does the partitioning portion of the quickselect algorithm
    */
    private static int partition(List<WordFrequency> wordToFreq, int start, int end) {
      int pivotFreq = wordToFreq.get(start).frequency;
      swapValue(wordToFreq, start, end);
      int left = start;
      int right = end -1;
      while(right > left) {
        //everything to left of pivot is less, right is more
        while(right >= 0 && wordToFreq.get(right).frequency > pivotFreq) {
          right --;
        }
        while(left < end && wordToFreq.get(left).frequency < pivotFreq) {
          left ++;
        }
        if(left < right) {
          swapValue(wordToFreq, left, right);
        }
      }
      swapValue(wordToFreq, left, end);
      return left;
    }

    /*
      Swaps two values in a WordFrequency List
    */
    private static void swapValue(List<WordFrequency> wordToFreq, int fromIndex, int toIndex) {
      WordFrequency temp = wordToFreq.get(fromIndex);
      wordToFreq.set(fromIndex, wordToFreq.get(toIndex));
      wordToFreq.set(toIndex, temp);
    }

    public static void main(String[] args) {
      String testCase1 = "escaping escaping baby pain pain no pain no no falling baby no";
      getNMostFrequentWords(testCase1, 2);
      List<String> testCaseResult = getNMostFrequentWords(testCase1, 2);
      if(testCaseResult != null && testCaseResult.get(0).equals("no") && testCaseResult.get(1).equals("pain")) {
        System.out.println("Correct results for test case 1 :) ");
      } else {
        System.out.println("Incorrect results for test case 1 :( ");
      }
      String testCase2 = "ariana justin nick nick taylor justin ellie justin ellie ariana ellie nick justin nick justin";
      String[] expectedList2 = {"justin", "nick", "ellie", "ariana", "taylor"};
      List<String> expectedOutput2 = Arrays.asList(expectedList2);
      List<String> testCase2Result = getNMostFrequentWords(testCase2, 5);
      //equals should also test order
      if(expectedOutput2.equals(testCase2Result)) {
        System.out.println("Correct results for test case 2 :) ");
      } else {
        System.out.print("Incorrect results for test case 1 :(");
      }
      String testCase3 = "quizlet quizlet evernote word onenote quizlet evernote evernote dropbox evernote onenote onenote evernote word onenote";
      String[] expectedList3 = {"evernote","onenote","quizlet","word"};
      List<String> expectedOutput3 = Arrays.asList(expectedList3);
      List<String> testCase3Result = getNMostFrequentWords(testCase3, 4);
      if(expectedOutput3.equals(testCase3Result)) {
        System.out.println("Correct results for test case 3 :) ");
      } else {
        System.out.print("Incorrect results for test case 3 :(");
      }
   }
}

