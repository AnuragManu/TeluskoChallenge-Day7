import java.util.HashMap;
import java.util.Map;

public class TinyUrlGenerator {
    private Map<String, String> urlMap; // Map to store the mapping between tiny URLs and full URLs
    private static final String BASE_URL = "https://tinyurl.com/"; // Base URL for the tiny URL

    public TinyUrlGenerator() {
        urlMap = new HashMap<>(); // Initialize the map in the constructor
    }

    public String createTinyUrl(String fullUrl) {
        String tinyUrl = generateTinyUrl(fullUrl); // Generate a tiny URL for the given full URL
        urlMap.put(tinyUrl, fullUrl); // Store the mapping in the map
        return BASE_URL + tinyUrl; // Return the full tiny URL
    }

    public String getFullUrl(String tinyUrl) {
        String code = tinyUrl.substring(BASE_URL.length()); // Extract the code from the tiny URL
        return urlMap.get(code); // Retrieve the original full URL from the map
    }

    private String generateTinyUrl(String fullUrl) {
        int hashCode = fullUrl.hashCode(); // Generate a hash code for the full URL
        return Integer.toHexString(hashCode); // Convert the hash code to a hexadecimal string
    }
}
