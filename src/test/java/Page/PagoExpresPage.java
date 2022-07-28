package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class PagoExpresPage extends BaseClass {

    //Constructor
    public PagoExpresPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorPagoExpress = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]");
    By locatorIngresoRut = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]");
    By locatorBtnContinuar = By.xpath("//b[contains(text(),'Continuar')]");
    By locatorMensajeClienteSinDeuda = By.xpath("//div[contains(text(),'Cliente no registra deuda')]");
    By locatorBtnVolver = By.xpath("//b[contains(text(),'Volver')]");

    // Acciones
    public void BuscarPagoVtr(String rutCliente){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));

        click(esperaExplicita(locatorPagoExpress));
        String homeTab = driver.getWindowHandle();
        newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        agregarTexto(esperaExplicita(locatorIngresoRut), rutCliente);
        click(esperaExplicita(locatorBtnContinuar));
    }

    public Boolean ClienteSinDeuda(){
        esperaXSegundos(3000);
        return estaDesplegado(locatorMensajeClienteSinDeuda);
    }

    public void BotonVolver(){
        click(esperaExplicita(locatorBtnVolver));
    }
}
