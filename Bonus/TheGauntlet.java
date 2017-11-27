import java.util.Arrays;


public class TheGauntlet {

	public static void main(String[] args) {
		if (! testConAndPrint()){
			System.out.println("Constructor and Print Failure");
		}
		else if (! testLength()){
			System.out.println("Length Failure");
		}
		else if (! testCharAt()){
			System.out.println("CharAt Failure");
		}
		else if (! testCharArray()){
			System.out.println("toCharArray Failure");
		} else if (! testIndexOf()){
			System.out.println("indexOf Failure");
		}
		else if (! testEquals()){
			System.out.println("Equals Failure");
		}
		else if (! testSubString()){
			System.out.println("SubString Failure");
		}
		else if (! testStartsWith()){
			System.out.println("Startswith Failure");
		}
		else if (! testConcat()){
			System.out.println("Concat Failure");
		} else if (! testTrim()){
			System.out.println("Trim Failure");
		}
		else if (! splitTest()){
			System.out.println("Split Failure");
		}
		else{
			System.out.println("You finished! That's amazing!");
		}

	}

	public static boolean testConAndPrint(){
		try{
			System.out.println("Visual Test");
			System.out.print("'");
			new MyString().print();
			System.out.println("' should be ''");
			char[] a = "abc".toCharArray();
			MyString abc = new MyString(a);
			a[0] = '?'; a[1] = '?'; a[2] = '?';
			abc.print();
			System.out.print( " should be abc\ndefg should be ");
			new MyString("defg".toCharArray()).println();
			new MyString("I Should be on a seperate line".toCharArray()).println();
			System.out.println("End Visual Test\n\n");
			return true;
		}
		catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testLength(){
		try{
			String s = "The Quick Brown Fox Jumped Over the Lazy Dog";
			if ( s.length() != new MyString(s.toCharArray()).getLength()){
				return false;
			}
			if (new MyString().getLength() != 0){
				return false;
			}
			return true;

		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testCharAt(){
		try{
			String s = "The Quick Brown Fox Jumped Over the Lazy Dog";
			MyString ms = new MyString(s.toCharArray());
			for (int i = 0; i < s.length(); i++){
				if (s.charAt(i) != ms.charAt(i)){

					return false;
				}
			}
			try{
				ms.charAt(-4);
				System.out.println("Accepts bad index");
				return false;
			}catch(IndexOutOfBoundsException e){
				//happy path
			}
			try{
				ms.charAt(50);
				System.out.println("Accepts bad index");
				return false;
			}catch(IndexOutOfBoundsException e){
				//happy path
			}
			return true;

		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testCharArray(){
		try{
			String s = "Hello, World!";
			MyString example = new MyString(s.toCharArray());
			if (! Arrays.equals(s.toCharArray(), example.toCharArray())){
				return false;
			}
			if ( example.toCharArray() == example.toCharArray()){
				System.out.println("Not a new array!");
				return false;
			}
			char[] array = example.toCharArray();
			array[1] = '?';
			if (example.charAt(1) == '?'){
				System.out.println("Vodoo Magic!");
				return false;
			}
			return true;
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}


	public static boolean testIndexOf(){
		try{
			String s = "The Quick Brown Fox Jumped Over the Lazy Dog";
			MyString ms = new MyString(s.toCharArray());
			for (char l = 'a'; l <= 'z'; l++){
				if (s.indexOf(l) != ms.indexOf(l)){

					return false;
				}
			}

			return true;
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testEquals(){
		try{
			String a = "ab1c";
			String b = "ab2c";
			String c = "ab";
			if (new MyString(a.toCharArray()).equals(new MyString(b.toCharArray()))){
				return false;
			}
			if (!new MyString(a.toCharArray()).equals(new MyString(a.toCharArray()))){
				return false;
			}
			if (new MyString(a.toCharArray()).equals(new MyString(c.toCharArray()))){
				return false;
			}
			return true;

		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testSubString(){
		try { 
			String s = "The Idler Wheel is Wiser";
			MyString ms = new MyString(s.toCharArray());
			for (int i = 0; i <= s.length(); i++){
				for (int j = 0; j <= i; j++){
					try{
						if (!Arrays.equals(
								ms.substring(j, i).toCharArray(), 
								s.substring(j, i).toCharArray())){
							System.out.printf("Indexes %d to %d\n", i, j);
							return false;
						}
					}catch( Exception e){
						e.printStackTrace();
						System.out.printf("Indexes %d %d\n", i, j);
						return false;
					}
				}
			}
			return true;

		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testStartsWith(){
		try{
			MyString s1 = new MyString("Fresh Fish".toCharArray());
			MyString s2 = new MyString("Fat Fish".toCharArray());
			MyString s3 = new MyString("Fresh".toCharArray());
			if ( ! s1.startsWith(s3)){
				return false;
			}
			if ( s2.startsWith(s3)){
				return false;
			}
			return true;
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testConcat(){
		try{
			String[] srcs = "The Idler Wheel Is Wiser Than The Turning of the Screw".split(" ");
			for (String s1 : srcs) for (String s2: srcs){
				String s = s1 + s2;
				MyString ms = new MyString(s1.toCharArray()).concat(
						new MyString(s2.toCharArray()));
				if (! Arrays.equals(s.toCharArray(), ms.toCharArray())){
					return false;
				}
			}
			return true;
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean testTrim(){
		try{
			MyString ms = new MyString(" \t\nabc\n\t ".toCharArray());
			MyString trim = ms.trim();
			if (trim.getLength() != 3){
				System.out.println("Trim Length Failure");
				return false;
			}
			if (!trim.equals(trim.trim())){
				return false;
			}
			MyString empty = new MyString(new char[]{});
			MyString almostEmpty = new MyString(new char[]{' '});
			if (! empty.trim().equals(almostEmpty.trim())){
				return false;
			}

			return true;
		}catch( Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean splitTest(){
		try{
			String s = "The Idler Wheel is Wiser than the Turning of the Screw, and Whipping Cords Will Serve You More Than Ropes Will Ever Do";
			String[] ss = s.split("er");
			MyString[] mss = new MyString(s.toCharArray()).split(new MyString("er".toCharArray()));
			if (ss.length != mss.length){
				System.out.println("Different Number of Splits");
				return false;
			}
			for (int i = 0; i < ss.length; i++){
				if (! Arrays.equals(ss[i].toCharArray(), mss[i].toCharArray()))
					return false;
			}
			return true;

		}catch( Exception e){
			e.printStackTrace();
			return false;
		}

	}
}
