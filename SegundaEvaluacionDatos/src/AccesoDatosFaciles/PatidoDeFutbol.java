package AccesoDatosFaciles;

public class PatidoDeFutbol {
	private String nombreLocal;
	private int golesLocal;
	private int golesVisi;
	private String nombreVisi;
	

	public PatidoDeFutbol() {
	}
	
	public PatidoDeFutbol(String nombreLocal, int golesLocal, int golesVisi, String nombreVisi) {
		this.nombreLocal = nombreLocal;
		this.golesLocal = golesLocal;
		this.golesVisi = golesVisi;
		this.nombreVisi = nombreVisi;
	}
	public String getNombreLocal() {
		return nombreLocal;
	}
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisi() {
		return golesVisi;
	}
	public void setGolesVisi(int golesVisi) {
		this.golesVisi = golesVisi;
	}
	public String getNombreVisi() {
		return nombreVisi;
	}
	public void setNombreVisi(String nombreVisi) {
		this.nombreVisi = nombreVisi;
	}

	@Override
	public String toString() {
		return "PatidoDeFutbol [nombreLocal=" + nombreLocal + ", golesLocal=" + golesLocal + ", golesVisi=" + golesVisi
				+ ", nombreVisi=" + nombreVisi + "]";
	}
	
	
	
	
	
}
