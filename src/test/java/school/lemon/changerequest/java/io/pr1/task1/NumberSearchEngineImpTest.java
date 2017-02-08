package school.lemon.changerequest.java.io.pr1.task1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by User on 03.02.2017.
 */
public class NumberSearchEngineImpTest {
    static NumberSearchEngineImp searchEngineImp;
    static StringBuilder stringBuilder = new StringBuilder();


    private final String testString1 = stringBuilder.toString() + File.separator + "case1.dat";
    private final String testString2 = stringBuilder.toString() + File.separator + "case2.dat";

    @BeforeClass
    public static void setUp() {
        searchEngineImp = new NumberSearchEngineImp();
        stringBuilder.append("src");
        stringBuilder.append(File.separator);
        stringBuilder.append("test");
        stringBuilder.append(File.separator);
        stringBuilder.append("resources");
        stringBuilder.append(File.separator);
        stringBuilder.append("task1");

    }

    @Test
    public void SearchEngineCreated() {

        Assert.assertNotNull(searchEngineImp);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void ShouldThrowIndexOutOfBoundsException() throws FileNotFoundException {

        searchEngineImp.hasNumberWithIndex(testString1, testString1.length());

    }
    @Test(expected = FileNotFoundException.class)
    public void ShouldThrowFileNotFoundException() throws FileNotFoundException {

        searchEngineImp.hasNumberWithIndex("src/test/resources/task1/case4.dat", 4);

    }

    @Test
    public void ShouldReturnFalse() throws FileNotFoundException {

        Assert.assertFalse(searchEngineImp.hasNumberWithIndex(testString1, 5));
    }

    @Test
    public void ShouldReturnTrue() throws FileNotFoundException {

        Assert.assertTrue(searchEngineImp.hasNumberWithIndex(testString1, 6));
    }

}
