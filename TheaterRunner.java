import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {
    
String[] title = {"My 2025"};
String[] textFood = {"Food"};
String[] images = FileReader.toStringArray("data1.txt");
String text = "~ Now, my 2026 so far! ~";
String[] friends = FileReader.toStringArray("data2.txt");
String[] friendText = {"Friends and Family"};
String[] moments = FileReader.toStringArray("data3.txt");
String[] favMoment = {"Favorite Moments!"};
String goal = "IMG_6924.jpeg";
String[] soFar = FileReader.toStringArray("data4.txt");
String[] SoFarText = {"Pictures so far!"};
    
    
    /* 
    Create scene objects from the classes LastYear and ThisYear
      */
  
    ThisYear thisYear = new ThisYear(goal, soFar, SoFarText, text);
    LastYear lastYear = new LastYear(title, textFood, images, friends, friendText, moments, favMoment);

    /* Call top level methods
      */

        lastYear.drawScene();
    thisYear.drawScene();


    /* Play scenes (in order of arguments)
      */
    
    Theater.playScenes(lastYear, thisYear);

  }
}