package CDArchiveProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecordsStorage {
    public static void main(String[] args) {
        List<CDRecord> records = LoadRecordList("records.data");
        // System.out.println(records);
    }
    public static List<CDRecord> LoadRecordList(String filepath){

        List<CDRecord> records = new ArrayList<>();
        try {

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataColumns = line.split(";");
                CDRecord record = new CDRecord(
//                        Integer.parseInt(dataColumns[0]),
                        dataColumns[1], dataColumns[2], dataColumns[3],
                        Integer.parseInt(dataColumns[4]),
                        Integer.parseInt(dataColumns[5]),
                        Integer.parseInt(dataColumns[6]),
                        dataColumns[7],
                        dataColumns[8].equalsIgnoreCase( "Yes")
                );
                records.add(record);
            }
        }
        catch (Exception e){
            System.err.println("Failed to load records: " + e.toString());
        }

        return records;
    }



    public static void SaveRecordList(String filepath, List<CDRecord> records) {

        // open file for writing
        // for each record
        // create string with members
        //write line to file
        // save and close file

    }


}
