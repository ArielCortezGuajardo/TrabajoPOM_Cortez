package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class RecuperarPage extends ClaseBase {

    By txtRutOlvido = By.xpath("//input[@id='id_rut_olvido']");
    By btnContiniar = By.xpath("//button[@id='id_btn_continuar']");
    By lblReinicioPass = By.xpath("//p[@class='link text-center']");

    public RecuperarPage(WebDriver driver) { super(driver); }

    public void reiniciatuContrasena(String txtRutOlvi){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(txtRutOlvido),txtRutOlvi);
        click(esperaExplicita(btnContiniar));
    }

    public String mensajeObtenidoReinicioPass(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(lblReinicioPass));
    }

}
