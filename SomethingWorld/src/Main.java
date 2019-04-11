import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner kb = new Scanner(System.in);
        ArrayList cards = inputToList(kb);
        //printList(cards);
        //cards.trimToSize();
        insertionSort(cards);
        printList(cards);
    }

    static ArrayList insertionSort(ArrayList a){
        for (int j=1; j<a.size(); j++){
           String key = (String)a.get(j);
           int i = j-1;
           while (i > -1 && (cardValue((String)a.get(i)) > cardValue(key))){
               a.set(i+1, a.get(i));
               i = i-1;
           }
           a.set(i+1, key);
       }
       return a;
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
        char temp = card.charAt(0);//get first value
        if (Character.isLetter(temp)) value += letterToVal(Character.toString(temp));
        else value += Integer.parseInt(Character.toString(temp));
        temp = card.charAt(1);
        if (Character.isLetter(temp)) value += letterToVal(Character.toString(temp));
        else value += Integer.parseInt(Character.toString(temp));
        return value;
    }

    static int letterToVal(String str){
        int val = 0;
        switch(str){
            case "A":
                val = 1;
                break;
            case "T":
                val = 10;
                break;
            case "J":
                val = 11;
                break;
            case "Q":
                val = 12;
                break;
            case "K":
                val = 13;
                break;
            case "C":
                val = 100;
                break;
            case "H":
                val = 200;
                break;
            case "S":
                val = 300;
                break;
        }
        return val;
    }

}

