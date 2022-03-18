class Solution {
    public String longestCommonPrefix2(String[] strs) {
        int smallest_length = 1000;
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (smallest_length > strs[i].length()) {
                smallest_length = strs[i].length();
                index = i;
            }
        }
        int total = strs.length;
        for (int i = 0; i < smallest_length; i++) {
            int count = 0;
            for (int j = 0; j < total; j++) {
                if (strs[j].charAt(i) != strs[index].charAt(i)) {
                    i = 1000;
                    break;
                } else
                    count++;
            }
            if (count == total)
                result.append(strs[index].charAt(i));
        }
        return String.valueOf(result);

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {

                if (strs[j].length() - 1 < i || ch != strs[j].charAt(i))
                    return String.valueOf(result);
            }
            result.append(ch);
        }
        return String.valueOf(result);
    }
}