class Solution {
    HashSet<String> hs = new HashSet<>();
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // find the delimiter '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // length of the next string
            int len = Integer.parseInt(str.substring(i, j));

            // move to the start of actual string
            j++;

            // extract the string of length len
            String word = str.substring(j, j + len);
            result.add(word);

            // move i to the next encoded part
            i = j + len;
        }

        return result;
    }
}
