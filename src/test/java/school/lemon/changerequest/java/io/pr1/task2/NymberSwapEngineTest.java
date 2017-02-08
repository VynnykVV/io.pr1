package school.lemon.changerequest.java.io.pr1.task2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;
/**
 * Created by User on 03.02.2017.
 */
public class NymberSwapEngineTest {

    @Test
    public void test()throws  FileNotFoundException{
        NumberSwapEngine n=new NumberSwapEngineImp();
        Assert.assertTrue(n.swapMinAndMax("src/test/resources/task2/case.dat"));
        Assert.assertTrue(n.swapMinAndMax("src/test/resources/task2/case1.dat"));
        Assert.assertTrue(n.swapMinAndMax("src/test/resources/task2/case2.dat"));
        Assert.assertTrue(n.swapMinAndMax("src/test/resources/task2/case3.dat"));
        Assert.assertTrue(n.swapMinAndMax("src/test/resources/task2/emptyCase4.dat"));
    }

}