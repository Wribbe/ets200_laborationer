package wb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NextDateTest {
	
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

	NextDate next_date = null;

	@Before
	public void setUp() throws Exception {
		next_date = new NextDate(0,0,0);
	}

	@After
	public void tearDown() throws Exception {
		next_date = null;
	}


	@Test
	public void test() {
	}
}