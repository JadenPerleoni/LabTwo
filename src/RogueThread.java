public class RogueThread implements Runnable{

    public String threadName;
    public void run() {
        Util oUtil = new Util();
        System.out.println("Rogue thread running");


        while (true) {
            oUtil.sleepRandomTime(threadName);
            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null) {
                MerkleManager.strikes += 1;
                System.out.println("STRIKE! Rogue thread grabbed the word");
                System.out.println("Strikes: " + MerkleManager.strikes);
            }
        }
    }
}
