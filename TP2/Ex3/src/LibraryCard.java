public class LibraryCard {
    private int cardId;
    private String startSubscriptionDate;
    private String endSubscriptionDate;

    public LibraryCard(int cardId, String startSubscriptionDate, String endSubscriptionDate) {
        this.cardId = cardId;
        this.startSubscriptionDate = startSubscriptionDate;
        this.endSubscriptionDate = endSubscriptionDate;
    }

    public int getCardId() {
        return cardId;
    }
    public String getStartSubscriptionDate() {
        return startSubscriptionDate;
    }
    public String getEndSubscriptionDate() {
        return endSubscriptionDate;
    }

    public void cardInformation() {
        System.out.println(cardId + " " + startSubscriptionDate + " " + endSubscriptionDate);
    }
}
