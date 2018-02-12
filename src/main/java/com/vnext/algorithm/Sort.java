package com.vnext.algorithm;

import java.util.Arrays;

/**
 * 排序算法是《数据结构与算法》中最基本的算法之一.
 * 排序算法可以分为内部排序和外部排序，内部排序是数据记录在内存中进行排序，而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。
 * 关于稳定性：
 *    稳定的排序算法：冒泡排序、插入排序、归并排序和基数排序。
 *    不是稳定的排序算法：选择排序、快速排序、希尔排序、堆排序。
 * @author leo
 * @since 2018/2/11 17:55
 */
public class Sort {
    // https://github.com/hustcc/JS-Sorting-Algorithm

    /**
     * 冒泡排序
     * 算法步骤:
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] bubbleSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     *    选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     * 算法步骤
     *    1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     *    2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *    3.重复第二步，直到所有元素均排序完毕。
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] selectionSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * 算法步骤:
     * 1.将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     *     （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] insertSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    /**
     * 希尔排序:也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
            插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
            但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
     * 希尔排序的基本思想是：
     *      先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * 算法步骤:
     *      1.选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
     *      2.按增量序列个数 k，对序列进行 k 趟排序；
     *      3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
     *        仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] shellSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

    /**
     * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用
     * 算法步骤:
     * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * 4.重复步骤 3 直到某一指针达到序列尾；
     * 5.将另一序列剩下的所有元素直接复制到合并序列尾。
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] mergeSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }


    /**
     * 快速排序
     * 算法步骤：
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）;
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *      在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] quickSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quick(arr, 0, arr.length - 1);

    }

    private static int[] quick(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quick(arr, left, partitionIndex - 1);
            quick(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    /**
     堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
        堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
        堆排序可以说是一种利用堆的概念来排序的选择排序。

     分为两种方法：
        大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
        小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
     堆排序的平均时间复杂度为 Ο(nlogn)。
     算法步骤：
        创建一个堆 H[0……n-1]；
        把堆首（最大值）和堆尾互换；
        把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
        重复步骤 2，直到堆的尺寸为 1
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] heapSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    /**
     计数排序:
        计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
        作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] countingSort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     为了使桶排序更加高效，我们需要做到这两点：
        在额外空间充足的情况下，尽量增大桶的数量
        使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
        同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] bucketSort (int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return bucketSort(arr, 5);
    }

    private static int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     基数排序:
        是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
        由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数.
     基数排序 vs 计数排序 vs 桶排序
        这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
        基数排序：根据键值的每位数字来分配桶；
        计数排序：每个桶只存储单一键值；
        桶排序：每个桶存储一定范围的数值；
     * @param sourceArray 元数据
     * @return 返回数据
     */
    public static int[] radixSort (int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    protected static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], arr[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] source = new int[6];
        for (int i = 0; i < source.length; i++) {
            source[i] = (int) (Math.random() * 100);
        }
        long startTime = System.currentTimeMillis();
        int[] bubbleSort = bubbleSort(source);
        long endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int[] selectionSort = selectionSort(source);
        endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int[] insertSort = insertSort(source);
        endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int[] shellSort = shellSort(source);
        endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int[] mergeSort = mergeSort(source);
        endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime - startTime) + "ms");

    }


}
