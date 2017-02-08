package school.lemon.changerequest.java.io.pr1.task3;

import org.junit.*;

import java.io.FileNotFoundException;

/**
 * Created by User on 03.02.2017.
 */
public class CountEngineImpTest {
    static CountEngine countEngine;
    private final String testString1 = "src/test/resources/task1/case1.dat";
    @BeforeClass
    public static void setUp(){
        countEngine= new CountEngineImp();
    }
    @Test
    public void CreateCounterImpl(){
        Assert.assertNotNull(countEngine);
    }
    @Test(expected = FileNotFoundException.class)
    public void countSpecificCharacterFileNotFound()throws FileNotFoundException{
        countEngine.countSpecificCharacter("src/test/resources/task3/case1.dat",'v');
    }
    @Test
    public  void  countSpecificCharacter()throws FileNotFoundException{
        Assert.assertEquals(5,countEngine.countSpecificCharacter("src/test/resources/task3/countSpecificCharacter.dat",'@'),0);
    }
    @Test(expected = FileNotFoundException.class)
    public void countCharactersFileNotFound()throws FileNotFoundException{
        countEngine.countCharacters("src/test/resources/task3/case1.dat");
    }

    @Test
    public  void  countCharacters()throws FileNotFoundException{

        Assert.assertEquals(13,countEngine.countCharacters("src/test/resources/task3/CountCharacters.dat"),0);
    }
    @Test
    public void countWords()throws FileNotFoundException{
        Assert.assertEquals(7,countEngine.countWords("src/test/resources/task3/countWords.dat"),0);

    }
    @Test
    public void countParagaphsEmpty()throws FileNotFoundException{
        Assert.assertEquals(0,countEngine.countParagraphs("src/test/resources/task3/countParagraphsEmpty.dat"));
    }
    @Test
    public void countParagaphs()throws FileNotFoundException{
        Assert.assertEquals(3,countEngine.countParagraphs("src/test/resources/task3/countParagraphs.dat"));
    }

}
