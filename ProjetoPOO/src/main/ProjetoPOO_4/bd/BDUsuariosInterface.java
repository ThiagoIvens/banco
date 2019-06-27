package bd;

import entidades.Usuarios;
import javafx.collections.ObservableList;

public interface BDUsuariosInterface {

	public Usuarios getUser(String username);

	public ObservableList<Usuarios> getUsers();

	public void changePass(String username, String newPass);

	public void addUser(String username, String pass);

}
