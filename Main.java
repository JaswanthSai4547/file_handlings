import java.io.*;
import java.util.*;

class Employee implements Serializable{
    int empno;
    String ename;
    int salary;

    public Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "empno=" + empno + " ename=" + ename + " salary=" + salary ;
    }
}
public class Main {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("/home/ee213130/Documents/text.txt");
        ArrayList<Employee> al = new ArrayList<>();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)); //whenever you call it old date will be removed,so we put it as null
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        int choice = -1;
        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Employee>)ois.readObject();
            ois.close();
        }
        while (true) {
            try {
                do {
                    System.out.println("1.Insert");
                    System.out.println("2.Display");
                    System.out.println("3.Search");
                    System.out.println("4.delete");
                    System.out.println("5.update");
                    System.out.println("6.sort by empno on screen");
                    System.out.println("7.sort by empno on file");
                    System.out.println("8.sort by ename on screen");
                    System.out.println("9.sort by ename on file");
                    System.out.println("10.sort by salary on descending on screen");
                    System.out.println("11.sort by salary on ascending on file");
                    System.out.println("12.exit");
                    System.out.println("Enter your choice:");
                    choice = Integer.parseInt(br1.readLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Employee number :");
                            int empno = Integer.parseInt(br1.readLine());
                            System.out.print("employee name :");
                            String ename = br1.readLine();
                            System.out.print("salary :");
                            int salary = Integer.parseInt(br1.readLine());
                            al.add(new Employee(empno, ename, salary));
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            break;
                        case 2:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();
                                System.out.println("-------------------------");
//                                li = al.listIterator();
//                                while (li.hasNext()) {
//                                    System.out.println(li.next());
//                                }
                                for(int i=0;i<al.size();i++)
                                {
                                    System.out.println(al.get(i));
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 3:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();
                                boolean found = false;
                                System.out.print("enter employee number:");
                                empno = Integer.parseInt(br1.readLine());
                                System.out.println("-------------------------");
//                                li = al.listIterator();
//                                while (li.hasNext()) {
//                                    Employee e = (Employee) li.next();
//                                    if (e.empno == empno) {
//                                        System.out.println(e);
//                                        found = true;
//                                    }
//                                }
                                for(int i=0;i<al.size();i++)
                                {
                                    Employee e = al.get(i);
                                    if(e.empno == empno)
                                    {
                                        System.out.println(e);
                                        found = true;
                                    }
                                }if (!found) {
                                    System.out.println("record not found...!");
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not exist");
                            }
                            break;
                        case 4:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();
                                boolean found = false;
                                System.out.print("enter employee number:");
                                empno = Integer.parseInt(br1.readLine());
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    Employee e = (Employee) li.next();
                                    if (e.empno == empno) {
                                        li.remove();
                                        found = true;
                                    }
                                }
                                if (found) {
                                    oos = new ObjectOutputStream(new FileOutputStream(file));
                                    oos.writeObject(al);
                                    oos.close();
                                    System.out.println("record deleted successfully");
                                } else {
                                    System.out.println("record not found...!");
                                }
                                System.out.println("-------------------------------");
                            } else {
                                System.out.println("file not exist");
                            }
                            break;
                        case 5:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();
                                boolean found = false;
                                System.out.print("enter employee number:");
                                empno = Integer.parseInt(br1.readLine());
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    Employee e = (Employee) li.next();
                                    if (e.empno == empno) {
                                        System.out.print("enter new employee name");
                                        ename = br1.readLine();
                                        System.out.print("enter new salary:");
                                        int sal = Integer.parseInt(br1.readLine());
                                        li.set(new Employee(empno, ename, sal));
                                        found = true;
                                    }
                                }
                                if (found) {
                                    oos = new ObjectOutputStream(new FileOutputStream(file));
                                    oos.writeObject(al);
                                    oos.close();
                                    System.out.println("record updated successfully");
                                } else {
                                    System.out.println("record not found...!");
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not exist");
                            }
                            break;
                        case 6:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.empno - e2.empno;
                                    }
                                });
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 7:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.empno - e2.empno;
                                    }
                                });

                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(al);
                                oos.close();
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 8:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.ename.compareTo(e2.ename);
                                    }
                                });
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 9:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.ename.compareTo(e2.ename);
                                    }
                                });

                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(al);
                                oos.close();
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 10:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e2.salary - e2.salary;
                                    }
                                });
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 11:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                al = (ArrayList<Employee>) ois.readObject();
                                ois.close();

                                Collections.sort(al, new Comparator<Employee>() {
                                    @Override  //sort only on screen
                                    public int compare(Employee e1, Employee e2) {
                                        return e1.salary - e2.salary;
                                    }
                                });

                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(al);
                                oos.close();
                                System.out.println("-------------------------");
                                li = al.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("file not found...!");
                            }
                            break;
                        case 12:
                            System.exit(0);
                    }
                } while (choice != 0);
            } catch (Exception exc) {

                System.out.println("invalid input");
            }
        }
    }
}