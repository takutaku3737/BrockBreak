package BlockBreak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class BlockViewPanel extends Panel {

	BlockBean ImgInfo;
	java.awt.Graphics OffGraph;
	java.awt.Image OffImg;

	public void setBounds(int x, int y, int width, int height){
		super.setBounds(x, y, width, height);
		int NowWidth = this.getWidth();
		int NowHeight = this.getHeight();
		OffImg = this.createImage(NowWidth, NowHeight);
		OffGraph = OffImg.getGraphics();
	}

	public void rewrite(BlockBean a){
		ImgInfo = a;
		this.repaint();
	}

	public Graphics doublebuffer(Graphics g){
		BeanDrawing(g);
		return g;
	}

	public Graphics BeanDrawing(Graphics b) {
		if(ImgInfo != null) {
			OffGraph.clearRect(
				0,
				0,
				ImgInfo.getBBWidth(),
				ImgInfo.getBBHeight()
			);
			OffGraph.drawImage(
				ImgInfo.getBallImg(),
				ImgInfo.getBallX(),
				ImgInfo.getBallY(),
				ImgInfo.getBallWidth()*2,
				ImgInfo.getBallHeight()*2,
				this
			);
			OffGraph.drawImage(
				ImgInfo.getRacketImg(),
				ImgInfo.getRacketX(),
				ImgInfo.getRacketY(),
				ImgInfo.getRacketWidth(),
				ImgInfo.getRacketHeight(),
				this
			);
			for(int counter = 0; counter < ImgInfo.getIsBlock().length; counter++) {
				if(ImgInfo.getIsBlock()[counter] == 1) {
					OffGraph.drawImage(
						ImgInfo.getBlockImg(),
						ImgInfo.getBlockX()[counter],
						ImgInfo.getBlockY()[counter],
						50,
						20,
						this
					);
				}
			}
			b.drawImage(OffImg, 0, 0, this);
			if(ImgInfo.getBlockQuantity() == 0) {
				Font font = new Font("Serif", Font.PLAIN, 50);
				b.setFont(font);
				b.setColor(Color.blue.darker());
				b.drawString("クリアー", 100, 200);
			}
			if(ImgInfo.getStatus() == 2) {
				Font font = new Font("Serif", Font.PLAIN, 50);
				b.setFont(font);
				b.setColor(Color.blue.darker());
				b.drawString("ゲームオーバー", 20, 200);
			}
		}
		return b;
	}

}
