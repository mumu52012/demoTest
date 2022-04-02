import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Letcode {
    public static void main(String[] args) {
        Letcode letcode = new Letcode();
//        System.out.println(letcode.lengthOfLongestSubstring("dvdf"));
        int[] nums1=new int[]{1,3};
        int[] nums2=new int[]{2,6};
        System.out.println(letcode.zhong(nums1,nums2));
        System.out.println(letcode.zhong(nums1,nums2));
        System.out.println(letcode.zhong(nums1,nums2));
        System.out.println(letcode.zhong(nums1,nums2));
    }

    public int lengthOfLongestSubstring1(String s) {
        ArrayList<Character> str = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList();
        for (char i : s.toCharArray()) {
            int n = str.indexOf(i);
            if (n != -1) {
                len.add(str.size());
                str.subList(0, n + 1).clear();
                str.add(i);
                continue;
            } else
                str.add(i);

        }
        len.add(str.size());
        len.sort(Comparator.naturalOrder());
        return len.get(len.size() - 1);
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        int[] temp = new int[128];

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(0));
            int index = s.charAt(i);

            start = Math.max(start, temp[index]);
            result = Math.max(result, i - start + 1);
            temp[index] = i + 1;
        }


        return result;
    }

    public float zhong(int[] nums1, int[] nums2) {
        ArrayList<Integer> numSum = new ArrayList<>();
        for (int i : nums1)
            numSum.add(i);
        for (int i : nums2)
            numSum.add(i);
        numSum.sort(Comparator.naturalOrder());
        if (numSum.size() % 2 != 0)
            return numSum.get(numSum.size() / 2);
        else
            return (numSum.get(numSum.size() / 2)+numSum.get(numSum.size() / 2-1))/(float)2;

    }
}

