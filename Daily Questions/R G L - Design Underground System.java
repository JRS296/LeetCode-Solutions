//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/design-underground-system/description/

class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkIns = new HashMap<>();
    private Map<Pair<String, String>, int[]> times = new HashMap<>();
    
    public void checkIn(int id, String stationName, int t) {
      checkIns.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
      var startStation = checkIns.get(id).getKey();
      var startTime = checkIns.get(id).getValue();
      checkIns.remove(id);
  
      var pair = new Pair(startStation, stationName);
      var totalTime = times.containsKey(pair) ? times.get(pair)[0] : 0;
      var dataPoints = times.containsKey(pair) ? times.get(pair)[1] : 0;
  
      times.put(pair, new int[] {totalTime + t - startTime, dataPoints + 1});
    }
    
    public double getAverageTime(String startStation, String endStation) {
      var pair = new Pair(startStation, endStation);
  
      return (double) times.get(pair)[0] / times.get(pair)[1];
    }
  }

/*

 */