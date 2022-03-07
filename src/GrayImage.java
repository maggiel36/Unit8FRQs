public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    /** The 2-dimensional representation of this image. Guaranteed not to be null.
     *  All values in the array are within the range [BLACK, WHITE], inclusive.
     */
    private int[][] pixelValues;

    /** constructor that takes a 2D array */
    public GrayImage(int[][] theArray)
    {
        pixelValues = theArray;
    }

    /** @return the total number of white pixels in this image.
     *  Postcondition: this image has not been changed.
     */
    public int countWhitePixels()
    {
        int whitePixels = 0;
        for(int[] row : pixelValues)
        {
            for (int value : row)
            {
                if (value == WHITE)
                {
                    whitePixels++;
                }
            }
        }
        return whitePixels;
    }

    /** Processes this image in row-major order and decreases the value of each pixel at
     *  position (row, col) by the value of the pixel at position (row + 2, col + 2) if it exists.
     *  Resulting values that would be less than BLACK are replaced by BLACK.
     *  Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged.
     */
    public void processImage()
    {
        for (int row = 0; row < pixelValues.length - 2; row++)
        {
            for (int col = 0; col < pixelValues[0].length - 2; col++)
            {
                if ((pixelValues[row][col] - pixelValues[row + 2][col + 2]) < BLACK)
                {
                    pixelValues[row][col] = BLACK;
                }
                else
                {
                    pixelValues[row][col] -= pixelValues[row + 2][col + 2];
                }
            }
        }
    }

    public void printValues()
    {
        for (int r = 0; r < pixelValues.length; r++)
        {
            for (int c = 0; c < pixelValues[0].length; c++)
            {
                System.out.print(pixelValues[r][c] + ", ");
            }
            System.out.println();
        }
    }
}