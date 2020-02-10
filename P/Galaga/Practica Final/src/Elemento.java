
public class Elemento {
	private int id;
	private int coordx;
	private int coordy;
	private String imagen;
	private int direccion=0;
	private boolean vivo;
	private int ti=0;
	public int getTi() {
		return ti;
	}
	public void setTi(int ti) {
		this.ti = ti;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoordx() {
		return coordx;
	}
	public void setCoordx(int x) {
		if (x >= 0) {
			this.coordx = x;		}
	}
	public int getCoordy() {
		return coordy;
	}
	public void setCoordy(int y) {
		if (y >= 0) {
			this.coordy = y;
		}
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
}