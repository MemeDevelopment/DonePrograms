import java.util.Scanner;

class PrintText {
  public static void main(String [] args){ 
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a word");
    String question = in.nextLine();
    char[] text = question.toCharArray();
    for(int i = 0; i < text.length; i++){
      try {
     System.out.print(text[i]); 
     Thread.sleep(100);
      } catch(Exception e){
        System.out.println(e);
      }
    }
  }
}