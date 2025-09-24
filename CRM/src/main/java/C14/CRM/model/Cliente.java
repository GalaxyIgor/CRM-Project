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
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setEmpresa(empresa);
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("O email do cliente é inválido.");
        }
        this.email = email;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("[0-9\\-]+")) {
            throw new IllegalArgumentException("O telefone só pode conter números e hífen.");
        }
        this.telefone = telefone;
    }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da empresa não pode ser vazio.");
        }
        this.empresa = empresa;
    }

    public List<Oportunidade> getOportunidades() { return oportunidades; }
    public List<Atividade> getAtividades() { return atividades; }

    // Métodos para adicionar oportunidades e atividades
    public void adicionarOportunidade(Oportunidade oportunidade) {
        if (oportunidade == null) {
            throw new IllegalArgumentException("A oportunidade não pode ser nula.");
        }
        this.oportunidades.add(oportunidade);
    }

    public void adicionarAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new IllegalArgumentException("A atividade não pode ser nula.");
        }
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