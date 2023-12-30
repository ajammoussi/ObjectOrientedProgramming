package Misc;

import Users.User;

import java.util.ArrayList;

public class Event {
    private int eventID;
    private String eventName;
    private String eventDate;
    private String eventType;
    private ArrayList<User> participants;

    public Event(int eventID, String eventName, String eventDate, String eventType) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
        participants = new ArrayList<User>();
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void eventInformation() {
        System.out.println("Event ID: " + eventID);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Type: " + eventType);
        System.out.println("Participants: ");
        for (User user : participants) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        System.out.println("===============");
    }

    public void eventInformationUser() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Type: " + eventType);
        System.out.println("===============");
    }
}
