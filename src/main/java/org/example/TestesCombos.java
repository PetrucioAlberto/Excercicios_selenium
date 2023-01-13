package org.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Pasta_PTO.DriveFactory.KillDriver;
import static Pasta_PTO.DriveFactory.getDriver;


public class TestesCombos {
    private WebDriver driver;
    @Before
    public void inicializa(){

       //getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=d0be7");
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza(){
        KillDriver();
    }

    @Test // ***********verifca uma opçao apenas**************//
    public void combo(){
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Corrida");
        Assert.assertEquals("Corrida",combo.getFirstSelectedOption().getText());
    }

    @Test // ***********verifca varias opçoes apenas**************//
    public void VariosOpçoes(){
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Natacao");

        List<WebElement> selecionarTodasopcoes = combo.getAllSelectedOptions();
        Assert.assertEquals(3,selecionarTodasopcoes.size());
    }

    @Test // ***********Deselecionar opçoes **************//
    public void DeselecionarOpçoes() {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Natacao");

        combo.deselectByVisibleText("Corrida");
        List<WebElement> selecionarTodasopcoes = combo.getAllSelectedOptions();
        Assert.assertEquals(2,selecionarTodasopcoes.size());
    }
    @Test
    @Ignore
    public void clicar(){
        getDriver().findElement(By.xpath("//*[@id=\"j_idt344:console\"]/tbody/tr/td[1]/div")).click();
    }


}
