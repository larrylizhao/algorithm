package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] test = {4, 6, 8, 5, 9, 11, -3, 500, 12, 345};
        heapSort(test);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 对给定数组进行排序: 堆排序
     * @param arr int[] 待排序数组
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 获取完全二叉树中的非叶子节点
        // 从第一个非叶子节点开始对将数组构建成最大堆
        for(int i = len / 2 - 1; i >= 0; i--) {
            buildMaxHeap(arr, i, len);
        }

        // 交换堆顶和堆中最后一个元素，将堆的大小减1，
        // 对堆顶调用buildMaxHeap，保持最大堆结构
        for(int i = len - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildMaxHeap(arr, 0, i);
        }
    }

    /**
     * 功能：将以i对应非叶子结点的子树构建成大顶堆
     * 时间复杂度O(n)
     * @param arr int[] 待调整的数组
     * @param i int 非叶子节点在数组中的索引
     * @param length int 表示对多少个元素进行构建, length是递减的
     */
    public static void buildMaxHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        //k = 2 * i + 1,k是i的左子节点
        //https://www.bilibili.com/video/BV1EQ4y1K7Rp?from=search&seid=8888522138698460765 03:34 演示
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
                // 子节点都小于父节点，结束循环。
                // 因为该节点一定大于其子节点，所以不用继续向下比较（堆是自下而上构建出来的）
                break;
            }
        }
        //将原子树根节点的值放到其最终位置
        arr[i] = temp;  // i=k负责每次发生交换后更新i的位置
    }

    public void buildMinHeap() {

    }
}
