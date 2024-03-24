public class Singleton {

  //private static variable of the same class that has a private access modifier
  private static Singleton single_instance = null;

  // private constructor restricted to this class itself
  private Singleton() {
    // prevent the instantiation of this class
  }

  // static method to create instance of Singleton class
  public static Singleton getInstance() {
    if (single_instance == null){
      single_instance = new Singleton();
    }
    return single_instance;
  }
}