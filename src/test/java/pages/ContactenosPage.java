package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class ContactenosPage extends ClaseBase {

    public ContactenosPage(WebDriver driver) { super(driver); }

    By lblNombreContacto = By.xpath("//input[@id='id_nombre_contacto']");
    By lblApellidoContacto = By.xpath("//input[@id='id_apellido_contacto']");
    By lblRutContacto = By.xpath("//input[@id='id_rut_contacto']");
    By lblTelefonoContacto = By.xpath("//input[@id='id_telefono_contacto']");
    By lblEmailContacto = By.xpath("//input[@id='id_email_contacto']");
    By lblNroBoleta = By.xpath("//input[@id='id_nro_boleta']");
    By comboBoxlistaMotivo = By.xpath("//select[@id='id_lista_motivo']");
    By comboBoxOpcionDos = By.xpath("//option[@value='2']");
    By textAreaComentarioContacto = By.xpath("//textarea[@id='id_comentarios_contacto']");
    By btnEnviarFormularioContacto = By.xpath("//button[@id='id_enviar_formulario']");
    By divrespuestaFormularioContacto = By.xpath("//div[@id='titulo_respuesta']");

    public void llenarFormularioContacto(String lblNombreConta, String lblApellidoConta, String lblRutConta,
    String lblTelefonoConta, String lblEmailConta, String lblNroConta, String textAreaConta){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(lblNombreContacto),lblNombreConta);
        agregarTexto(esperaExplicita(lblApellidoContacto),lblApellidoConta);
        agregarTexto(esperaExplicita(lblRutContacto),lblRutConta);
        agregarTexto(esperaExplicita(lblTelefonoContacto),lblTelefonoConta);
        agregarTexto(esperaExplicita(lblEmailContacto),lblEmailConta);
        agregarTexto(esperaExplicita(lblNroBoleta),lblNroConta);
        click(esperaExplicita(comboBoxlistaMotivo));
        click(esperaExplicita(comboBoxOpcionDos));
        agregarTexto(esperaExplicita(textAreaComentarioContacto),textAreaConta);
        esperarXSegundos(2000);
        click(esperaExplicita(btnEnviarFormularioContacto));
    }

    public String resultadoContactenos(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(divrespuestaFormularioContacto));
    }
}
