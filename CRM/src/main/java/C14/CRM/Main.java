package C14.CRM;

import C14.CRM.model.Atividade;
import C14.CRM.model.Cliente;
import C14.CRM.model.Oportunidade;
import C14.CRM.repository.ClienteRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA CRM SIMPLIFICADO ===");

        ClienteRepository repository = new ClienteRepository();

        // Criar clientes
        Cliente cliente1 = new Cliente("Igor Silva", "igor@email.com", "11-9999-9999", "Igor Company");
        Cliente cliente2 = new Cliente("Maria Santos", "maria@email.com", "11-8888-8888", "Maria Enterprises");

        // Salvar clientes
        repository.salvarCliente(cliente1);
        repository.salvarCliente(cliente2);

        // Adicionar oportunidades
        repository.adicionarOportunidade(cliente1.getId(), "Website Corporativo", 15000.00);
        repository.adicionarOportunidade(cliente1.getId(), "Sistema de Gestão", 25000.00);
        repository.adicionarOportunidade(cliente2.getId(), "Consultoria Marketing", 12000.00);

        // Adicionar atividades
        repository.adicionarAtividade(cliente1.getId(), Atividade.Tipo.REUNIAO, "Apresentação inicial");
        repository.adicionarAtividade(cliente1.getId(), Atividade.Tipo.LIGACAO, "Follow-up proposta");
        repository.adicionarAtividade(cliente2.getId(), Atividade.Tipo.EMAIL, "Envio de documentação");

        // Listar todos os clientes
        System.out.println("\n--- TODOS OS CLIENTES ---");
        for (Cliente cliente : repository.listarTodos()) {
            System.out.println(cliente);

            // Mostrar oportunidades do cliente
            if (!cliente.getOportunidades().isEmpty()) {
                System.out.println("  Oportunidades:");
                for (Oportunidade op : cliente.getOportunidades()) {
                    System.out.println("  - " + op);
                }
            }

            // Mostrar atividades do cliente
            if (!cliente.getAtividades().isEmpty()) {
                System.out.println("  Atividades:");
                for (Atividade atv : cliente.getAtividades()) {
                    System.out.println("  - " + atv);
                }
            }
            System.out.println();
        }

        // Buscar cliente específico
        System.out.println("--- BUSCAR CLIENTE POR ID ---");
        Cliente clienteBuscado = repository.buscarPorId(cliente1.getId());
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
            System.out.println("Total em oportunidades: R$ " +
                    clienteBuscado.getOportunidades().stream()
                            .mapToDouble(Oportunidade::getValor)
                            .sum());
        }
    }
}