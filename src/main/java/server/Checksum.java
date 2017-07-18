package server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksum {
	// calculate checksum
	public static String CalChecksum(byte[] bytesOfData) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(bytesOfData);
		byte digest[] = md.digest();
		return convertToString(digest);
	}

	public static String convertToString(byte byteChecksum[]) {
		// convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteChecksum.length; i++) {
			sb.append(Integer.toString((byteChecksum[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
