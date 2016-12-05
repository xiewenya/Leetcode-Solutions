package LeetCode.hard;

/**
 * Created by bresai on 2016/11/29.
 */
// TODO: 2016/11/29 not passed yet
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median1, median2;
        median1 = getMedian(nums1);
        median2 = getMedian(nums2);
        if (median1 == 0.0){
            return median2;
        }
        if (median2 == 0.0){
            return median1;
        }
        return (getMedian(nums1) + getMedian(nums2))/2.0;
    }

    private double getMedian(int[] array){
        double median;
        if (array.length == 0){
            return 0.0;
        }
        if (array.length == 1){
            return array[0];
        }
        if (array.length % 2 == 0){
            median = (array[array.length/2 - 1] +  array[array.length/2])/2.0;
        }else{
            median = array[array.length/2];
        }
        return median;
    }

    public static void main(String[] args){
        MedianOfTwoSortedArray object = new MedianOfTwoSortedArray();
        int[] nums1 = {};
        int[] nums2 = {1,2,3,4,5};
        System.out.println(object.findMedianSortedArrays(nums1, nums2));
    }
}
