package Tests;

import Page.*;
import Utils.DataDriven;
import Utils.PropertiesDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CasosPrueba {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private BuscadorPage buscador;
    private PagoExpresPage pagoCliente;
    private ServiciosPage serviciosCliente;
    private String urlVTR;
    private ArrayList<String> dataPrueba;


    @BeforeClass
    public void preparacionEjecucion(){
        String path = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutDriver")).toString();
        String browser = PropertiesDriven.getProperty("browser");
        String propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser, path, propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        buscador = new BuscadorPage(homePage.getDriver());
        pagoCliente = new PagoExpresPage(homePage.getDriver());
        serviciosCliente = new ServiciosPage(homePage.getDriver());
        dataPrueba = new ArrayList<>();
    }

    @BeforeMethod
    public void preparacionTests(){
        urlVTR = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(urlVTR);
        homePage.maximizarBrowser();
    }

    @AfterTest
    public void posEjecucionTests(){
        homePage.cerrarBrowser();
    }

    @Test
    public void CP001_ValidarSucursalVirtual_IngresoLogin(){
        dataPrueba = DataDriven.getData(("CP001_ValidarSucursalVirtual_IngresoLogin"));
        loginPage.esperaXSegundos(5000);
        homePage.IrASucursalVirtual();
        loginPage.Login(dataPrueba.get(1), dataPrueba.get(2));
        loginPage.esperaXSegundos(5000);
        String valor = loginPage.LoginCorrecto();
        Assert.assertEquals(valor, dataPrueba.get(3));
        loginPage.BotonCerrarSesion();
    }

    @Test
    public void CP002_ValidarSucursalVirtual_LoginFallido(){
        dataPrueba = DataDriven.getData(("CP002_ValidarSucursalVirtual_LoginFallido"));
        loginPage.esperaXSegundos(3000);
        homePage.IrASucursalVirtual();
        loginPage.Login(dataPrueba.get(1), dataPrueba.get(2));
        String loginFallido = loginPage.LoginFallido();
        Assert.assertEquals(loginFallido, dataPrueba.get(3));
    }

    @Test
    public void CP003_ValidarSucursalVirtual_RecuperacionContrasena(){
        dataPrueba = DataDriven.getData(("CP003_ValidarSucursalVirtual_RecuperacionContrasena"));
        loginPage.esperaXSegundos(3000);
        homePage.IrASucursalVirtual();
        loginPage.RecuperarContrasena(dataPrueba.get(1));
        String msjRecuperacion = loginPage.MensajeRecuperacion();
        Assert.assertEquals(msjRecuperacion, dataPrueba.get(2));
    }

    @Test
    public void CP004_ValidarProductos_Persona(){
        dataPrueba = DataDriven.getData(("CP004_ValidarProductos_Persona"));
        loginPage.esperaXSegundos(5000);
        homePage.DesplegarProductosPersona();
        loginPage.esperaXSegundos(5000);
        Boolean btnQuieroContratar = homePage.ValidarBtnContratar();
        Assert.assertTrue(btnQuieroContratar);
    }

    @Test
    public void CP005_ValidarProductos_Empresa(){
        dataPrueba = DataDriven.getData("CP005_ValidarProductos_Empresa");
        loginPage.esperaXSegundos(3000);
        homePage.DesplegarProductosEmpresa();
        Assert.assertNotNull(homePage.ValidarNecesitoMovil(),dataPrueba.get(1));
    }

    @Test
    public void CP006_ValidarBuscador_VTR(){
        dataPrueba = DataDriven.getData("CP006_ValidarBuscador_VTR");
        loginPage.esperaXSegundos(3000);
        buscador.BuscadorVtr(dataPrueba.get(1));
        Boolean btnBuscar = buscador.ValidarBusqueda();
        Assert.assertTrue(btnBuscar);
    }

    @Test
    public void CP007_ValidarDeudaPendiente(){
        dataPrueba = DataDriven.getData("CP007_ValidarDeudaPendiente");
        loginPage.esperaXSegundos(12000);
        pagoCliente.BuscarPagoVtr(dataPrueba.get(1));
        pagoCliente.BotonVolver();
        Assert.assertFalse(pagoCliente.ClienteSinDeuda());
    }

    @Test
    public void CP008_ValidarEstadoDeTusServicios(){
        dataPrueba = DataDriven.getData("CP008_ValidarEstadoDeTusServicios");
        loginPage.esperaXSegundos(12000);
        serviciosCliente.EstadoServicio(dataPrueba.get(1));
        Assert.assertEquals(serviciosCliente.ValidarServicio(), dataPrueba.get(2));
    }
}
