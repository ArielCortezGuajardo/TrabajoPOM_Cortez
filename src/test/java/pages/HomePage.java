package pages;

import utils.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ClaseBase {

    By btnMicuenta = By.xpath("//button[@class='button-no-decoration header__profile-arrow']");
    By btnOlvidoPassword = By.xpath("//a[@class='link link--sm link--bold link--blue link--underline']");
    By btnContacto = By.xpath("//a[@href='/contactenos']");
    By btnSeguirPedido = By.xpath("//a[@href='/despacho']");
    By btnBoletaElectronica = By.xpath("//a[@href='/boleta']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void miCuenta(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnMicuenta));
    }
    public void olvidoContrasena(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnMicuenta));
        esperarXSegundos(2000);
        click(esperaExplicita(btnOlvidoPassword));
    }
    public void contactenos(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnContacto));
    }
    public void despacho(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnSeguirPedido));
    }

    public void boletaElectronica(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnBoletaElectronica));
    }
}
