package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] test = {4, 6, 8, 5, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(test);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 对给定数组进行排序
     * @param arr int[] 待排序数组
     */
    public void heapSort(int[] arr) {
        int len = arr.length;
        //获取完全二叉树中的非叶子节点
        for(int i = len / 2 - 1; i >= 0; i--) {
            buildHeap(arr, i, len);
        }
    }

    /**
     * 功能：将以i对应非叶子结点的子树构建成大顶堆
     * @param arr int[] 待调整的数组
     * @param i int 非叶子节点在数组中的索引
     * @param length int 表示对多少个元素进行构建, length是递减的
     */
    public void buildHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        //k = 2 * i + 1,k是i的左子节点
        for(int k=2*i+1; k<length; k=2*k+1) {
            //取左右子节点中的较大值与其下标
            if(k+1<length && arr[k] < arr[k+1]) {
                k++;
            }

            //子节点中的较大值大于父节点
            if(arr[k] > temp) {
                arr[i] = arr[k]; //将较大的子节点与父节点互换位置
                i = k;  //i指向k，相当于i从父节点指向大于父节点的那个子节点
            } else {
                //子节点都小于父节点，结束循环。
                // 因为子节点一定大于其子节点（堆是自下而上构建出来的）
                break;
            }
        }
        //将原子树根节点的值放到其最终位置
        arr[i] = temp;  // i=k负责每次发生交换后更新i的位置
    }
}
