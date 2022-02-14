public class MerkleManager {
    public static volatile String userWord;
    public static String userMerkleRoot;
    public static String merkleRoot = null;
    public static int strikes = 0;


    public void manage() {

        Util oUtil = new Util();
        userMerkleRoot = oUtil.promptUser("Enter your desired Merkle Root");

        MerkleThread merThread = new MerkleThread();
        merThread.threadName = "Merkle Thread";

        RogueThread rogThread = new RogueThread();
        rogThread.threadName = "Rogue Thread";

        MonitorThread monThread = new MonitorThread();

        Thread merThread1 = new Thread(merThread);
        Thread rogThread1 = new Thread(rogThread);
        Thread monThread1 = new Thread(monThread);

        merThread1.start();
        rogThread1.start();
        monThread1.start();

        while (true) {
            userWord = oUtil.promptUser("Enter a word");
        }
    }

    public static synchronized String grabWord() {
        String temp = userWord;
        userWord = null;

        return temp;
    }
}
