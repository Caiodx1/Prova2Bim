 package dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "Crianca")
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @Column(unique = true)
    private String cpf;

    private boolean temAlergia;

    private String descricaoAlergia;

    private String nomeMae;

    private String telefonePais;

    public Crianca() {}

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isTemAlergia() {
        return temAlergia;
    }

    public void setTemAlergia(boolean temAlergia) {
        this.temAlergia = temAlergia;
    }

    public String getDescricaoAlergia() {
        return descricaoAlergia;
    }

    public void setDescricaoAlergia(String descricaoAlergia) {
        this.descricaoAlergia = descricaoAlergia;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTelefonePais() {
        return telefonePais;
    }

    public void setTelefonePais(String telefonePais) {
        this.telefonePais = telefonePais;
    }
}