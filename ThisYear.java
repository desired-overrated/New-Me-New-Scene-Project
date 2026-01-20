import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  /* Variables (instance & static)
  */
private String goal;
private String[] soFar;
private String[] SoFarText;
private static final String blackBoarder = "blackSquare.png";
private String text;
  
  /* 
  Constuctor
  */

  public ThisYear(){
    String goal = "";
    String[] sofar = {""};
    String[] SoFarText = {" "};
    String text = "";
  }
  
  public ThisYear(String goal, String[] soFar, String[] SoFarText, String text) {
 this.goal = goal;
    this.soFar = soFar;
    this.SoFarText = SoFarText;
    this.text = text;
  }

  /**
  
   * Top level drawScene method(contains all the methods and is called in the TheaterRunner class)
  
   */
  public void drawScene() {
    drawBanner(200, 22);
    clear("white");
    grow(175, 175, 50);
    pause(3);
    clear("white");
    textSoFar(25, 275, 350, 100);
    drawStackSoFar(true);
  }

  /* 
    creates the line of text that moves across the screen
  */


  public void drawBanner(int yPos, int textSize) {
    setTextHeight(textSize);

    int xPos = 400; // start on right side of screen
    int textWidth = getEstimateLengthInPixels(text, textSize);

    while (xPos > -textWidth) {
      clear("white"); // can change to different color or image
      
      drawText(text, xPos, yPos);
      pause(0.1); // this is the fastest it can be, can slow down
      
      xPos -= 10; // shift over by 10px, can change
    }
  }

/* used in the drawBanner method
  */
  
    public static int getEstimateLengthInPixels(String text, int textSize) {
    // the average width per character at size 22 is ~15px, which is about 70%
    double avgWidthPerChar = 0.7 * textSize;
    // add 15% buffer to overestimate
    return (int) (text.length() * avgWidthPerChar * 1.15);
  }

/* used to enlarge the goal image
  */
  
   public void grow(int xPos, int yPos, int size) {
    pause(1.0);
    while (size < 400) {
      drawImage(goal, xPos, yPos, size);

      size += 20;
      xPos -= 10;
      yPos -= 10;

      pause(0.1);
    }
  }

/* creates the images for the last screen
  */
  
public void drawStackSoFar(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String yeah : soFar) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // black boarder - 5px offset all around
      if (hasBoarder) {
        double boarderHalfSize = (size + 10) / 2.0;
        int boarderX = (int)(centerX - (boarderHalfSize * Math.cos(radians) - boarderHalfSize * Math.sin(radians)));
        int boarderY = (int)(centerY - (boarderHalfSize * Math.sin(radians) + boarderHalfSize * Math.cos(radians)));
        drawImage(blackBoarder, boarderX, boarderY, size + 10, dAngle);
      }
      
      // image on top of black boarder (if drawn)
      drawImage(yeah, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }

/* 
    creates the text for the images
  */
  
public void textSoFar(int xPos, int yPos, int width, int height) {
    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 25;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 90;
    int yLinePos = yPos - 250;
    for (String last : SoFarText) {
      drawText(last, xLinePos, yLinePos);
      yLinePos += fontSize;
    }
  }
  
  
}