package school.lemon.changerequest.java.io.pr1.task3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 03.02.2017.
 */
public class CountEngineImp implements CountEngine {

    @Override
    public long countSpecificCharacter(String filename, char c) throws FileNotFoundException {

        long result = 0;
        File file = new File(filename);
        BufferedInputStream bis;
        FileInputStream fis;
        if (!file.exists()) throw new FileNotFoundException();
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            while (bis.available() > 0) {
                if ((char) bis.read() == c) result++;
            }
        } catch (IOException n) {
        }
        return result;
    }

    @Override
    public long countCharacters(String filename) throws FileNotFoundException {
        long result = 0;
        File file = new File(filename);
        BufferedInputStream bis;
        FileInputStream fis;
        if (!file.exists()) throw new FileNotFoundException();
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            while (bis.available() > 0) {
                bis.read();
                result++;
            }
        } catch (IOException n) {
        }
        return result;
    }

    @Override
    public long countWords(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        char c;
        int words = 0;
        int charForWords = 0;
        int spaces = 0;
        boolean wordWasCounted = false;
        boolean firstWord = true;
        Pattern charsP = Pattern.compile("[a-zA-Z0-9]");
        Pattern spacesP = Pattern.compile("[\n\\s]");
        Matcher charsM;
        Matcher spacesM;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            c = (char) bufferedInputStream.read();
            CharSequence str = Character.toString(c);
            while (bufferedInputStream.available() > 0) {
                charsM = charsP.matcher(str);
                spacesM = spacesP.matcher(str);
                if (spacesM.matches()) {
                        spaces++;
                        wordWasCounted = false;
                        charForWords = 0;
                } else if ((charsM.matches() && (spaces > 0) || firstWord)) {
                    firstWord = false;
                    charForWords++;
                    if (charForWords == 1 && !wordWasCounted) {
                        words++;
                        wordWasCounted = true;
                    }
                }
                c = (char) bufferedInputStream.read();
                str = Character.toString(c);
            }
        } catch (IOException n) {
        }
        return words;
    }

    @Override
    public long countParagraphs(String filename) throws FileNotFoundException {
        File file = new File(filename);
        int paragraphs = 0;
        boolean firstParagraph = true;
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            String contentLine = br.readLine();
            while (contentLine != null) {
                if (countWordsInLine(contentLine) > 2 && !firstParagraph) {
                    contentLine = br.readLine();
                    if (contentLine.isEmpty()) {
                        contentLine = br.readLine();
                        if (contentLine.isEmpty()) {
                            paragraphs++;
                        }
                    }
                } else if (countWordsInLine(contentLine) > 2 && firstParagraph) {
                    paragraphs++;
                    firstParagraph = false;
                }
                contentLine = br.readLine();
            }

        } catch (IOException n) {
        }
        return paragraphs;
    }

    private int countWordsInLine(String string) {
        int words = 0;
        int charForWords = 0;
        int spaces = 0;
        boolean wordWasCounted = false;
        boolean firstWord = true;
        char[] chars = string.toCharArray();
        CharSequence str = null;
        if (string.length() < 1) {
            return 0;
        } else {
            str = Character.toString(chars[0]);
        }
        Pattern charsP = Pattern.compile("[a-zA-Z0-9]");
        Pattern spacesP = Pattern.compile("[\n\\s]");
        Matcher charsM;
        Matcher spacesM;
        for (int i = 0; i < chars.length; i++) {
            charsM = charsP.matcher(str);
            spacesM = spacesP.matcher(str);
            if (spacesM.matches()) {
                spaces++;
                wordWasCounted = false;
                if (charForWords > 0) {
                    charForWords = 0;
                }
            } else if ((charsM.matches() && spaces > 0) || firstWord) {
                firstWord = false;
                charForWords++;
                if (charForWords == 1 && !wordWasCounted) {
                    words++;
                    wordWasCounted = true;
                }
            }
            str = Character.toString(chars[i]);
        }
        return words;
    }
}
