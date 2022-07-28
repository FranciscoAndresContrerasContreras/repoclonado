package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmpresaPage extends BaseClass {

    //Constructor
    public EmpresaPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorEmpresa = By.xpath("//body/lla-consumer-root[1]/section[1]/lla-main-menu[1]/div[1]/div[1]/div[1]/div[1]/lla-top-bar[1]/div[1]/div[1]/div[1]/lla-btn-groups[1]/div[1]/mat-button-toggle-group[1]/mat-button-toggle[2]/button[1]/span[1]");

    //Acciones
    public void SeccionPersona(){
        click(esperaExplicita(locatorEmpresa));
    }
}
