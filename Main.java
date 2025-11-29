/*import java.util.*;
class VacancyRequest {
    String title;
    String description;
    boolean approved;
    VacancyRequest(String title, String desc) {
        this.title = title;
        this.description = desc;
        this.approved = false;
    }
}
class Candidate {
    String name;
    int courage;
    int intelligence;
    int magic;
    boolean passedHR = false;
    boolean passedTech = false;

    Candidate(String name, int courage, int intelligence, int magic) {
        this.name = name;
        this.courage = courage;
        this.intelligence = intelligence;
        this.magic = magic;
    }
}
class HR {
    boolean checkVacancy(VacancyRequest req){
        System.out.println("HR: Вакансияны тексерудемін...");
        return req.description.length() > 10;
    }

    boolean firstInterview(Candidate c){
        System.out.println("HR: Алғашқы сұхбат — батылдығын сынау!");
        boolean pass = c.courage + c.intelligence >= 10;
        c.passedHR = pass;
        System.out.println(pass ? "⚔ " + c.name + " сынақты сәтті өтті!" : "Батылдығы жетпейді...");
        return pass;
    }

    void invite(Candidate c){ System.out.println("HR: «"+c.name+"», сұхбатқа шақырамыз!"); }
    void reject(Candidate c){ System.out.println("HR: Құрметті "+c.name+", келесіде сәттілік!"); }
}
class Manager {
    void createVacancy(VacancyRequest req){
        System.out.println("Басшы: Жаңа жауынгер (Java Dev) іздейміз!");
    }

    boolean technicalInterview(Candidate c) {
        System.out.println("Техникалық сынақ — сиқыр деңгейін тексеру!");
        boolean ok = c.magic >= 6;
        c.passedTech = ok;
        System.out.println(ok ? "Сиқыры күшті!" : "Сиқыры әлсіз...");
        return ok;
    }
}
class ITDept {
    void prepare(String name){
        System.out.println("IT: " + name + " үшін супер ортаны дайындадық!");
    }
}
class SystemService {
    void addEmployee(String name){
        System.out.println("Жүйе: " + name + " енді біздің батырлар құрамында!");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        HR hr = new HR();
        ITDept it = new ITDept();
        SystemService sys = new SystemService();
        System.out.println("Жұмысқа қабылдау корольдігі басталды!");
        VacancyRequest req = new VacancyRequest("Java Wizard", "Кем дегенде 3 жылдық сиқыршылық тәжірибесі бар кодер.");
        manager.createVacancy(req);
       if(!hr.checkVacancy(req)){
            System.out.println("Басшы: О, HR ханым, дұрыстадым!");
        }
        req.approved = true;
        System.out.println("Вакансия ашылды! Үлкен сайыс басталды!");

        List<Candidate> list = Arrays.asList(
                new Candidate("Aida", 5, 6, 8),
                new Candidate("Bulat", 3, 3, 2)
        );

        System.out.println("Кандидаттар өтініштерін жіберуде...");

        for(Candidate c: list){
            if(c.courage + c.intelligence < 7){
                hr.reject(c);
                continue;
            }
            hr.invite(c);
            if(!hr.firstInterview(c)){
                hr.reject(c);
                continue;
            }
            if(!manager.technicalInterview(c)){
                hr.reject(c);
                continue;
            }
            System.out.println("Оффер берілді: " + c.name);
            System.out.println("good " + c.name + " ұсынысты қабылдады!");
            sys.addEmployee(c.name);
            it.prepare(c.name);
        }

        System.out.println("Процесс аяқталды! Корольдікке жаңа батыр қосылды!");
    }
}*/