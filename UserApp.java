import java.io.*;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.io.FileWriter;

public class UserApp {  //To get user input
    public static void main(String [] args) throws FileNotFoundException, IOException{
        String filename=args[0];
        String option= args[1];
        System.out.println("Filename: "+filename+ " option: "+option);
        FileResult app=new append();
        FileResult hv=new hasValue();
        FileResult FI=new firstIndex();
        FileResult LI=new lastIndex();
        FileResult Ind=new Index();
        FileResult Ins=new insert();
        FileResult Del=new delete();
        FileResult del_all=new deleteAll();
        String func=app.options(option);
        if(func.equalsIgnoreCase("append")){
            app.operation(filename);
        }
        else if(func.equalsIgnoreCase("hasvalue")){
            hv.operation(filename);
        }
        else if(func.equalsIgnoreCase("firstIndex")){
            FI.operation(filename);
        }
        else if(func.equalsIgnoreCase("lastIndex")){
            LI.operation(filename);
        }
        else if(func.equalsIgnoreCase("findindices")){
            Ind.operation(filename);
        }
        else if(func.equalsIgnoreCase("insert")){
            Ins.operation(filename);
        }
        else if(func.equalsIgnoreCase("delete")){
            Del.operation(filename);
        }
        else if(func.equalsIgnoreCase("deleteAll")){
            del_all.operation(filename);
        }
        else{
            System.out.println("Invalid option");
        }      
    }
    
}

abstract class FileResult{        

    String options(String option ){
        String[] selection={"append","hasValue","firstIndex","lastIndex","findIndices","insert","delete","deleteAll"};
        int opt= Integer.parseInt(option);
        if(opt<selection.length){
        return selection[opt];}
        else{return "null";}

    }
    abstract void operation(String filename) throws FileNotFoundException, IOException;
    
    
}

interface UserResponse {
    String print();    
}

class append extends FileResult implements UserResponse{
    void operation(String filename){
        System.out.println("enter data to be appended: ");
        String text=print();
        try {
 
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt",true));
            fWriter.write(text);
            fWriter.newLine();
            fWriter.close();
            System.out.println(
                "File is created successfully with the content.");
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }

    public String print(){
        Scanner sc= new Scanner(System.in);     
        String a= sc.nextLine(); 
        return a; 
    }
} 
class hasValue extends FileResult implements UserResponse{
    public String print(){
        System.out.println("enter data to be checked : ");
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        //System.out.print("Enter first number- ");  
        String a= sc.nextLine(); 
        System.out.println("Interface");
        return a; 
    }
    void operation(String filename) throws IOException{ 
        String expected_value = print();
        int count=0;
        File file =new File("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
    try{
        Scanner Reader = new Scanner(file);
        while (Reader.hasNextLine()) {
            String data = Reader.nextLine();
            if(expected_value.equals(data)){
                System.out.println("Value is present in File");
                count++;
                break;
                }                
            }
            Reader.close();
            if(count==0){System.out.println("Value is not in file");}
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    }

class firstIndex extends FileResult implements UserResponse{
    public String print(){
        System.out.println("enter data to get 1st Index: ");
        Scanner sc= new Scanner(System.in);  
        String a= sc.nextLine(); 
        return a; 
    }
        void operation(String filename) throws IOException{ 
            String expected_value = print();
            int lineNum=0;
            File file =new File("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        try{
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                if(expected_value.equals(data)){
                    System.out.println("1st Index Position: "+lineNum);                
                    break;
                    }    
                   lineNum++;             
                }
                Reader.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
        }    
        }

class lastIndex extends FileResult implements UserResponse{
    public String print(){
        System.out.println("enter data to get  lastIndex: ");
        Scanner sc= new Scanner(System.in);      
        String a= sc.nextLine(); 
        return a; 
    }
            void operation(String filename) throws IOException{ 
                String expected_value = print();
                int lineNum=0;
                int index=0;
                File file =new File("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
            try{
                Scanner Reader = new Scanner(file);
                while (Reader.hasNextLine()) {
                    String data = Reader.nextLine();
                    if(expected_value.equals(data)){
                        index=lineNum;                
                        }    
                       lineNum++;             
                    }
                    Reader.close();
                    System.out.println("LastIndex: "+index);
                }
                catch (FileNotFoundException e) {
                    System.out.println("An error has occurred.");
                    e.printStackTrace();
                }
            }        
            }

class Index extends FileResult implements UserResponse{
    public String print(){
        System.out.println("enter data to get all Index: ");
        Scanner sc= new Scanner(System.in);  
        String a= sc.nextLine(); 
        return a; 
    }

    void operation(String filename) throws IOException{ 
        String expected_value = print();
        ArrayList<Integer>  indices=new ArrayList<Integer>();
        int lineNum=0;
        File file =new File("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        try{
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                if(expected_value.equals(data)){
                    indices.add(lineNum);                
                    }    
                lineNum++;             
                }
            Reader.close();
            System.out.println("Indices: "+indices);
            }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
            }
        }        
}

class insert extends FileResult implements UserResponse{
    public String print(){
        System.out.println("enter data to be inserted: ");
        Scanner sc= new Scanner(System.in);   
        String a= sc.nextLine(); 
        return a; 
    }
    void operation(String filename) throws IOException{ 
        System.out.println("enter position for data to be inserted: ");
        Scanner sc= new Scanner(System.in);   
        String pos = sc.nextLine(); 
        int index=Integer.parseInt(pos);
       
        Path path = Paths.get("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String val = print();  
        

        lines.add(index,val);
        Files.write(path, lines, StandardCharsets.UTF_8);

         }     
        
        }
    
class delete extends FileResult{
    public String print(){
        System.out.println("enter data to be deleted: ");
        Scanner sc= new Scanner(System.in);   
        String a= sc.nextLine(); 
        System.out.println("Interface");
        return a; 
    }
    void operation(String filename) throws IOException{ 
                
        Path path = Paths.get("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String removeValue = print();  
        
        lines.remove(removeValue);//Remove 1st occerence of element
        Files.write(path, lines, StandardCharsets.UTF_8);
        
                 }        
                }


                //needs work

class deleteAll extends FileResult{
    public String print(){
        System.out.println("enter data to be completely deleted: ");
        Scanner sc= new Scanner(System.in);   
        String a= sc.nextLine(); 
        //System.out.println("Interface");
        return a; 
    }
    ArrayList<Integer> indices(String filename, String expected_value)
    {
        ArrayList<Integer>  indices=new ArrayList<Integer>();
        int lineNum=0;
        //System.out.println("yess");
        File file =new File("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        try{
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                if(expected_value.equals(data)){
                    indices.add(lineNum);                
                    }    
                lineNum++;             
                }
            Reader.close();
            
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
        //System.out.println(indices);
        return indices;     
    }

    void operation(String filename) throws IOException{ 
                        
        Path path = Paths.get("C:\\Users\\dhars\\Desktop\\text_file_java\\"+filename+".txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        String removeValue = print();  
        ArrayList<Integer> index=indices(filename, removeValue);
        int j=0;
       // System.out.println( index);

        for(int i:index){
            if(index.indexOf(i)==0){
            lines.remove(i);
        }
        else{
            lines.remove(i-j);
        }
         j++;  
         Files.write(path, lines, StandardCharsets.UTF_8);

        }
     }        
}