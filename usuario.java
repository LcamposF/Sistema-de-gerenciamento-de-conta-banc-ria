class Usuario {
    private String id;
    private String senha;
    private boolean autorizado;

    public Usuario(String id, String senha, boolean autorizado) {
        this.id = id;
        this.senha = senha;
        this.autorizado = autorizado;
    }

    public String getId() {
        return this.id;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public boolean isAutorizado() {
        return this.autorizado;
    }
}