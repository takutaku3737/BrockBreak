package BlockBreak;

public class BlockBean {

	java.awt.Image BallImg; //= new java.awt.Image();
	java.awt.Image RacketImg; //= new java.awt.Image();
	java.awt.Image BlockImg; //= new java.awt.Image();
	private int Speed;
	private int BallWidth;
	private int BallHeight;
	private int BallX;
	private int BallY;
	private int BallXAdd;
	private int BallYAdd;
	private int BBWidth;
	private int BBHeight;
	private int RacketX;
	private int RacketY;
	private int RacketWidth;
	private int RacketHeight;
	private int IsBlock[];
	private int BlockX[];
	private int BlockY[];
	private int BlockWidth;
	private int BlockHeight;
	private int BlockMargin;
	private int BlockRow;
	private int BlockColumn;
	private int BlockQuantity;
	private int Status;



	public java.awt.Image getBallImg() {
		return BallImg;
	}
	public void setBallImg(java.awt.Image ballImg) {
		BallImg = ballImg;
	}
	public java.awt.Image getRacketImg() {
		return RacketImg;
	}
	public void setRacketImg(java.awt.Image racketImg) {
		RacketImg = racketImg;
	}
	public java.awt.Image getBlockImg() {
		return BlockImg;
	}
	public void setBlockImg(java.awt.Image blockImg) {
		BlockImg = blockImg;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public int getBallWidth() {
		return BallWidth;
	}
	public void setBallWidth(int ballWidth) {
		BallWidth = ballWidth;
	}
	public int getBallHeight() {
		return BallHeight;
	}
	public void setBallHeight(int ballHeight) {
		BallHeight = ballHeight;
	}
	public int getBallX() {
		return BallX;
	}
	public void setBallX(int ballX) {
		BallX = ballX;
	}
	public int getBallY() {
		return BallY;
	}
	public void setBallY(int ballY) {
		BallY = ballY;
	}
	public int getBallXAdd() {
		return BallXAdd;
	}
	public void setBallXAdd(int ballXAdd) {
		BallXAdd = ballXAdd;
	}
	public int getBallYAdd() {
		return BallYAdd;
	}
	public void setBallYAdd(int ballYAdd) {
		BallYAdd = ballYAdd;
	}
	public int getBBWidth() {
		return BBWidth;
	}
	public void setBBWidth(int bBWidth) {
		BBWidth = bBWidth;
	}
	public int getBBHeight() {
		return BBHeight;
	}
	public void setBBHeight(int bBHeight) {
		BBHeight = bBHeight;
	}
	public int getRacketX() {
		return RacketX;
	}
	public void setRacketX(int racketX) {
		RacketX = racketX;
	}
	public int getRacketY() {
		return RacketY;
	}
	public void setRacketY(int racketY) {
		RacketY = racketY;
	}
	public int getRacketWidth() {
		return RacketWidth;
	}
	public void setRacketWidth(int racketWidth) {
		RacketWidth = racketWidth;
	}
	public int getRacketHeight() {
		return RacketHeight;
	}
	public void setRacketHeight(int racketHeight) {
		RacketHeight = racketHeight;
	}
	public int[] getIsBlock() {
		return IsBlock;
	}
	public void setIsBlock(int index) {
		IsBlock[index] = 0;
	}
	public int[] getBlockX() {
		return BlockX;
	}
	public void setBlockX(int[] blockX) {
		BlockX = blockX;
	}
	public int[] getBlockY() {
		return BlockY;
	}
	public void setBlockY(int[] blockY) {
		BlockY = blockY;
	}
	public int getBlockWidth() {
		return BlockWidth;
	}
	public void setBlockWidth(int blockWidth) {
		BlockWidth = blockWidth;
	}
	public int getBlockHeight() {
		return BlockHeight;
	}
	public void setBlockHeight(int blockHeight) {
		BlockHeight = blockHeight;
	}
	public int getBlockMargin() {
		return BlockMargin;
	}
	public void setBlockMargin(int blockMargin) {
		BlockMargin = blockMargin;
	}
	public int getBlockRow() {
		return BlockRow;
	}
	public void setBlockRow(int blockRow) {
		BlockRow = blockRow;
	}
	public int getBlockColumn() {
		return BlockColumn;
	}
	public void setBlockColumn(int blockcolumn) {
		BlockColumn = blockcolumn;
	}
	public int getBlockQuantity() {
		return BlockQuantity;
	}
	public void setBlockQuantity(int quantity) {
		BlockQuantity = BlockQuantity + quantity;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}

	public void blockFirstSetting() {


		IsBlock = new int[BlockRow * BlockColumn];
		BlockX = new int[BlockRow * BlockColumn];
		BlockY = new int[BlockRow * BlockColumn];
		BlockQuantity = BlockRow * BlockColumn;

		int Counter1;
		int Counter2;
		int BlockNum;
		int BlockStepY;

		BlockNum = 0;

		for(Counter1 = 0; Counter1 < BlockRow; Counter1++) {
			BlockStepY = Counter1*(BlockHeight+3)+0;
			for(Counter2 = 0; Counter2 < BlockColumn; Counter2++) {
				BlockX[BlockNum] = Counter2*(BlockWidth+30)+0;
				BlockY[BlockNum] = BlockStepY;
				IsBlock[BlockNum] = 1;
				BlockNum++;
			}
		}
	}

}
