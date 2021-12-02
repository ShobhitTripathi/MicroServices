package filesHandler;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.UserInfo;

public class CSVWriter1 {

    public  void writeDataLineByLine (String filePath, UserInfo userInfo) {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Name", "DOB", "Salary", "Age" };
            writer.writeNext(header);

            // add data to csv
            String[] data1 = {
                    userInfo.getName(),
                    userInfo.getDob(),
                    userInfo.getSalary(),
                    userInfo.getAge()};
            writer.writeNext(data1);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}
