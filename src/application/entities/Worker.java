package application.entities;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Departament departament;
    //Como um worker (trabalhador) tem vários contratos, o vários teria que ser representado como uma lista, para usar o List é preciso importar no java.util.List, nesse caso já vamos instanciar a lista já na declaração do atributo//
    private List<HourContract> contracts = new ArrayList<>();
    //quando tiver uma composição "tem muitos" (no caso uma lista) não se inclui ela no construtor, inicia ela vazia na própria delcaração.
    public Worker(){
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    

    public Double income(int year, int month){
         double sum = baseSalary;
         Calendar cal = Calendar.getInstance();
         for(HourContract c : contracts){
            cal.setTime(c.getDate());

            int c_year = cal.get(Calendar.YEAR);

            int c_month = 1 + cal.get(Calendar.MONTH); 

            if (year == c_year && month == c_month){
                sum += c.totalValue();
            }
         }
        return sum;
    }

}




