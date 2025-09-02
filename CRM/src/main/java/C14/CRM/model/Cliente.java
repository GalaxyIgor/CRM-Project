package C14.CRM.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String empresa;
    private List<Oportunidade> oportunidades;
    private List<Atividade> atividades;

    public Cliente() {
        this.id = UUID.randomUUID().toString();
        this.oportunidades = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    public Cliente(String nome, String email, String telefone, String empresa) {
        this();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.empresa = empresa;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public List<Oportunidade> getOportunidades() { return oportunidades; }
    public List<Atividade> getAtividades() { return atividades; }

    // Métodos para adicionar oportunidades e atividades
    public void adicionarOportunidade(Oportunidade oportunidade) {
        this.oportunidades.add(oportunidade);
    }

    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", empresa='" + empresa + '\'' +
                ", oportunidades=" + oportunidades.size() +
                ", atividades=" + atividades.size() +
                '}';
    }
}