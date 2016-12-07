
class BottlesOfBeer {
  public static void main(String [] args){
    for(int i = 99; i > 0; i--){
      try {
        System.out.println(i + " Bottles of beer on the wall");
        Thread.sleep(1500);
        System.out.println(i + " Bottles of beer");
        Thread.sleep(1500);
        System.out.println("Take 1 down, pass it around");
        Thread.sleep(1500);
        i--;
        System.out.println(i + " Bottles of beer on the wall");
        Thread.sleep(1500);
        i++;
      }
      catch(Exception e){
        System.out.println(e);
      }
    }
}
}