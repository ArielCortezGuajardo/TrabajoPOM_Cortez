package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class MiCuentaPage extends ClaseBase {
    By txtRut = By.xpath("//input[@id='rutId1_uno']");
    By txtContrasena = By.xpath("//input[@id='rutId2_uno']");
    By btnIniciarSesion = By.xpath("//button[@class='button-bg--blue mt-2']");
    By lblErrorContrasena = By.xpath("//div[@id='id_nota_forgot_password']");

    public MiCuentaPage(WebDriver driver) {
        super(driver);
    }

    public void iniciarSesion(String txtRuts, String txtPass){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(txtRut),txtRuts);
        agregarTexto(esperaExplicita(txtContrasena),txtPass);
        click(esperaExplicita(btnIniciarSesion));
    }
    public String obtenerErrorMiCuenta(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(lblErrorContrasena));
    }
}
