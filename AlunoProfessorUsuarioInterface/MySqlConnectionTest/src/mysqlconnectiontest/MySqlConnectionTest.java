package mysqlconnectiontest;

public class MySqlConnectionTest {

    public static void main(String[] args){
        
        try
        {
            System.out.println(JdbcUtil.getConnection());
            AlunoDAO alunodao = new AlunoDAO(JdbcUtil.getConnection());
            alunodao.insere((new Aluno("Vitor")));
            alunodao.insere((new Aluno("Henrique")));
            alunodao.insere((new Aluno("Caio")));
            alunodao.update((new Aluno("Felipe")));
            alunodao.deletar(1);
            alunodao.listar();
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        try
        {
            System.out.println(JdbcUtil.getConnection());
            ProfessorDAO professordao = new ProfessorDAO(JdbcUtil.getConnection());
            professordao.insere((new Professor("Camargo")));
            professordao.insere((new Professor("Luan")));
            professordao.insere((new Professor("Samantha")));
            professordao.update((new Professor("Thiago")));
            professordao.deletar(1);
            professordao.listar();
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        try
        {
            System.out.println(JdbcUtil.getConnection());
            UsuarioDAO usuariodao = new UsuarioDAO(JdbcUtil.getConnection());          
            usuariodao.insere((new Usuario("Lucas", "PaoEhGostoso", "")));            
            usuariodao.insere((new Usuario("Pedrão", "123asd", "")));           
            usuariodao.insere((new Usuario("Leopoldo", "MbEmFissor", "")));//Somente o ultimo user é valido.
            usuariodao.update((new Usuario("Vanessa","PaoEhGostoso","")));
            usuariodao.deletar(2);          
            usuariodao.listar();
            usuariodao.Login((new Usuario("Leopoldo","MbEmFissor", "")));
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
