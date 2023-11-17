public class CafeManagerViewBidsController {
    public CafeManagerViewBidsController() {}

    public WorkSlot getWorkSlotById(int slotID)
    {
        WorkSlot ws = new WorkSlot();
        ws = ws.getWorkSlotById(slotID);

        return ws;
    }
}
