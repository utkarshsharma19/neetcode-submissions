class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        String t = transform(s);
        int[] p = new int [t.length()];
        int center = 0; 
        int right = 0;
        int bestcenter = 0;
        int bestLen = 0;

        for(int i = 1; i < t.length() - 1; i++) {
            int mirror = 2 * center - i;

            if(i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

              while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > bestLen) {
                bestLen = p[i];
                bestcenter = i;
            }
        }
        int start = (bestcenter - bestLen) / 2;    
        return s.substring(start, start + bestLen);
    }

   private String transform(String s) {
        StringBuilder sb = new StringBuilder(2 * s.length() + 3);
        sb.append('^');                
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#$");               
        return sb.toString();
    }
}
