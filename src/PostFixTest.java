import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostFixTest {
	
	// Testing finger-exercises 

	@Test
	void test_a() throws StackUnderflow, StackOverflow {
		assertEquals(5, PostFix.evaluate("1 2 * 3 +"));
		}
	
	
	@Test
	void test_b() throws StackUnderflow, StackOverflow {
		assertEquals(7, PostFix.evaluate("1 2 3 * +"));

	}
	
	@Test
	void test_c() throws StackUnderflow, StackOverflow {
			assertEquals(-78, PostFix.evaluate("1 2 + 3 4 ^ -"));
	}
	
	@Test
	void test_d() throws StackUnderflow, StackOverflow {
        assertEquals(-11, PostFix.evaluate("1 2 ^ 3 4 * -"));

	}
	
	@Test
	void test_e() throws StackUnderflow, StackOverflow {
		assertEquals(-1011, PostFix.evaluate("1 2 3 * + 4 5 ^ - 6 +"));

	}
	
	@Test
	void test_f() throws StackUnderflow, StackOverflow {
		assertEquals(9.25, PostFix.evaluate("1 2 + 3 * 4 5 6 - ^ +"));

	}
	
	@Test
	void test_g() throws StackUnderflow, StackOverflow {
		assertEquals(98.75, PostFix.evaluate("1 2 + 3 4 / + 5 + 6 7 8 + * +"));

	}
	
	@Test
	void test_h() throws StackUnderflow, StackOverflow {
		assertEquals(-1, PostFix.evaluate("9 1 - 2 - 3 2 * - 1 -"));

	}
	
	// infixToPostfix test cases
	
	@Test
	void test_1() throws StackUnderflow, StackOverflow {
		assertEquals("1 2 * 3 +", PostFix.infixToPostfix("1 * 2 + 3"));

	}
	
	
	
	
	

}
