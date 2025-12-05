/*
  ImageApp: 
 */

import java.awt.Color;

public class ImageApp
{
  public static void main(String[] args)
  {

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    /* to be implemented */
    for (int row = 0; row < recoloredPixels.length; row++) {
      for (int col = 0; col < recoloredPixels[0].length; col++) {
        Pixel p = origPixels[row][col];
        //recoloredPixels[row][col].setColor(new Color(p.getBlue(), p.getGreen(), p.getRed()));
        //recoloredPixels[row][col].setColor(new Color(p.getGreen(), p.getRed(), p.getBlue()));
        //recoloredPixels[row][col].setColor(new Color(p.getRed(), p.getBlue(), p.getGreen()));
      }
    }
    recoloredImg.explore();

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    /* to be implemented */
    for (int row = 0; row < negPixels.length; row++) {
      for (int col = 0; col < negPixels[0].length; col++) {
        Pixel p = origPixels[row][col];
        negPixels[row][col].setColor(new Color(255 - p.getRed(),
                                               255 - p.getGreen(),
                                               255 - p.getBlue()));
      }
    }
    negImg.explore();

    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    /* to be implemented */
    for (int row = 0; row < grayscalePixels.length; row++) {
      for (int col = 0; col < grayscalePixels[0].length; col++) {
        int avg = (origPixels[row][col].getRed() +
                   origPixels[row][col].getGreen() +
                   origPixels[row][col].getBlue()) / 3;
        grayscalePixels[row][col].setColor(new Color(avg, avg, avg));
      }
    }
    // display the new grayscale image once
    grayscaleImg.explore();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();

    /* to be implemented */

    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    /* to be implemented */

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    /* to be implemented */

    // Final Image: Add a small image to a larger one

    /* to be implemented */
    Picture largeImg = new Picture ("lib/bridge.jpg");
    Pixel[][] largePixels = largeImg.getPixels2D();
    Picture smallImg = new Picture ("lib2/bird.png");
    Pixel[][] smallPixels = smallImg.getPixels2D();
    int startRow = (largePixels.length - smallPixels.length) / 2;
    int startCol = (largePixels[0].length - smallPixels[0].length) / 2;
    if (startRow < 0) startRow = 0;
    if (startCol < 0) startCol = 0;

    for (int r = 0; r < smallPixels.length; r++) {
      for (int c = 0; c < smallPixels[0].length; c++) {
        int lr = startRow + r;
        int lc = startCol + c;
        if (lr >= 0 && lr < largePixels.length && lc >= 0 && lc < largePixels[0].length) {
          largePixels[lr][lc].setColor(smallPixels[r][c].getColor());
        }
      }
    }

    largeImg.explore();

    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];
  }
}
