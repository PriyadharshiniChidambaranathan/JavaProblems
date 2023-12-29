import java.io.*;

public class first_app {
    public static void main(String[] args) {
       
        Filedata fd=new Filedata();
        FileList fl = new FileList();
        fd.createFile();   

        int[] append_data=fl.append(5);
        fd.writeFileArray(append_data,"1) Result append():");

        String isPresent=fl.hasValue(3);
        fd.writeFileData(isPresent,"2) Result hasValue(): ");

        String Index_value=fl.findIndices(2);
        fd.writeFileData(Index_value,"3) Result findIndices(): ");

        String Index1_value=fl.findFirstIndex(2);
        fd.writeFileData(Index1_value,"4) Result findFirstIndex(): ");

        int[] deleteFirst_data=fl.deleteFirst(2);
        fd.writeFileArray(deleteFirst_data,"5) Result deleteFirst():");

        fl.findLastIndex(2);
        fl.deleteAll(2);      
}
}

class FileList{
    
    int[] original_values={1, 2, 3 , 4, 2};
    int[] modified_values= new int[9];
    
//Add an element to array:-------------
   
    int[] append(int value){
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
    
//To check the presence of value

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


//To find the position of value
    
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


//To find the first index of value:
    
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
    

//To delete 1st value

    int[] deleteFirst(int value){
        int position=0;
        int[] del_modified_values=new int[modified_values.length];
        for(int i=0;i<del_modified_values.length;i++){
            del_modified_values[i]=modified_values[i];
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

    //Needs work------------------------------------------
//To delete All value:

    void deleteAll(int value){

        int[] position=new int[modified_values.length];
        int num=0;
        for(int i=0;i<modified_values.length;i++){
            if(modified_values[i]==value){
                position[num]=i;
                num++;
            }}
        for(int i=0;i<position.length;i++){
                System.out.println(position[i]);
        }
            
        }
        
  // To find the last Index of Value:

    void findLastIndex(int value){
        int[] modifiedd_values = {1,2,3,4,5,2};
        int position=0;
        int len=modifiedd_values.length;
        for(int i=len; i>0 ; i--){
            if(modifiedd_values[i-1]==value){
                position=i;
                break;
            }
        }
       System.out.println("Last Index of value " + value + " is: " +position);
        
    }
  

//To insert value in specific position:

    void insert(int value, int index){
        
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
      myWriter.write("[");
      for (int i=0;i<x.length;i++){
      myWriter.write(x[i]+",");
    }
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

   
  