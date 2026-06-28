class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String, List<String>> allComboDict = new HashMap<>();
    for (String word : wordList) {
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
            List<String> transformation = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformation.add(word);
            allComboDict.put(newWord, transformation);
        }
    }

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<>();
        while(!q.isEmpty()) {
            Pair<String, Integer> node = q.poll();
            String word = node.getKey();
            int level = node.getValue();

            for(int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);


                for(String adjWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if(adjWord.equals(endWord)) {
                        return level + 1;
                    }

                    if(!visited.containsKey(adjWord)) {
                        visited.put(adjWord, true);
                        q.add(new Pair(adjWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
