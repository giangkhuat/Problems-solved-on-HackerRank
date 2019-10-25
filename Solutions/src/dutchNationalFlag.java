class dutchNationalFlag {
  public void swap(int i, int j, int[] arr) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public void sortColors(int[] arr) {
    if (arr.length == 0) {
      return;
    }
    int lo = 0, mid = 0;
    int hi = arr.length - 1;
    while (mid <= hi) {
      if (arr[mid] == 0) {
        swap(mid, lo, arr);
        mid++;
        lo++;
      } else if (arr[mid] == 1) {
        mid++;
      } else if (arr[mid] == 2) {
        swap(mid, hi, arr);
        hi--;
      }
    }
  }
}
