import com.sun.tools.javah.Gen;

public class Person implements describable, birthdayable{
    private Integer age;
    private String name;
    private Place curentInhabitance;
    private Boolean birthdayFlag;
    private Mood mood;
    private Gender gender;

    public Place getCurentInhabitance() {
        return curentInhabitance;
    }

    public void change_inhabitance(Place newInhabitance){
        this.curentInhabitance = newInhabitance;
        System.out.print(name);
        System.out.print(" отправился в ");
        System.out.print(newInhabitance.toString());
    }

    public void visit(Person personToVisit){
        try{
            if (curentInhabitance == personToVisit.curentInhabitance){
                throw new SamePlaceException("SamePlaceException self.curentInhabitance == personToVisit.curentInhabitance ==", personToVisit.curentInhabitance);
            }

            Movement visit_move = new Movement(personToVisit.curentInhabitance, this);
            try {
                visit_move.hapen();
            } catch (VisitException ex){
                System.out.println(ex.getMessage());
                System.out.println(ex.getVisitMove());
            }

            System.out.print(" к " + personToVisit.toString());

            if(personToVisit.birthdayFlag){
                System.out.print(" на день рождения " + "\n");
            }
        }
        catch(SamePlaceException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getPlace());
        }
    }

    public void setMood(Mood mood){
        this.mood = mood;
        String moodText = "UNSPECIFIED";

        switch (this.mood) {
            case bad   : moodText = toString() + " настроение = грустно "; break;
            case good : moodText = toString() + " настроение = весело "; break;
            case neutral : moodText = toString() + " настроение = нормально "; break;
        }
         System.out.print(moodText + "\n");
    }

    @Override
    public void birthday_begin(){
        birthdayFlag = true;
        mood = Mood.good;
    }

    @Override
    public void birthday_end(){
        birthdayFlag = false;
        age += 1;
    }

    @Override
    public String toString() {
        return name;
    }

    public Person(Integer age, String name, GenderSetting genderSetting, String customCase, Place curentInhabitance){
        this.age = age;
        this.name = name;
        this.curentInhabitance = curentInhabitance;
        this.gender = new Gender(genderSetting, customCase);

        birthdayFlag = false;

        mood = Mood.neutral;
    }

    public Person(Integer age, String name, GenderSetting genderSetting, Place curentInhabitance){
        this.age = age;
        this.name = name;
        this.curentInhabitance = curentInhabitance;
        try {
            this.gender = new Gender(genderSetting);
        }catch (Gender.GenderSettingException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getSetting());
        }

        birthdayFlag = false;

        mood = Mood.neutral;
    }

    class Gender{
        private GenderSetting setting;
        private String customeCase = "";

        public GenderSetting getSetting() {
            return setting;
        }

        public String getCustomeCase() {
            return customeCase;
        }

        public Gender(GenderSetting setting, String customeCase){
            switch (setting){
                case MALE:
                    this.setting = setting;
                    this.customeCase = "";
                case FEMALE:
                    this.setting = setting;
                    this.customeCase = "";
                case CUSTOME:
                    this.setting = setting;
                    this.customeCase = customeCase;
            }
        }

        public Gender(GenderSetting setting) throws GenderSettingException{
            switch (setting){
                case MALE:
                    this.setting = setting;
                    this.customeCase = "";
                case FEMALE:
                    this.setting = setting;
                    this.customeCase = "";
                case CUSTOME:
                    this.setting = setting;
                    this.customeCase = "UNSPECIFIED";
                    if (setting == GenderSetting.CUSTOME) {
                        throw new GenderSettingException("Custome case unspecified, use Person(Integer age, String name, GenderSetting genderSetting, String customCase, Place curentInhabitance) cunstrucor instead", setting);
                    }
            }
        }

        class GenderSettingException extends Exception {
            private GenderSetting setting;

            GenderSetting getSetting() {
                return setting;
            }

            GenderSettingException(String message, GenderSetting setting){
                super(message);
                this.setting=setting;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return true;
            //Because all genders are equal
        }
    }

    @Override
    public void describe() {
        System.out.print(name + " " + age + " лет");
    }
}
