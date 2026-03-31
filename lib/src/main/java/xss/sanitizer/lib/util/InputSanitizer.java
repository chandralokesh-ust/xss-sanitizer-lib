package xss.sanitizer.lib.util;


public class InputSanitizer {

    public static String sanitize(String input) {

        if (input == null) {
            return null;
        }
        // Block any HTML tags
        if (input.matches(".*<.*>.*")) {
            throw new IllegalArgumentException(
                    "Invalid input detected. HTML or script content is not allowed.");
        }
        return input;
    }
}
