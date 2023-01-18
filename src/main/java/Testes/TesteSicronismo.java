package Testes;

import Core.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Core.DriveFactory.KillDriver;
import static Core.DriveFactory.getDriver;

public class TesteSicronismo {

    private DSL dsl;


    @Before
    public void inicializa(){

        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();


    }

    @After
    public void finaliza(){
        KillDriver();
    }


    /********* Sincronismo ************/
    @Test
    public void deveInteragirCampoDemorado() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escrever("novoCampo","testandoo");


    }


}
