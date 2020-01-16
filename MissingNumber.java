public class MissingNumber {

    // Time: O(N) | Space: O(N)
    public static int getMissingNumber(int[] nums){

        // Declare an list of values to represent the range of nums, initializing it with false as default
        boolean[] A = new boolean[nums.length+1];

        // For values that exist in nums, toggle the position of that value in A to true
        for (int i = 0; i < nums.length; i++){
            A[nums[i]] = true;
        }

        // For values that is false, it means that it doesnt exist, so simply return it
        for (int i = 0; i < A.length; i++) {
            if (A[i] == false) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(getMissingNumber(nums));
    }

}