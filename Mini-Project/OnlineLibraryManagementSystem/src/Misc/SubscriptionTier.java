package Misc;

public abstract class SubscriptionTier {
    private int tierID;
    private String tierName;
    private String subStartDate;
    private String subEndDate;

    public SubscriptionTier(int tierID, String tierName, String subStartDate, String subEndDate) {
        this.tierID = tierID;
        this.tierName = tierName;
        this.subStartDate = subStartDate;
        this.subEndDate = subEndDate;
    }

    public void setSubStartDate(String subStartDate) {
        this.subStartDate = subStartDate;
    }

    public void setSubEndDate(String subEndDate) {
        this.subEndDate = subEndDate;
    }

    public int getTierID() {
        return tierID;
    }

    public void tierInformation() {
        System.out.println("Tier ID: " + tierID);
        System.out.println("Tier Name: " + tierName);
        System.out.println("Subscription Start Date: " + subStartDate);
        System.out.println("Subscription End Date: " + subEndDate);
        System.out.println("===============");
    }
}
