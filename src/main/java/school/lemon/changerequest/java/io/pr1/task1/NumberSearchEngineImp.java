package school.lemon.changerequest.java.io.pr1.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.02.2017.
 */
public class NumberSearchEngineImp implements NumberSearchEngine {


    @Override
    public boolean hasNumberWithIndex(String filename, int index) throws FileNotFoundException, IndexOutOfBoundsException {

        if (filename.length() < index) throw new IndexOutOfBoundsException();
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String str = br.readLine();
            List<String> arrayList = new ArrayList<>();
            while (str != null) {
                arrayList.add(str);
                str = br.readLine();
            }
            try {
                int i = Integer.parseInt(arrayList.get(index));
            } catch (NumberFormatException n) {
                return false;
            }
        } catch (IOException n) {
        }
        return true;
    }
}

