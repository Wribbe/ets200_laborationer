package wb;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NextDateTest {

	static String invalid_date_short_path = "invalid Input Date";
	static String invalid_date = "Invalid Input Date";
	static String invalid_year = "Invalid Next Year";

	static int total_tests = 20;
	
	//static TestCase[] test_cases = new TestCase[total_tests+2];
	ArrayList<TestCase> test_cases = new ArrayList<TestCase>();

	TestCase t1 = new TestCase(-1,-1,-1, invalid_date_short_path);
	TestCase terror = new TestCase(5,5,2001, invalid_date_short_path);

	NextDate next_date = null;
	
	public class TestCase{
		String result;
		int month;
		int day;
		int year;
		
		public TestCase(int month, int day, int year, String result) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.result = result;
		}
	}

	int thirtyday = 4;
	int thirtyoneday = 1;
	int leap = 2016;
	int december = 12;
	int february = 2;

	@Before
	public void setUp() throws Exception {

		next_date = new NextDate(0,0,0);

		test_cases.add(new TestCase(10, -1, 2015, invalid_date_short_path)); 

		test_cases.add(new TestCase(thirtyoneday, 20, 2015, "1/21/2015")); 
		test_cases.add(new TestCase(thirtyoneday, 31, 2015, "2/1/2015")); 

		test_cases.add(new TestCase(thirtyday, 22, 2015, "4/23/2015")); 
		test_cases.add(new TestCase(thirtyday, 30, 2015, "5/1/2015")); 
		test_cases.add(new TestCase(thirtyday, 35, 2015, invalid_date));

		test_cases.add(new TestCase(december, 30, 2015, "12/31/2015"));
		test_cases.add(new TestCase(december, 31, 2015, "12/32/2015")); //BUG!
		test_cases.add(new TestCase(december, 33, 2015, "1/1/2016")); 
		test_cases.add(new TestCase(december, 33, 2021, invalid_year)); 

		test_cases.add(new TestCase(february, 22, 2015, "2/23/2015")); 
		test_cases.add(new TestCase(february, 29, 2016, "3/1/2016")); 
		test_cases.add(new TestCase(february, 29, 2015, invalid_date)); 
		test_cases.add(new TestCase(february, 30, 2015, invalid_date)); 
		test_cases.add(new TestCase(february, 28, 2016, "2/29/2016")); 
		test_cases.add(new TestCase(february, 28, 2015, "3/1/2015")); 

		test_cases.add(new TestCase(february, -2, 2015, invalid_date_short_path)); 
		test_cases.add(new TestCase(-2, 1, 2015, invalid_date_short_path)); 
		test_cases.add(new TestCase(13, 1, 2015, invalid_date_short_path)); 
		test_cases.add(new TestCase(1, 1, 1200, invalid_date_short_path)); 
		test_cases.add(new TestCase(1, 1, 3000, invalid_date_short_path)); 
	}

	@After
	public void tearDown() throws Exception {
		next_date = null;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	public String format(String format_string, Object... args) {
		return String.format(format_string, args);
	}
	
	public void run(int test_index) {
		TestCase test_case = test_cases.get(test_index);
		int day = test_case.day;
		int month = test_case.month;
		int year = test_case.year;
		String result_string = test_case.result;
		String format_string = "Input day=%d, month=%d, year=%d did not result in the output: \"%s.\"";
		String error_string = format(format_string, day, month, year, result_string);
		String return_string = next_date.run(month, day, year);
		assertEquals(error_string, result_string, return_string);
	}

	@Test
	public void test() {
		for (int i = 0; i < test_cases.size(); i++) {
			System.out.println(format("Running test case #%d.",i));
			run(i);
		}
	}
}