package sorting;
import CDArchiveProject.CDRecord;
import java.util.ArrayList;
import java.util.List;

// Arrays:
// getting a value at index: int foo = array[index]
// setting a value at index: array[index] = foo
// array.length
// Lists:
// getting a value: int foo = list.get(index)
// setting a value: list.set(index, foo)
// list.size()
public class Selection {
    public static void main(String[] args) {
        List<CDRecord> records = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomBarcode = (int) (Math.random() * 100);
            records.add(new CDRecord(randomBarcode));

        }

        System.out.println("Before sort : " + records.toString());
        Selection.sort(records);
        System.out.println("After sort : " + records.toString());
    }
    public static void sort(List<CDRecord> records){
        for (int index = 0; index < records.size() - 1 ; index++ ) {
            int smallest_index = index;
            for (int current_index = index + 1; current_index < records.size(); current_index++) {
                if (records.get(current_index).getBarcode() < records.get(smallest_index).getBarcode()) {

                    smallest_index = current_index;

                }
            }

            CDRecord smallest_record = records.get(smallest_index);
            CDRecord index_record = records.get(index);
            records.set(index, smallest_record);
            records.set(smallest_index, index_record);

        }
    }

}
