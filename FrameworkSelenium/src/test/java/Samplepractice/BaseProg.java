package Samplepractice;

//import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		//duplicate elements in array
		int[] arr = {1,5,8,9,6,3,1,5,3,4,8,9};
		int flag = 0;
		for(int i=0; i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[j]);
					flag++;
				}
			}
		}
//		System.out.println("count of numbers repeating:"+flag);
		//extract a word from a string
//		String word = "This is just a sample code";
//		String seart = "sample";
//		if(word.contains(seart))
//		{
//			int y = word.indexOf(seart);
//			System.out.println(y);
//			String u = word.substring(y, y+(seart.length()));
//			System.out.println(u);
//		}
//		
		//-------------sorting array--------------
//		int[] arr = {5,2,8,6,3,4};
//		Arrays.sort(arr);
//		for(int i=arr.length -1; i>=0; i--)
//		{
//			System.out.print(arr[i]);
//		}
//		System.out.println("Ascending order:"+Arrays.toString(	arr));
//		
		//count number of words repeated
//		String str = "defeat the defeat before it defeat you and you are on to it";
//		String[] words = str.split("\\s");
//		Map<String, Integer> wordcount = new HashMap<>();
//		for(String word: words) 
//		{
//			wordcount.put(word, wordcount.getOrDefault(word, 0)+1);
//		}
//		for(Map.Entry<String, Integer> entry: wordcount.entrySet())
//		{
//			System.out.println(entry.getKey()+": "+ entry.getValue());
//		}
		
		
//		//check for anagram
//		String str1 = "listen";
//		String str2 = "silent";
//		char ch1[] = str1.toCharArray();
//		char ch2[] = str2.toCharArray();
//		Arrays.sort(ch1);
//		Arrays.sort(ch2);
//		if(Arrays.equals(ch1, ch2))
//		{
//			System.out.println("Anagram");
//		}
//		else
//		{
//			System.out.println("Not an Anagram");
//		}			
		
		//largest & smallest number in array
//		int[] arr = {1,5,89,6,5,26,7};
//		int larg = arr[0];
//		for(int i=1;i<arr.length;i++)
//		{
//			if(larg<arr[i])
//			{
//				larg=arr[i];
//			}
//		}
//		System.out.println(larg);
		
		//Sorting an array
//		int[] arr = {4,5,8,9,6,7,1};
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		//--------vowels and consonants count-----------
//		String str = "Silambarasan TRA";
//		str = str.toLowerCase();
//		int vowels = 0, consonants = 0;
//		for(int i=0; i<str.length();i++)
//		{
//			char ch = str.charAt(i);
//			if(ch >= 'a' && ch <= 'z')
//			{
//				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
//				{
//					vowels++;
//				}
//				else
//				{
//					consonants++;
//				}
//			}
//		}
//		System.out.println("Vowels: "+vowels);
//		System.out.println("Consonants: "+consonants);
		//---------Prime number-------------------
//		int num = 17;
//		boolean isprime = true;
//		for(int i=2; i<= num/2; i++)
//		{
//			if(num %i ==0)
//			{
//				isprime = false;
//				break;
//			}
//		}
//		System.out.println(isprime);
		
		//--------Factorial number ---------------------------
//		int num = 5, fact = 1;
//		for(int i=1; i<=num;i++)
//		{
//			fact *=i;
//		}
//		System.out.println(fact);
		
		//--------------Fibonacci series-----------------------
//		int n=10;
//		int a = 0, b= 1;
//		System.out.print("Fib Series:"+a+", "+b);
//		for(int i=2; i<n;i++)
//		{
//			int c = a + b;
//			System.out.print(", "+c);
//			a=b;
//			b=c;
//		}

//		//----------------String Reversal & Palindrome --------------------
//		String str = "MAdaM is ready for development";
//		String strr = "";
//		//using string builder
//		StringBuilder strr1 = new StringBuilder(str).reverse();
//		str = strr1.toString();
//		System.out.println(strr1);
////		for(int i=str.length() - 1;i>=0;i--)
////		{
////			strr += str.charAt(i);
////		}
////		System.out.println(strr);
//		
//		
//		if(str.equalsIgnoreCase(strr))
//		{
//			System.out.println("Palindrome");
//		}
//		else
//		{
//			System.out.println("Not Palindrome");
//		}
//		
//		
//	}
	}
}
