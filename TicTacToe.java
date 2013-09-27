package com.xo;

import java.io.IOException;

public class TicTacToe {
	
	private static int DEFAULT_BOARD_SIZE = 3;
	
	private final static char SYMBOL = '\u0001';
	
	private int boardSize = DEFAULT_BOARD_SIZE;
	
	private
	
	private char[][] gameBoard;
	
	private int xPosition=0;
	
	private int yPosition=0;
	
	// Число, определяющее чей ход: игрока1 (turn=1) или игрока2 (turn=2). 
	// Инициализируется случайным значением 1 или 2
	
	private int turn= Math.random()>0.5?2:1; 
	
	//Конструктор создает поле, размеры которого задаются полем boardSize
	public TicTacToe(int boardSize) {
		this.boardSize=boardSize;
		gameBoard = new char [boardSize][boardSize];
		
		for(int i = 0 ; i < boardSize; i++) {
			
			for(int j = 0; j < boardSize; j++) {
				
				gameBoard[i][j]=' ';
				
			}
		}	
	}
	
	public TicTacToe()
	{
		this(DEFAULT_BOARD_SIZE);
	}
	
	//Конструктор копирования
	public TicTacToe(TicTacToe ticTacToe) {
		
		this.boardSize=ticTacToe.boardSize;
		
		for(int i = 0; i < boardSize; i++) {
			
			for(int j = 0; j < boardSize; j++) {
				
				this.gameBoard[i][j] = ticTacToe.gameBoard[i][j];
			
			}
		}
	}
	
	public void beginGame() {
		makeMove();
	}
	
	//Выводит поле на экран
	private static void drawBoard(char[][] gameBoard) {
		
		for(int i=0;i<gameBoard.length;i++) {
			
			for(int j = 0; j < gameBoard.length; j++) {
			
				System.out.print("["+gameBoard[i][j]+"]");
			}
			
			System.out.println();
		}
	}
	
	public void makeMove() {
		
		drawBoard(this.gameBoard);
		
		char[][] actionBoard=new char[this.boardSize][this.boardSize];
		
		for(int i = 0; i < this.boardSize; i++) {
			
			for(int j = 0; j < this.boardSize; j++) {
				
				actionBoard[i][j] = this.gameBoard[i][j];
				
			}
			
		}
		
		
		actionBoard[xPosition][yPosition]='\u0001';
		
		System.out.println("Ходит игрок " + this.turn);
		
		drawBoard(actionBoard);
		int code=0;
		try
		{
			while(code!=2386) {
				code=System.in.read();
				char symbol = (char) code;
				switch (symbol) {
					case 'w': 
						if(xPosition != 0) {
							actionBoard[xPosition][yPosition] = this.gameBoard[xPosition][yPosition];
							actionBoard[xPosition-1][yPosition] =  SYMBOL;
							xPosition-=1;
							Runtime.getRuntime().exec("cls");
							drawBoard(this.gameBoard);
							drawBoard(actionBoard);
						}
					break;
					case 'd':
						if(yPosition != this.boardSize-1) {
							actionBoard[xPosition][yPosition] = this.gameBoard[xPosition][yPosition];
							actionBoard[xPosition][yPosition+1] =  SYMBOL;
							yPosition+=1;
							Runtime.getRuntime().exec("cls");
							drawBoard(this.gameBoard);
							drawBoard(actionBoard);
						}
					break;
					case 'a':
						if(yPosition != 0) {
							actionBoard[xPosition][yPosition] = this.gameBoard[xPosition][yPosition];
							actionBoard[xPosition][yPosition-1] =  SYMBOL;
							yPosition-=1;
							Runtime.getRuntime().exec("cls");
							drawBoard(this.gameBoard);
							drawBoard(actionBoard);
						}
					break;
					case 's': 
						if(xPosition != this.boardSize-1) {
							actionBoard[xPosition][yPosition] = this.gameBoard[xPosition][yPosition];
							actionBoard[xPosition+1][yPosition] =  SYMBOL;
							xPosition+=1;
							Runtime.getRuntime().exec("cls");
							drawBoard(this.gameBoard);
							drawBoard(actionBoard);
						}
					break;
				}
				
			}
		} catch (IOException e)
		{
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
	}

}
