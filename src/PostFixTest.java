import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostFixTest {
	
	// Testing finger-exercises 

	@Test
	void test_a() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();	
		assertEquals(5, a.evaluate("1 2 * 3 +"));
		}
	
	
	@Test
	void test_b() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
		assertEquals(7, a.evaluate("1 2 3 * +"));

	}
	
	@Test
	void test_c() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
			assertEquals(-78, a.evaluate("1 2 + 3 4 ^ -"));
	}
	
	@Test
	void test_d() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
        assertEquals(-11, a.evaluate("1 2 ^ 3 4 * -"));

	}
	
	@Test
	void test_e() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
		assertEquals(-1011, a.evaluate("1 2 3 * + 4 5 ^ - 6 +"));

	}
	
	@Test
	void test_f() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
		assertEquals(9.25, a.evaluate("1 2 + 3 * 4 5 6 - ^ +"));

	}
	
	@Test
	void test_g() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
		assertEquals(98.75, a.evaluate("1 2 + 3 4 / + 5 + 6 7 8 + * +"));

	}
	
	@Test
	void test_h() throws StackUnderflow, StackOverflow {
		PostFix a = new PostFix();
		assertEquals(-1, a.evaluate("9 1 - 2 - 3 2 * - 1 -"));

	}
	
	
	
	
	
	

}