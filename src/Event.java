public abstract class Event{
    private String name;

    abstract void hapen();

    @Override
    public String toString() {
        return name;
    }

    public Event(String name){
        this.name = name;
    }
}
