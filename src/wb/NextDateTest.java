package wb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NextDateTest {
	
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