package codigo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DataDriven;
import utils.PropertiesManager;
import java.util.ArrayList;

public class Demo {

    private WebDriver driver;
    private HomePage homePage;
    private MiCuentaPage miCuentaPage;
    private RecuperarPage recuperarPage;
    private ContactenosPage contactenosPage;
    private DespachoPage despachoPage;
    private BoletaPage boletaPage;

    private String url = PropertiesManager.obtenerProperty("url");
    private String rutaDriver = PropertiesManager.obtenerProperty("rutaDriver");
    private String propertyDriver = PropertiesManager.obtenerProperty("propertyDriver");
    private String browser = PropertiesManager.obtenerProperty("browser");
    private ArrayList<String> datosCP;

    @BeforeEach
    public void preCondiciones() {
        datosCP = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexion(browser,rutaDriver,propertyDriver);

        miCuentaPage = new MiCuentaPage(homePage.getDriver());
        recuperarPage = new RecuperarPage(homePage.getDriver());
        contactenosPage = new ContactenosPage(homePage.getDriver());
        despachoPage = new DespachoPage(homePage.getDriver());
        boletaPage = new BoletaPage(homePage.getDriver());

        homePage.cargarPagina(url);
        homePage.maximizarBrowser();

    }

    @AfterEach
    public void posCondiciones(){
        miCuentaPage.cerrarBrowser();
    }

    @Test
    public void CP001_ingreso_login_erroneo(){
        datosCP = DataDriven.prepararData("CP001_ingreso_login_erroneo");
        homePage.miCuenta();
        miCuentaPage.iniciarSesion(datosCP.get(1),datosCP.get(2));
        String resultadoActual = miCuentaPage.obtenerErrorMiCuenta();
        Assertions.assertEquals(resultadoActual,datosCP.get(3));
    }

    @Test
    public void CP002_olvido_contrasena(){
        datosCP = DataDriven.prepararData("CP002_olvido_contrasena");
        homePage.olvidoContrasena();
        recuperarPage.reiniciatuContrasena(datosCP.get(1));
        String resultadoActual = recuperarPage.mensajeObtenidoReinicioPass();
        Assertions.assertEquals(resultadoActual,datosCP.get(2));
    }

    @Test
    public void CP003_contactenos(){
        datosCP = DataDriven.prepararData("CP003_contactenos");
        homePage.contactenos();
        contactenosPage.llenarFormularioContacto(datosCP.get(1),datosCP.get(2),datosCP.get(3),
                datosCP.get(4),datosCP.get(5),datosCP.get(6),datosCP.get(7));
        String resultadoActual = contactenosPage.resultadoContactenos();
        Assertions.assertEquals(resultadoActual,datosCP.get(8));

    }

    @Test
    public void CP004_seguir_pedido_no_existe(){
        datosCP = DataDriven.prepararData("CP004_seguir_pedido_no_existe");
        homePage.despacho();
        despachoPage.BuscarDespacho(datosCP.get(1), datosCP.get(2));
        String resultadoActual = despachoPage.resultadoDespacho();
        Assertions.assertEquals(resultadoActual,datosCP.get(3));

    }

    @Test
    public void CP005_consulta_boletaElectronica_noExiste(){
        datosCP = DataDriven.prepararData("CP005_consulta_boletaElectronica_noExiste");
        homePage.boletaElectronica();
        boletaPage.buscarBoleta(datosCP.get(1),datosCP.get(2),datosCP.get(3));
        String resultadoActual = boletaPage.mesajeBuscaBoleta();
        Assertions.assertEquals(resultadoActual,datosCP.get(4));

    }
}
