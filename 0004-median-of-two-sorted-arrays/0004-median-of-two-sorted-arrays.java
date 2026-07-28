class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int l = 0;
        int h = m;

        while (l <= h) {
            int c1 = (l + h) / 2;
            int c2 = totalLeft - c1;

            int l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[c1 - 1];
            int r1 = (c1 == m) ? Integer.MAX_VALUE : nums1[c1];

            int l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[c2 - 1];
            int r2 = (c2 == n) ? Integer.MAX_VALUE : nums2[c2];

            if (l1 <= r2 && l2 <= r1) {
                if (((m + n) % 2) == 0) {
                    int leftMax = Math.max(l1, l2);
                    int rightMin = Math.min(r1, r2);
                    return (leftMax + rightMin) / 2.0;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                h = c1 - 1;
            } else {
                l = c1 + 1;
            }
        }

        return 0.0;
    }
}
