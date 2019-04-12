import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner kb = new Scanner(System.in);
            ArrayList<String[]> cards = inputToList(kb);
            for (String[] hand : cards) {
                insertionSort(hand);
            }
            printList(cards);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    static void insertionSort(String[] a) throws IndexOutOfBoundsException{
        int j = 1;
        while (j < a.length){
            String key = (String)Array.get(a, j);
            int i = j -1;
            while (i > -1 && (cardValue((String)Array.get(a, i)) > cardValue(key))){
                Array.set(a,i+1, Array.get(a, i));
                i = i -1;
            }
            Array.set(a, i+1, key);
            j = j+1;
        }
    }

    static void printList(ArrayList <String []> cards){
        for (String[] hand : cards) {
            printHand(hand);
        }
    }

    static void printHand(String[] hand){
        for (int i = 0; i < hand.length-1; i++) {
            Object o = hand[i];
            System.out.print(o + " ");
        }
        System.out.print(hand[hand.length-1] + "\n");
    }

    static ArrayList <String[]> inputToList(Scanner kb){
        ArrayList <String []> cards = new ArrayList<>();
        String str = kb.next().trim();
        do{
            //create a hand - array of 5 strings
            String[] hand = new String[5];
            for (int x=0; x<5; x++) {//add only 5 cards to hand
                hand[x] = str;
                str = kb.next().trim();
            }
            cards.add(hand);
        }while(!str.equals("00")); //leave when no more cards
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
                val = 200;
                break;
            case "H":
                val = 100;
                break;
            case "S":
                val = 0;
                break;
            case "D":
                val = 300;
        }
        return val;
    }

}