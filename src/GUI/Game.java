package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Utilities.BoardUtils;
import Utilities.CheckerBoard;
import Utilities.Symbol;

public class Game{
	
	private CheckerBoard checkerBoard;
	private JFrame frame;
	
	public Game() {
		this.checkerBoard = new CheckerBoard("Player 1",Symbol.CROSS,"Player 2",Symbol.NOUGHT);
		this.frame = new JFrame("Tic-Tac-Toe");
		this.frame.setSize(600,600);
		this.frame.add(new Board(),BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	
	private class Board extends JPanel{
		
		private final List<Tile> tiles;
		
		public Board() {
			super(new GridLayout(3,3));
			tiles = new ArrayList<>();
			for(int i=0;i<9;i++) {
				final Tile newTile = new Tile(this,i);
				tiles.add(newTile);
				add(newTile);
			}
			setPreferredSize(new Dimension(400,350));
			validate();	
		}
		
		public void drawBoard(CheckerBoard checkerBoard) {
			removeAll();
			for(final Tile tile: tiles) {
				tile.reDraw(checkerBoard);
				add(tile);
			}
			validate();
			repaint();
		}
	}
	
	private class Tile extends JPanel{
		
		final int index;
		
		public Tile(final Board board,final int index) {
			super(new GridLayout());
			this.index = index;
			setPreferredSize(new Dimension(10,10));
			assignBorder();
			assignTileValue(checkerBoard);
			addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(!checkerBoard.isAlreadyDone(index)) {
						checkerBoard = checkerBoard.makeMove(index);
						if(checkerBoard.hasWinner()) {
							JOptionPane.showMessageDialog(frame,checkerBoard.getOpponentPlayer().getName() +" is the winner!");
							System.exit(0);
						}
					}
					SwingUtilities.invokeLater(()->{
						board.drawBoard(checkerBoard);
					});
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			
		}
		
		public void reDraw(final CheckerBoard checkerBoard) {
			assignBorder();
			assignTileValue(checkerBoard);
			validate();
			repaint();
		}
		
		private void assignBorder() {
			setBackground(Color.YELLOW);
			int bottom = 0,right=0;
			if(BoardUtils.FIRST_ROW[index]||BoardUtils.SECOND_ROW[index]) {
				bottom=5;
			}
			if(BoardUtils.FIRST_COLUMN[index] || BoardUtils.SECOND_COLUMN[index]) {
				right=5;
			}
			setBorder(BorderFactory.createMatteBorder(0,0,bottom,right,Color.BLACK));
		}

		private void assignTileValue(CheckerBoard checkerBoard) {
			this.removeAll();
			if(checkerBoard.getSymbol(index).isNought()) {
				try {
					BufferedImage image = ImageIO.read(new File("images/Nought.png"));
					add(new JLabel(new ImageIcon(image)));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(checkerBoard.getSymbol(index).isCross()) {
				try {
					BufferedImage image = ImageIO.read(new File("images/Cross.png"));
					add(new JLabel(new ImageIcon(image)));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
