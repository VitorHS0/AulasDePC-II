package mysqlconnectiontest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class UsuarioDAO implements IDao <Usuario>{
    
    private Connection conn;
    public UsuarioDAO(Connection c){
        this.conn = c;
    }
    
    @Override
    public void insere(Usuario u){
        try {
        String sql = "insert into Usuario(Nome, Senha) values('"+u.getNome()+"','"+u.getSenha()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    @Override
    public void update (Usuario u) /*throws SQLException*/ 
    {
        try
        {
            String sql = "UPDATE Usuario SET nome = '"+u.getNome()+"' WHERE senha = '"+u.getSenha()+"'";
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
        String sql = "select * from Usuario";
        System.out.println(sql);		
        List al1 = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String Nome = rs.getString("Nome");
                                String Senha = rs.getString("Senha");
                                al1.add("\nID: "+ID+"\nNome: "+Nome+"\nSenha: "+Senha);
			}
                        System.out.println(al1);

			prepareStatement.close();
		} catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return al1;
    }
    
    @Override
    public void deletar(int id){
        try {
        String sql = "delete from Usuario where id="+id+";";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        showMessageDialog(null,"Apagou o Usuario com o id: "+id);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
     
    public void Login (Usuario u) throws SQLException{
        
        try{
        String sql = "select * from usuario where Senha='"+u.getSenha()+"';";
        String senha="";
        int id=0;
        String nome="";
        PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	ResultSet rs = prepareStatement.executeQuery();
        while (rs.next())
            {
                senha=rs.getString("Senha");
                nome=rs.getString("Nome");
                id=rs.getInt("ID");
                System.out.println("ID: "+id+"\nNOME: "+nome+"\nSENHA: "+senha);                
            }
        if(senha.equals(u.getSenha())) //Alterar para a ultima senha funcionar
        {
            showMessageDialog(null,"Login efetuado com sucesso");
            sql = "";
            senha = "";
        }
            else
            {
                showMessageDialog(null,"Senha ou Usuário incorreto");
                sql = "";
                senha = "";
            }   
        
         
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }       
    }      
}

