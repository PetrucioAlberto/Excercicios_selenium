package Testes;

import Core.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriveFactory.KillDriver;
import static Core.DriveFactory.getDriver;


public class TestesAjax {
    private WebDriver driver;

    private DSL dsl;

    @Before
    public void inicializa(){

        getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=6ae39");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        KillDriver();
    }


    @Test
    public void TesteAjax(){
        dsl.escrever("j_idt343:name","teste");
        dsl.clicarBotao("j_idt343:j_idt347");


        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBe(By.id("j_idt343:display"), "teste"));
        //wait.until(ExpectedConditions.textToBe(By.id("j_idt343:display"), "teste"));
        Assert.assertEquals("teste",dsl.obterTexto("j_idt343:display"));


    }
}
