public class TinyurlApplication {
    public static void main(String[] args) {
        TinyUrlGenerator urlGenerator = new TinyUrlGenerator(); // Create an instance of TinyUrlGenerator
        String fullUrl = "https://courses.telusko.com/learn/Live-Java-Course";
        String tinyUrl = urlGenerator.createTinyUrl(fullUrl); // Generate a tiny URL for the full URL
        System.out.println("Tiny URL: " + tinyUrl);
        String retrievedUrl = urlGenerator.getFullUrl(tinyUrl); // Retrieve the original full URL from the tiny URL
        System.out.println("Retrieved URL: " + retrievedUrl);
    }
}
