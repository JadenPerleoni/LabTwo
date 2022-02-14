public class MonitorThread implements Runnable{


    public void run() {

        Util oUtil = new Util();

        System.out.println("Strikes: " + MerkleManager.strikes);

        while(true) {
            if (MerkleManager.merkleRoot != null) {

                if (MerkleManager.merkleRoot.equals(MerkleManager.userMerkleRoot)) {
                    System.out.println("You win: " + MerkleManager.merkleRoot);
                    System.exit(0);
                } else {
                    System.out.println("You lost: " + MerkleManager.merkleRoot);
                    System.exit(0);
                }
            } else if (MerkleManager.strikes == 3) {
                System.out.println("You lost!!");
                System.exit(0);
            }
            oUtil.sleep(1);
        }

    }
}
