import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner kb = new Scanner(System.in);
        ArrayList <ArrayList> cards = inputToList(kb);
        //sort hands using outer list
        //for (int x=0; x < cards.size(); x++){
         //   cards.set(x, insertionSort(cards.get(x)));
        //}
        for (ArrayList hand: cards) {
            insertionSort(hand);
        }
        printList(cards);
    }

    static ArrayList insertionSort(ArrayList a) throws IndexOutOfBoundsException{
        int j = 1;
        while (j < a.size()){
            String key = (String)a.get(j);
            int i = j -1;
            while (i > -1 && (cardValue((String)a.get(i)) > cardValue(key))){
                a.set(i+1, a.get(i));
                i = i -1;
            }
            a.set(i+1, key);
            j = j+1;
        }
       return a;
    }

    static void printList(ArrayList <ArrayList> cards){
        for (ArrayList hand : cards) {
            printHand(hand);
            System.out.println();
        }
    }

    static void printHand(ArrayList hand){
        for (Object o : hand) {
            System.out.print(o + " ");
        }
    }

    static ArrayList inputToList(Scanner kb){
        ArrayList <ArrayList> cards = new ArrayList<>(); //store 5 card hands
        String str = kb.next().trim();
        do{
            //create a hand - arraylist of 5 strings
            ArrayList <String> hand = new ArrayList<>();
            for (int x=0; x<5; x++){//add only 5 cards to hand
                hand.add(str);
                str = kb.next().trim();
            }
            //add hand to cards arraylist
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

