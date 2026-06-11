public class Ejerr3 {
 
    public static void main(String[] args) {
 
        int R = (int)(Math.random() * 19 + 2);
 
        int[][] m = new int[R][];
 
        System.out.println("R = " + R);
 
        for (int f = 0; f < R; f++) {
 
            m[f] = new int[f + 1];
 
            for (int c = 0; c < m[f].length; c++) {
                m[f][c] = f + 1;
            }
        }
 
        for (int f = 0; f < R; f++) {
 
 
            for (int c = 0; c < m[f].length; c++) {
                System.out.print(m[f][c]);
 
                if (c < m[f].length - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}