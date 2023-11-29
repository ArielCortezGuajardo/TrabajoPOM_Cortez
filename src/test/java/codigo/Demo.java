package codigo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    String rutaProyecto = System.getProperty("user.dir");
    String rutaDriver = rutaProyecto+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    WebDriver driver;

    @BeforeEach
    public void preCondiciones() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();

        driver.get("https://www.pcfactory.cl/");
        Thread.sleep(1000);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void posCondiciones(){
        driver.quit();
    }

    @Test
    public void CP001_ingreso_login_erroneo() throws InterruptedException {

        driver.findElement(By.xpath("//span[contains(text(), 'Mi cuenta')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='rutId1_uno']")).sendKeys("173184662");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='rutId2_uno']")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_login_uno']")).click();
        Thread.sleep(4000);

    }

    @Test
    public void CP002_olvido_contrasena() throws InterruptedException {

        driver.findElement(By.xpath("//span[contains(text(), 'Mi cuenta')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/recuperar']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_rut_olvido']")).sendKeys("145674332");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='id_btn_continuar']")).click();
        Thread.sleep(2000);

    }

    @Test
    public void CP003_seguir_pedido_no_existe() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(), 'Seguir mi pedido')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_rut_despacho']")).sendKeys("173184662");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_boleta_despacho']")).sendKeys("3456765432");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='id_buscar_documento']")).click();
        Thread.sleep(2000);

    }

    @Test
    public void CP004_consulta_boletaElectronica_noExiste() throws InterruptedException {

        driver.findElement(By.xpath("//a[@href='/boleta']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_folio_doc_boleta']")).sendKeys("564563453");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_fecha_emision_boleta']")).sendKeys("24-11-2024");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_monto_total_boleta']")).sendKeys("40000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='id_ver_documento']")).click();
        Thread.sleep(4000);

    }

    @Test
    public void CP005_Contactenos()  throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(), 'Contacto')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_nombre_contacto']")).sendKeys("juan");
        Thread.sleep(1000);
        driver.findElement(By.id("id_apellido_contacto")).sendKeys("carlos");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_rut_contacto']")).sendKeys("173184662");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_telefono_contacto']")).sendKeys("966578955");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_email_contacto']")).sendKeys("a@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='id_nro_boleta']")).sendKeys("1234567");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='id_lista_motivo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value='2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='id_lista_clasificacion_motivo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value='16']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@id='id_comentarios_contacto']")).sendKeys("consulta sobre una compra realizada");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='id_enviar_formulario']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='confirm-close']")).click();
        Thread.sleep(2000);

    }
}
