
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.NoSuchElementException;
import java.util.Optional;
public class filter {
    private static Map<Integer, String> name_map = new TreeMap<>();
    private static Map<Integer, String> serNum_map = new TreeMap<>();
    private static Map<Integer, String> cost_map = new TreeMap<>();
    private static Map<Integer, String> ord_map = new TreeMap<>();
    private static Map<Integer, String> color_map = new TreeMap<>();
    private static Map<Integer, String> os_map = new TreeMap<>();
    private static Map<Integer, laptop> lap_map = new TreeMap<>();
    


public static  Queue<Integer> SortedMap(Map<Integer, String> map) {
    Queue<Integer> sorted = new LinkedList<Integer>();
    Set<Map.Entry<Integer, String>> set = new HashSet<>(sortedByValues(map));
    for (Map.Entry<Integer, String> s : set){
        Integer i = s.getKey();
        sorted.add(i);
    }
    return sorted;
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
    Queue<Integer> q = new LinkedList<Integer>();
    switch (choice) {
        case 1 -> {
            q = SortedMap(name_map);
            for (Integer i : q) {
                System.out.println(lap_map.get(i));                
            }
            }
        case 2 -> {
            q = SortedMap(serNum_map);
            for (Integer i : q) {
                System.out.println(lap_map.get(i));
            }
            }
        case 3 -> {
            q = SortedMap(cost_map);
            System.out.println("Введите минимальное значение:");
            Integer min_cost =Integer.getInteger(filterMethods.getChoice());
            for (Integer i : q) {
                if (Integer.getInteger(lap_map.get(i).getCost()) >= min_cost) System.out.println(lap_map.get(i));
            }
            }
        case 4 -> {
            q = SortedMap(ord_map);
            System.out.println("Введите минимальное значение:");
            Integer min_ord =Integer.getInteger(filterMethods.getChoice());
            for (Integer i : q) {
                if (Integer.getInteger(lap_map.get(i).getORD()) >= min_ord) System.out.println(lap_map.get(i));
            }
            }
        case 5 -> {
            q = SortedMap(color_map);
            System.out.println("Введите цвет:");
            String color =filterMethods.getChoice().toLowerCase();
            for (Integer i : q) {
                if ((lap_map.get(i).getColor().toLowerCase()).equals(color)) System.out.println(lap_map.get(i));
            }
            }
        case 6 -> {
            q = SortedMap(os_map);
            System.out.println("Введите ОС:");
            String os =filterMethods.getChoice().toLowerCase();
            for (Integer i : q) {
                if ((lap_map.get(i).getOs().toLowerCase()).equals(os)) System.out.println(lap_map.get(i));
            }
            }
        default -> {
            choice = 1;
            
        }
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