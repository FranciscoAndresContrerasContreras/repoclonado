package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ServiciosPage extends BaseClass {

    //Contructor
    public ServiciosPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorSeccionEstadoServicios = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[2]/div[2]/lla-horizontal-menu[1]/div[1]/ul[1]/li[9]/a[1]/span[1]");
    By locatorRutCliente = By.xpath("//input[@id='vandalismo_rut']");
    By locatorBtnVerEstado = By.xpath("//a[contains(text(),'Ver estado')]");
    By locatorMsjServicio = By.xpath("//span[contains(text(),'No existen incidencias reportadas')]");

    //Acciones
    public void EstadoServicio(String rutCliente){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for(int i=1;i < newTab.size();i++){
            driver.switchTo().window(newTab.get(i));
            driver.close();
        }
        driver.switchTo().window(newTab.get(0));

        click(esperaExplicita(locatorSeccionEstadoServicios));
        String homeTab = driver.getWindowHandle();
        newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        agregarTexto(esperaExplicita(locatorRutCliente), rutCliente);
        click(esperaExplicita(locatorBtnVerEstado));
    }

    public String ValidarServicio(){
        esperaXSegundos(9000);
        String valor = obtenerTexto(locatorMsjServicio);
        return valor;
    }

}
