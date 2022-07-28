package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class BuscadorPage extends BaseClass {

    //Constructor
    public BuscadorPage(WebDriver driver) {
        super(driver);
    }

    //Localizador
    By locatorBuscador = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]");
    By locatorTxtBuscador = By.xpath("//body/div[@id='___gatsby']/div[@id='gatsby-focus-wrapper']/div[3]/div[1]/div[1]/div[1]/input[1]");

    //Acciones
    public void BuscadorVtr(String dato1){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));

        click(esperaExplicita(locatorBuscador));
        String homeTab = driver.getWindowHandle();
        newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        esperaXSegundos(1000);
        agregarTexto(locatorTxtBuscador, dato1);
        js.executeScript("window.scrollBy(1,350)","");
    }

    public Boolean ValidarBusqueda(){
        esperaXSegundos(4000);
        return estaHabilitado(locatorTxtBuscador);
    }

}
