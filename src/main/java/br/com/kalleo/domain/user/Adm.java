package br.com.kalleo.domain.user;

public class Adm {
    private String email;
    private String senha;
    private int senhaConfimacao;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getSenhaConfimacao() {
        return senhaConfimacao;
    }

    public void setSenhaConfimacao(int senhaConfimacao) {
        this.senhaConfimacao = senhaConfimacao;
    }
}
