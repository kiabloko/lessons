public class KbIn {
    public static void main (String args[])
        throws java.io.IOException {
        char ch, answer = 'S';
        System.out.println ("Загадана буква");
        System.out.println ("Угадай");

        ch=(char) System.in.read();
        if (ch==answer) System.out.println("Молодец");
        else
        System.out.println("Ты не очень");
    }
}
