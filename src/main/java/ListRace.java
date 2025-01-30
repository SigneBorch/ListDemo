

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListRace {

    public static void main(String[] args) throws FileNotFoundException {
        //Test med List - prøv at skifte ArrayList ud med en LinkedList for at se forskel i performance
        List<String> list = new ArrayList<>();
        ListRace listRace = new ListRace(list);
        listRace.fillList();
        listRace.removeFirst();
    }

    private List list;

    public ListRace(List<String> list) {
        this.list = list;
    }

    public void fillList(){
        long before = System.currentTimeMillis();
        try {
            Scanner in = new Scanner(new File("src/main/resources/MobyDick.txt"));

            while (in.hasNext()) {
                String word = in.next();
                list.add(word);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        long after = System.currentTimeMillis();
        long millis = after - before;
        System.out.println("It took " + millis + " milliseconds to fill the list.");
        System.out.println("The book is this long: " + list.size() + " words.");
    }

    public void removeFirst() {
        Iterator it = list.iterator();
        long before = System.currentTimeMillis();
        while (it.hasNext()) {
            list.remove(0);
        }
        long after = System.currentTimeMillis();
        long millis = after - before;
        System.out.println("It took " + millis + " milliseconds to run the removeFirst.");
    }
}