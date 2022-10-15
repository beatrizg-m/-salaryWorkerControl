package application.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Aplication {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament`s name: ");
        String departamentName = sc.nextLine();
        System.out.println("Enter work data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();

        //Com os dados acima, podemos instânciar nosso trabalhador. Para isso declaramos uma variável do tipo Worker (lembrar de importar do pacote entities) com isso vamos criar um new Worker()com o construtor que contem nome, level, base salary e departament. Como o WorkLevel é do tipo enumerado é necessário transformá-lo em fazendo WorkLeval.valueOf(workLevel) com isso criamos uma instância do tipo enumerado WorkLevel no valor equivalente ao que foi digitado. O departamento é um outro objeto do tipo Departamento, precisamos instânciar um departamente passando o nome que foi digitado, para isso usamos um new Departamente(departamentName)//

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));

        
        
        System.out.print("How  many contracts to this worker? ");
        int n = sc.nextInt();


        //Para verificar quantos contratos e le o valor dos contratos, utilizamos um sysout para receber a quantidade dos contratos, e para ler os dados utilizamos um for.  //
        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract #" + i + "data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hous): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
       

        System.out.println();
        System.out.println("Enter month year to calculate income(MM/YYYY): ");

        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        
         sc.close();

    }
}    
