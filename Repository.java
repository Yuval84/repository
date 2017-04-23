
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by yuval_edelman on 6/4/2015.
 */
public class Repository {
    private ArrayList list;
    private int maxThread,waiting;
    private boolean endOfThreads;

    public Repository(Integer[] array,int maxThread)
    {
        list=new ArrayList(Arrays.asList(array));
        this.maxThread=maxThread;
        waiting=0;
        endOfThreads=false;
    }

    public synchronized void addToList(int num)
    {
        list.add(num);
        notifyAll();
    }

    public synchronized int[] removeFromList()
    {
        while (list.size()<2 && !endOfThreads) {
            if (waiting != maxThread - 1) {
                waiting++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
                waiting--;
            } else {
                endOfThreads = true;
                notifyAll();
            }
        }
        if (endOfThreads==true){return null;}
        int[]a=new int[2];
        a[0]=(Integer)list.get(0);
        a[1]=(Integer)list.get(1);
        list.remove(0);
        list.remove(0);
        return a;
    }

    public synchronized int getSum()
    {
        while (!endOfThreads){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        return (Integer)list.get(0);
    }

}//end
