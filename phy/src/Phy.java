
public class Phy implements Runnable{
    private int idx;
    private Servant servant;

    public Phy(int idx, Servant servant){
        this.idx = idx;
        this.servant = servant;
    }

    @Override
    public void run() {
        while(true){
//            System.out.println("Phy " + idx + " is thinking....");
            try {
                Thread.sleep(2000 + (int)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Phy " + idx  + " is trying to take chops....");
            servant.take(idx); //可能阻塞
//            System.out.println("Phy " + idx + " has taken chops....");
            System.out.println("Phy " + idx + " is eating....");
            try {
                Thread.sleep(2000 + (int)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servant.put(idx);
//            System.out.println("Phy " + idx + " put chops....");
        }
    }
}
