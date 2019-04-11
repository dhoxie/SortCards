import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner kb = new Scanner(System.in);
        List cards = inputToList(kb);
    }

    static List inputToList(Scanner kb){
        ArrayList <String> cards = new ArrayList<>();
        String str = kb.next();
        do{
            cards.add(str);
            str = kb.next().trim();
        }while(!str.equals("00"));
        return cards;
    }

    int getValue(String card){
        
    }

}

