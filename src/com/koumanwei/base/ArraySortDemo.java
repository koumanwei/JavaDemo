package com.koumanwei.base;

/**
 * 2017-04-03 22:04
 *
 * @author koumanwei
 * @version 1
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 2, 3, 4, 5, 6, 8, 7, 9};
//        sort1(arr);
        sort2(arr);
        for (int i : arr) {

            System.out.print(i + " ");
        }
    }

    /**
     * 选择排序法
     *
     * @param arr
     */
    private static void sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // 思路和步骤：
        // 写方法的时候两个明确
        // 1、明确返回值，这个方法应该返回的是一个排好序的数组，但是因为是引用型的变量
        // 当主函数中arr赋给sort1中的变量arr时候，其实他们指向的是同一个数组，所以不需要返回值
        // 2、明确未知参数，位置参数就是数组

        // 首先取出数组0位置上的数，依次后面位置的数进行比较，把小的数放到0位置上，这样就能把数组中最小的数放到0位置上
        // 然后取1位置上的数，依次跟后面位置的相比较，依次类推
        // 但是取到最后一个数的时候，它后面没有可以比较的数，所以最后一个数不需要取出，所以外层循环的次数是数组的长度-1

        // 当取了0位置上的数时，就依次跟后面的书比较，1位置也是同理，比较的次数在依次递减
        // 也就是开始比较的角标在变化，不再是从0开始而是从取到的元素的后面一个数开始比较
        // 其实内层循环就是依次取出要比较的数，所以内层循环取出的第一个元素是外层循环取出的元素
        // 的角标+1
    }

    /**
     * 冒泡排序法
     *
     * @param arr
     */
    private static void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 思路和步骤：
        // 首先0位置和1位置比，如果0位置上的数大于1位置上的数，那么就换位置
        // 这样就能将最大的数放到最后一个位置上，然后接着从0开始和1比，依次类推

        // 首先是遍历0-最后一个，然后是0-最后一个-1
        // 当遍历到1位置上的数时，就不用遍历了，所以外层循环的次数是数组的长度-1

        // 而内层循环是每两个元素比较的次数
        // -1是为了避免越界，-i是为了让外循环增加一次，内循环参与比较的元素的个数递减
    }
}
