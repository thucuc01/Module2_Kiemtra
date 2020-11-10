import java.awt.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ManagerDanhBa managerDanhBa=new ManagerDanhBa();
        Menus menus=new Menus();
        Scanner scanner=new Scanner(System.in);
        boolean check;
        do{
            check=true;
            menus.menu3();
            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    managerDanhBa.add();
                    break;
                case "2":
                    managerDanhBa.edit();
                    break;
                case "3":
                    managerDanhBa.delete();
                    break;
                case "4":
                    DachBa danhba=managerDanhBa.search();
                    if(danhba!=null){
                        System.out.println(danhba.toString());
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case "5":
                    managerDanhBa.show();
                    break;
                case "6":
                    System.out.println("_____Co muon xoa toan bo Memmory khong_____");
                    System.out.println("1.Co");
                    System.out.println("2.Khong");
                    String choice1=scanner.nextLine();
                    if(choice1.equals("1")){
                        managerDanhBa.deleteMemmory();
                    }else {
                        if(choice1.equals("2")){
                            managerDanhBa.show();
                        }else {
                            System.out.println("Khong co chuc nang nay");
                        }
                    }
                    break;
                case "7":
                    check=false;
                    System.out.println("________________Exit_________________");
                    break;
                default:
                    System.out.println("Khong co chuc nang nay");
                    break;
            }
        }while (check);

    }
}
