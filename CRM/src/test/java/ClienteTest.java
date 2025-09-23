import C14.CRM.model.Atividade;
import C14.CRM.model.Cliente;
import C14.CRM.model.Oportunidade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    // Teste Que Vão Dar True
    @Test
    void testCriacaoCliente() {
        Cliente cliente = new Cliente("João Silva", "joao@email.com", "11-9999-8888", "João Company");
        assertNotNull(cliente.getId()); // Recebe True
        assertEquals("João Silva", cliente.getNome()); // Recebe True
        assertEquals("joao@email.com", cliente.getEmail()); // Recebe True
        assertEquals("11-9999-8888", cliente.getTelefone()); // Recebe True
        assertEquals("João Company", cliente.getEmpresa()); // Recebe True
    }

    @Test
    void testAdicionarOportunidade() {
        Cliente cliente = new Cliente("Teste", "teste@email.com", "00-0000-0000", "Teste");
        Oportunidade oportunidade = new Oportunidade("Projeto Teste", 1000.0);

        cliente.adicionarOportunidade(oportunidade);

        assertEquals(1, cliente.getOportunidades().size()); // Recebe True
        assertEquals("Projeto Teste", cliente.getOportunidades().get(0).getDescricao()); // Recebe True
    }

    @Test
    void testAdicionarAtividade() {
        Cliente cliente = new Cliente("Teste", "teste@email.com", "00-0000-0000", "Teste");
        Atividade atividade = new Atividade(Atividade.Tipo.REUNIAO, "Reunião 18:00");

        cliente.adicionarAtividade(atividade);

        assertEquals(1, cliente.getAtividades().size()); // Recebe True
        assertEquals("Reunião 18:00", cliente.getAtividades().get(0).getDescricao()); // Recebe True
    }

    @Test
    void testClienteComListasVazias() {
        Cliente cliente = new Cliente("Maria", "maria@email.com", "11-7777-6666", "Maria LTDA");

        //  ASSERT True proposital
        assertTrue(cliente.getOportunidades().isEmpty());  // Recebe true
        assertTrue(cliente.getAtividades().isEmpty());     // Recebe true
    }

    @Test
    void testCriacaoDeOportunidade (){
        Oportunidade oportunidade = new Oportunidade("Projeto De Construção de Uma Ferroviaria",1000000);
        assertNotNull(oportunidade.getId());
        assertEquals("Projeto De Construção de Uma Ferroviaria", oportunidade.getDescricao());
        assertEquals(1000000, oportunidade.getValor());
        assertEquals(Oportunidade.Status.ABERTA, oportunidade.getStatus());
    }
    @Test
    void testCriacaoDeAtividade (){
        Cliente cliente = new Cliente("Teste", "teste@email.com", "00-0000-0000", "Teste");
        Atividade atividade = new Atividade(Atividade.Tipo.REUNIAO, "Reunião 18:00");
        assertNotNull(atividade.getId());
        assertEquals("Reunião 18:00", atividade.getDescricao());
        assertEquals(Atividade.Tipo.REUNIAO, atividade.getTipo());
    }

    @Test
    void testAlterarStatusOportunidade(){
        Oportunidade oportunidade = new Oportunidade("Projeto Teste", 3000.0);

        oportunidade.setStatus(Oportunidade.Status.GANHA);
        assertEquals(Oportunidade.Status.GANHA, oportunidade.getStatus());

        oportunidade.setStatus(Oportunidade.Status.PERDIDA);
        assertEquals(Oportunidade.Status.PERDIDA, oportunidade.getStatus());
    }

    @Test
    void testTiposAtividade() {
        Atividade email = new Atividade(Atividade.Tipo.EMAIL, "Email teste");
        Atividade reuniao = new Atividade(Atividade.Tipo.REUNIAO, "Reunião teste");
        Atividade ligacao = new Atividade(Atividade.Tipo.LIGACAO, "Ligação teste");

        assertEquals(Atividade.Tipo.EMAIL, email.getTipo());
        assertEquals(Atividade.Tipo.REUNIAO, reuniao.getTipo());
        assertEquals(Atividade.Tipo.LIGACAO, ligacao.getTipo());
    }


    @Test
    void testValorNegativoEAceitoPeloSistemaAtual() {
        Oportunidade op = new Oportunidade("Projeto com Valor Negativo", -1000.0);

        assertEquals(-1000.0, op.getValor());
        assertTrue(op.getValor() < 0);
    }

    @Test
    void testDescricaoVaziaEAceitaPeloSistemaAtual() {
        Oportunidade op = new Oportunidade("", 500.0);

        assertEquals("", op.getDescricao());
        assertTrue(op.getDescricao().isEmpty());
    }


    // Testes negativos
    @Test
    void testClienteComListasCheiasError() {
        Cliente cliente = new Cliente("Maria", "maria@email.com", "11-7777-6666", "Maria LTDA");

        // ASSERT FALSO proposital, em uma situação ideal esse teste seria usado para caso o construtor estivesse cheio
        // No Caso estou verificando as oportunidades e Atividades
        assertTrue(cliente.getOportunidades().isEmpty());  // Espera false, mas recebe true
        assertTrue(cliente.getAtividades().isEmpty());     // Espera false, mas recebe true
    }

    @Test
    void testEmailSemArrobaError(){
        Cliente cliente = new Cliente();
        cliente.setEmail("emailsemarroba.com");
        assertFalse(cliente.getEmail().contains("@"));
    }

    @Test
    void testNomeVazioError() {
        Cliente cliente = new Cliente();
        cliente.setNome("");
        assertTrue(cliente.getNome().trim().isEmpty());
    }

    @Test
    void testDescriçãoVaziaError() {
        Oportunidade op = new Oportunidade("", 1000.0);
        assertTrue(op.getDescricao().trim().isEmpty());
    }

    @Test
    void testEmpresaVaziaError() {
        Cliente cliente = new Cliente();
        cliente.setEmpresa("");
        assertTrue(cliente.getEmpresa().trim().isEmpty());
    }

    @Test
    void testTelefoneLetrasError() {
        Cliente cliente = new Cliente();
        cliente.setTelefone("abc-1234");
        assertFalse(cliente.getTelefone().matches("[0-9\\-]+"));
    }

    @Test
    void testTipoAtividadeNuloError() {
        Atividade atv = new Atividade(null, "Descrição teste");
        assertNull(atv.getTipo());
    }

    @Test
    void testStatusOportunidadeNuloError() {
        Oportunidade op = new Oportunidade("Teste", 1000.0);
        op.setStatus(null);
        assertNull(op.getStatus());
    }

    @Test
    void testValorZeroOportunidadeError() {
        Oportunidade op = new Oportunidade("Projeto Zero", 0.0);
        assertFalse(op.getValor() > 0); // Espera > 0, mas recebe 0.0
    }

    @Test
    void testDescricaoAtividadeVaziaError() {
        Atividade atv = new Atividade(Atividade.Tipo.EMAIL, "");
        assertTrue(atv.getDescricao().trim().isEmpty()); // Espera não vazio, mas recebe vazio
    }

}
