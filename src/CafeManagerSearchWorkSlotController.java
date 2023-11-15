import java.util.ArrayList;

public class CafeManagerSearchWorkSlotController {

    public CafeManagerSearchWorkSlotController() {
        
    }

    public ArrayList <WorkSlot> searchWorkSlot(String userinput){
        WorkSlot ws = new WorkSlot();
        return ws.searchWorkSlots(userinput);
    }
    
}
