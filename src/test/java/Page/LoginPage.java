package Page;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores
    By locatorTxtRutoEmail = By.xpath("//input[@id='usernameOCC']");
    By locatorTxtContrasena = By.xpath("//input[@id='passwordOCC']");
    By locatorBtnIngresar = By.xpath("//span[contains(text(),'Ingresar')]");
    By locatorMsjInicioSesion= By.xpath("//h5[contains(text(),'MIS SERVICIOS CONTRATADOS')]");
    By locatorTxtFallido = By.xpath("//p[contains(text(),'Usuario o contraseña incorrecto')]");
    By locatorOlvideContrasena = By.xpath("//a[@id='passwordRecoveryBtn']");
    By locatorTextoEmailRut = By.xpath("//input[@id='recoveryPasswordInput']");
    By locatorBtnContinuar = By.xpath("//button[@id='recoverFirstStep']");
    By locatorMsjRecuperacion = By.xpath("//b[@id='forceChangePasswordTitle']");
    By menuDesplegable = By.xpath("//header/nav[@id='contentHeader']/div[1]/div[1]/div[3]/a[2]/span[2]");
    By locatorBtnCerrarSesion = By.linkText("Cerrar Sesión");

    //Acciones
    public void Login(String user, String pass) {
       click(esperaExplicita(locatorTxtRutoEmail));
        agregarTexto(locatorTxtRutoEmail, user);
        click(esperaExplicita(locatorTxtContrasena));
        agregarTexto(locatorTxtContrasena, pass);

        if (estaHabilitado(locatorBtnIngresar)) {
            click(esperaExplicita(locatorBtnIngresar));
        }
    }

    public String LoginCorrecto(){
        esperaXSegundos(12000);
        String valor = obtenerTexto(locatorMsjInicioSesion);
        return valor;
    }

    public String LoginFallido(){
         esperaXSegundos(12000);
         String valor = obtenerTexto(locatorTxtFallido);
         return valor;
    }

    public void RecuperarContrasena(String email){
        click(esperaExplicita(locatorOlvideContrasena));
        agregarTexto(locatorTextoEmailRut, email);

        if (estaHabilitado(locatorBtnContinuar)) {
            click(esperaExplicita(locatorBtnContinuar));
        }
    }

    public String MensajeRecuperacion(){
        String valor = obtenerTexto(locatorMsjRecuperacion);
        return valor;
    }

    public void BotonCerrarSesion(){
        esperaXSegundos(3000);
        click(menuDesplegable);
        esperaXSegundos(3000);
        click(locatorBtnCerrarSesion);
        esperaXSegundos(6000);
    }

}

