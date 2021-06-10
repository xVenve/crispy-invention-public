public class Enemigo extends Elemento{
	Bala bala;
	public Enemigo(int id,int x, int y,int direccion) {
		this.setId(id);
		this.setCoordx(x);
		this.setCoordy(y);
		this.setDireccion(direccion);
		this.setVivo(true);
	}
	public String getImagenV() {
		String directionCode;
		if (getDireccion()<=9) {
			directionCode= "10"+getDireccion();
		}else {
			directionCode= "1" + getDireccion();
		
		}
		setDireccion(getDireccion()+1);
		setImagen("enemy"+ directionCode +".png");
		return ("enemy"+ directionCode +".png");
	}
	public String getImagenR() {
		String directionCode;
		if (getDireccion()<=9) {
			directionCode= "20"+getDireccion();
		}else {
			directionCode= "2" + getDireccion();
		
		}
		setDireccion(getDireccion()+1);
		setImagen("enemy"+ directionCode +".png");
		return ("enemy"+ directionCode +".png");	
	}
	public String getImagenA() {
		String directionCode;
		if (getDireccion()<=9) {
			directionCode= "30"+getDireccion();
		}else {
			directionCode= "3" + getDireccion();
		}
		setDireccion(getDireccion()+1);
		setImagen("enemy"+ directionCode +".png");
		return ("enemy"+ directionCode +".png");
	}
	public boolean move(int direction, int steps) {
		if (direction < 0 || direction > 17 || steps < 1) {
			return false;
		} else {
			setDireccion(direction);
			setCoordx(this.getCoordx() + Constantes.mov[direction][0] * steps);
			setCoordy(this.getCoordy() + Constantes.mov[direction][1] * steps);
			return true;
		}
	}
}