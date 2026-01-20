import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  /* Variables (instance & static)
  */
  private String[] title = {"Enter Year"};
  private String[] textFood = {"Enter Title"};
  private String[] images;
  private static final String blackBoarder = "blackSquare.png";
  private String[] friends;
  private String[] friendText;
  private String[] moments;
  private String[] favMoment;

  /* 
  Constuctor(no agrument and argument)
  */

public LastYear(){
  images = FileReader.toStringArray("data1.txt");
}
  
  public LastYear(String[] title, String[] textFood, String[] images, String[] friends, String[] friendText, String[] moments, String[] favMoment) {
      this.title = title;
    this.textFood = textFood;
    this.images = images;
    this.friends = friends;
    this.friendText = friendText;
    this.favMoment = favMoment;
    this.moments = moments;
  }


  /**
  
   * Top level drawScene method(contains all the methods and is called in the TheaterRunner class)
  
   */
  public void drawScene() {
    
    drawImage("golden-gate-bridge-75th-anniversary-fireworks-square.jpg", 0,0, 400);
    drawCaptionBox(25, 275, 350, 100);
    pause(2);
    clear("white");
    foodLabel(25, 275, 350, 100);
   drawStack(true);
    pause(1);
    clear("white");
    friendLabel(25, 275, 350, 100);
    drawStackFriends(true);
    pause(1);
    clear("white");
    textMoments(25, 275, 350, 100);
    drawStackMoments(true);
    pause(1);
    
  }



  /* 
  
  This method creates the text box for the intro screen saying "My 2025"
  
  */

    public void drawCaptionBox(int xPos, int yPos, int width, int height) {
    // shadow box, 5px offset
    setFillColor("black");
    drawRectangle(xPos + 5, yPos - 125, width, height);
    
    // front box
    setFillColor("white");
    drawRectangle(xPos, yPos - 130, width, height);

    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 50;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 85;
    int yLinePos = yPos - 65;
    for (String line : title) {
      drawText(line, xLinePos, yLinePos);
      yLinePos += fontSize;
    } 
  }

  /*
    The text that appears when the food pictures appear saying "food"

  */

  public void foodLabel(int xPos, int yPos, int width, int height) {
    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 25;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 145;
    int yLinePos = yPos - 250;
    for (String line : textFood) {
      drawText(line, xLinePos, yLinePos);
      yLinePos += fontSize;
    }
  }
  

/*
  Creates the food images
*/

 public void drawStack(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String image : images) {
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
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }
  
 
  /*
    creates the images for the friends slide
  */
  
  public void drawStackFriends(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String pic : friends) {
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
      drawImage(pic, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }

  /*
    creates the text that displays when the pictures of the friends appear
  */

  public void friendLabel(int xPos, int yPos, int width, int height) {
    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 25;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 90;
    int yLinePos = yPos - 250;
    for (String lin2 : friendText) {
      drawText(lin2, xLinePos, yLinePos);
      yLinePos += fontSize;
    }
  }

  /*
    creates the pictures of my favorite moments of 2025
  */

  
public void drawStackMoments(boolean hasBoarder) {
    int centerX = 200;  // center of the stack
    int centerY = 200;  // center of the stack
    int size = 250;
    
    for (String pics : moments) {
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
      drawImage(pics, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }

  /*
    creates the text that displays when the pictures of my favorite moments plays
  */

public void textMoments(int xPos, int yPos, int width, int height) {
    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 25;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 90;
    int yLinePos = yPos - 250;
    for (String linee : favMoment) {
      drawText(linee, xLinePos, yLinePos);
      yLinePos += fontSize;
    }
  }

  
}