import C14.CRM.model.Atividade;
import C14.CRM.model.Cliente;
import C14.CRM.model.Oportunidade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    // Testes Positivos
    @Test
    void testCriacaoCliente() {
        Cliente cliente = new Cliente("João Silva", "joao@email.com", "11-9999-8888", "João Company");
        assertNotNull(cliente.getId()); // Recebe True
        assertEquals("João Silva", cliente.getNome()); // Recebe True
        assertEquals("joao@email.com", cliente.getEmail()); // Recebe True
        assertEquals("11-9999-8888", cliente.getTelefone()); // Recebe True
        assertEquals("João Company", cliente.getEmpresa()); // Recebe True
        assertTrue(cliente.getOportunidades().isEmpty());
        assertTrue(cliente.getAtividades().isEmpty());
    }

    @Test
    void testClienteSemOportunidadesEAtividadesInicialmente() {
        Cliente cliente = new Cliente("Lucas", "lucas@email.com", "33-1111-2222", "Empresa Z");
        assertTrue(cliente.getOportunidades().isEmpty());
        assertTrue(cliente.getAtividades().isEmpty());
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
    void testAlterarValorOportunidade() {
        Oportunidade oportunidade = new Oportunidade("Upgrade Sistema", 2000.0);
        oportunidade.setValor(3500.0);
        assertEquals(3500.0, oportunidade.getValor());
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
        Atividade atividade = new Atividade(Atividade.Tipo.REUNIAO, "Reunião 18:00");
        assertNotNull(atividade.getId());
        assertEquals("Reunião 18:00", atividade.getDescricao());
        assertEquals(Atividade.Tipo.REUNIAO, atividade.getTipo());
    }

    @Test
    void testAlterarStatusOportunidade(){ // No caso aqui ele passa de aberta p/ ganha
        Oportunidade oportunidade = new Oportunidade("Projeto Teste", 3000.0);

        oportunidade.setStatus(Oportunidade.Status.GANHA);
        assertEquals(Oportunidade.Status.GANHA, oportunidade.getStatus());
    }

    @Test
    void testAlterarDescricaoAtividade() {
        Atividade atividade = new Atividade(Atividade.Tipo.LIGACAO, "Ligação inicial");
        atividade.setDescricao("Ligação finalizada");
        assertEquals("Ligação finalizada", atividade.getDescricao());
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
    // TESTES DE VALIDAÇÃO

    @Test
    void testEmailSemArrobaDeveError() {
        Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class,
                () -> cliente.setEmail("emailsemarroba.com"));
    }

    @Test
    void testNomeVazioError() {
        Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class,
                () -> cliente.setNome(""));
    }

    @Test
    void testDescriçãoVaziaError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Oportunidade("", 1000.0));
    }

    @Test
    void testEmpresaVaziaError() {
        Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class,
                () -> cliente.setEmpresa(""));
    }

    @Test
    void testTelefoneInvalidoError() {
        Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class,
                () -> cliente.setTelefone("abc-1234"));
    }

    @Test
    void testTipoAtividadeNuloError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Atividade(null, "Descrição teste"));
    }

    @Test
    void testStatusOportunidadeNuloError() {
        Oportunidade op = new Oportunidade("Teste", 1000.0);
        assertThrows(IllegalArgumentException.class,
                () -> op.setStatus(null));
    }

    @Test
    void testValorZeroOportunidadeError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Oportunidade("Projeto Zero", 0.0));
    }

    @Test
    void testValorNegativoOportunidadeDeveFalhar() {
        assertThrows(IllegalArgumentException.class,
                () -> new Oportunidade("Projeto Negativo", -500.0));
    }

    @Test
    void testDescricaoAtividadeVaziaError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Atividade(Atividade.Tipo.EMAIL, ""));
    }

}
