package scripts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;
import java.sql.Driver;

public class EjemploWebElement {

    @Test
    public void ERROR_LOGIN() throws InterruptedException {
        //Enlazar el wbdriver al browser de nuestro sistema

        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+ "\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://open.spotify.com/intl-es");

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement btnIniciarSesion;
        By byBtnIniciarSesion = By.xpath("//button[@data-testid=\"login-button\"]");

        btnIniciarSesion = driver.findElement(byBtnIniciarSesion);
        btnIniciarSesion.click();

        Thread.sleep(5000);

        driver.findElement(By.id("login-username")).sendKeys("cualquiercosa@algo.cl");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        Assertions.assertEquals(corregirEncoding("Nombre de usuario o contraseña incorrectos."),driver.findElement(By.xpath("//span[contains(text(), 'contrase')]")).getText());
        Thread.sleep(5000);
        driver.close();


        driver.close();
    }

    @Test
    public void CP002_REGUSUARIO() throws InterruptedException {

        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+ "\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://open.spotify.com/intl-es");

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement btnRegistrar;
        By byBtnRegistrar = By.xpath("//button[@data-testid=\"signup-button\"]");

        btnRegistrar = driver.findElement(byBtnRegistrar);
        btnRegistrar.click();

        Thread.sleep(5000);

       /* WebElement btnCerrarPopupReg;
        By byBtnCerrarPopupReg = By.xpath("//a[@data-encore-id=\"buttonPrimary\"]");
        btnCerrarPopupReg = driver.findElement(byBtnCerrarPopupReg);
        btnCerrarPopupReg.click();
        if (btnCerrarPopupReg.isDisplayed()) {
            btnCerrarPopupReg.click();
        }*/

        driver.findElement(By.id("username")).sendKeys("daniela.brito@tsoftlatam.com");
        Thread.sleep(5000);

        WebElement btnSiguiente;
        By byBtnSiguiente = By.xpath("//button[@data-testid=\"submit\"]");

        btnSiguiente = driver.findElement((byBtnSiguiente));
        btnSiguiente.click();

        //PAso 1 de 3

        driver.findElement(By.id("new-password")).sendKeys("algo12345#");//llenado de campo contraseña
        Thread.sleep(5000);

        WebElement btnSiguienteI;
        By byBtnSiguienteI = By.xpath("//span[contains(text(),'Siguiente')]");

        btnSiguienteI = driver.findElement((byBtnSiguienteI));
        btnSiguienteI.click();

        //PAso 2 de 3
        //1er campo
        driver.findElement(By.id("displayName")).sendKeys("Cualquier Cosa");//llenado de campo nombre
        Thread.sleep(5000);

        //Fecha de nacimiento
        driver.findElement(By.id("day")).sendKeys("31");
        driver.findElement(By.id("month")).sendKeys("Enero");
        driver.findElement(By.id("year")).sendKeys("1992");
        Thread.sleep(3000);
        WebElement radBtnMujer;
        By byRadBtnMujer = By.xpath("//span[contains(text(),'Mujer')]");
        radBtnMujer = driver.findElement(byRadBtnMujer);
        radBtnMujer.click();

        Thread.sleep(5000);

        WebElement btnSiguienteII;
        By byBtnSiguienteII = By.xpath("//span[contains(text(),'Siguiente')]");

        btnSiguienteII = driver.findElement((byBtnSiguienteII));
        btnSiguienteII.click();

        Thread.sleep(5000);
        //Parte 3 de 3
        WebElement chkBtnTermCond;
        By bychkBtnTermCond = By.xpath("//span[@class=\"Indicator-sc-1airx73-0 lhZnAn\"]");
        chkBtnTermCond = driver.findElement(bychkBtnTermCond);
        chkBtnTermCond.click();

        WebElement btnRegistroFin;
        By byBtnRegistroFin = By.xpath("//span[@class=\"ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set\"]");

        btnRegistroFin = driver.findElement((byBtnRegistroFin));
        btnRegistroFin.click();

        //Etapa Final



      //  driver.close();


    }


    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }


}
