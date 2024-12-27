import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class filterMethods {

    private final static Map<Integer, String> filterMenu= new HashMap<>();

    public static void main(String[] args) {
        while (true) { 
            showMenu();
        }

    }

    public static void   showMenu() {
            Map<Integer, String > map = new HashMap<>(createMenuFilter());
            showFilter(map);
            System.out.println("Для выхода введите 'exit' \nВведите команду ");
            String o = getChoice();
            try {
                Integer i = Integer.valueOf(o);
                if (i == 0 || i > filterMenu.keySet().size()) {
                    System.out.printf("Something wrong, you write '%d'\n", i);
                    showMenu();
                }
                filter.chooseFilterMap(i);
            } catch (NumberFormatException e) {
                if (o.equals("exit")) System.exit(0);            
                else {
                    System.out.printf("Something wrong, you write '%s'\n", o);
                }
            }
        }
    
    public static Map<Integer, String> createMenuFilter() {
        filterMenu.put(1, "Имя");
        filterMenu.put(2, "Серийный номер");
        filterMenu.put(3, "Стоимость");
        filterMenu.put(4, "ОЗУ");
        filterMenu.put(5, "Цвет");
        filterMenu.put(6, "Опеационная система");
        
        return filterMenu;
    }

    public static void showFilter(Map<Integer, String> filter){
        for (int i = 1; i < filter.size()+1; i++) {
            System.out.printf("Для фильтрации объектов используя '%s' введите %d; \n", filter.get(i), i);
        }
    }

    public static String getChoice() {

        String choice = "";
        Scanner scan = new Scanner(System.in);
        try {
            choice = scan.next();  
        } catch (Exception e) {
        System.out.println(e);
       } 
       return choice;
    }

}
