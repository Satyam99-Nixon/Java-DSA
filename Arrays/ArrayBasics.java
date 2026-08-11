public class ArrayBasics {

    public static void main(String[] args) {

        // Declare and initialize an array
        int[] arr = {10, 20, 30, 40, 50};

        // Print array elements
        System.out.println("Array Elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        // Find sum of array elements
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        System.out.println("Sum = " + sum);

        // Find maximum element
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Maximum = " + max);
    }
}