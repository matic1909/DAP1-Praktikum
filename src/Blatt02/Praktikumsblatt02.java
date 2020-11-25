package Blatt02;

public class Praktikumsblatt02 {
  public static void main(String[] args) {
    Fraction[] testArray = {new Fraction(1, -4), new Fraction(2, 3), new Fraction(-1, 4), new Fraction(2, 3), new Fraction(3, 5)};
    Fraction[] sortedArray = {new Fraction(1, 6), new Fraction(1, 5), new Fraction(1, 4), new Fraction(1, 3)};
    Fraction[] sequenceArray = {new Fraction(1, 6), new Fraction(1, 5), new Fraction(0, 2), new Fraction(1, 4), new Fraction(0, 4), new Fraction(0, 1), new Fraction(1, 3)};
    System.out.println(toString(testArray));
    System.out.println(countNegatives(testArray).toString());
    System.out.println(sumUpNegatives(testArray).toString());
    System.out.println(maximum(testArray));
    System.out.println(countMaximum(testArray).toString());
    System.out.println(isSorted(sortedArray));
    //System.out.println(toString(increaseArray(testArray, new Fraction(1, 2))));
    System.out.println(toString(doubleIfContainsPositive(testArray)));
    System.out.println(toString(selectNegatives(testArray)));
    System.out.println(countSequences(sequenceArray));
  }

  public static Fraction countNegatives(Fraction[] arr) {
    int count = 0;
    for (Fraction f : arr) {
      if (f.toDouble() < 0) count++;
    }
    return new Fraction(count);
  }

  public static Fraction sumUpNegatives(Fraction[] arr) {
    Fraction sum = new Fraction(0);
    for (Fraction f : arr) {
      if (f.toDouble() < 0) {
        sum = sum.add(f);
      }
    }
    return sum;
  }

  public static Fraction maximum(Fraction[] arr) {
    Fraction max = arr[0];
    for(Fraction f: arr) {
      if(f.toDouble() > max.toDouble()) max = f;
    }
    return max;
  }

  public static Fraction countMaximum(Fraction[] arr) {
    Fraction max = arr[0];
    int count = 1;
    for(Fraction f: arr) {
      if(f.toDouble() > max.toDouble()) {
        max = f;
        count = 1;
      } else if (f.equals(max)) {
        count++;
      }
    }
    return new Fraction(count);
  }

  public static boolean isSorted(Fraction[] arr) {
    for(int i = 0; i < arr.length -1; i++) {
      if(arr[i].toDouble() > arr[i + 1].toDouble()) return false;
    }
    return true;
  }

  public static Fraction[] increaseArray(Fraction[] arr, Fraction z) {
    for(int i = 0; i < arr.length; i++) {
      arr[i] = arr[i].add(z);
    }
    return arr;
  }

  public static Fraction[] doubleIfContainsPositive(Fraction[] arr) {
    boolean containsPositive = false;
    for(Fraction f: arr) {
      if (f.toDouble() > 0) {
        containsPositive = true;
        break;
      }

    }
    if(containsPositive) {
      for(int i = 0; i < arr.length; i++) {
        arr[i] = arr[i].add(arr[i]);
      }
    }
    return arr;
  }

  public static String toString(Fraction[] arr) {
    String output = "";
    for(Fraction f: arr) {
      output += f.toString() + ", ";
    }
    return output;
  }

  public static Fraction[] selectNegatives(Fraction[] arr){
    int size = (int) countNegatives(arr).toDouble();
    Fraction[] negatives = new Fraction[size];
    int index = 0;
    for(Fraction f: arr) {
      if(f.toDouble() < 0) {
        negatives[index] = f;
        index++;
      }
    }
    return negatives;
  }

  public static Fraction countSequences(Fraction[] arr) {
    int count = 0;
    boolean firstInSequence = true;
    for(Fraction f: arr) {
      if(f.toDouble() != 0 && firstInSequence) {
        count++;
        firstInSequence = false;
      } else if (f.toDouble() == 0) {
        firstInSequence = true;
      }
    }
    return new Fraction(count);
  }
}
