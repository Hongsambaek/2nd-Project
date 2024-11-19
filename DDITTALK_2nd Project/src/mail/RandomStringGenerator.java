package mail;

import java.security.SecureRandom;

public class RandomStringGenerator {
	// 사용할 문자 집합 정의
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@";
	private static final SecureRandom RANDOM = new SecureRandom();

	public static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = RANDOM.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(randomIndex));
		}
		return sb.toString();
	}
}