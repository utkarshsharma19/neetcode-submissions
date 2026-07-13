class Pair{
    String value;
    int timestamp;
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getKey() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) { 
        List<Pair> values = map.get(key);

        if (values == null) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;
        String result = "";
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
