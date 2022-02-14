import java.util.ArrayList;

public class MerkleThread implements Runnable{
    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;
    public String threadName;

    public void run() {
        Util oUtil = new Util();
        lstWords = new ArrayList<>();
        System.out.println("Merkle thread running");

        while (true) {

            oUtil.sleepRandomTime(threadName);
            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null) {
                System.out.println("Merkle thread grabbed the word!");
                lstWords.add(sNewWord);

                if (lstWords.size() == iMerkleTreeInputs) {
                    MerkleManager.merkleRoot = oUtil.getMerkleRoot(lstWords);
                }
            }

        }
    }

}
