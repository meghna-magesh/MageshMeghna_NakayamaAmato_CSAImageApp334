/*
  ImageApp
*/

import java.awt.Color;
import javax.swing.JOptionPane;

public class ImageApp {

  // Big Images from lib folder
  public static String getLargeImageFile(String name) {
    switch (name) {
      case "Arch": return "lib/arch.jpg";
      case "Beach": return "lib/beach.jpg";
      case "Bicycle": return "lib/bicycle.jpg";
      case "Bridge": return "lib/bridge.jpg";
      case "City-Street": return "lib/city-street.jpg";
      case "Dock at Lake": return "lib/dock-at-lake.jpg";
      case "Door": return "lib/door.jpg";
      case "Field": return "lib/field.jpg";
      case "Forest Path": return "lib/forest-path.jpg";
      case "Forest": return "lib/forest.jpg";
      case "Gorge": return "lib/gorge.jpg";
      case "Koala": return "lib/koala.jpg";
      case "leftArrow": return "lib/leftArrow.gif";
      case "Moon": return "lib/moon-surface.jpg";
      case "Motorcycle": return "lib/motorcycle.jpg";
      case "Picnic": return "lib/picnic.jpg";
      case "Rainbow": return "lib/rainbow.jpg";
      case "Right Arrow": return "lib/rightArrow.gif";
      case "Ruins": return "lib/ruins.jpg";
      case "Sportscar": return "lib/sports-car.jpg";
      case "Taj Mahal": return "lib/taj-mahal.jpg";
      case "Temple": return "lib/temple.jpg";
    }
    return null;
  }
  // Small Images from lib2 folder
  public static String getSmallImageFile(String name) {
    switch (name) {
      case "Balloon": return "lib2/balloon.png";
      case "Bird": return "lib2/bird.png";
      case "Butterfly": return "lib2/butterfly-g61ce9fba8_1280.png";
      case "Cat": return "lib2/cat.png";
      case "Dog": return "lib2/dog.png";
      case "Fish": return "lib2/fish.png";
      case "Flowers": return "lib2/flowers.png";
      case "Frog": return "lib2/frog.png";
      case "Robot": return "lib2/robot-g13e1b1d67_1280.png";
      case "Rocket": return "lib2/rocket.png";
    }
    return null;
  }

  // menu for user interaction
  public static void main(String[] args) {

    String[] choiceMenu = {
      "Recolor Image",
      "Photographic Negative",
      "Grayscale Image",
      "Add Small Image",
      "Exit"
    };

    String[] imageMenu1 = {
      "Arch","Beach","Bicycle","Bridge","City-Street","Dock at Lake",
      "Door","Field","Forest Path","Forest","Gorge","Koala","leftArrow",
      "Moon","Motorcycle","Picnic","Rainbow","Right Arrow","Ruins",
      "Sportscar","Taj Mahal","Temple"
    };

    String[] imageMenu2 = {
      "Balloon","Bird","Butterfly","Cat","Dog","Fish",
      "Flowers","Frog","Robot","Rocket"
    };

    while (true) {
      String choice = (String) JOptionPane.showInputDialog(
        null, "Choose an option:", "Image App",
        JOptionPane.PLAIN_MESSAGE, null, choiceMenu, choiceMenu[0]
      );

      if (choice == null || choice.equals("Exit")) return;
      String largeChoice = (String) JOptionPane.showInputDialog(
        null, "Choose a base image:", "Select Large Image",
        JOptionPane.PLAIN_MESSAGE, null, imageMenu1, imageMenu1[0]
      );
      if (largeChoice == null) continue;

      String largeFile = getLargeImageFile(largeChoice);

      if (choice.equals("Recolor Image")) {
        Recolor(largeFile);
      }
      else if (choice.equals("Photographic Negative")) {
        Negative(largeFile);
      }
      else if (choice.equals("Grayscale Image")) {
        Grayscale(largeFile);
      }
      else if (choice.equals("Add Small Image")) {
        String smallChoice = (String) JOptionPane.showInputDialog(
          null, "Choose a small image:", "Select Small Image",
          JOptionPane.PLAIN_MESSAGE, null, imageMenu2, imageMenu2[0]
        );
        if (smallChoice == null) continue;

        String smallFile = getSmallImageFile(smallChoice);

        Overlay(largeFile, smallFile);
      }
    }
  }


  public static void Recolor(String imageFile) {
    Picture img = new Picture(imageFile);
    Pixel[][] orig = img.getPixels2D();

    Picture result = new Picture(imageFile);
    Pixel[][] pixels = result.getPixels2D();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {
        Pixel p = orig[r][c];
        pixels[r][c].setColor(new Color(p.getGreen(), p.getBlue(), p.getRed()));
      }
    }
    result.explore();
  }

  public static void Negative(String imageFile) {
    Picture img = new Picture(imageFile);
    Pixel[][] orig = img.getPixels2D();

    Picture result = new Picture(imageFile);
    Pixel[][] pixels = result.getPixels2D();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {
        Pixel p = orig[r][c];
        pixels[r][c].setColor(new Color(
          255 - p.getRed(),
          255 - p.getGreen(),
          255 - p.getBlue()
        ));
      }
    }
    result.explore();
  }

  public static void Grayscale(String imageFile) {
    Picture img = new Picture(imageFile);
    Pixel[][] orig = img.getPixels2D();

    Picture result = new Picture(imageFile);
    Pixel[][] pixels = result.getPixels2D();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {
        Pixel p = orig[r][c];
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
        pixels[r][c].setColor(new Color(avg, avg, avg));
      }
    }
    result.explore();
  }

  // overlays small image onto large image 
  public static void Overlay(String largeFile, String smallFile) {
    Picture largeImg = new Picture(largeFile);
    Picture smallImg = new Picture(smallFile);
    Pixel[][] large = largeImg.getPixels2D();
    Pixel[][] small = smallImg.getPixels2D();
    for (int r = 0; r < small.length; r++) {
      for (int c = 0; c < small[0].length; c++) {
        Pixel sp = small[r][c];
        if (sp.getRed() == 255 && sp.getGreen() == 255 && sp.getBlue() == 255)
          continue;
        if (r + 100 < large.length && c + 100 < large[0].length) {
          large[r + 100][c + 100].setColor(sp.getColor());
        }
      }
    }

    largeImg.explore();
  }
}
