package by.train.bpp;

@OurAnnotation
public class AnotherCat implements AnotherAnimal {
   private String message;
   private int age;

   public void setMessage(String message){
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Your Message : " + message);
   }

   public AnotherCat() {
      System.out.println("constructor cat");
   }

   public void init(){
      System.out.println("Cat is going through init.");
   }
   public void destroy(){
      System.out.println("Cat will destroy now.");
   }

   @Override
   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public int getAge() {
      return age;
   }
}