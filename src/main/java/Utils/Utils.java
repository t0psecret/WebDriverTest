package Utils;

import java.util.Random;

public class Utils {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final char[] LETTERS_ARRAY = LETTERS.toCharArray();
    private static final String SYMBOLS = LETTERS + NUMBERS;
    private static final char[] SYMBOLS_ARRAY = SYMBOLS.toCharArray();
    private static final String[] TOP_LEVEL_DOMAINS = {".com", ".ru", ".org", ".net"};

    private static final int MAX_SIZE_EMAIL = 15;
    private static final int MAX_SIZE_DOMAIN = 15;

    public static String generateRandomEMail() {
        StringBuilder email = new StringBuilder();
        email.append(randomEMailName());
        email.append('@');
        email.append(randomSecondLevelDomain());
        email.append(randomTopLevelDomain());
        return email.toString();
    }

    private static String randomTopLevelDomain() {
        return TOP_LEVEL_DOMAINS[new Random().nextInt(TOP_LEVEL_DOMAINS.length)];
    }

    private static String randomSecondLevelDomain() {
        StringBuilder domain = new StringBuilder(MAX_SIZE_DOMAIN);
        Random random = new Random();
        domain.append(LETTERS_ARRAY[random.nextInt(LETTERS_ARRAY.length)]);
        for (int i = 0; i < random.nextInt(MAX_SIZE_DOMAIN); i++) {
            domain.append(SYMBOLS_ARRAY[random.nextInt(SYMBOLS_ARRAY.length)]);
        }
        return domain.toString();
    }

    private static String randomEMailName() {
        return randomSecondLevelDomain();
    }
}
