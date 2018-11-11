public class Event {
    public String What;
    public String Who;
    public int HowMuch;

    public boolean isEmpty() {
        return What == null || Who == null;
    }
    Event() {
        What = null;
        Who = null;
        HowMuch = 0;
    }

    Event(String What, String When) {
        this.What = What;
        this.Who = When;

    }
    Event(String What, String When, int HowMuch) {
        this.What = What;
        this.Who = When;
        this.HowMuch = HowMuch;
    }
    public void printEvent() {
        System.out.println(What);
        System.out.println(Who);
        System.out.println(HowMuch);
    }
}
