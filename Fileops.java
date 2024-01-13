import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;

public class Fileops {
    public static void main(String[] args){
        System.out.println("welcome");
        ArrayList<Integer> data_arr=new ArrayList<Integer>();

        data_arr.add(8);
        data_arr.add(9);
        data_arr.add(8);
        data_arr.add(19);
        data_arr.add(23);
        data_arr.add(8);

        //System.out.println(data_arr);

        file_data FD=new file_data();
        Filedata fd=new Filedata();
        fd.createFile();   

        fd.writeFileArray(data_arr, "Original Array: ");

        
        ArrayList<Integer> data_append=FD.append(29,data_arr);
        fd.writeFileArray(data_append, "Result of append() : ");
        
        String data_hasValue=FD.hasValue(12,data_arr);
        fd.writeFileData(data_hasValue, "Result of hasValue() : ");

        String data_findIndices=FD.findIndices(9,data_arr);
        fd.writeFileData(data_findIndices, "Result Of findIndices()");

        int data_first=FD.findFirstIndex(9,data_arr);
        String data_FirstIndex="The index of value 9 is : "+data_first;
        fd.writeFileData(data_FirstIndex, "Result Of firstIndices()");        

        String data_last=FD.findLastIndex(8,data_arr);
        fd.writeFileData(data_last, "Result of findLastIndex()");        


        ArrayList<Integer> data_insert =FD.insert(7, 1, data_arr);
        fd.writeFileArray(data_insert, "Result of insert() : ");

        ArrayList<Integer> data_delFirst=FD.deleteFirst(8,data_arr);
        fd.writeFileArray(data_delFirst, "Result of deleteFirst()");
        
        ArrayList<Integer> data_deleteAll=FD.deleteAll(8,data_arr);
        fd.writeFileArray(data_deleteAll, "Result of deleteAll() : ");

    }
    
}

class file_data {

//Add value to list:

    ArrayList<Integer> append(int i, ArrayList<Integer> data_arr){
        data_arr.add(i);
        System.out.println("Append Result :\n" + data_arr);
        return data_arr;
    }

//To check the presence of data:

    String hasValue(int value, ArrayList<Integer> data_arr){
        boolean ispresent=data_arr.contains(value);
        //System.out.println(ispresent);
        String result="The value "+value+" is Present/not: "+ispresent;
        return result;

    }

//to find the index of the value:

    String findIndices(int value, ArrayList<Integer> data_arr){
        
        int position=data_arr.indexOf(value);
        //System.out.println("index value of "+value+" : " +position);
        String result="The index of value "+value+" is : "+position;
        return result;

    }

//To find the 1st index of element: 

    int findFirstIndex(int value, ArrayList<Integer> data_arr){
        int position=data_arr.indexOf(value);
        //System.out.println("1st index value "+value+" is : " +position);
        return position;
    }

//TO find last occurence of element :

    String findLastIndex(int value, ArrayList<Integer> data_arr){
        int size=data_arr.size();
        int position=0;
        for(int i=size;i>0;i--){
            if(data_arr.get(i-1)==value){
                position=i-1;
                break;
            }
        }
        String result="The last index of the element "+value+" is : "+position; 
        return result;
    }

//to delete the first occurence of given element: 

    ArrayList<Integer> deleteFirst(int value, ArrayList<Integer> data_arr){
        int index=findFirstIndex(value, data_arr);
        data_arr.remove(index);
        //System.out.println("Delete First element: \n " + data_arr);
        return data_arr;
    }

//Insert element to given position: 
    ArrayList<Integer> insert(int value, int index,ArrayList<Integer> data_arr){
        //System.out.println("Array: "+data_arr );
        data_arr.add(index,value);        
        //System.out.println("Array out: "+data_arr );
        return data_arr;       

    }

    
//Delete all occurence of given element:
 
    ArrayList<Integer> deleteAll(int value, ArrayList<Integer> data_arr){
        //System.out.println(data_arr);
        for(int i=0; i<data_arr.size();i++){
            if(data_arr.get(i)==value){
                data_arr.remove(i);
            }
        }
        //System.out.println(data_arr);
        return data_arr;       
    }


}

class Filedata{

    void createFile(){
    File file = new File("C:\\Users\\dhars\\Desktop\\text_file_java\\Data.txt");   
    boolean result=false ;
    try{
    result = file.createNewFile();  //creates a new file  
    if(result)      // test if successfully created a new file  
    {  
        System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
    }  
    else  
    {  
    System.out.println("File already exist at location: "+file.getCanonicalPath());  
    }  
    }
    catch (IOException e)   
    {      e.printStackTrace();         }   
    }

    void writeFileArray(ArrayList<Integer> data_arr,String statement) {
    
        try {
      BufferedWriter myWriter = new BufferedWriter(new FileWriter("C:\\Users\\dhars\\Desktop\\text_file_java\\Data.txt",true));
      myWriter.write(statement);
      myWriter.newLine();
      myWriter.write("[");
      int size=data_arr.size();
      //myWriter.write(data_arr);
      for (int i=0;i<size;i++){
      myWriter.write(data_arr.get(i)+" ");}
      myWriter.write("]");
      myWriter.newLine();
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  void writeFileData(String data,String statement){
    try {
      BufferedWriter myWriter = new BufferedWriter(new FileWriter("C:\\Users\\dhars\\Desktop\\text_file_java\\data.txt",true));
      myWriter.write(statement);
      myWriter.newLine();
      myWriter.write(data);
      myWriter.newLine();
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


