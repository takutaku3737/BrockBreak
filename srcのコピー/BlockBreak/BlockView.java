package BlockBreak;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BlockView extends Frame implements ActionListener, MouseMotionListener{

	BlockViewPanel BVP;
	BlockControl BC;
	Button StartButton;
	Button StopButton;
	Button ReplayButton;
	BlockBean ImageInfo = new BlockBean();

	public BlockBean getImageInfo() {
		return ImageInfo;
	}
	public void setImageInfo(BlockBean imageInfo) {
		ImageInfo = imageInfo;
	}

	public BlockView() {
		BVP = new BlockViewPanel();
		BVP.setBackground(Color.black);
		BVP.setVisible(true);
		this.add(BVP);

		StartButton = new Button("スタート");
		StopButton = new Button("ストップ");
		ReplayButton = new Button("リトライ");
		this.add(StartButton);
		this.add(StopButton);
		this.add(ReplayButton);

		StartButton.addActionListener(this);
		StopButton.addActionListener(this);
		ReplayButton.addActionListener(this);
		BVP.addMouseMotionListener(this);

		firstSetting();
	}

	public void firstSetting() {
		//初期設定
		ImageInfo.setBallImg(Toolkit.getDefaultToolkit().getImage("src/ball.png"));
		ImageInfo.setRacketImg(Toolkit.getDefaultToolkit().getImage("src/racket.png"));
		ImageInfo.setBlockImg(Toolkit.getDefaultToolkit().getImage("src/block.png"));

		ImageInfo.setBallX(10);
		ImageInfo.setBallY(100);

		ImageInfo.setBallWidth(5);
		ImageInfo.setBallHeight(5);

		ImageInfo.setSpeed(5);

		ImageInfo.setBallXAdd(2);
		ImageInfo.setBallYAdd(2);

		ImageInfo.setBlockWidth(50);
		ImageInfo.setBlockHeight(20);
		ImageInfo.setBlockMargin(10);

		ImageInfo.setBlockRow(3);
		ImageInfo.setBlockColumn(5);
		ImageInfo.blockFirstSetting();

		ImageInfo.setStatus(0);
	}

	public void infoSetting() {
		int ButtonHeight = 30;

		Insets Insets = this.getInsets();
		int DomainWidth = this.getWidth() - Insets.left - Insets.right;
		int DomainHeight = this.getHeight() - Insets.top - Insets.bottom - ButtonHeight;

		BVP.setBounds(Insets.left, Insets.top, DomainWidth, DomainHeight);

		int ButtonWidth = DomainWidth / 3;

		int ButtonX = Insets.left;
		int ButtonY = this.getHeight() - Insets.bottom - ButtonHeight;

		StartButton.setBounds(ButtonX, ButtonY, ButtonWidth, ButtonHeight);
		StopButton.setBounds(ButtonX + ButtonWidth, ButtonY, ButtonWidth, ButtonHeight);
		ReplayButton.setBounds(ButtonX + ButtonWidth*2, ButtonY, ButtonWidth, ButtonHeight);

		ImageInfo.setRacketWidth(50);
		ImageInfo.setRacketWidth(10);

		ImageInfo.setRacketX( (DomainWidth - ImageInfo.getRacketWidth()) / 2 );
		ImageInfo.setRacketY( DomainHeight - ImageInfo.getRacketHeight() );

		ImageInfo.setBBWidth(BVP.getWidth());
		ImageInfo.setBBHeight(DomainHeight);
	}

	public void gameStop() {
		BC.interrupt();
	}

	public void paint(BlockBean a) {
		BVP.rewrite(a);
	}

	public void startbuttonPushed() {
		if(ImageInfo.getStatus() == 0) {
			ImageInfo.setStatus(1);
			BC = new BlockControl(this);
			BC.start();
		}
	}

	public void stopbuttonPushed() {
		System.exit(0);
	}

	public void replaybuttonPushed() {
		if(ImageInfo.getStatus() == 2 || ImageInfo.getStatus() == 3) {
			firstSetting();
			startbuttonPushed();
		}
	}

	public void actionPerformed(ActionEvent b) {
		if(b.getSource().equals(StartButton)) {
			startbuttonPushed();
		}else if(b.getSource().equals(StopButton)){
			stopbuttonPushed();
		}else if(b.getSource().equals(ReplayButton)) {
			replaybuttonPushed();
		}
	}

	public void mouseDragged(MouseEvent c) {
		//空実装
	}

	public void mouseMoved(MouseEvent d) {
		int MousePosition;

		if( d.getX() + ImageInfo.getRacketWidth() > ImageInfo.getBBWidth() ) {
			MousePosition = ImageInfo.getBBWidth() - ImageInfo.getRacketWidth();
		}else {
			MousePosition = d.getX();
		}
		ImageInfo.setRacketX(MousePosition);
		paint(ImageInfo);
	}

}
