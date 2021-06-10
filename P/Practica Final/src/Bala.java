
public class Bala extends Elemento {
	public Bala(int x, int y, int id, int direccion) {
		this.setCoordx(x);
		this.setCoordy(y);
		this.setId(id);
		this.setImagen(getImagen());
		this.setDireccion(direccion);
	}
	//Torpedo jugador
	public String getImagen() {
		return "torpedo100.png";
	}
	//Torpedo enemigo
	public String getImagene() {
		return "torpedo200.png";
	}
	//Movimiento
	public void move(int direccion, int paso){
		setDireccion(direccion);
		setCoordy(this.getCoordy()+Constantes.mov[direccion][1]*paso);
	}
}