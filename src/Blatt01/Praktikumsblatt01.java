package Blatt01;

import java.util.Arrays;

public class Praktikumsblatt01 {
    public static void main(String[] args) {
        System.out.println(interval(3,-1));
        System.out.println(digitSum(-666));
        System.out.println(digitToString(8));
        System.out.println(intToString(-123));
        System.out.println(digitSumToString(-77777));
        System.out.println(isHarshad(777));
        computeHarshads(50);
        int[] testArray = {1, 2, -3, 4, -5, 6, -7, 8, -9, 8, 3, 2, -3, 8};
        int[] testArraySorted = {-9, -7, -5, -3, -3, 1, 2, 2, 3, 4, 6, 8, 8, 8};
        int[] palindromeArray = {5, 17, 88, 88, 17, 5};
        int[] sequenceTestArray = {80,0,1,0,11,72,0,0,37,12};
        int[] twoTimesTestArray = {2, 3, 4, 3, 7, 7, 4, 1, 2, 1};
        System.out.println(countNegatives(testArray));
        System.out.println(sumUpNegatives(testArray));
        System.out.println(maximum(testArray));
        System.out.println(countMaximum(testArray));
        System.out.println(isSorted(testArraySorted));
        System.out.println(checkArray(palindromeArray));
        System.out.println(toString(increaseArray(palindromeArray, 2)));
        System.out.println(toString(copyStartingValues(palindromeArray)));
        System.out.println(toString(selectNegatives(testArray)));
        System.out.println(toString(copyAndInvert(testArray)));
        System.out.println(toString(addArrays(testArray, testArraySorted)));
        System.out.println(countSequences(sequenceTestArray));
        System.out.println(twoTimes(twoTimesTestArray));
    }

    public static int interval(int a, int b) {
        int sum = 0;
        int min;
        int max;
        if (a > b) {
            min = b;
            max = a;
        } else {
            min = a;
            max = b;
        }
        for(int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    public static int digitSum(int x) {
        int sum = 0;
        int amount;

        if(x < 0) {
            amount = -x;
        } else {
            amount = x;
        }

        while(amount > 0) {
            sum += amount % 10;
            amount /= 10;
        }
        return sum;
    }

    public static String digitToString(int z1){
        switch (z1) {
            case 0: return "null";
            case 1: return "eins";
            case 2: return "zwei";
            case 3: return "drei";
            case 4: return "vier";
            case 5: return "fünf";
            case 6: return "sechs";
            case 7: return "sieben";
            case 8: return "acht";
            case 9: return "neun";
            default: return "";
        }
    }

    public static String intToString(int z) {
        String output = "";
        boolean negative = false;
        if (z < 0) {
            negative = true;
            z = -z;
        }

        // Für die letzte Stelle
        output = digitToString(z%10) + output;
        z /= 10;

        // Für alle anderen Stellen
        while(z > 0) {
            output = digitToString(z%10) + "-" + output;
            z /= 10;
        }

        if(negative) output = "minus-" + output;
        return output;
    }

    public static String digitSumToString(int x) {
        return intToString(digitSum(x));
    }

    public static boolean isHarshad(int z) {
        return z % digitSum(z) == 0;
    }

    public static void computeHarshads(int n) {
        for (int i = 1; i <= n; i++) {
            if(isHarshad(i)) {
                System.out.println(i + " is a Harshad number.");
            }
        }
    }

    // Vorbereitung auf Testat 1
    // 1) Werte zählen
    public static int countNegatives(int[] arr) {
        int count = 0;
        for(int i: arr) {
            if(i < 0) count++;
        }
        return count;
    }

    // 2) Werte aufsummieren
    public static int sumUpNegatives(int[] arr) {
        int sum = 0;
        for(int i: arr) {
            if(i < 0) sum += i;
        }
        return sum;
    }

    // 3) Bestimmen des Maximums in einem Feld
    public static int maximum(int[] arr) {
        int max = arr[0];
        for(int i: arr) {
            if(i > max) max = i;
        }
        return max;
    }

    // 4) Bestimmen der Häufigkeit des Maximums in einem Feld
    public static int countMaximum(int[] arr) {
        int max = arr[0];
        int count = 1;
        for(int i: arr) {
            if(i > max) {
                max = i;
                count = 1;
            } else if (i == max) {
                count++;
            }
        }
        return count;
    }

    // 5) Sortierung prüfen
    public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    // 6) Palindrome erkennen
    public static boolean checkArray(int[] arr){
        int front = 0;
        int end = arr.length - 1;
        while(front < end) {
            if (arr[front] != arr[end]) return false;
            front++;
            end--;
        }
        return true;
    }

    // 7) Erhöhen der Inhalte eines Feldes
    public static int[] increaseArray(int[] arr, int z) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] += z;
        }
        return arr;
    }

    // 8) Bedingtes Verdoppeln der Inhalte eines Feldes
    public static int[] doubleIfContainsPositive(int[] arr) {
        boolean containsPositive = false;
        for(int num: arr) {
            if (num > 0) {
                containsPositive = true;
                break;
            }
        }
        if(containsPositive) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    // 9) Erzeugen eines Textes
    public static String toString(int[] arr) {
        String output = "";
        for(int i = 0; i < arr.length; i++) {
            if(i < arr.length - 1) {
                output += arr[i] + ",";
            } else {
                output += arr[i];
            }
        }
        return output;
    }

    // 10) Erzeugen eines Feldes mit drei Elementen
    public static int[] copyStartingValues(int[] arr) {
        int copiedLength = 3;
        if(arr.length < 3) {
            copiedLength = arr.length;
        }
        int[] copiedArray = new int[copiedLength];
        for(int i = 0; i < copiedArray.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }

    // 11) Erzeugen eines Feldes mit ausgesuchten Inhalten
    public static int[] selectNegatives(int[] arr) {
        int size = countNegatives(arr);
        int[] negativesArray = new int[size];
        int index = 0;
        for(int num: arr) {
            if(num < 0) {
                negativesArray[index] = num;
                index++;
            }
        }
        return negativesArray;
    }

    // 12) Erzeugen eines Feldes mit invertiertem Inhalt
    public static int[] copyAndInvert(int[] arr) {
        int[] invertedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            invertedArray[arr.length - i -1] = arr[i];
        }
        return invertedArray;
    }

    // 13) Zusammenführen von Feldern
    public static int[] addArrays(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return new int[0];
        } else {
            int[] sumArray = new int[arr1.length];
            for(int i = 0; i < arr1.length; i++) {
                sumArray[i] = arr1[i] + arr2[i];
            }
            return sumArray;
        }
    }

    // 14) Zählen von Folgen
    public static int countSequences(int[] arr) {
        int count = 0;
        boolean firstInSequence = true;
        for (int num : arr) {
            if (num != 0 && firstInSequence) {
                count++;
                firstInSequence = false;
            } else if (num == 0) {
                firstInSequence = true;
            }
        }
        return count;
    }

    // 15) Analyse eines Feldes
    public static boolean twoTimes(int[] arr) {
        return false;
    }
}
