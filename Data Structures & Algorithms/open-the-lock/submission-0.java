class Solution {
    public int openLock(String[] deadends, String target) {
         Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );

        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );

        Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        Queue<String> pendingCombinations = new LinkedList<>();
        int turns = 0;
        if (visitedCombinations.contains("0000")) {
            return -1;
        }
        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while(!pendingCombinations.isEmpty()) {
            int currentLevel = pendingCombinations.size();

            for(int i = 0; i < currentLevel; i++) {
                String currentCombinations = pendingCombinations.poll();

                if(currentCombinations.equals(target)) {
                    return turns;
                }

                for(int j = 0; j < 4; j++) {
                    StringBuilder newCombination = new StringBuilder(currentCombinations);
                    newCombination.setCharAt(j, nextSlot.get(newCombination.charAt(j)));

                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }

                    newCombination = new StringBuilder(currentCombinations);
                    newCombination.setCharAt(j, prevSlot.get(newCombination.charAt(j)));
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }
                }
            }
            turns++;
        }
    return -1;
    }
}