import edu.uc3m.game.GameBoardGUI;
import java.util.Random;
public class Principal {
	
	public static void main(String[] args) throws InterruptedException{
		//Crear tablero
		GameBoardGUI gui= new GameBoardGUI(Constantes.MAXancho, Constantes.MAXlargo);
		//Dar color al tablero
		for (int ii = 0; ii < Constantes.MAXancho; ii++) {
			for (int jj = 0; jj < Constantes.MAXlargo; jj++) {
				gui.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}		
		gui.gb_setGridColor(0, 0, 0);
		//Rellenar el tablero (GUI)
		gui.gb_setPortraitPlayer("portrait.png");
		gui.gb_setTextPlayerName("Player 1");
		gui.gb_setTextPointsUp("Score");
		gui.gb_setTextPointsDown("Total Score");
		gui.gb_setTextAbility1("Shots");
		gui.gb_setTextAbility2("Accuracy (%)");
		gui.gb_setTextLevel("Level");
		gui.gb_setValueLevel(1);
		//Datos iniciales
		int direne=Constantes.DIR_E;
		int ptos=0;
		int juvida=Constantes.MAXVidajug;
		int hit=0;
		int acc=0;
		int Tshot=0;
		gui.gb_setValuePointsDown(ptos);
		gui.gb_setValueHealthMax(Constantes.MAXVidajug);
		gui.gb_setValueHealthCurrent(juvida);
		int ritmo=0;
		int aleteo=0;
		boolean salir=true;
		gui.setVisible(true);
		
		//Crear al Jugador
		Jugador jugador=new Jugador(0,((Constantes.MAXancho)*10)/2, (Constantes.MAXlargo*10)-25);//Posicion Inicial 
		gui.gb_addSprite(jugador.getId(), jugador.getImagn(), true);
		gui.gb_moveSpriteCoord(jugador.getId(), jugador.getCoordx(), jugador.getCoordy());
		gui.gb_setSpriteVisible(jugador.getId(), true);
		//Vidas en pantalla
		for(int g=1;g<4;g++) {
			gui.gb_addSprite(g, jugador.getImagn(), true);
			gui.gb_moveSpriteCoord(g,(g*10),(Constantes.MAXlargo*10)-10);
			gui.gb_setSpriteVisible(g, true);
			}
		//Creacion del enjambre de Enemigos
		Enemigo[] enemigos=new Enemigo[40];
		for (int i=0; i<4; i++) {
			Enemigo enemigo1=new Enemigo(100+i, 70+i*10, 5, Constantes.DIR_S);
			enemigos[i]=enemigo1;
			gui.gb_addSprite(enemigo1.getId(),enemigo1.getImagenV(), true);
			gui.gb_setSpriteVisible(enemigo1.getId(), true);
			gui.gb_moveSpriteCoord(enemigo1.getId(), enemigo1.getCoordx(), enemigo1.getCoordy());
		}
		for (int i=4; i<12; i++) {
			Enemigo enemigo1=new Enemigo(100+i, 50+(i-4)*10, 15, Constantes.DIR_S);
			enemigos[i]=enemigo1;
			gui.gb_addSprite(enemigo1.getId(),enemigo1.getImagenR(), true);
			gui.gb_setSpriteVisible(enemigo1.getId(), true);
			gui.gb_moveSpriteCoord(enemigo1.getId(), enemigo1.getCoordx(), enemigo1.getCoordy());
		}for (int i=12; i<20; i++) {
			Enemigo enemigo1=new Enemigo(100+i, 50+(i-12)*10, 25, Constantes.DIR_S);
			enemigos[i]=enemigo1;
			gui.gb_addSprite(enemigo1.getId(),enemigo1.getImagenR(), true);
			gui.gb_setSpriteVisible(enemigo1.getId(), true);
			gui.gb_moveSpriteCoord(enemigo1.getId(), enemigo1.getCoordx(), enemigo1.getCoordy());
		}
		for (int i=20; i<30; i++) {
			Enemigo enemigo1=new Enemigo(100+i, 40+(i-20)*10, 35, Constantes.DIR_S);
			enemigos[i]=enemigo1;
			gui.gb_addSprite(enemigo1.getId(),enemigo1.getImagenA(), true);
			gui.gb_setSpriteVisible(enemigo1.getId(), true);
			gui.gb_moveSpriteCoord(enemigo1.getId(), enemigo1.getCoordx(), enemigo1.getCoordy());
		}
		for (int i=30; i<40; i++) {
			Enemigo enemigo1=new Enemigo(100+i, 40+(i-30)*10, 45, Constantes.DIR_S);
			enemigos[i]=enemigo1;
			gui.gb_addSprite(enemigo1.getId(),enemigo1.getImagenA(), true);
			gui.gb_setSpriteVisible(enemigo1.getId(), true);
			gui.gb_moveSpriteCoord(enemigo1.getId(), enemigo1.getCoordx(), enemigo1.getCoordy());
		}
		
		//Pasar datos gui al jugador
		jugador.guijug=gui;
		
		do {
			//Actualizar los datos
			gui=jugador.guijug;
			jugador.actualizar();
			String CmdSalida=jugador.accion;
			ritmo++;
			if(ritmo%4==0) {
				aleteo++;
				for(int i=0;i<enemigos.length;i++){
					if(enemigos[i]!=null) {
						//Disparos de los enemigos
						if(i>=4&&i<20&&enemigos[i].bala==null) {
							int ran=(int)(Math.random()*150);
							if(ran==1) {
								enemigos[i].bala= new Bala(enemigos[i].getCoordx(), enemigos[i].getCoordy(), enemigos[i].getId(), Constantes.DIR_S);
								gui.gb_addSprite(enemigos[i].getId()+1000, enemigos[i].bala.getImagene(), true);
								gui.gb_setSpriteVisible(enemigos[i].getId()+1000, true);
							}
						}
						if(enemigos[i].bala!=null) {
							enemigos[i].bala.move(Constantes.DIR_S,1);
							gui.gb_setSpriteImage(enemigos[i].getId()+1000, enemigos[i].bala.getImagene());
							gui.gb_moveSpriteCoord(enemigos[i].getId()+1000, enemigos[i].bala.getCoordx(), enemigos[i].bala.getCoordy());
							//Impacto de bala enemiga en el Jugador
							if(Math.abs(enemigos[i].bala.getCoordx()-jugador.getCoordx())<=5 && 
									Math.abs(enemigos[i].bala.getCoordy()-jugador.getCoordy())<=5) {
								jugador.setVivo(false);
								gui.gb_setSpriteVisible(enemigos[i].getId()+1000, false);
							}
							if(enemigos[i].bala.getCoordy()>=Constantes.MAXlargo*10) {
								enemigos[i].bala=null;	
								gui.gb_setSpriteVisible(enemigos[i].getId()+1000, false);
							}
						}
						//Animacion aleteo
						if (aleteo%2==0 && enemigos[i].isVivo()) {
							if(i<40&&i>=20) {
								enemigos[i].setImagen("enemy3G0.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());				
							}
							if(i<20&&i>=4) {
								enemigos[i].setImagen("enemy2G0.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());							
							}
							if(i<4) {
								enemigos[i].setImagen("enemy1G0.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
						}else if (aleteo%2==1 && enemigos[i].isVivo()){
							if(i<40&&i>=20) {
								enemigos[i].setImagen("enemy3G1.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							if(i<20&&i>=4) {
								enemigos[i].setImagen("enemy2G1.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							if(i<4) {
								enemigos[i].setImagen("enemy1G1.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
						}
						//Avance de los enemigos en la horizontal
						enemigos[i].move(direne, 1);
						gui.gb_moveSpriteCoord(enemigos[i].getId(), enemigos[i].getCoordx(), enemigos[i].getCoordy());						
					}	
				}
			}
			//Movimiento del enjambre de enemigos hacia abajo al tocar el borde
			for(int o=0;o<enemigos.length;o++) {
				if(enemigos[o]!=null) {
					if(enemigos[o].getCoordx()>=((Constantes.MAXancho*10)-5)) {
						for(int k=0;k<enemigos.length;k++){
							if(enemigos[k]!=null) {
								enemigos[k].move(Constantes.DIR_Abajo, 2);
								gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
							}
						}
					}else if((enemigos[o].getCoordx()+5)<=Constantes.MINancho+10){
						for(int k=0;k<enemigos.length;k++){
							if(enemigos[k]!=null) {
								enemigos[k].move(Constantes.DIR_Abajo, 2);
								gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
							}
						}
					}
				}				
			}
			//Aparicion en la parte superior de una fila de enemigos cuando alcanza el limite inferior.
			for (int o=0;o<enemigos.length;o++) {
				if(enemigos[o]!=null) {
					if(enemigos[o].getCoordy()>=((Constantes.MAXlargo*10)-5)) {
						enemigos[o].setCoordy(0);
						gui.gb_moveSpriteCoord(enemigos[o].getId(), enemigos[o].getCoordx(), enemigos[o].getCoordy());
					}
				}
			}
			for(int i=0;i<enemigos.length;i++){
				for(int j=0;j<jugador.proyectiles.length;j++){
					//Cambio de la direccion de los enemigos en el borde
					if(enemigos[i]!=null) {
						if(enemigos[i].getCoordx()>=((Constantes.MAXancho*10)-5)) {
							direne=Constantes.DIR_W;
						}else if((enemigos[i].getCoordx()+5)<=Constantes.MINancho+10){
							direne=Constantes.DIR_E;
						}
						//Hits proyectil del jugador contra enemigo
						if(jugador.proyectiles[j]!=null) {
							if(Math.abs(enemigos[i].getCoordx()-jugador.proyectiles[j].getCoordx())<=5 && 
									Math.abs(enemigos[i].getCoordy()-jugador.proyectiles[j].getCoordy())<=5) {
								gui.gb_setSpriteVisible(jugador.proyectiles[j].getId(), false);
								jugador.proyectiles[j]=null;
								hit++;
								enemigos[i].setVivo(false);
								}
						}
						//Hit del jugador contra enemigo
						if(Math.abs(enemigos[i].getCoordx()-jugador.getCoordx())<=5 &&
								Math.abs(enemigos[i].getCoordy()-jugador.getCoordy())<=5) {
							jugador.setVivo(false);
							//Si el enjambre golpea al jugador vuelven a su posicion inicial(los vivos)
							for(int k=0;k<enemigos.length;k++) {
								if(enemigos[k]!=null) {
									if(k<4) {
										enemigos[k].setCoordx(70+k*10);
										enemigos[k].setCoordy(5);
										gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
									}
									if(k<12&&k>=4) {
										enemigos[k].setCoordx(50+(k-4)*10);
										enemigos[k].setCoordy(15);
										gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
									}
									if(k<20&&k>=12) {
										enemigos[k].setCoordx(50+(k-12)*10);
										enemigos[k].setCoordy(25);
										gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
									}
									if(k<30&&k>=20) {
										enemigos[k].setCoordx(40+(k-20)*10);
										enemigos[k].setCoordy(35);
										gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
									}
									if(k<40&&k>=30) {
										enemigos[k].setCoordx(40+(k-30)*10);
										enemigos[k].setCoordy(45);
										gui.gb_moveSpriteCoord(enemigos[k].getId(), enemigos[k].getCoordx(), enemigos[k].getCoordy());
									}
								}
							}
						}
						//Animacion de la explosion del enemigo
						if(!enemigos[i].isVivo()) {
							enemigos[i].setTi(enemigos[i].getTi()+1);
							if(enemigos[i].getTi()<=10) {
								enemigos[i].setImagen("explosion20.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							if(enemigos[i].getTi()<=20&&enemigos[i].getTi()>10) {
								enemigos[i].setImagen("explosion21.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							if(enemigos[i].getTi()<=30&&enemigos[i].getTi()>20) {
								enemigos[i].setImagen("explosion22.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							if(enemigos[i].getTi()<=40&&enemigos[i].getTi()>30) {
									enemigos[i].setImagen("explosion23.png");
									gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}							
							if(enemigos[i].getTi()>40) {
								enemigos[i].setImagen("explosion24.png");
								gui.gb_setSpriteImage(enemigos[i].getId(), enemigos[i].getImagen());
							}
							//Feed de los enemigos muertos y suma de puntos
							if(enemigos[i].getTi()==50) {
								if(i<40&&i>=20) {
									ptos+=100;
									gui.gb_setValuePointsUp(100);
									gui.gb_println("Zako muerto");
								}
								if(i<20&&i>=4) {
									ptos+=250;
									gui.gb_setValuePointsUp(250);
									gui.gb_println("Goei muerto");
								}
								if(i<4) {
									ptos+=500;
									gui.gb_setValuePointsUp(500);
									gui.gb_println("Capitan Galaga muerto");
								}
								gui.gb_setValuePointsDown(ptos);
								enemigos[i].setTi(0);
								gui.gb_setSpriteVisible(enemigos[i].getId(), false);
								if(enemigos[i].bala!=null) {
									gui.gb_setSpriteVisible(enemigos[i].getId()+1000, false);
								}
								enemigos[i].bala=null;
								enemigos[i]=null;
							}
						}
					}
				}
			}
			//Animacion de la explosion del jugador
			if(!jugador.isVivo()) {
				jugador.setTi(jugador.getTi()+1);
				if(jugador.getTi()<=10) {
					gui.gb_animateDamage();
					jugador.setImagen("explosion11.png");
					gui.gb_setSpriteImage(jugador.getId(), jugador.getImagen());
				}
				if(jugador.getTi()<=20&&jugador.getTi()>10) {
					jugador.setImagen("explosion12.png");
					gui.gb_setSpriteImage(jugador.getId(), jugador.getImagen());
				}
				if(jugador.getTi()<=30&&jugador.getTi()>20) {
					jugador.setImagen("explosion13.png");
					gui.gb_setSpriteImage(jugador.getId(), jugador.getImagen());
				}
				if(jugador.getTi()>30) {
					jugador.setImagen("explosion14.png");
					gui.gb_setSpriteImage(jugador.getId(), jugador.getImagen());
				}
				if(jugador.getTi()==40) {
					gui.gb_setSpriteVisible(juvida, false);
					juvida--;
					gui.gb_setValueHealthCurrent(juvida);
					jugador.setTi(0);
					gui.gb_setSpriteImage(jugador.getId(), jugador.getImagn());
					gui.gb_println("Has perdido una vida, te quedan: "+(juvida));							
					jugador.setVivo(true);
				}
			}	
			Thread.sleep(30);
			//Actualizar Accuracy y Shots
			gui.gb_setValueAbility1(jugador.Tshot);
			if(jugador.Tshot!=0) {
				gui.gb_setValueAbility2((hit*100)/jugador.Tshot);
			}
			//Ganar
			for  (int i = 0; i<enemigos.length; i++) {
				if (enemigos[i]!=null) {
						break;
				}if (i == enemigos.length-1) {			
					gui.gb_showMessageDialog("Has ganado");					
					salir = false;			
				}						
			}
			//Perder
			if(juvida==0) {
				gui.gb_showMessageDialog("Has perdido");			
				salir = false;
			}
			if(CmdSalida.equals("exit game")) {
				salir=false;
			}
		}while(salir);
		gui.setVisible(false);
	}
}