package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class HomePage extends BaseClass {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorBtnSucursalVirtual = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]");
    By locatorSeccionPersona = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[1]/lla-btn-groups[1]/div[1]/mat-button-toggle-group[1]/mat-button-toggle[1]/button[1]/span[1]");
    By locatorSeccionEmpresa = By.xpath("/html[1]/body[1]/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[1]/lla-btn-groups[1]/div[1]/mat-button-toggle-group[1]/mat-button-toggle[2]/button[1]");
    By locatorBtnQuieroContratar = By.xpath("//div[contains(text(),'¿Qué quieres contratar?')]");
    By locatorMovil = By.xpath("//p[contains(text(),'MÓVIL')]");
    //Acciones
    public void IrASucursalVirtual(){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));

        click(esperaExplicita(locatorBtnSucursalVirtual));

        newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    public void DesplegarProductosPersona(){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));
        click(esperaExplicita(locatorSeccionPersona));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
    }
    public void DesplegarProductosEmpresa(){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));

        click(esperaExplicita(locatorSeccionEmpresa));
        String homeTab = driver.getWindowHandle();
        newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
        esperaXSegundos(1000);
        js.executeScript("window.scrollBy(1,500)","");
    }

    public Boolean ValidarBtnContratar(){
        esperaXSegundos(9000);
        return estaDesplegado(locatorBtnQuieroContratar);
    }

    public String ValidarNecesitoMovil(){
        esperaXSegundos(3000);
        String valor = obtenerTexto(locatorMovil);
        return valor;
    }
}
