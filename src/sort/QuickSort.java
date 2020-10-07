package sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 6, 10, 9, 3, 1, 6, 2, 4, 11, 9};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }
    public static void quickSort(int[] arr, int upper, int lower) {
        int left = upper;
        int right = lower;
        int mid = left + (right - left) / 2;
        // 中轴
        int pivot = arr[mid];
        int temp;

        // 小于pivot的放在左边，大于pivot的放在右边
        while(left < right) {
            // 在pivot左边找到大于他的值
            while(arr[left] < pivot) {
                left++;
            }
            // 在pivot右边找到小于他的值
            while(arr[right] > pivot) {
                right--;
            }
            // left >= right, 说明pivot两边已经满足条件
            if(left >= right) {
                break;
            }

            // 交换
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            if(arr[left] == pivot) {
                right--;
            }
            if(arr[right] == pivot) {
                left++;
            }
        }
        if(left == right) {
            left++;
            right--;

        }
        if(left < right) {

        }
        quickSort(arr, 0, mid - 1);
        quickSort(arr, mid + 1, arr.length - 1);
    }
}
