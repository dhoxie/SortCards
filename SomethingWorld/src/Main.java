import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner kb = new Scanner(System.in);
        ArrayList cards = inputToList(kb);
        cards.trimToSize();
        printList(insertionSort(cards));
    }

    static ArrayList insertionSort(ArrayList source){
        int i = 1;
        while ( i < source.size()){
            insertSorted((String)(source.get(i)), source, i);
            i++;
        }
        return source;
    }

    static ArrayList insertSorted(String s, ArrayList source, int i){
        int cur = i -1;
        int curVal = cardValue((String)source.get(cur));
        int iVal = cardValue((String)source.get(i));
        while ((cur >= 0) && (curVal > iVal)){
            source.set(cur + 1, source.get(cur));
            cur = cur - 1;
            curVal = cardValue((String)source.get(cur));
        }
        source.set(cur + 1, s);
        return source;
    }

    static void printList(ArrayList a){
        for (int i=0; i < a.size(); ){
            for (int x=0; x < 4; x++, i++){
                System.out.print(a.get(i) + " ");
            }
            System.out.print(a.get(i) + "\n");
            i++;
        }
    }

    static ArrayList inputToList(Scanner kb){
        ArrayList <String> cards = new ArrayList<>();
        String str = kb.next();
        do{
            cards.add(str);
            str = kb.next().trim();
        }while(!str.equals("00"));
        return cards;
    }

    static int cardValue(String card){
        int value = 0;
        String temp = card.substring(0, 1); //get first value
        if (isLetter(temp)) value += letterToVal(temp);
        else value += Integer.parseInt(temp);
        String temp2 = card.substring(1);
        if (isLetter(temp2)) value += letterToVal(temp2);
        else value += Integer.parseInt(temp2);
        return value;
    }

    static boolean isLetter(String str){
        final boolean b = str.equals("A") || str.equals("J") || str.equals("Q") || str.equals("K") || str.equals("D") || str.equals("C") || str.equals("H") || str.equals("S");
        return b;
    }

    static int letterToVal(String str){
        switch(str){
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "D":
                return 0;
            case "C":
                return 100;
            case "H":
                return 200;
            case "S":
                return 300;
        }
        return 0; //if str doesn't match any
    }

}

