////basic example program to read and write text file
//
//import java.io.*;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws FileNotFoundException {

/*       File f = new File("/home/ee213130/IdeaProjects/file handlings/out/production/file handlings/test.txt");
if the file is present in this intellij directory */

//        File f = new File("/home/ee213130/Documents/test.txt");
//        Scanner sc = new Scanner(System.in);
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter("/home/ee213130/Documents/test.txt"));
//            bw.write(sc.nextLine());
//            bw.newLine();
//            bw.write(sc.nextLine());
//            bw.newLine();
//            bw.write(sc.nextLine());
//            bw.close();
//        }catch (Exception exc){
//        }
//        BufferedReader br = new BufferedReader(new FileReader(f));
//        String st;
//        try {
//            while ((st = br.readLine()) != null){
//                System.out.println(st);
//            }
//        } catch (Exception exc){
//        }
//
//    }
//}