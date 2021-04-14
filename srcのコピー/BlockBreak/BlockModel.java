package BlockBreak;

public class BlockModel {

	public BlockBean judge(BlockBean b){

		int BallX = b.getBallX();
		int BallY = b.getBallY();
		int BallWidth = b.getBallWidth();
		int BallHeight = b.getBallHeight();
		int RacketX = b.getRacketX();
		int RacketY = b.getRacketY();
		int RacketWidth = b.getRacketWidth();
		int RacketHeight = b.getRacketHeight();
		int BBWidth = b.getBBWidth();
		int BBHeight = b.getBBHeight();
		int BallXAdd = b.getBallXAdd();
		int BallYAdd = b.getBallYAdd();
		int ArraySize = b.getBlockRow()*b.getBlockColumn();

		if(BallY + BallHeight >= RacketY && BallY + BallHeight <= RacketY + RacketHeight && BallX + BallWidth >= RacketX && BallX <= RacketX + RacketWidth) {
			BallYAdd = -2;
			if(BallX < RacketX || BallX + BallWidth > RacketX + RacketWidth) {
				if(BallXAdd == 0) {
					if(BallXAdd < RacketX) {
						BallXAdd = -2;
					}
					if(BallX + BallWidth > RacketX + RacketWidth) {
						BallXAdd = 2;
					}
				}else {
					BallXAdd = 0;
				}
			}
		}
		if(BallX < 0) {
			BallXAdd = 2;
		}
		if(BallX + BallWidth > BBWidth) {
			BallXAdd = -2;
		}
		if(BallY < 0) {
			BallYAdd = 2;
		}
		for(int counter = 0; counter < ArraySize; counter++) {
			if(b.getIsBlock()[counter] == 1) {
				if(BallY + BallWidth >= b.getBlockY()[counter] && BallY <= b.getBlockY()[counter] + b.getBlockHeight() && BallX + BallWidth >= b.getBlockX()[counter] && BallX <= b.getBlockX()[counter] + b.getBlockWidth()) {
					BallYAdd = -BallYAdd;
					b.setIsBlock(counter);
					b.setBlockQuantity(-1);
				}
			}
		}
		if(BallY + BallHeight > BBHeight + 100) {
			b.setStatus(2);
		}
		BallX = BallX + BallXAdd;
		BallY = BallY + BallYAdd;

		b.setBallX(BallX);
		b.setBallY(BallY);

		b.setBallXAdd(BallXAdd);
		b.setBallYAdd(BallYAdd);


		return b;
	}


}
