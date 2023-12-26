package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClaseBase {

    private WebDriver driver;
    private WebDriverWait espera;

    //Métodos

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones que podemos realizar en el browser

    //cargar URL
    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //buscar elemento web
    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    //buscar varios elementos web
    public List<WebElement> buscarElementosWeb(By localizador){
        return this.driver.findElements(localizador);
    }

    //Esperar X segundos
    public void esperarXSegundos(int milisegundos)  {

        try{
            Thread.sleep(milisegundos);
        }catch (Exception e){
            System.out.println("No se pudo aplicar espera");
            System.out.println("Error: "+ e.getStackTrace());
        }
    }

    //Espera Explicita
    public WebElement esperaExplicita(By localizador){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //click
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    //click
    public void click(WebElement elemento){
        elemento.click();
    }

    //obtener texto
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    //AgregarTexto
    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }

    //Limpiar imput
    public void limpiarCajaTexto(WebElement elemento){
        elemento.clear();
    }

    public void limpiarCajaTexto(By localizador){
        this.driver.findElement(localizador).clear();
    }

    //maximizar el browser
    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    //Cerrar el browser
    public void cerrarBrowser(){
        this.driver.close();
    }

    public boolean estaDesplegado(By localizador){
        try{
            return this.driver.findElement(localizador).isDisplayed();
        }catch (Exception e){
            System.out.println("Error al encontrar elemento web:" + e.getStackTrace());
            return false;
        }
    }

    public WebDriver conexion(String browser, String ruta, String property){
        switch (browser){
            case "chrome":
                System.setProperty(property,ruta);
                this.driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
