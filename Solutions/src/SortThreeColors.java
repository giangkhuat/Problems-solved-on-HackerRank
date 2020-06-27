class SortThreeColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int hi = nums.length - 1;
        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap (nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, hi);
                hi--;
            }
        }
        
    }
    public static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}