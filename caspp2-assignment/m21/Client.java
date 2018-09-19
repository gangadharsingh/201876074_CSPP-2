import java.util.Scanner;
import java.util.*;

class Fitnessgoals {

    ArrayList<Foodlog> foodlog;
    ArrayList<Waterlog> waterlog;
    ArrayList<PhysicalActivity> physicalactivitylog;
    ArrayList<Weightlog> weightlog;
    ArrayList<Sleeplog> sleeplog;

    Fitnessgoals() {
        foodlog = new ArrayList<Foodlog>();
        waterlog = new ArrayList<Waterlog>();
        physicalactivitylog = new ArrayList<PhysicalActivity>();
        weightlog = new ArrayList<Weightlog>();
        sleeplog = new ArrayList<Sleeplog>();
    }

    public void addFoodlog(String[] food) {
        foodlog.add(new Foodlog(food));
    }
    public void showFoodlog() {
        System.out.println("Food");
        if (foodlog.size() == 0) {
            System.out.println("None");
            return ;
        }
        for (Foodlog flog : foodlog) {
            System.out.println(flog);
        }
    }

    public void addWaterlog(String[] water) {
        waterlog.add(new Waterlog(water));
    }
    public void showWaterlog() {
        System.out.println("Water");
        if (waterlog.size() == 0) {
            System.out.println("None");
            return ;
        }
        for (Waterlog wlog : waterlog) {
            System.out.println(wlog);
        }
    }

    public void addPhysicalActivity(String[] activity) {
        physicalactivitylog.add(new PhysicalActivity(activity));
    }
    public void showPhysicalActivity() {
        System.out.println("PhysicalActivity");
        if (physicalactivitylog.size() == 0) {
            System.out.println("None");
            return;
        }
        for (PhysicalActivity palog : physicalactivitylog) {
            System.out.println(palog);
        }
    }

    public void addWeightlog(String[] weight) {
        weightlog.add(new Weightlog(weight));
    }
    public void showWeightlog() {
        System.out.println("Weight");
        if (weightlog.size() == 0) {
            System.out.println("None");
            return;
        }
        for (Weightlog wtlog : weightlog) {
            System.out.println(wtlog);
        }
    }

    public void addSleeplog(String[] sleep) {
        sleeplog.add(new Sleeplog(sleep));
    }
    public void showSleeplog() {
        System.out.println("Sleep");
        if (sleeplog.size() == 0) {
            System.out.println("None");
            return;
        }
        for (Sleeplog slplog : sleeplog) {
            System.out.println(slplog);
        }
    }

    public void showSummary(String date) {

        for (Foodlog fl : foodlog) {
            if (fl.getdate().equals(date)) {
                System.out.println("Food");
                System.out.println(fl);
                System.out.println();
            }
        }
        for (Waterlog wlog : waterlog) {
            if (wlog.getdate().equals(date)) {
                System.out.println("Water");
                System.out.println(wlog);
                System.out.println();
            }
        }
        for (PhysicalActivity palog : physicalactivitylog) {
            if (palog.getdate().equals(date)) {
                System.out.println("PhysicalActivity");
                System.out.println(palog);
                System.out.println();
            }
        }
        for (int i = 0; i < weightlog.size(); i++) {
            if (weightlog.get(i).getdate().equals(date)) {
                System.out.println("Weight");
                System.out.println(weightlog.get(i));
                System.out.println();
            }
        }
        for (int i = 0; i < sleeplog.size(); i++) {
            if (sleeplog.get(i).getdate().equals(date)) {
                System.out.println("Sleep");
                System.out.println(sleeplog.get(i));
                System.out.println();
            }
        }

        for (Foodlog fl : foodlog) {
            if (fl.getdate().equals(date)) {
                System.out.println("Food");
                System.out.println(fl);
            }
        }
        for (Waterlog wlog : waterlog) {
            if (wlog.getdate().equals(date)) {
                System.out.println("Water");
                System.out.println(wlog);
            }
        }
        for (PhysicalActivity palog : physicalactivitylog) {
            if (palog.getdate().equals(date)) {
                System.out.println("PhysicalActivity");
                System.out.println(palog);
            }
        }
        for (int i = 0; i < weightlog.size(); i++) {
            if (weightlog.get(i).getdate().equals(date)) {
                System.out.println("Weight");
                System.out.println(weightlog.get(i));
            }
        }
        for (int i = 0; i < sleeplog.size(); i++) {
            if (sleeplog.get(i).getdate().equals(date)) {
                System.out.println("Sleep");
                System.out.println(sleeplog.get(i));
            }
        }
    }
    public void showSummary() {
        showFoodlog();
        showWaterlog();
        showPhysicalActivity();
        showWeightlog();
        showSleeplog();
    }
}

public final class Client {

    public static void main(final String[] args) {

        Scanner sc =  new Scanner(System.in);

        Fitnessgoals fitbit = new Fitnessgoals();

        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
            case "Food":
                String[] fd = token[1].split(",");
                fitbit.addFoodlog(fd);
                break;
            case "Water":
                String[] water = token[1].split(",");
                fitbit.addWaterlog(water);
                break;
            case "PhysicalActivity":
                String[] physact = token[1].split(",");
                fitbit.addPhysicalActivity(physact);
                break;
            case "Weight":
                String[] wt = token[1].split(",");
                fitbit.addWeightlog(wt);
                break;
            case "Sleep":
                String[] sleep = token[1].split(",");
                fitbit.addSleeplog(sleep);
                break;
            case "Summary":
                if (token.length == 2) {
                    fitbit.showSummary(token[1]);
                } else {
                    fitbit.showSummary();
                }
                System.out.println();
                break;
            case "Foodlog":
                fitbit.showFoodlog();
                System.out.println();
                break;
            case "Waterlog":
                fitbit.showWaterlog();
                System.out.println();
                break;
            case "PhysicalActivitylog":
                fitbit.showPhysicalActivity();
                System.out.println();
                break;
            case "Weightlog":
                fitbit.showWeightlog();
                System.out.println();
                break;
            case "Sleeplog":
                fitbit.showSleeplog();
                System.out.println();
                break;
            default:
            }
        }
    }
}