import java.util.*;
public class ProblemSet10 {

    public static void main(String[] args) {
    }

    public static String[] fizzBuzz(int start, int end) {
        String [] changed = new String [end - start];
        int position = 0;
        if( start >= end){
            return null;
        } else {
            for( int i = start; i < end; i++ ){

                if( i % 3 == 0 && i % 5 == 0){
                    changed[position] = "FizzBuzz";
                    position++;
                } else if( i % 3 == 0){

                    changed[position] = "Fizz";
                    position++;
                } else if ( i % 5 == 0) {
                    changed[position] = "Buzz";
                    position++;
                } else {
                    changed[position] = Integer.toString(i);
                    position++;
                }
            }
            return changed;
        }
    }

    public static  int maxSpan(int[] numbers) {
        int maxSpan = 0;
        int span;
        int x;
        for(int i = 0; i < numbers.length; i++)
        {
            for(x = numbers.length - 1; numbers[i] != numbers[x]; x--);
            span = 1 + x - i;
            if(span > maxSpan)
                maxSpan = span;
        }
        return maxSpan;
    }

    public static int[] fix34(int[] numbers) {
        int threeX= 0;
        int fourX = 0;
        boolean threeY = true;
        boolean last = false;
        boolean fourY = false;
        for ( int i = 0; i < numbers.length; i++){
            if( numbers[i] == 3){
                threeX++;
            }
            if (numbers[i] == 3 && i < numbers.length -1 && numbers[i + 1] == 4){
                fourY = true;
            }
            if(numbers[i] == 4){
                fourX++;
            }
            if ( numbers[i] == 4 && threeX == 0){
                threeY = false;
            }
            if (numbers[numbers.length - 1] == 3){
                last = true;
            }
        }
        if(numbers == null || threeX != fourX || last || !threeY || fourY){
            return null ;
        } else {
            for (int j = 0; j < numbers.length-1; j++){
                int afterPosition = 0;
                if (numbers[j] == 3){
                    afterPosition = numbers[j+1];
                    for( int k = 0; k < numbers.length; k++){
                        if (numbers[k] == 4 && numbers[ k-1] != 3){
                            numbers[j+1] = numbers[k];
                            numbers[k] = afterPosition;
                            k = numbers.length;
                        }
                    }
                }

            }
            return numbers;
        }
    }

    public static int[] fix45(int[] numbers) {
        int fiveX= 0;
        int fourX = 0;
        boolean next = false;

        for ( int i = 0; i < numbers.length; i++){
            if( numbers[i] ==5){
                fiveX++;
            }

            if(numbers[i] == 4){
                fourX++;
            }


            if (i < numbers.length-1 && numbers[i] == 4 && numbers [i +1] == 4 ){
                next = true;
            }

        }
        if(numbers == null || fiveX != fourX || next || numbers[numbers.length-1] == 4){
            return null ;
        } else {
            for (int j = 0; j < numbers.length-1; j++){
                int afterPos = 0;

                if (numbers[j] == 4){
                    afterPos = numbers[j+1];
                    for( int k = 0; k < numbers.length; k++){
                        if (k == 0 && numbers[0] == 5){
                            numbers[j+1] = numbers[k];
                            numbers[k] = afterPos;
                            k = numbers.length;
                        } else if (numbers[k] == 5 && numbers[k-1] != 4 ){
                            numbers[j+1] = numbers[k];
                            numbers[k] = afterPos;
                            k = numbers.length;
                        }
                    }

                }

            }
            return numbers;
        }
    }

    public static boolean canBalance(int[] numbers) {
        if(numbers == null || numbers.length < 1 ){
            return false;
        } else {
            int total = 0;
            for(int i =  0; i < numbers.length; i++){
                total += numbers[i];
            }
            if ( total % 2 == 0){
                int half = 0;
                int mid = 0;
                for( int j = 0; j < numbers.length; j++){
                    half += numbers[j];
                    if (half >= (total / 2)) {
                        mid = j;
                        break;
                    }
                }
                int last = 0;
                for (int k = mid + 1; k < numbers.length; k++){
                    last += numbers[k];
                    if( half > total /2){
                        break;
                    }
                }
                if (last == half){
                    return true;
                }  else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean linearIn(int[] outer, int[] inner) {
        boolean OuterX = true;
        for (int i = 0; i < outer.length - 1; i++) {
            if (outer[i] > outer[i + 1]) {
                OuterX = false;
            }
        }
        boolean InnerX = true;
        for (int j = 0; j < inner.length - 1; j++) {
            if (inner[j] > inner[j + 1]) {
                InnerX = false;
            }
        }
        if (outer == null || outer == null || outer.length < 1 || inner.length < 1 || InnerX == false || OuterX == false) {
            return false;
        } else {
            boolean equal = false;
            int count = 0;
            for (int k = 0; k < inner.length; k++) {
                for (int l = 0; l < outer.length; l++) {
                    if (inner[k] == outer[l]) {
                        count++;
                    }
                }
            }
            if( count >= inner.length){
                return true;
            } else{
                return false;
            }
        }
    }

    public static int[] squareUp(int n) {
        int [] square = new int[n*n];
        if(n < 0 ){
            return null;
        } else {
            for( int i = n; i > 0; i--){
                for(int j = 1; j<= i ; j++ ){
                    square[n*i -j] = j;
                }
            }
            return square;
        }
    }

    public static int[] seriesUp(int n) {
        if(n < 0){
            return null;
        } else {
            int size = 0;
            for (int i = 0; i <= n; i++) {
                size += i;
            }
            int[] arr = new int[size];

            for (int i = n; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    arr[size - 1] = j;
                    size--;
                }
            }

            return arr;
        }
    }

    public static int maxMirror(int[] numbers) {
        int maximum = 0;
        if( numbers == null){
            return -1;
        } else {
            for(int start = 0; start < numbers.length; start++) {
                for(int begin = numbers.length - 1; begin >= 0; begin--) {
                    int size = 0;
                    int i = start;
                    int j = begin;

                    while(i < numbers.length && j >= 0 && numbers[i] == numbers[j]) {
                        size++;
                        i++;
                        j--;
                    }

                    maximum = Math.max(maximum, size);
                }
            }

            return maximum;
        }
    }

    public static int countClumps(int[] numbers) {
        if( numbers == null ){
            return -1;
        } else {
            int count = 0;
            for (int i = 0; i < numbers.length - 2; i++) {
                if (numbers[i] == numbers[i + 1]) {
                    count++;
                    if (numbers[i] == numbers[i + 2]) {
                        count--;
                    }
                }
            }
            if (numbers[numbers.length - 1] == numbers[numbers.length - 2]) {
                count++;
            }
            return count;
        }
    }
}