import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Create 06/27/2024 - 12:30
 * @Author xiao
 * @Description TODO
 */

public class TestException {
    void calculate(int i) throws ArithmeticException {
        if (i == 0)
            throw new ArithmeticException("被除数为0");
    }

    // FileNotFoundException belongs to IOException, so only the general one is ok
    void readFile() throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream("test.txt");
        int b = in.read();  // read file
        while (b != -1) {
            System.out.println((char) b);
            b = in.read();
        }
        in.close();
    }
    public static void main (String[] args) {
        TestException te = new TestException();

        try {
            te.calculate(0);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();;
            System.out.println("error ae");
        }



        try {
            te.readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {


        }
    }

}
