package tictaclab;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
public class prac {

	
		private String[][] str=new String[3][3];
		JTextField change=new JTextField(20);
		String ch="X";
		int count=0;
		int flag=0;
		private int a1;
		private int a2;
		private int b1;
		private int b2;
		
		public prac()
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
					str[i][j]="-";
			}
		}
		private JButton but(String text,int font,int x,int y,int w,int h,int back)
		{
			JButton b=new JButton(text);
			//initial();
			b.setBounds(x, y, w, h);
			b.setFont(new Font("serif", Font.BOLD, font));
			b.setBackground(new Color(back,200,255));
			return b;
		}
		private JFrame newframe()
		{
			final JFrame frm= new JFrame("TicTacToe");
			frm.setVisible(true);
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frm.setSize(700, 700);
			JLabel startlab=new JLabel("Tic-Tac-Toe");
			frm.setLayout(null);
			frm.add(startlab);
			startlab.setBounds(220, 80, 350, 150);
			startlab.setFont(new Font("Algerian",Font.BOLD,40));
			startlab.setForeground(Color.RED);
			startlab.setBackground(Color.MAGENTA);
			final JButton start=but("Start Game",28,170,200,350,70,255);
			start.setBackground(Color.YELLOW);
			start.setFont(new Font("serif",Font.BOLD,28));
			final JButton exit0=but("Exit",28,170,300,350,70,120);
			exit0.setBackground(Color.YELLOW);
			exit0.setFont(new Font("serif",Font.BOLD,28));
			exit0.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			start.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frm.setVisible(false);
					JFrame fin=new JFrame("GRID");
					fin.setVisible(true);
					JButton b1=but("User1 vs User2",20,50,100,250,50,250);
					JButton b2=but("User vs CPU",20,50,180,250,50,250);
					JButton b3=but("CPU vs AI BOT",20,50,260,250,50,250);
					JButton b4=but("User vs AI BOT",20,50,340,250,50,250);
					JButton b5=but("EXIT",25,50,450,250,50,200);
					change.setBounds(350,450,300,50);
					change.setFont(new Font("serif",Font.BOLD,16));
					change.setBackground(Color.YELLOW);
					//change.setFont(new Font("Calibri", Font.BOLD, 22));
					change.setForeground(Color.RED);
					fin.add(change);
					change.setText("Output for showing turns and result");
					final JButton grid[][] = new JButton[3][3];
					for(int i=0 ; i<3 ; i++)
				    {
				    	for(int j=0 ; j<3 ; j++)
				    	{
				    		
				    		grid[i][j]=but("",0,100*j+330,100*i+100,100,100,150);
				    		//System.out.println(i);
				    		fin.add(grid[i][j]);
				    	}
				    }
					b1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								JPanel pn=new JPanel();
								b2.setBackground(new Color(250,200,255));
								b3.setBackground(new Color(250,200,255));
								b4.setBackground(new Color(250,200,255));
								b1.setBackground(Color.orange);
								Scanner inp=new Scanner(System.in);
								JTextField t1=new JTextField(20);
								JTextField t2=new JTextField(20);
								JLabel j1=new JLabel("USER 1: ");
								reseta(grid);
								resetall(grid);
								flag=0;
								count=0;
								for(int i=0;i<3;i++)
								{
									for(int j=0;j<3;j++)
									{
										grid[i][j].setBackground(Color.MAGENTA);
									}
								}
								pn.add(j1);
								pn.add(t1);
								JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								while(t1.getText().length()==0)
								{
									JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								}
								
								pn.removeAll();
								pn.add(new JLabel("USER 2: "));
								pn.add(t2);
								JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								while(t2.getText().length()==0)
								{
									JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								}
								pn.removeAll();
								JTextField firstuser=new JTextField(20);
								pn.add(new JLabel("First Player: "));
								pn.add(firstuser);
								JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								while(firstuser.getText().length()==0)
								{
									JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								}
								//change.setBounds(350, 450, 250, 50);
								change.setText(firstuser.getText()+"'s Turn");
								grid[0][0].addActionListener(new ActionListener()
									    {
									    	
									    	public void actionPerformed(ActionEvent e)
									    	{
									    		perform(0,0,grid,t1,t2);
									    		
									    	}
									    });
								grid[0][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(0,1,grid,t1,t2);
							    		
							    	}
							    });
								grid[0][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(0,2,grid,t1,t2);
							    		
							    	}
							    });
								grid[1][0].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(1,0,grid,t1,t2);
							    		
							    	}
							    });
								grid[1][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(1,1,grid,t1,t2);
							    		
							    	}
							    });
								grid[1][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(1,2,grid,t1,t2);
							    		
							    	}
							    });
								grid[2][0].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(2,0,grid,t1,t2);
							    		
							    	}
							    });
								grid[2][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(2,1,grid,t1,t2);
							    		
							    	}
							    });
								grid[2][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		perform(2,2,grid,t1,t2);
							    		
							    	}
							    	
							    });
								   		
										
							}
					});
					
					b2.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								JPanel pn=new JPanel();
								b1.setBackground(new Color(250,200,255));
								b3.setBackground(new Color(250,200,255));
								b4.setBackground(new Color(250,200,255));
								b2.setBackground(Color.orange);
								JTextField t1=new JTextField(20);
								pn.add(new JLabel("User :"));
								pn.add(t1);
								reseta(grid);
								resetall(grid);
								flag=0;
								count=0;
								for(int i=0;i<3;i++)
								{
									for(int j=0;j<3;j++)
									{
										grid[i][j].setBackground(Color.MAGENTA);
									}
								}
								JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								while(t1.getText().length()==0)
								{
									JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
								}
								Random gen=new Random();
								int x=gen.nextInt(2);
								change.setText(t1.getText()+"'s turn");
								if(x==0)
								{
									int x1=gen.nextInt(3);
									int y1=gen.nextInt(3);
									while(str[x1][y1]!="-")
										{
										x1=gen.nextInt(3);
										y1=gen.nextInt(3);
										}
									perform(x1,y1,grid,t1,t1);
									count++;
								}
								grid[0][0].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(0,0,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								grid[0][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(0,1,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								grid[0][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(0,2,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								grid[1][0].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(1,0,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								grid[1][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(1,1,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    		
							    	}
							    });
								grid[1][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(1,2,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
							    			}
								    	}
							    	
							    });
								grid[2][0].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(2,0,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
							    			}
								    	}
							    	
							    });
								grid[2][1].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(2,1,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								grid[2][2].addActionListener(new ActionListener()
							    {
							    	
							    	public void actionPerformed(ActionEvent e)
							    	{
							    		int k=perform(2,2,grid,t1,t1);
							    		if(k==0)
							    		{
							    			count++;
							    			cpu(grid,t1,t1);
								    	}
							    	}
							    });
								
							}
					});
					b3.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
						{
							Runnable r=new Runnable(){
								public void run(){
									reseta(grid);
									b2.setBackground(new Color(250,200,255));
									b1.setBackground(new Color(250,200,255));
									b4.setBackground(new Color(250,200,255));
									b3.setBackground(Color.orange);
									resetall(grid);
									flag=0;
									count=0;
									JTextField j1=new JTextField("CPU");
									JTextField j2=new JTextField("AI Bot");
									for(int i=0;i<3;i++)
									{
										for(int j=0;j<3;j++)
										{
											grid[i][j].setBackground(Color.MAGENTA);
										}
									}
									Random gen=new Random();
									int val=0;
									 int x=gen.nextInt(2);
											if(x==0)
											{
											int x1=gen.nextInt(3);
											int y1=gen.nextInt(3);
											while(str[x1][y1]!="-")
												{
												x1=gen.nextInt(3);
												y1=gen.nextInt(3);
												}
											perform(x1,y1,grid,j1,j2);
											try{
												Thread.sleep(1000);
											
											}catch(InterruptedException e){
												System.out.println("");
											};
											count++;
											}
									
									while(count<9)
									{
										//Random gen1=new Random();
										
										if(x!=0)
										{
											val=aibot(grid,j2,j2);
											try{
												Thread.sleep(1000);
											
											}catch(InterruptedException e){
												System.out.println("");
											};
											count++;
											x=0;
										}
										else {	
													
												int x1=gen.nextInt(3);
												int y1=gen.nextInt(3);
												while(str[x1][y1]!="-")
													{
													x1=gen.nextInt(3);
													y1=gen.nextInt(3);
													}
												perform(x1,y1,grid,j1,j2);
												try{
													Thread.sleep(1000);
												
												}catch(InterruptedException e){
													System.out.println("");
												};
												count++;
												x=1;
											}	
									}	
										
										
									if(change.getText().equals("AI Bot's Turn")||change.getText().equals("CPU's Turn") )
										change.setText("It's a TIE");
								}
							};
							Thread t=new Thread(r);
							t.start();
						}
					});
					b4.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							JPanel pn=new JPanel();
							b2.setBackground(new Color(250,200,255));
							b3.setBackground(new Color(250,200,255));
							b1.setBackground(new Color(250,200,255));
							b4.setBackground(Color.orange);
							JTextField t1=new JTextField(20);
							pn.add(new JLabel("User :"));
							pn.add(t1);
							reseta(grid);
							resetall(grid);
							flag=0;
							count=0;
							JTextField j1=new JTextField("AI Bot");
							for(int i=0;i<3;i++)
							{
								for(int j=0;j<3;j++)
								{
									grid[i][j].setBackground(Color.magenta);
								}
							}
							JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
							while(t1.getText().length()==0)
							{
								JOptionPane.showConfirmDialog(null, pn, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
							}
							Random gen=new Random();
							int x=gen.nextInt(2);
							change.setText(t1.getText()+"'s turn");
							if(x==0)
							{
								int x1=gen.nextInt(3);
								int y1=gen.nextInt(3);
								while(str[x1][y1]!="-")
									{
									x1=gen.nextInt(3);
									y1=gen.nextInt(3);
									}
								perform(x1,y1,grid,t1,t1);
								count++;
							}
							grid[0][0].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(0,0,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[0][1].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(0,1,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[0][2].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(0,2,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[1][0].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(1,0,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[1][1].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(1,1,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[1][2].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(1,2,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[2][0].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(2,0,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[2][1].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(2,1,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
							grid[2][2].addActionListener(new ActionListener()
						    {
						    	
						    	public void actionPerformed(ActionEvent e)
						    	{
						    		int k=perform(2,2,grid,t1,t1);
						    		if(k==0)
						    		{
						    			count++;
						    			if(count<9)
						    			{
						    				int val=aibot(grid,t1,j1);
						    				count++;
						    			}
						    		}
						    	}
						    });
						}
					});
					b5.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							System.exit(0);
						}
					});
					fin.setSize(700,700);
					fin.setLayout(null);
					fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					fin.add(b1);
					fin.add(b2);
					fin.add(b3);
					fin.add(b4);
					fin.add(b5);
					
				}
			});
			frm.add(start);
			frm.add(exit0);
			return frm;
		}
		private int aibot(JButton grid[][],JTextField t1,JTextField j1)
		{
			int sum=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(str[i][j]=="-")
					{
						int m=0,q=0;
						if(i==j)
							m=findd1(i, j, ch);
						if(i+j==2)
							if((str[0][2]==ch && str[2][0]==ch )&&(str[0][2]==ch && str[1][1]==ch)||(str[2][0]==ch&&str[1][1]==ch) )
							{
								q=1;
							}
						int k=findi(i,j,ch);
						int l=findj(i,j,ch);
						if(m==1 || k==1 || l==1 || q==1)
							{
							sum=1;
							perform(i,j,grid,t1,j1);
							return 0;
							}
					
						}
				}
				if(sum==1)
					return 0;
			}
			if(sum==0)
			{
				String s="X";
				if(s.equals(ch))
				{
					s="O";
				}
				for(int i=0;i<3;i++)
				
				{
					for(int j=0;j<3;j++)
					{
						if(str[i][j]=="-")
							{
							//int z=obj.put(i,j,'O');
							int m=0,q=0;
							if(i==j)
								m=findd1(i, j, s);
							if(i+j==2)
								if((str[0][2]==s && str[2][0]==s )&&(str[0][2]==s && str[1][1]==s)||(str[2][0]==s && str[1][1]==s) )
								{
									q=1;
								}
							int k=findi(i,j,s);
							int l=findj(i,j,s);
							if(k==1 || l==1 || q==1 || m==1)
								{
								sum=1;
								perform(i,j,grid,t1,j1);
								return 1;
								}
						
							}
					}
					if(sum==1)
						return 1;
				}
			
			}
			if(sum==0)
			{
				Random gen=new Random();
				int x=gen.nextInt(3);
				int y=gen.nextInt(3);
				while(str[x][y]!="-")
				{
					x=gen.nextInt(3);
					y=gen.nextInt(3);
				}
				perform(x,y,grid,t1,t1);
				return 1;
			}
			return 0;
		}
		private int perform(int i,int j,JButton grid[][],JTextField t1,JTextField t2)
		{
			String s1=ch;
			int k;
			int r=runall();
			if(r==0 && flag==0)
			{
				if(free(i,j,str)==0)
				{
					grid[i][j].setText(s1);
					str[i][j]=s1;
					grid[i][j].setFont(new Font("serif", Font.BOLD, 50));
					if(ch.equals("X"))
					{
						ch="O";
						k=checkState(i,j,s1,t1);
						if(k==0)
							change.setText(t2.getText() +"'s Turn");
						else
						{
							grid[i][j].setBackground(Color.GREEN);
							grid[a1][b1].setBackground(Color.GREEN);
							grid[a2][b2].setBackground(Color.GREEN);
							flag=1;
							System.out.println(a1+" "+b1);
							System.out.println(a2+" "+b2);
						}
					}
					else 
					{
						ch="X";
						k=checkState(i,j,s1,t2);
						if(k==0)
							change.setText(t1.getText() + "'s Turn");
						else
						{
							grid[i][j].setBackground(Color.GREEN);
							grid[a1][b1].setBackground(Color.GREEN);
							grid[a2][b2].setBackground(Color.GREEN);
							flag=1;
							System.out.println(a1+" "+b1);
							System.out.println(a2+" "+b2);
						}
					}
					return 0;
				}
				else return 1;
			}
			else if(flag==0)
				{
				change.setText("It's a Tie");
				//resetall(grid);
				flag=1;
				return 1;
				}
			return 0;
		}
		private void resetall(JButton grid[][])
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					str[i][j]="-";
					//grid[i][j].setText("");
				}
			}
		}
		private void reseta(JButton grid[][])
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					grid[i][j].setText("");
				}
			}
		}
		private int runall()
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(str[i][j]=="-")
					{
						return 0;
					}
				}
			}
			return 1;
		}
		private int free(int i ,int j,String str[][])
		{
			if(str[i][j].equals("-"))
				return 0;
			else 
				return 1;
		}
		private void cpu(JButton grid[][],JTextField t1,JTextField t2)
		{
			Timer timer1=new Timer(0,new ActionListener()
			{@Override
				public void actionPerformed(ActionEvent e)
				{	Random gen=new Random();
	    			if(count<9)
	    			{
	    				int x1=gen.nextInt(3);
						int y1=gen.nextInt(3);
						while(str[x1][y1]!="-")
							{
							x1=gen.nextInt(3);
							y1=gen.nextInt(3);
							}
						perform(x1,y1,grid,t1,t1);
						count++;
	    			}
				}
			
			});	
			
			timer1.setRepeats(false);
			timer1.setCoalesce(false);
			timer1.setInitialDelay(1000);
			timer1.start();
		}
		private int findd1(int x,int y,String val)
		{
			int count=0;
			for(int i=0;i<3;i++)
			{
				if(i!=x && str[i][i]==val)
					{
					//a[count]=i;
					//b[count]=i;	
					count++;
						
					}
			}
			if(count==2)
				{int q=0;
				for(int i=0;i<3;i++)
				{
					if(i!=x && str[i][i]==val)
						{
						//a[count]=i;
						//b[count]=i;	
						if(q==0)
							a1=b1=i;
						else
							a2=b2=i;
						q++;
							
						}
				}
				return 1;
				}
			return 0;
		}
		private int findi(int x,int y,String val)
		{
			int count=0;
			b1=b2=y;
			for(int i=0;i<3;i++)
			{
				
				if(i!=x && str[i][y]==val)
					{
					//a[count]=i;
					//b[count]=y;
					
					count++;		
					}
			}
			if(count==2)
			{
				int q=0;
				for(int i=0;i<3;i++)
				{
					if(i!=x && str[i][y]==val)
					{
				//a[count]=i;
				//b[count]=y;
						if(q==0)
							a1=i;
						else
							a2=i;
						q++;
					}
				}
				
				return 1;
			}
			return 0;
		}
		private int findj(int x,int y,String val)
		{
			int count=0;
			a1=a2=x;
			for(int j=0;j<3;j++)
			{
				
				if(j!=y && str[x][j]==val)
					{
					//a[count]=x;
					//b[count]=j;
					count++;		
					}
			}
			if(count==2)
			{
				int q=0;
				for(int j=0;j<3;j++)
				{
					
					if(j!=y && str[x][j]==val)
						{
						//a[count]=x;
						//b[count]=j;
						if(q==0)
							b1=j;
						else
							b2=j;
						q++;
						}
				}
				return 1;
			}
			return 0;
		}
		private int checkState(int x,int y,String val,JTextField t)
		{
			if(x==1 && y==1)
			{
				if((str[0][0]==val && str[2][2]==val))
				{
					a1=b1=0;
					a2=b2=2;
					change.setText(t.getText()+ " wins");
					return 1;
				}
				if (str[0][2]==val && str[2][0]==val)
				{
					a1=b2=0;
					a2=b1=2;
					change.setText(t.getText()+ " wins");
					return 1;
				}
				if(str[0][1]==val && str[2][1]==val)
				{
					b2=b1=1;
					a1=0;
					a2=2;
					change.setText(t.getText()+ " wins");
					return 1;
				}
				if(str[1][0]==val&&str[1][2]==val)
				{
					a1=1;
					a2=1;
					b1=0;
					b2=2;
					change.setText(t.getText()+ " wins");
					return 1;
				}
			}
			else 
			{
				int l;
				int k=findi(x,y,val);
				if(k==1)
					{
					change.setText(t.getText()+ " wins");
					//initial();
					return 1;
					}
				else if(k!=1)
				{
					l=findj(x,y,val);
					if(l==1)
						{
						change.setText(t.getText()+ " wins");
						//initial();
						return 1;
						}
					else if(l!=1)
					{
						if(x==y)
						{
							int z=findd1(x,y,val);
							if(z==1)
								{
								change.setText(t.getText()+ " wins");
							//	initial();
								return 1;
								}
						}
						else if(x+y==2)
						{
							if(str[0][2]==val && str[1][1]==val && str[2][0]==val)
								{
								
									change.setText(t.getText()+ " wins");
								if(x==0 && y==2)
								{
									a1=b1=1;
									a2=2;
									b2=0;
								}
								if(x==1 && y==1)
								{
									a1=0;
									b1=2;
									a2=2;
									b2=0;
								}if(x==2 && y==0)
								{
									a1=0;
									b1=2;
									a2=1;
									b2=1;
								}
								
									//initial();
									return 1;
								}
						}
					}
				}
			}
			return 0;
		}

		public static void main(String[] args) {
			prac obj=new prac();
			JFrame fr=obj.newframe();
			//fr.add(obj);
			
		}
	


	}

