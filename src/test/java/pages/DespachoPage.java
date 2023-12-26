package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class DespachoPage extends ClaseBase {

    public DespachoPage(WebDriver driver) { super(driver); }

    By lblRutDepacho = By.xpath("//input[@id='id_rut_despacho']");
    By lblNumeroBoleta = By.xpath("//input[@id='id_boleta_despacho']");
    By btnBuscarDespacho = By.xpath("//button[@id='id_buscar_documento']");
    By divResultadoDepacho = By.xpath("//div[@id='id_msg_error_despacho']");

    public void BuscarDespacho(String txtRutDespa, String txtNumBoleta){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(lblRutDepacho),txtRutDespa);
        agregarTexto(esperaExplicita(lblNumeroBoleta),txtNumBoleta);
        click(esperaExplicita(btnBuscarDespacho));
    }

    public String resultadoDespacho(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(divResultadoDepacho));
    }

}
