package mysqlconnectiontest;

import java.util.List;

public interface IDao <T> {
    
    void update(T o);
    void insere(T o);
    void deletar(int o);
    List listar();
}
