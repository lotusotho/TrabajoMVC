package servicio;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Encryption {
	/**
	 * Encriptamos las contrasenas usando SHA-256,
	 * primero pasando las constrasenas a SHA y luego a hexadecimal
	 * Funciones basadas en el codigo de Baeldung en https://www.baeldung.com/sha-256-hashing-java
	 * @param passwd
	 * @return
	 */
	public String Encrypt(String passwd) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] encHash = md.digest(passwd.getBytes(StandardCharsets.UTF_8));
			return this.bytesToHex(encHash);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error";		
	}
	
	private String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		
		for(int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
}
