package assignment10;

public class MyString {
	private final String innerString;
	//allow charAt, substring, concat
	private final int length;
	public MyString(String s) {
		innerString = s;
		length = s.length();
	}
	
	
	public char charAt(int i) {
		return innerString.charAt(i);
	}
	
	public MyString subString(int from, int until) {
		return new MyString(innerString.substring(from, until));
	}
	
	public String getString() {
		//For testing/debugging only
		return innerString;
	}
	
	public MyString subString(int from) {
		return subString(from, length);
	}
	
	public MyString concat(MyString s) {
		return new MyString(innerString + s.innerString);
	}
	
	public boolean equals(MyString s) {
		if (length != s.length) return false;
		for (int i = 0; i < length; i++) {
			if (charAt(i) != s.charAt(i)) return false;
		}
		return true;
	}
	
	public int indexOf(char c) {
		for(int i = 0; i < length; i++) {
			if (charAt(i) == c) return i;
		}
		return -1;
	}
	public int indexOf(MyString s) {
		for(int i = 0; i + s.length <= length; i++) {
			if (subString(i, i + s.length).equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(MyString s) {
		return indexOf(s) != -1;
	}
	
	public MyString replace(MyString target, MyString replacement) {
		int index = indexOf(target);
		if ( index == -1) return this;
		else return subString(0, index).concat(replacement).concat(subString(index + target.length, length));
		
	}
	
	public MyString replaceAll(MyString target, MyString replacement) {
		MyString ret = this;
		while (ret.contains(target)) ret = ret.replace(target, replacement);
		return ret;
	}
	public boolean isPallendrome() {
		for (int i = 0; i < length - i - 1; i++) {
			if (charAt(i) != charAt(length - i - 1)) return false;
		}
		return true;
	}
}
