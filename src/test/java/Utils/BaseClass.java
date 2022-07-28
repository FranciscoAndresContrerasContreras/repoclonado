package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    //Atributos
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Métodos
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    //Contructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    //Acciones
    public void cargarSitio(String url){
        this.driver.get(url);
    }

    //Definir espera explicita
    public WebElement esperaExplicita(By localizador){
        wait = new WebDriverWait(this.driver,30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //Espera implicita
    public void esperaXSegundos(int miliSegundos){
        try{
            Thread.sleep(miliSegundos);
        }catch (Exception e){
            System.out.println("Fallo la espera implicita");
            e.getStackTrace();
        }
    }

    //Click
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elementoWeb){
        elementoWeb.click();
    }

    //ObtenerTexto
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elementoWeb){
        return elementoWeb.getText();
    }

    //AgregarTexto
    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }
    public void agregarTexto(WebElement elementoWeb, String texto){
        elementoWeb.sendKeys(texto);
    }

    //Maximizar Browser
    public  void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    //Cerrar Browser
    public  void cerrarBrowser(){
        this.driver.close();
    }

    //Conexion Browser
    public WebDriver conexionBrowser(String browser, String ruta, String propertyDriver){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("IExplorer")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new InternetExplorerDriver();
        }
        return this.driver;
    }

    //Verificar si se despliega un elemento web
    public boolean estaDesplegado(By localizador){
        try{
            return this.driver.findElement(localizador).isDisplayed();
        }catch (Exception e){
            System.out.println("No se encontro el elemento indicado por el locator: "+localizador);
            return false;
        }
    }

    public boolean estaHabilitado(By localizador){
        try{
            return this.driver.findElement(localizador).isEnabled();
        }catch (org.openqa.selenium.NoSuchElementException e){
            System.out.println("No se encontro el elemento indicado por el locator: "+localizador);
            return false;
        }
    }
}

