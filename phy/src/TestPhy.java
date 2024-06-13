public class TestPhy {
    public static void main(String[] args) {
        showPhy(10);
    }

    private static void showPhy(int n){
        Servant servant = new Servant(n);
        for(int i = 0;i < n;i++){
            new Thread(new Phy(i, servant)).start();
        }
    }
}
