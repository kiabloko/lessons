import java.util.Arrays;

public class HomeWork1 {

    public static void main(String[] args) {
// Перевод в двоичную систему:
        int b=48;
        String y = "";
        while (b > 0) {
            if (b%2!=0){
                y+="1";
            }
            else {
                y+="0";
            }
            b=b/2;
        }
        StringBuilder x = new StringBuilder(y);
        x=(new StringBuilder(y)).reverse();
        System.out.println(x);
//Перевод в шестнадцатиричную систему:
        int b=601;
        String z = "";

        while (b > 0) {
            if (b % 16 <1 ){
                z =("0");
            }
            else if (b % 16>0 &b % 16< 2){
                z+=("1");
            }
            else if (b % 16>1 &b % 16< 3){
                z+=("2");
            }
            else if (b % 16>2 &b % 16< 4){
                z+=("3");
            }
            else if (b % 16>3 &b % 16< 5){
                z+=("4");
            }
            else if (b % 16>4 &b % 16< 6){
                z+=("5");
            }
            else if (b % 16>5 &b % 16< 7){
                z+=("6");
            }
            else if (b % 16>6 &b % 16< 8){
                z+=("7");
            }
            else if (b % 16>7 &b % 16< 9){
                z+=("8");
            }
            else if (b % 16>8 &b % 16< 10){
                z+=("9");
            }
            else if (b % 16>9 &b % 16< 11){
                z+=("A");
            }
            else if (b % 16>10 &b % 16< 12){
                z+=("B");
            }
            else if (b % 16>11 &b % 16< 13){
                z+=("C");
            }
            else if (b % 16>12 &b % 16< 14){
                z+=("D");
            }
            else if (b % 16>13 &b % 16< 151){
                z+=("E");
            }
            else if (b % 16>14 &b % 16< 16){
                z+=("F");
            }
            b=b/16;
        }
        StringBuilder w = new StringBuilder(z);
        w=(new StringBuilder(z)).reverse();
        System.out.println(w);

        // Полуение НОД:

int a = 7;
int b = 14;
        while (a != 0 & b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            System.out.println(b);
        } else {
            System.out.println(a);
        }




        }
    }
 /* По заданию с массивом: материал,данный на занятии+ прочтение базового учебника не помогли найти решение.
Поиск в интернете только усилил понимание того, что для выполнения домашнего задания материалов с уроков не хватает,
требуется много дополнительнойлитературы. а для новичка в этой области - найти решение просто нереально, так как
дополнительная информация на интернет просторах несет абсолютно непонятные новые методы.Перед началом курса мне не
сообщали, что для прохождения курса нужна уже база java.
  */
