package assignment10;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class MyStringTest {

	@Test
	void testSubStringInt() {
		MyString empty = new MyString("");
		try {
			assertEquals(empty.subString(0).getString(), "");
		}catch (IndexOutOfBoundsException e) {
			fail("Substring does not index properly: " + e.getMessage());
		}
		
	}

	@Test
	void testEqualsMyString() {
		MyString copy1 = new MyString("test");
		MyString copy2 = new MyString("test");
		MyString spacy = new MyString("test ");
		assertTrue(copy1.equals(copy1));
		assertTrue(copy1.equals(copy2));
		assertFalse(copy1.equals(spacy));
	}

	@Test
	void testIndexOfChar() {
		MyString sample = new MyString("abczyx");
		assertEquals(sample.indexOf('a'), 0);
		assertEquals(sample.indexOf('c'), 2);
		assertEquals(sample.indexOf('w'), -1);
		assertEquals(sample.indexOf('y'), 4);
	}

	@Test
	void testIndexOfMyString() {
		MyString sample = new MyString("foo bar baz");
		assertEquals(sample.indexOf(new MyString("foo")), 0);
		assertEquals(sample.indexOf(new MyString("bar")), 4);
		assertEquals(sample.indexOf(new MyString("baz")), 8);
		assertEquals(sample.indexOf(new MyString(" ")), 3);
		assertEquals(sample.indexOf(new MyString("food")), -1);
	}

	@Test
	void testContains() {
		MyString sample = new MyString("By the power of loops, I, while living, have conquered the computer");
		assertTrue(sample.contains(new MyString("By")));
		assertTrue(sample.contains(new MyString("loops")));
		assertFalse(sample.contains(new MyString("recursion")));
	}

	@Test
	void testReplace() {
		 MyString start = new MyString("Three Blind Mice");
		 MyString desired = new MyString("Three White Mice");
		 MyString replacement = start.replace(new MyString("Blind"), new MyString("White"));
		 assertTrue(replacement.equals(desired));
	}

	@Test
	void testReplaceAll() {
		MyString start = new MyString("foo foo fo");
		MyString desired = new MyString("bar baz bar baz fo");
		MyString replacement = start.replaceAll(new MyString("foo"), new MyString("bar baz"));
		System.out.println(replacement.getString());
		assertTrue(replacement.equals(desired));
	}

	@Test
	void testIsPallendrome() {
		assertTrue(new MyString("dogeeseseegod").isPallendrome());
		assertTrue(new MyString("neveroddoreven").isPallendrome());
		assertFalse(new MyString("Madam, I'm Steven").isPallendrome());
	}

}
