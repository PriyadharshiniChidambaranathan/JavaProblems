import java.io.*;
import java.util.Arrays;

public class first_app {
    public static void main(String[] args) {

        int[] original_values={1, 2, 3 , 4, 2};
        
       
        Filedata fd=new Filedata();
        FileList fl = new FileList();
        fd.createFile();   

        fd.writeFileArray(original_values, "Original Array: ");

        int[] append_data=fl.append(5,original_values);
        fd.writeFileArray(append_data,"1) Result append():");

        String isPresent=fl.hasValue(3);
        fd.writeFileData(isPresent,"2) Result hasValue(): ");

        String Index_value=fl.findIndices(3);
        fd.writeFileData(Index_value,"3) Result findIndices(): ");

        String Index1_value=fl.findFirstIndex(2);
        fd.writeFileData(Index1_value,"4) Result findFirstIndex(): ");

        String last_index=fl.findLastIndex(2);
        fd.writeFileData(last_index, "5) Find Last Index : ");

        int[] deleteFirst_data=fl.deleteFirst(2,original_values);
        fd.writeFileArray(deleteFirst_data,"5) Result deleteFirst():");
        
        int[] del_all_data=fl.deleteAll(2); 
        fd.writeFileArray(del_all_data, "7) Result deleteAll() : ");
        

        int[]  insert_data=fl.insert(8, 2);
        fd.writeFileArray(insert_data, "8) Result insert(): ");
        
}
}

class FileList{
    
    int[] modified_values= new int[9];
    
//Add an element to array:-------------
   
    int[] append(int value,int[] original_values){
        for (int i=0 ; i<modified_values.length ; i++)
        {   
            if(i < original_values.length){
            modified_values[i]=original_values[i];}
        }
        for (int i=0;i<modified_values.length;i++){
            modified_values[original_values.length]=value;
        }
        return modified_values;
    }
    
//To check the presence of value:----------

    String hasValue(int value){
        boolean contains=false;
        for (int i=0; i < modified_values.length ; i++){
            if(modified_values[i]==value){
                contains=true;
            }
        }
       String result = "The value " +(value)+ " is present in array : " + contains;
       return result;     
    }


//To find the position of value:-----------
    
    String findIndices(int value){
        int position=0;
        for(int i=0; i<modified_values.length ; i++){
            if(modified_values[i]==value){
                position=i;
		break;
            }
        }
        String result="Index  of value " +(value) + " is: " +(position);
        return result;
   }


//To find the first index of value:---------------
    
    String findFirstIndex(int value){ 
        int position=0;
        for(int i=0; i<modified_values.length ; i++){
            if(modified_values[i]==value){
                position=i;
		break;
            }
        }
        
        String result= "First Index of value " + value + " is: " +position;
        return result;
        
    }
    
// To find the last Index of Value:-------------

    String findLastIndex(int value){
        int position=0;
        int len=modified_values.length;
        for(int i=len; i>0 ; i--){
            if(modified_values[i-1]==value){
                position=i-1;
                break;
            }
        }
        String ans= "Last Index of value " + value + " is : " +position;
        return ans;
    }

//To delete 1st value:--------------

    int[] deleteFirst(int value,int[] arr){

        int position=0;
        int[] del_modified_values=new int[modified_values.length];
       
        for(int i=0;i<del_modified_values.length-1;i++){
            if(i < arr.length){
            del_modified_values[i]=arr[i];
            }
        }        

        for(int i=0; i<del_modified_values.length ; i++){
            if(del_modified_values[i]==value){
                position=i;
		break;
            }
        }
        
        for (int in=position;in<del_modified_values.length-1;in++){
            del_modified_values[in]=del_modified_values[in+1];
        }        
        return del_modified_values;
    }

//To delete All value:---------------

    int[] deleteAll(int value){
        int[] ans=new int[modified_values.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=modified_values[i];
        }

        for(int i=0;i<ans.length-1;i++){        
            if(ans[i] ==value){
                ans=deleteFirst(ans[i],ans);
            }
        }
        return ans;
        }

//To insert value in specific position:

    int[] insert(int value, int index){
        int temp=0;
        System.out.println("Array: "+Arrays.toString(modified_values) );
        for(int i=0;i<modified_values.length;i++){
            if(i==index){
                for(int j=i;j<modified_values.length;j++){
                    temp=modified_values[j];
                    modified_values[j]=value;
                    value=temp;
                }            
            }                
        }        
        System.out.println("Array out: "+Arrays.toString(modified_values) );
        return modified_values;        
    }     
}

class Filedata{

    void createFile(){
    File file = new File("C:\\Users\\dhars\\Desktop\\text_file_java\\data.txt");   
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

    void writeFileArray(int[] x,String statement) {
    
        try {
      BufferedWriter myWriter = new BufferedWriter(new FileWriter("C:\\Users\\dhars\\Desktop\\text_file_java\\data.txt",true));
      myWriter.write(statement);
      myWriter.newLine();
      //myWriter.write("[");
      myWriter.write(Arrays.toString(x));
      //for (int i=0;i<x.length;i++){
      //myWriter.write(x[i]+" ");}
      //myWriter.write("]");
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

   
  