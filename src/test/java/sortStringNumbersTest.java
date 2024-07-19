import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcode.sortStringNumbers;

public class sortStringNumbersTest {

    //Given: an array of numbers as strings, i.e., {"1", "5", "15", "9", "4"}
    //Task: sort the numbers
    //Restriction: the numbers must stay strings - no converting to integers

    sortStringNumbers s;

    @Before
    public void setUp() throws Exception {
        s = new sortStringNumbers();
    }

    @org.junit.Test
    public void testArraySort() {
        //Given - Starting Data
        String[] input = {"1", "5", "15", "9", "4"};
        sortStringNumbers s = new sortStringNumbers();
        String[] expected = {"1", "4", "5", "9", "15"};

        //When - Action
        String[] actual = s.sortNumbers(input);

        //Then - Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleTestWithDecimal() {
        //Given - Starting Data
        String[] input = {"1.001", "5.162", "15.742", "9.901", "4.002"};
        sortStringNumbers s = new sortStringNumbers();
        String[] expected = {"1.001", "4.002", "5.162", "9.901", "15.742", };

        //When - Action
        String[] actual = s.sortNumbers(input);

        //Then - Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTest() {
        //Given
        String s1 = "1";
        String s2 = "2";
        int expected = -1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void compareTestEqual() {
        //Given
        String s1 = "0";
        String s2 = "0";
        int expected = 0;

        //When
        int actual = s.compare(s1, s2);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTestGreaterThan() {
        //Given
        String s1 = "2";
        String s2 = "1";
        int expected = 1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTestLengthGreaterThan() {
        //Given
        String s1 = "10";
        String s2 = "2";
        int expected = 1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTestLengthLessThan() {
        //Given
        String s1 = "2";
        String s2 = "10";
        int expected = -1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCaseDecimal() {
        //Given
        String s1 = "1.000";
        String s2 = "0.02000";
        int expected = 1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        System.out.println("actual: " + actual);
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testEdgeCaseDecimalTest2() {
        //Given
        String s1 = "2.000";
        String s2 = "15.00";
        int expected = -1;

        //When
        int actual = s.compare(s1, s2);

        //Then
        System.out.println("actual: " + actual);
        Assert.assertTrue(actual < 0);
    }
}
