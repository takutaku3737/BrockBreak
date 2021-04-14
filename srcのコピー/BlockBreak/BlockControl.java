package BlockBreak;

public class BlockControl extends Thread{

	BlockModel BM;
	BlockView BV;
	BlockBean BB;

	public BlockControl(BlockView a) {
		this.BV = a;
		this.BB = BV.getImageInfo();
		this.BM = new BlockModel();
	}

	public void run() {
		try {
			BV.paint(BB);
			Thread.sleep(100);

			while(true) {
				BB = BV.getImageInfo();
				BB = BM.judge(BB);
				BV.setImageInfo(BB);
				BV.paint(BB);
				if(BB.getBlockQuantity() == 0) {
					BB.setStatus(3);
					BV.gameStop();
				}
				if(BB.getStatus() == 2) {
					BV.gameStop();
				}
				Thread.sleep(BB.getSpeed());
			}
		}
		catch(InterruptedException a){

		}
	}

}
