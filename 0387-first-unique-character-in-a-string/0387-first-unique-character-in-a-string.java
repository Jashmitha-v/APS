class Solution {
    public int firstUniqChar(String s) {
        int i;
        int[]h= new int[26];
        for (char c:s.toCharArray())
        h[c-'a']++;
        for(i=0;i< s.length(); i++)
        {
            if (h [s.charAt(i)-'a']==1)
            return i;
        }
        return -1;
    }
}