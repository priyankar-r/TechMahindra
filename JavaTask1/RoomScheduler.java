import java.util.*;
public class RoomScheduler {
    private Map<String, MeetingRoom> rooms = new HashMap<>();
    //add's meeting room to the scheduler
    public void addMeetingRoom(MeetingRoom room) {
        rooms.put(room.roomId, room);
        System.out.println("Room added: " + room.roomName + ", ID: " + room.roomId);
    }
    //book's room if requirement is matched
    public String bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = rooms.get(roomId);
        if (room != null && room.features.containsAll(requiredFeatures)) {
            return "Room " + roomId + " booked successfully.";
        } else {
            return "Room " + roomId + " does not meet the requirements.";
        }
    }
    // displays available rooms that match required features
    public List<String> listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : rooms.values()) {
            if (room.features.containsAll(requiredFeatures)) {
                availableRooms.add(room.roomName);
            }
        }
        return availableRooms;
    }
}
