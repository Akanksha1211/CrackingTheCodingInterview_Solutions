package com.arraystring.akanksha;

import java.util.Arrays;

public class ArrayandString {

	boolean IsUniqueChar(String input){
		if(input.length()>128){
			return false;
		}
		else{
			boolean chars[]=new boolean[128];
			
			for(int i=0;i<input.length();i++){
				int val=input.charAt(i);
				if(chars[val]){
					return false;
				}
				chars[val]=true;
			}
		}
		return true;
	}
	
	boolean isPermutation(String a, String b){
		
		if(a.length()!=b.length()){
			return false;
		}
		
			char[] a_new=a.toCharArray();
			char[] b_new=b.toCharArray();
		
		Arrays.sort(a_new);
		Arrays.sort(b_new);
		
		return String.valueOf(a_new).equals(String.valueOf(b_new));
	
	}
	
	public String replaceSpace(String a){
		
		String b=a.trim();
		String value = b.replace(" ", "%20");
		return value;
	}
	
	public boolean permutatePalindrome(String string) {
		int length=string.length();
		boolean chars[]=new boolean[26];
		String s_new=string.toLowerCase();
		int count=0;
		for(int i=0;i<length;i++){
			
			if(s_new.charAt(i)==' '){
				continue;
			}
			
			int value=s_new.charAt(i)-'a';
			if(chars[value]){
				chars[value]=false;
				count--;
			}
			else{
				chars[value]=true;
				count++;
			}
				
		}
		
		if(count==0 && length%2==0){
			return true;
		}
		if(count==1 && length%2==1){
			return true;
		}
		else{
			return false;
		}
	
	}
	
	public boolean oneAway(String string1, String string2) {
		int a=string1.trim().length();
		int b=string2.trim().length();		
		boolean foundValue=false;
		
		int c=Math.abs(a-b);
		System.out.println(c);
		String smaller;
		String longer;
		int smallindex=0;
		int longindex=0;
		
		if(c>1){
			return false;
		}
		
		if(a>b){
			smaller=string2.trim();
			longer=string1.trim();
		}
		else{
			longer=string2.trim();
			smaller=string1.trim();
		}
		
		while(smallindex<smaller.length() && longindex<longer.length()){
			if(smaller.charAt(smallindex)!=longer.charAt(longindex)){
				if(foundValue)
					return false;
				foundValue=true;
				
				if(smaller.length()==longer.length()){
					smallindex++;
				}

					
			}else{
				smallindex++;
			}
			longindex++;
		}
		
		return true;
		
	}
	
	public String stringCompression(String oldString){
		int countConsecutive=0;
		StringBuilder newString=new StringBuilder();
		for(int i=0;i<oldString.length();i++){
			countConsecutive++;
			if(i+1>=oldString.length() || oldString.charAt(i)!=oldString.charAt(i+1)){
				newString.append(oldString.charAt(i));
				newString.append(countConsecutive);
				countConsecutive=0;
			}	
		}
		
		if(oldString.length()<newString.toString().length()){
			return oldString;
		}else{
			return newString.toString();
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Question1
		ArrayandString temp=new ArrayandString();
		boolean val=temp.IsUniqueChar("abc");
		//System.out.println(val);
		
		//Question2
		boolean per=temp.isPermutation("abcd", "bcsa");
		//System.out.println(per);
		
		//Question 3
		String new_s=temp.replaceSpace("fgfdg gdfgfg gfdgdfg      ");
		//System.out.println(new_s);
		
		//Question 4
		//Permutation Tact Coa
		boolean temp1=temp.permutatePalindrome("TactCa");
		//System.out.println(temp1);
		
		//Question 5
		boolean away=temp.oneAway("dale","pale");
		//System.out.println(away);
		
		//
		String compressedString=temp.stringCompression("aaabbbbcccdddd");
		System.out.println(compressedString);
	}

}
