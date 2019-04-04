package mysqlconnectiontest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class UsuarioDAO {
    
    private Connection conn;
    public UsuarioDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Usuario u) throws SQLException{
        try {
        String sql = "insert into Usuario(Nome) values('"+u.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public void update (String novo, String id) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET nome = '"+novo+"' WHERE id = '"+id+"'");
    ps.executeUpdate();
    ps.close();
    
    }
     
    public List listar() {
		String sql = "select * from Usuario";
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
        String sql = "delete from usuario where id="+id+";";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        showMessageDialog(null,"ID 3 apagado");
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
}
