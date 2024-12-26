
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class filter {
    private static Map<Integer, String> name_map = new TreeMap<>();
    private static Map<Integer, String> serNum_map = new TreeMap<>();
    private static Map<Integer, String> cost_map = new TreeMap<>();
    private static Map<Integer, String> ord_map = new TreeMap<>();
    private static Map<Integer, String> color_map = new TreeMap<>();
    private static Map<Integer, String> os_map = new TreeMap<>();
    private static Map<Integer, laptop> lap_map = new TreeMap<>();
    


public static  void showSortedMap(Map<Integer, String> map) {
    Queue<Integer> sorted = new LinkedList<Integer>();
    Set<Map.Entry<Integer, String>> set = new HashSet<>(sortedByValues(map));
    for (Map.Entry<Integer, String> s : set){
        Integer i = s.getKey();
        sorted.add(i);
    }
    for (Integer i : sorted) {
        System.out.println(lap_map.get(i));
    }
}

public static void addNewLaptop(laptop lap) {
    name_map.put(lap.getIndex(), lap.getName());
    serNum_map.put(lap.getIndex(), lap.getSerialNumber());
    cost_map.put(lap.getIndex(), lap.getCost());
    ord_map.put(lap.getIndex(), lap.getORD());
    color_map.put(lap.getIndex(), lap.getColor());
    os_map.put(lap.getIndex(), lap.getOs());
    lap_map.put(lap.getIndex(), lap);
}

public static void chooseFilterMap( Integer choice){
    switch (choice) {
        case 1:
            showSortedMap(name_map);
            break;
        case 2:
            showSortedMap(serNum_map);
            break;
        case 3:
            showSortedMap(cost_map);
            break;
        case 4:
            showSortedMap(ord_map);
            break;
        case 5:
            showSortedMap(color_map);
            break;
        case 6:
            showSortedMap(os_map);
            break;
        default:
            throw new AssertionError();
    }
    
}

private static <K,V extends Comparable<? super V>>
SortedSet<Map.Entry<K,V>> sortedByValues(Map<K,V> map) {
    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
        new Comparator<Map.Entry<K,V>>() {
            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                int res = e1.getValue().compareTo(e2.getValue());
                return res != 0 ? res : 1;
            }
        }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
    }
}