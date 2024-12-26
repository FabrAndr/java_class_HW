import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class filterMethods {

    public static void main(String[] args) {
        while (true) { 
            showMenu();
        }

    }

    public static void   showMenu() {
            Map<Integer, String > map = new HashMap<>(createMenuFilter());
            showFilter(map);
            System.out.println("Для выхода введите 'exit'");
            String o = getChoice();
            try {
                Integer i = Integer.valueOf(o); 
                filter.chooseFilterMap(i);
            } catch (NumberFormatException e) {
                if (o.equals("exit")) System.exit(0);            
                else {
                    System.out.printf("Something wrong, you write '%s'", o);
                }
            }
        }
    
    public static Map<Integer, String> createMenuFilter() {
        Map<Integer, String> filter = new HashMap<>();
        filter.put(1, "Имя");
        filter.put(2, "Серийный номер");
        filter.put(3, "Стоимость");
        filter.put(4, "ОЗУ");
        filter.put(5, "Цвет");
        filter.put(6, "Опеационная система");
        
        return filter;
    }

    public static void showFilter(Map<Integer, String> filter){
        for (int i = 1; i < filter.size(); i++) {
            System.out.printf("Для фильтрации объектов используя '%s' введите %d; \n", filter.get(i), i);
        }
    }

    public static String getChoice() {
        System.out.println("Введите команду");
        String choice = "";
        Scanner scan = new Scanner(System.in);
        try{
            choice = scan.next();  
       } catch (Exception e) {
        System.out.println(e);
       } 
       return choice;
    }
    
}
