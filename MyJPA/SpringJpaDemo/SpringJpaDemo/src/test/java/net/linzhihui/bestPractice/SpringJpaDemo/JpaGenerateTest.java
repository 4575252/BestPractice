package net.linzhihui.bestPractice.SpringJpaDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class JpaGenerateTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JpaGenerateTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JpaGenerateTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	JpaGenerate t = new JpaGenerate();
		t.generate();
		
        assertTrue( true );
    }
}
