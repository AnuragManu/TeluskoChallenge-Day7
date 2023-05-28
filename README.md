# Tiny URL Generator

The Tiny URL Generator is a Java class that allows you to generate a tiny URL from a full URL and retrieve the original full URL from the generated tiny URL.

## How it Works

The TinyUrlGenerator class uses a simple hashing algorithm to generate a unique code for each full URL provided. It then stores the mapping between the generated tiny URL and the original full URL in a HashMap.

```java
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
```
### Explanation
- The `TinyUrlGenerator` class provides methods to generate tiny URLs from full URLs and retrieve the original full URL from a tiny URL.
- The `urlMap` is a `HashMap` that stores the mapping between the tiny URLs and the corresponding full URLs.
- The `BASE_URL` is the constant string representing the base URL for the tiny URLs.
- In the constructor, the `urlMap` is initialized as an empty `HashMap`.
- The `createTinyUrl` method takes a full URL as input, generates a tiny URL for it, and stores the mapping in the `urlMap`. It returns the full tiny URL by concatenating the `BASE_URL` with the generated tiny URL.
- The `getFullUrl` method retrieves the original full URL from the `urlMap` based on the provided tiny URL. It extracts the code from the tiny URL and looks up the code in the `urlMap` to find the corresponding full URL.
- The `generateTinyUrl` method generates a unique code for a full URL by calculating its hash code and converting it to a hexadecimal string.


### Creating a Tiny URL

To create a tiny URL, use the `createTinyUrl` method of the TinyUrlGenerator class. Pass the full URL as a parameter to the method, and it will generate a tiny URL for you. The generated tiny URL will be in the format `https://tinyurl.com/{code}`.

### Retrieving the Full URL

To retrieve the original full URL from a tiny URL, use the `getFullUrl` method of the TinyUrlGenerator class. Pass the tiny URL as a parameter to the method, and it will return the original full URL.

## Usage Example

Here's an example usage of the TinyUrlGenerator class:

```java
TinyUrlGenerator urlGenerator = new TinyUrlGenerator();
String fullUrl = "https://courses.telusko.com/learn/Live-Java-Course";
String tinyUrl = urlGenerator.createTinyUrl(fullUrl);
System.out.println("Tiny URL: " + tinyUrl);
String retrievedUrl = urlGenerator.getFullUrl(tinyUrl);
System.out.println("Retrieved URL: " + retrievedUrl);
```
This code creates an instance of the TinyUrlGenerator class, generates a tiny URL for the provided full URL, and then retrieves the original full URL from the generated tiny URL.

## Duplication Handling

The TinyUrlGenerator class handles duplication by using a HashMap to store the mapping between the tiny URLs and the corresponding full URLs. When a new tiny URL is generated, it checks if the generated code already exists in the map. If a collision occurs, the existing mapping is overwritten with the new mapping.

This approach ensures that each full URL will have a unique corresponding tiny URL. If the same full URL is provided multiple times, it will generate the same tiny URL each time.
