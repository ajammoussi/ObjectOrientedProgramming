package Misc;

public class Feedback {
    private int ID;
    private int userID;
    private int rating;
    private String writtenfFeedback;

    public Feedback(int ID, int userID, int rating, String writtenfFeedback) {
        this.ID = ID;
        this.userID = userID;
        this.rating = rating;
        this.writtenfFeedback = writtenfFeedback;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public int getRating() {
        return rating;
    }

    public String getWrittenfFeedback() {
        return writtenfFeedback;
    }

    public void feedbackInformation() {
        System.out.println("Feedback ID: " + ID);
        System.out.println("User ID: " + userID);
        System.out.println("Rating: " + rating);
        System.out.println("Written Feedback: " + writtenfFeedback);
        System.out.println("===============");
    }
}
