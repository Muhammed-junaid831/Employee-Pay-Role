import java.util.ArrayList;

abstract class Employe {
    private String name ;
    private  int id;

    public Employe(String name,int id){
       this.name = name;
       this.id =id;
    }
    public String getName(){
    return name;
    }
    public int getId(){
        return id;
    }
    abstract public double calculateSalary();

    @Override
    public String toString(){
      return "Employe [name " + name + "id="+id+" salary="+calculateSalary()+"]";
    }
}
class fullTimeEmploye extends Employe {
    private double monthlySalary;

    public fullTimeEmploye(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
        @Override
        public double calculateSalary(){
            return monthlySalary;
        }
    }
    class partTimeEmploye extends Employe {
        private int hoursWork;
        private double hourlyRate;

        partTimeEmploye(String name,int id,int hoursWork,double hourlyRate){
          super(name,id);
          this.hoursWork = hoursWork;
          this.hourlyRate =hourlyRate;
        }
        @Override
        public double calculateSalary(){
            return hoursWork * hourlyRate ;
        }
    }

    class payRollSystem  {
        private ArrayList<Employe> employeList;

        public payRollSystem(){
             employeList = new ArrayList<>();
        }
        public void addEmploye(Employe employe){
         employeList.add(employe);
        }
        public void removeEmploye(int id){
            Employe employeToRemove = null;
            for(Employe employe : employeList){
                if(employe.getId() == id){
                   employeToRemove =  employe;
                   break;
                }
            }
            if(employeToRemove != null){
                employeList.remove(employeToRemove);
            }
        }
        public void displayEmploye(){
            for(Employe employe:employeList){
                System.out.println(employe);
            }
        }
    }


public class project {
    public static void main(String[] args) {
        payRollSystem payrollsystem = new payRollSystem();
        fullTimeEmploye emp1 = new fullTimeEmploye("yaseer ",1 ,70000.0);
        fullTimeEmploye emp2 = new fullTimeEmploye("ashfan ",2 ,50000.0);
        partTimeEmploye emp3 = new partTimeEmploye("arman ",3 ,40 ,90);
        partTimeEmploye emp4 = new partTimeEmploye("saif ",4 ,90,120);


        payrollsystem.addEmploye(emp1); 
        payrollsystem.addEmploye(emp2);
        payrollsystem.addEmploye(emp3);
        payrollsystem.addEmploye(emp4);

        System.out.println("Intital Employe details ");
        payrollsystem.displayEmploye();

        System.out.println("Removing Employe ");
        payrollsystem.removeEmploye(2);

        System.out.println("Remaining Employe details ");
        payrollsystem.displayEmploye();
    }
}
