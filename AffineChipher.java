//Name:Anirban Chatterjee
//Registration number:2241003014
//Section:2241035

import java.util.Scanner; 
 
public class AffineChipher { 
  
 static int k1 =7; 
 static int k2 =2; 
  
  
public static String encrypt(String plaintext) {
	String cipher=""; 
	for(int i =0;i<plaintext.length();i++) { 
		
		char ch= plaintext.charAt(i); 
		if(ch !=' ') { 
			int value = (int)ch -97; 
			int z =((value *k1)+k2)%26;   
			value= z+97; 
			cipher=cipher+ ((char)value); 
		
		} 
		else cipher=cipher+ " "; 
	} 
	return cipher; 
 
} 
  
  
public static String decrypt(String ciphertext) {
	int q=Inverse(k1); 
	String Decrypt_value=""; 
	for(int i = 0;i<ciphertext.length();i++) { 
    
		char ch=ciphertext.charAt(i); 
		if(ch != ' ') { 
			
			int value= (int)ch - 97; 
			int t=value-k2; 
			if(t<0) t+=26; 
			int z =t * q%26; 
			value=z+97; 
			Decrypt_value=Decrypt_value +((char)value); 
			
		} 
		else Decrypt_value=Decrypt_value +" "; 
	}	 
	return Decrypt_value; 
 
} 
  
  
public static int Inverse(int mod) {
	double  x=0; 
	for(int i=1;;i++) { 
		x=((26.0*i)+1)/k1; 
		if(x-((int) x)==0) { 
			break; 
		} 
	} 

	System.out.println((int)x); 
	return (int)x; 
 
} 
 
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in); 
	System.out.print("Enter a String :"); 
	String s= sc.nextLine().toLowerCase(); 
	String CipherText=encrypt(s); 
	System.out.println("Encrypted text : "+CipherText.toUpperCase()); 
	System.out.println("Decrypted text : "+decrypt(CipherText)); 
	sc.close();
 
	} 
 
}

