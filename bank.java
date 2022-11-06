import java.util.ArrayList;

public class bank {
    private String name;
    private  ArrayList<user> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }

    public bank(String name, ArrayList<user> users) {
        this.name = name;
        this.users = users;
    }
}
