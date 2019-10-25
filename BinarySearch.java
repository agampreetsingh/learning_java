import java.util.Scanner;

public class BinarySearch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the length of Array: ");
        int n = scanner.nextInt();

        System.out.println("Enter the element to be searched:");
        int element = scanner.nextInt();

        System.out.println("Enter array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int elementIndex = binarySearch(arr, element);

        if(elementIndex == -1){
            System.out.println("Not found");
        }else{
            System.out.println("Found Element Index: "+elementIndex);
        }

    }

    static int binarySearch(int[] arr, int element){
        int left = 0;
        int right = arr.length - 1;
         while(left <= right){
             int mid = (left + right) / 2;
             if(arr[mid] == element) return mid;
             if(arr[mid] > element)
             {
                 right = mid - 1;

             }else{

                 left = mid + 1;
             }
         }

         return -1;
    }
}
