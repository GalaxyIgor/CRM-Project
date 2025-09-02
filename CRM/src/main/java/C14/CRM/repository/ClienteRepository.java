package C14.CRM.repository;

import C14.CRM.model.Atividade;
import C14.CRM.model.Cliente;
import C14.CRM.model.Oportunidade;
import C14.CRM.persistence.JsonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository {
    private static final String DIRETORIO = "data/clientes/";
    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
        new File(DIRETORIO).mkdirs(); // Cria o diretório se não existir
    }

    public void salvarCliente(Cliente cliente) {
        // Salva cada cliente em arquivo separado
        String arquivo = DIRETORIO + "cliente_" + cliente.getId() + ".json";
        JsonUtils.salvar(arquivo, cliente);
        clientes.add(cliente);
        System.out.println("Cliente salvo: " + cliente.getNome());
    }

    public Cliente buscarPorId(String id) {
        String arquivo = DIRETORIO + "cliente_" + id + ".json";
        return JsonUtils.carregar(arquivo, Cliente.class);
    }

    public List<Cliente> listarTodos() {
        List<Cliente> todosClientes = new ArrayList<>();
        File diretorio = new File(DIRETORIO);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".json"));

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    Cliente cliente = JsonUtils.carregar(arquivo.getPath(), Cliente.class);
                    if (cliente != null) {
                        todosClientes.add(cliente);
                    }
                }
            }
        }
        return todosClientes;
    }

    public void adicionarOportunidade(String clienteId, String descricao, double valor) {
        Cliente cliente = buscarPorId(clienteId);
        if (cliente != null) {
            Oportunidade oportunidade = new Oportunidade(descricao, valor);
            cliente.adicionarOportunidade(oportunidade);
            salvarCliente(cliente); // Atualiza o arquivo
        }
    }

    public void adicionarAtividade(String clienteId, Atividade.Tipo tipo, String descricao) {
        Cliente cliente = buscarPorId(clienteId);
        if (cliente != null) {
            Atividade atividade = new Atividade(tipo, descricao);
            cliente.adicionarAtividade(atividade);
            salvarCliente(cliente); // Atualiza o arquivo
        }
    }
}