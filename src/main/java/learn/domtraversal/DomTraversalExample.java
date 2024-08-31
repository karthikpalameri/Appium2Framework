package learn.domtraversal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DomTraversalExample {
    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        try {
            // Get the current working directory
            String currPath = System.getProperty("user.dir");

            // Use Paths.get() to construct file paths
            Path oldHtmlPagePath = Paths.get(currPath, "src", "main", "java", "learn", "domtraversal", "oldHtmlPage.html");
            Path modifiedPagePath = Paths.get(currPath, "src", "main", "java", "learn", "domtraversal", "newHtmlPage.html");
            Document originalDoc = Jsoup.parse(oldHtmlPagePath.toFile(), "UTF-8");
            Document modifiedDoc = Jsoup.parse(modifiedPagePath.toFile(), "UTF-8");

            Elements elements = modifiedDoc.selectXpath("//div[@name='div1']");
            System.out.println("elements = " + elements);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void traverseAndFind(Element currentElement, Element targetElement) {
        try {
            if (currentElement.tagName().equals(targetElement.tagName()) &&
                    currentElement.id().equals(targetElement.id()) &&
                    currentElement.className().equals(targetElement.className()) &&
                    currentElement.text().equals(targetElement.text())) {
                System.out.println("Element found: " + currentElement.outerHtml());
                return;
            }

            for (Element child : currentElement.children()) {
                traverseAndFind(child, targetElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}


