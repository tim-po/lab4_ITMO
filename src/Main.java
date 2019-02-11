public class Main {
    public static void main(String[] args){
        Place little_guys_home = new Place("дом");
        Person little_guy = new Person(7, "малыш",GenderSetting.MALE, little_guys_home);
        Action cry = new Action("плакать на кровате", little_guy, Mood.bad);
        cry.hapen();

        Place carlasons = new Place("дом");
        Person carlason = new Person(35, "карласон",GenderSetting.CUSTOME, "мужчина в самом расцвете сил", carlasons);

        little_guy.birthday_begin();
        carlason.visit(little_guy);
        little_guy.birthday_end();

        Natural_event sumertime = new Natural_event("началось лето");
        sumertime.hapen();

        Natural_event school_end = new Natural_event("занятия в школле закончились");
        school_end.hapen();

        Action bd = new Action("ждать дня рождения", little_guy);
        bd.hapen();

        Action fly_on_fan = new Action("лететь в небо", carlason){
            @Override
            void hapen() {
                super.hapen();
                Place sky = new Place("небо");
                carlason.change_inhabitance(sky);
            }
        };
        fly_on_fan.hapen();

        Place countryside = new Place("деревня");
        Person granny = new Person(70, "бабушка",GenderSetting.FEMALE, countryside);

        little_guy.visit(granny);
    }
}
