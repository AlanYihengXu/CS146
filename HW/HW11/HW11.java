package HW.HW11;

public class HW11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int old = image[sr][sc];
        image[sr][sc] = color;
        if (sr+1 < image.length && image[sr+1][sc] == old) floodFill(image, sr+1, sc, color);
        if (sr-1 >= 0 && image[sr-1][sc] == old) floodFill(image, sr-1, sc, color);
        if (sc+1 < image[0].length && image[sr][sc+1] == old) floodFill(image, sr, sc+1, color);
        if (sc-1 >= 0 && image[sr][sc-1] == old) floodFill(image, sr, sc-1, color);
        return image;
    }

    public static void main(String[] args) {
        HW11 tester = new HW11();
        int[][] image = {{1,1,1},
                         {1,1,0}, 
                         {1,0,1}};
        tester.floodFill(image, 1, 1, 2);
        for (int[] i : image) {
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
        
        int[][] image2 = {{0,0,0},
                          {0,0,0}};
        tester.floodFill(image2, 0, 0, 0);
        for (int[] i : image2) {
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
    }
}
