package mysqlconnectiontest;

public class Usuario{
    
    private String Nome, Senha;
    //private String Id ;

    public Usuario(String nome, String senha, String id) {
        this.Nome = nome;
        this.Senha = senha;
        //this.Id = Id;
    }
    
    String getNome() {
        return Nome;
    }
    
    String getSenha() {
        return Senha;
    }
    
    /*String getID() {
        return Id;
    }*/
}
