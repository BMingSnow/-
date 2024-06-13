
public class Servant {
    private int n;
    private boolean[] chops;

    public Servant(int n){
        //n：问题规模
        this.n = n;
        this.chops = new boolean[this.n]; //true:占用, false:空闲
    }

    public synchronized void take(int idx){
        //idx:哲学家编号
        while(true){
            if(chops[idx] || chops[(idx + 1) % n]){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            break;
        }
        chops[idx] = true;
        chops[(idx + 1) % n] = true;
        this.notify();
    }

    public synchronized void put(int idx){
        //idx:哲学家编号
        chops[idx] = false;
        chops[(idx + 1) % n] = false;
        this.notify();
    }
}
