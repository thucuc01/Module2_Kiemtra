import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerDanhBa {
    List<DachBa> dachBaList;
    FileIO fileIO=new FileIO();
    Scanner scanner=new Scanner(System.in);

    public ManagerDanhBa() {
        fileIO = new FileIO();
        dachBaList = fileIO.read();
    }

    public void add() {
        if(dachBaList==null){
            dachBaList=new ArrayList<>();
        }
        DachBa danhba1=inputInfo();
        dachBaList.add(danhba1);
        System.out.println("Them moi thanh cong");
        fileIO.write(dachBaList);
    }
    public void edit() {
        System.out.print("Nhap sdt edit :");
        String sdt=scanner.nextLine();
        boolean isExisted = false;
        int size = dachBaList.size();
        for (int i = 0; i < size; i++) {
            if (dachBaList.get(i).getSdt().equals(sdt)) {
                isExisted = true;
                dachBaList.get(i).setSdt(inputSdt());
                dachBaList.get(i).setName(inputName());
                dachBaList.get(i).setGioitinh(inputGioitinh());
                dachBaList.get(i).setAddress(inputAdres());
                dachBaList.get(i).setGroup(inputGroup());
                dachBaList.get(i).setEmail(inputEmail());
                System.out.println("Edit thanh cong");
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", sdt);
        }
        else {
            fileIO.write(dachBaList);
        }
    }

    public DachBa search(){
        String sdt=inputSdt();
        for (DachBa danhba :dachBaList) {
            if (danhba.getSdt().equals(sdt)){
                return danhba;
            }
        }
        return null;
    }

    public void deleteMemmory(){

        dachBaList = new ArrayList<>();
        fileIO.write(dachBaList);
    }


    public void delete() {
        System.out.print("Enter the SDT to delete :");
        int sdt=Integer.parseInt(scanner.nextLine());
        DachBa dachBa = null;
        int size = dachBaList.size();
        int index=0;
        for (int i = 0; i < size; i++) {
            if (dachBaList.get(i).getSdt().equals(sdt)) {
                dachBa = dachBaList.get(i);
                index=i;
                break;
            }
        }
        if (dachBa != null) {
            dachBaList.remove(dachBa);
            fileIO.write(dachBaList);
        } else {
            System.out.printf("id = %d not existed.\n", sdt);
        }
    }
    public void show() {
        try{
            for (DachBa danhba : dachBaList) {
                System.out.println(danhba.toString());
            }
        }catch (Exception e){
            System.out.println("The list is empty !!!! (>.<)");
        }

    }


    public String inputSdt(){
        boolean check;
        String sdt;
        do {

            System.out.print("Moi nhap sdt (9 so nhe!!!) :");
            sdt = scanner.nextLine();
            String regex = "[0-9]{9}";
            check=isMatch(regex,sdt);
            if(!check){
                System.out.println("Moi nhap dung dinh dang");
            }
        }while (!check);
        return sdt;
    }
    public String inputGroup(){
        boolean check;
        String group;
        do{
            check=false;
            menu();
            System.out.println("Nhap Group :");
            group=scanner.nextLine();
            switch (group){
                case "1":
                    return "Gia dinh";
                case "2":
                    return "Ban be";
                default:
                    check=true;
            }
        }while (check);
        return "";
    }

    public String inputName(){
        System.out.println("Moi nhap ten: ");
        String name=scanner.nextLine();
        return name;
    }
    public String inputGioitinh(){
        boolean check;
        String group;
        do{
            System.out.println("Nhap Gioi tinh :");
            check=false;
            menu2();

            group=scanner.nextLine();
            switch (group){
                case "1":
                    return "Nam";
                case "2":
                    return "Nu";
                default:
                    check=true;
            }
        }while (check);
        return "";

    }

    public String inputAdres(){
        System.out.println("Moi nhap dia chi: ");
        String adres=scanner.nextLine();
        return adres;
    }

    public String inputEmail(){
        System.out.println("Moi nhap email: ");
        String email=scanner.nextLine();
        return email;
    }

    public DachBa inputInfo(){
        String sdt=inputSdt();
        String grp=inputGroup();
        String name=inputName();
        String gt=inputGioitinh();
        String adres=inputAdres();
        String email=inputEmail();
        DachBa danhba=new DachBa(sdt,grp,name,gt,adres,email);
        return danhba;

    }
    public boolean isMatch(String rg, String temp){
        String regex = rg;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(temp);
        return matcher.matches();

    }

    public static void menu(){
        System.out.println("1.Gia dinh");
        System.out.println("2.Ban be");
        System.out.print("Chon 1 or 2 : ");
    }
    public static void menu2(){
        System.out.println("1.Nam");
        System.out.println("2.Nu");
        System.out.print("Chon chuc nang 1 or 2 : ");
    }

}
