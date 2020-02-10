
import edu.uc3m.game.GameBoardGUI;

public class Jugador extends Elemento{
	public Bala[] proyectiles= new Bala[10];
	GameBoardGUI guijug;
	String accion;
	public int Tshot=0;
	public Jugador(int id,int x, int y) {
		this.setId(id);
		this.setCoordx(x);
		this.setCoordy(y);
		this.setImagen(getImagen());
		this.setVivo(true);
	}
	public String getImagn() {			
		return "player.png";
	}
	public void mover(int x) {
		if(x>=5 && x<=((Constantes.MAXancho*10)-5) ) {
		setCoordx(x);
		}
	}
	public void actualizar() {
		accion=guijug.gb_getLastAction().trim();
		if (accion.length() > 0) {
			guijug.gb_println(accion);
		}
		if(isVivo()) {
			switch (accion) {
			//Movimiento
			case "left":
				mover(getCoordx()-5);
				guijug.gb_moveSpriteCoord(getId() , getCoordx(), getCoordy());
				break;
			case "right":
				mover(getCoordx()+5);
				guijug.gb_moveSpriteCoord(getId() , getCoordx(), getCoordy());
				break;
				//Disparo
			case "space":
				for(int i=0;i<proyectiles.length;i++) {
					if(proyectiles[i]==null) {
						proyectiles[i]=new Bala(getCoordx(), getCoordy(), (i%10)+10, Constantes.DIR_N);
						guijug.gb_addSprite(proyectiles[i].getId(), proyectiles[i].getImagen(),true);
						guijug.gb_moveSpriteCoord(proyectiles[i].getId(),proyectiles[i].getCoordx(), proyectiles[i].getCoordy());
						guijug.gb_setSpriteVisible(proyectiles[i].getId(), true);
						Tshot++;
						break;
					}
				}
			}
		}
		for(int j=0; j<proyectiles.length;j++) {
			if(proyectiles[j]!=null) {
				if (proyectiles[j].getCoordy()<=10) {
					guijug.gb_setSpriteVisible(proyectiles[j].getId(), false);
					proyectiles[j]=null;
				}else {
					proyectiles[j].move(Constantes.DIR_N,1);
					guijug.gb_setSpriteImage(proyectiles[j].getId(), proyectiles[j].getImagen());
					guijug.gb_moveSpriteCoord(proyectiles[j].getId(), proyectiles[j].getCoordx(), proyectiles[j].getCoordy());
				}
			}
		}
	}
}