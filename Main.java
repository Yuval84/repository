import javax.swing.*;

/**
 * Created by yuval_edelman on 6/5/2015.
 */
public class Main {
    public static void main(String[]args){
        String a = JOptionPane.showInputDialog("Enter array size");
        String b = JOptionPane.showInputDialog("Enter thread number");
        int array=Integer.parseInt(a);
        int thread=Integer.parseInt(b);
        Integer[]arr=new Integer[array];
        for (int i=0;i<arr.length;i++){
            arr[i]= (int) (Math.random() * 100);
        }
        Repository rep=new Repository(arr,thread);
        for (int i=1;i<=thread;i++){
            (new Thread(new Process(rep))).start();
        }
        JOptionPane.showMessageDialog(null, rep.getSum());







    }
}
