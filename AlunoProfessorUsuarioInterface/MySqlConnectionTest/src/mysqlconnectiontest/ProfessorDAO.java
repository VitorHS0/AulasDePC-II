package mysqlconnectiontest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProfessorDAO implements IDao <Professor>{
    
    private Connection conn;
    public ProfessorDAO(Connection c){
        this.conn = c;
    }
    @Override
    public void insere(Professor p){
        try {
        String sql = "insert into Professor(Nome) values('"+p.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    @Override
    public void update (Professor u) /*throws SQLException*/ 
    {
        try
        {
            String sql = "UPDATE Professor SET nome = '"+u.getNome()+"' WHERE id = '"+"2"+"'";
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
        String sql = "select * from Professor";
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
        String sql = "delete from professor where id="+id+";";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        showMessageDialog(null,"Apagou o Professor com o id: "+id);
        }
        catch(Exception ex){System.out.println(ex);}
        
    }   
}
