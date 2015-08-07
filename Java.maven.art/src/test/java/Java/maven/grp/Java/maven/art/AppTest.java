package Java.maven.grp.Java.maven.art;



import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;

import org.junit.Before;

import Java.maven.grp.Java.maven.art.RemoveDuplicates;




/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
   
    
    public void testApp()
    {
        assertTrue( true );
    }
    private RemoveDuplicates r; 
    
    public void testduplcate() {
		int[] arr = new int[] { 1, 2, 3, 3, 4, 5,5,5,6 };
		r = new RemoveDuplicates();
		int[] resultArr = r.removeduplicates(arr);
		
		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6,0,0,0},  resultArr);
	
	}

	
	public void testAllDuplicate() {
		int[] arr = new int[] { 1, 1, 1, 1, 1, 1 };
		r = new RemoveDuplicates();
		int[] resultArr = r.removeduplicates(arr);
		
		assertArrayEquals(new int[] {1,0,0,0,0,0},  resultArr);
	}

	
	public void testNoDuplicates() {
		int[] arr = new int[] { 1, 2, 1, 3, 1, 5 };
		r = new RemoveDuplicates();
		int[] resultArr = r.removeduplicates(arr);
		
		assertArrayEquals(new int[] { 1, 2, 1, 3, 1, 5 },  resultArr);
	}
	
	
	public void testRemovalOnEmptyArr() {
		int[] arr = new int[0]; // { 1, 2, 1, 3, 1, 5 };
		r = new RemoveDuplicates();
		int[] resultArr = r.removeduplicates(arr);
		
		assertArrayEquals(new int[0],  resultArr);
	}

}
