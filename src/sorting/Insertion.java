package sorting;
import java.util.ArrayList;
import java.util.List;
import CDArchiveProject.CDRecord;

public class Insertion {
    public static void main(String[] args){
        List<CDRecord> records = new ArrayList<>();
        for( int i = 0; i< 20; i++){
            int randomBarcode = (int)(Math.random()*100);
            records.add(new CDRecord(randomBarcode));

        }
        System.out.println("Before sort: " + records.toString());
        Insertion.sort(records);
        System.out.println("After  sort: " + records.toString());
    }
    public static void sort(List<CDRecord> records){
        for(int index = 1; index< records.size(); index++){
            CDRecord indexRecord = records.get(index);
            int previousIndex = index - 1 ;
            while (previousIndex >= 0 && records.get(previousIndex).getBarcode() > indexRecord.getBarcode()){
                CDRecord previousRecord = records.get(previousIndex);
                records.set(previousIndex + 1, previousRecord);
                previousIndex--;
            }

            records.set(previousIndex + 1, indexRecord);

        }

    }
}
