import java.util.ArrayList;

final class viewAccountsController {
    public viewAccountsController(){}

    public ArrayList<User> displayAll(){
        User aUser = new User();
        return aUser.empRecordArray();
    }
}
