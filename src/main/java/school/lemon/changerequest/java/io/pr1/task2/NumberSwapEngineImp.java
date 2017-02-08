package school.lemon.changerequest.java.io.pr1.task2;

import java.io.*;

/**
 * Created by User on 03.02.2017.
 */
public class NumberSwapEngineImp implements NumberSwapEngine {
    private static final String SEPARATOR = ",";

    @Override
    public boolean swapMinAndMax(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int min = 0;
        int countMin = 0;
        int max = 0;
        int countMax = 0;
        int temp;

        boolean firstMin = true;
        String[] result = null;
        String[] strins = null;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return true;
            } else if (line.length() < 2) {
                return true;
            }
            strins = line.split(SEPARATOR);
            result = strins.clone();
            for (int i = 0; i < strins.length; i++) {
                temp = Integer.parseInt(strins[i].trim());
                while (firstMin) {
                    min = temp;
                    firstMin = false;
                }
                if (temp > max) {
                    max = temp;
                    countMax = 1;
                } else if (temp < min) {
                    min = temp;
                    countMin = 1;
                } else if (temp == max) {
                    countMax++;
                } else if (temp == min) {
                    countMin++;
                }
            }
            if (countMax > countMin) {
                countMax = countMin;
            } else if (countMin > countMax) {
                countMin = countMax;
            }
            int[] mins = getIndexesOfMin(result, min, countMin);
            int[] maxs = getIndexesOfMax(result, max, countMax);
            for (int b = 0; b < result.length; b++) {
                temp = Integer.parseInt(result[b].trim());
                if (temp == max && countMin > 0) {
                    result[b] = strins[mins[countMin - 1]];
                    countMin--;
                }
                if (temp == min && countMax > 0) {
                    result[b] = strins[maxs[countMax - 1]];
                    countMax--;
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            String resultStr = String.join(SEPARATOR, result);
            bufferedWriter.newLine();
            bufferedWriter.write(resultStr);
            bufferedWriter.flush();
        } catch (IOException n) {
        }
        return !(result.equals(strins));
    }
    private int[] getIndexesOfMin(String[] strings, int min, int count) {
        int[] result = new int[count];
        for (int i = 0; i < strings.length; i++) {
            if (count == 0) {
                return result;
            }
            if (Integer.parseInt(strings[i].trim()) == min) {
                result[count - 1] = i;
                count--;
            }
        }
        return result;
    }
    private int[] getIndexesOfMax(String[] strings, int max, int count) {
        int[] result = new int[count];
        for (int i = 0; i < strings.length; i++) {
            if (count == 0) {
                return result;
            }
            if (Integer.parseInt(strings[i].trim()) == max) {
                result[count - 1] = i;
                count--;
            }
        }
        return result;
    }
}
