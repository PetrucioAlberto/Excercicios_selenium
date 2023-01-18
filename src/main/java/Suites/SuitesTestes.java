package Suites;

import Testes.TesteCadastro;
import Testes.TesteRegrasCadastro;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastro.class,
        TesteRegrasCadastro.class
})
public class SuitesTestes {
}
