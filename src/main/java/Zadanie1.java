import java.util.Arrays;

public class Zadanie1 {

    public static void main(String[] args) {

        int arr[] = {20, 303, 3, 4, 25};
        System.out.println(check(arr, 49));

//        Given an array of numbers and a number k, determine if there are three entries in
//        the array which add up to the specified number k. For example, given [20, 303, 3,
//                4, 25] and k = 49, return true as 20 + 4 + 25 = 49.
    }

    private static boolean check(int[] arr, int target){


        arr = Arrays.stream(arr).sorted().toArray();

        int l, r, currentSum;

        for(int i = 0; i< arr.length - 2; i++){
            if(arr[i] > target){
                continue;
            }
            l = i+1;
            r= arr.length-1;
            currentSum = arr[i];
            for (int k = i+1; k< arr.length; k++){
                while(l!=r) {
                    if (arr[l] + arr[r] + currentSum > target) {
                        r -= 1;
                    } else if (arr[l] + arr[r] + currentSum < target) {
                        l += 1;
                    }
                    if (currentSum + arr[l] + arr[r] == target) {
//                            here we can see a numbers
                        System.out.println(currentSum +" " + arr[l] +" " + arr[r]);
                        return true;
                    }
                }
            }


        }
        return false;
    }
}
