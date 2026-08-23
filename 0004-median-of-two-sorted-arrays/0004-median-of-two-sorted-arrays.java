class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int elem1 = -1;
        int elem2 = -1;
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(count == ind1) elem1 = nums1[i];
                if(count == ind2) elem2 = nums1[i];
                i++;
                count++;
            }
            else{
                if(count == ind1) elem1 = nums2[j];
                if(count == ind2) elem2 = nums2[j];
                j++;
                count++;
            }
        }
        while(i < n1){
            if(count == ind1) elem1 = nums1[i];
            if(count == ind2) elem2 = nums1[i];
            i++;
            count++;
        }
        while(j < n2){
            if(count == ind1) elem1 = nums2[j];
            if(count == ind2) elem2 = nums2[j];
            j++;
            count++;
        }
        if(n % 2 != 0) return (double) elem2;
        else return (double) (elem1 + elem2) / 2;
    }
}