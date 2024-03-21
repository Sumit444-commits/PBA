package myPackage;

public class Querry {
   public static String getData(String s) {
      return "SELECT District,Crop,Year FROM crop_production Where State = \'" + s + "\'";
   }

   public static String getStates() {
      return "SELECT DISTINCT State FROM crop_production";
   }
}
