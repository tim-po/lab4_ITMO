public class Action extends Event implements describable{
    private Person performer;
    private boolean does_have_mood;
    private Mood mood;

    @Override
    void hapen() {
        describe();
        if(does_have_mood) {
            performer.setMood(mood);
        }
    }

    @Override
    public void describe() {
        System.out.print(performer.toString());
        System.out.print(" совершает действие: ");
        System.out.print(this.toString() + "\n");
    }

    public Action(String name, Person performer){
        super(name);
        this.performer = performer;
        this.mood = Mood.bad;
        this.does_have_mood = false;
    }

    public Action(String name, Person performer, Mood mood){
        super(name);
        this.performer = performer;
        this.mood = mood;
        this.does_have_mood = true;
    }
}
