package mysqlconnectiontest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProfessorDAO {
    
    private Connection conn;
    public ProfessorDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Professor p) throws SQLException{
        try {
        String sql = "insert into Professor(Nome) values('"+p.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public void update (String novo, String id) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE professor SET nome = '"+novo+"' WHERE id = '"+id+"'");
    ps.executeUpdate();
    ps.close();
    
    }
     
    public List listar() {
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
				System.out.println(al1);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al1;
	}
    public void remover(int id) throws SQLException{
        try {
        String sql = "delete from professor where id="+id+";";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        showMessageDialog(null,"ID 2 apagado");
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
}
