package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;


public class BoletaPage extends ClaseBase {

    public BoletaPage(WebDriver driver) { super(driver);}

    By lblNumeroFolio = By.xpath("//input[@id='id_folio_doc_boleta']");
    By lblFechaEmision = By.xpath("//input[@id='id_fecha_emision_boleta']");
    By lblMontoTotal = By.xpath("//input[@id='id_monto_total_boleta']");
    By btnBuscar = By.xpath("//button[@id='id_ver_documento']");
    By lblResultadoBoleta = By.xpath("//div[@class='title-md mt-1']");

    public void buscarBoleta(String lblNumeroFol, String lblFechaEmi, String lblMontoTot){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(lblNumeroFolio),lblNumeroFol);
        agregarTexto(esperaExplicita(lblFechaEmision),lblFechaEmi);
        agregarTexto(esperaExplicita(lblMontoTotal),lblMontoTot);
        click(esperaExplicita(btnBuscar));
    }

    public String mesajeBuscaBoleta(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(lblResultadoBoleta));
    }
}
