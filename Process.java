

/**
 * Created by yuval_edelman on 6/4/2015.
 */
public class Process implements Runnable {
    Repository rep;

    public Process(Repository rep) {
        this.rep = rep;
    }

    public void run() {
        int[] couple;
        couple = rep.removeFromList();
        while (couple != null) {
            rep.addToList(couple[0] + couple[1]);
            couple = rep.removeFromList();
        }
    }

}


