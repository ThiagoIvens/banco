package bd;

import java.util.ArrayList;

import entidades.Usuarios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BDUsuarios implements BDUsuariosInterface {

	public static ObservableList<Usuarios> users;

	@Override
	public Usuarios getUser(String username) {
		users = getUsers();
		for (Usuarios user : users)
			if (user.getName().contentEquals(username))
				return user;
		return null;
	}
	
	@Override
	public ObservableList<Usuarios> getUsers() {
		if (users == null) {
			users = FXCollections.observableArrayList(new ArrayList<Usuarios>());
			users.add(new Usuarios("admin", "admin"));
		}
		return users;
	}
	
	@Override
	public void changePass(String username, String newPass) {
		Usuarios user = getUser(username);
		user.setPass(newPass);
	}

	@Override
	public void addUser(String username, String pass) {
		getUsers().add(new Usuarios(username, pass));
	}
}
