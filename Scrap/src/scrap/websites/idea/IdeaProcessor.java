package scrap.websites.idea;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import scrap.selenium.Browser;
import scrap.websites.IProcessor;

import java.util.ArrayList;
import java.util.List;

import scrap.websites.Product;

public class IdeaProcessor implements IProcessor {

    private final int SLEEP_PER_PAGE = 1000; // ms

    @Override
    public List<Product> process() throws InterruptedException {
        List<Product> allProducts = new ArrayList<>();

        WebDriver driver = Browser.getWebDriver();

        ArrayList<String> categoryUrls = new ArrayList<>();
        List<String> subcategoryUrls = new ArrayList<>();
        List<String> productUrls = new ArrayList<>();

        // Lista kategorije
        driver.get("https://www.idea.rs/online/#!/");
        Thread.sleep(SLEEP_PER_PAGE);  // ceka na stranicu da se ucita 
        List<WebElement> categoryElements = driver.findElements(By.className("index-kategorija"));
        for (WebElement categoryElement:categoryElements) {
            WebElement referenceElement = categoryElement.findElements(By.tagName("a")).get(0);
            String reference = referenceElement.getAttribute("href");
            categoryUrls.add(reference);
        }

        // Izvlaci podkategorije iz kategorija
        driver.get(categoryUrls.get(0));
        Thread.sleep(SLEEP_PER_PAGE);
        List<WebElement> allReferences = driver.findElements(By.tagName("a"));
        for (WebElement referenceElement:allReferences) {
            String reference = referenceElement.getAttribute("href");
            if (reference != null &&
                    reference.contains("categories") &&
                    !categoryUrls.contains(reference) &&
                    !subcategoryUrls.contains(reference)) {
                subcategoryUrls.add(reference);
            }
        }

        // Prolazi kroz kategorije i uzima linkove kategorija
        for (String subcategoryUrl:subcategoryUrls) {
            driver.get(subcategoryUrl);
            Thread.sleep(SLEEP_PER_PAGE);
            List<WebElement> allProductReferenceElements = driver.findElements(By.tagName("a"));
            for (WebElement productReferenceElement:allProductReferenceElements) {
                String reference = productReferenceElement.getAttribute("href");
                // TODO: podrska za paginaciju
                if (reference != null &&
                        reference.contains("products") &&
                        !productUrls.contains(reference)) {
                    productUrls.add(reference);
                }
            }
        }

        // Prolaz kroz sve produkte
        for (String productUrl:productUrls) {
            Product prod = new Product();
            // setuje prodavnicu iz koje dolazi produkt
            prod.setShop("idea");
            prod.setUrl(productUrl);

            driver.get(productUrl);
            Thread.sleep(SLEEP_PER_PAGE);
            // uzima i setuje cenu
            WebElement cenaBlok = driver.findElement(By.className("cijene-block"));
            List<WebElement> cenaBlokSpans = cenaBlok.findElements(By.tagName("span"));
            String cena = cenaBlokSpans.get(0).getText() + "." + cenaBlokSpans.get(1).getText();
            prod.setPrice(cena);
            // TODO: uzmi ostale propery i setuj
            // cenaBlok.findElements(By.xpath()) mozda korisno xpath, vidi kako radi
             

            allProducts.add(prod);
        }


        driver.close();

        return allProducts;
    }

}
