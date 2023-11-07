import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarCliente(){
        Empresa empresa = new Empresa("1_Empresa", "Gerente 1");
        Cliente cliente1 = new Cliente("Primeiro Cliente");
         cliente1.answerForm(empresa);
        empresa.novaResposta();
        assertEquals("Primeiro Cliente, respondeu a pesquisa da empresa 1_Empresa, gerente: Gerente 1", cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes(){
        Empresa empresa = new Empresa("1_Empresa", "Gerente 1");
        Cliente cliente1 = new Cliente("Pessoa1");
        Cliente cliente2 = new Cliente("Pessoa2");
        cliente1.answerForm(empresa);
        cliente2.answerForm(empresa);
        empresa.novaResposta();
        assertEquals("Pessoa1, respondeu a pesquisa da empresa 1_Empresa, gerente: Gerente 1", cliente1.getUltimaNotificacao());
        assertEquals("Pessoa2, respondeu a pesquisa da empresa 1_Empresa, gerente: Gerente 1", cliente2.getUltimaNotificacao());
    }

    @Test
    void deveNaoNotificarCliente(){
        Empresa empresa = new Empresa("1_Empresa", "Gerente 1");
        Cliente cliente = new Cliente("Cliente");
        empresa.novaResposta();
        assertEquals(null, cliente.getUltimaNotificacao());
    }
}