package mysqlconnectiontest;

public class MySqlConnectionTest {

    public static void main(String[] args)throws Exception{
        System.out.println(JdbcUtil.getConnection());
        AlunoDAO alunodao = new AlunoDAO(JdbcUtil.getConnection());
        alunodao.insere((new Aluno("Vitor")));
        alunodao.insere((new Aluno("Henrique")));
        alunodao.insere((new Aluno("Caio")));
        alunodao.update("João", "3");
        alunodao.remover(1);
        alunodao.listar();
        
        /*-----------------------*/
        ProfessorDAO professordao = new ProfessorDAO(JdbcUtil.getConnection());
        professordao.insere((new Professor("Carlos")));
        professordao.insere((new Professor("Wagner")));
        professordao.insere((new Professor("Rogerio")));
        professordao.update("Luciano", "2");
        professordao.remover(2);
        professordao.listar();
        
        /*-----------------------*/
        UsuarioDAO usuariodao = new UsuarioDAO(JdbcUtil.getConnection());
        usuariodao.insere((new Usuario("Fernando")));
        usuariodao.insere((new Usuario("Erick")));
        usuariodao.insere((new Usuario("Laryssa")));
        usuariodao.update("Bianca", "3");
        usuariodao.remover(3);
        usuariodao.listar();
        
        
        //alunodao.update();
    }
    
}
