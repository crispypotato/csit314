import java.util.ArrayList;

final class viewAccountsController {
    public viewAccountsController(){}

    public ArrayList<User> displayAll(){
        return User.empRecordArray();
    }
}
