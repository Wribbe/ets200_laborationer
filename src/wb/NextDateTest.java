package wb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NextDateTest {

	String invalid_date_short_path = "invalid Input Date";
	String invalid_date = "Invalid Input Date";
	String invalid_year = "Invalid Next Year";

	int month_31 = 1;
	int month_30 = 4;
	int month_december = 12;
	int month_februari = 2;
	int month_invalid_high = 14;
	int month_invalid_low = -1;
	
	int day_30 = 30;
	int day_31 = 31;
	int day_sub_30 = 20;
	int day_post_31 = 35;
	int day_invalid_low = -1;
	int day_invalid_high = 50;

	int day_28 = 28;
	int day_sub_28 = 20;
	int day_29 = 29;
	int day_post_29 = 33;
	
	int year_invalid_high = 2021;
	int year_invalid_low = 1800;
	int year_valid_leap = 2016;
	int year_valid_non_leap = 2015;

	int total_tests = 20;
	
	TestCase[] test_cases = new TestCase[total_tests+1];

	TestCase t1 = new TestCase(-1,-1,-1, invalid_date_short_path);
	TestCase terror = new TestCase(5,5,2001, invalid_date_short_path);

	NextDate next_date = null;
	
	public class TestCase{
		String result;
		int month;
		int day;
		int year;
		
		public TestCase(int day, int month, int year, String result) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.result = result;
		}
	}

	@Before
	public void setUp() throws Exception {
		next_date = new NextDate(0,0,0);
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
	
	public void run(TestCase test_case) {
		int day = test_case.day;
		int month = test_case.month;
		int year = test_case.year;
		String result_string = test_case.result;
		String format_string = "Input day=%d, month=%d, year=%d did not result in the output: \"%s.\"";
		String error_string = format(format_string, day, month, year, result_string);
		boolean passed = next_date.run(day, month, year).equals(result_string);
		assertTrue(error_string, passed);
	}

	@Test
	public void test() {
		run(t1);
		run(terror);
	}
}