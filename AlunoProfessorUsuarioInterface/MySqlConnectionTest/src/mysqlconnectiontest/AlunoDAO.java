package mysqlconnectiontest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class AlunoDAO implements IDao <Aluno>{
    
    private Connection conn;
    public AlunoDAO(Connection c){
        this.conn = c;
    }
    
    @Override
    public void insere(Aluno a){
        try {
        String sql = "insert into Aluno(Nome) values('"+a.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    @Override
    public void update (Aluno u) /*throws SQLException*/ 
    {
        try
        {
            String sql = "UPDATE Aluno SET nome = '"+u.getNome()+"' WHERE id = '"+"2"+"'";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close(); 
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    } 
    
    @Override
    public List listar(){
        String sql = "select * from Aluno";
        System.out.println(sql);		
        List al1 = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String Nome = rs.getString("Nome");
                                al1.add("\nID: "+ID+"\nNome: "+Nome);
			}
                        System.out.println(al1);

			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al1;
    }
    
    @Override
    public void deletar(int id){
        try {
        String sql = "delete from aluno where id="+id+";";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        showMessageDialog(null,"Apagou o Aluno com o id: "+id);
        }
        catch(Exception ex){System.out.println(ex);}
        
    }   
}
