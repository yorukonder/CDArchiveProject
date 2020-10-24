package sorting;

import CDArchiveProject.CDRecord;

import java.util.ArrayList;
import java.util.List;

public class Bubble {

    public static void main(String[] args) {
        List<CDRecord> records = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomBarcode = (int)(Math.random() * 100);
            records.add(new CDRecord(randomBarcode));
        }

        System.out.println("Before sort: " + records.toString());
        Bubble.sort(records);
        System.out.println("After sort: " + records.toString());

    }

    public static void sort(List<CDRecord> records) {
        // Write sorting logic here



        boolean swapped = true;

        while (swapped){
            swapped = false;
            for(int i = 0 ; i < records.size() - 1; i++){
                if (records.get(i).getBarcode() > records.get(i+1).getBarcode() ){
                    CDRecord a = records.get(i+1);
                    CDRecord b = records.get(i);
                    records.set(i+1, b);
                    records.set(i, a);
                    swapped = true;


                }
            }
        }
    }

}
