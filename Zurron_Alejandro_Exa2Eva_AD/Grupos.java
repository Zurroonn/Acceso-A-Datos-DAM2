import java.util.Arrays;
import java.util.List;

public class Grupos {
String grupo;
String genero;
String decada;
List[] discos;
List[] giras;
public Grupos(String grupo, String genero, String decada, List[] discos, List[] giras) {
	super();
	this.grupo = grupo;
	this.genero = genero;
	this.decada = decada;
	this.discos = discos;
	this.giras = giras;
}
public String getGrupo() {
	return grupo;
}
public void setGrupo(String grupo) {
	this.grupo = grupo;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}
public String getDecada() {
	return decada;
}
public void setDecada(String decada) {
	this.decada = decada;
}
public List[] getDiscos() {
	return discos;
}
public void setDiscos(List[] discos) {
	this.discos = discos;
}
public List[] getGiras() {
	return giras;
}
public void setGiras(List[] giras) {
	this.giras = giras;
}
@Override
public String toString() {
	return "Grupos [grupo=" + grupo + ", genero=" + genero + ", decada=" + decada + ", discos="
			+ Arrays.toString(discos) + ", giras=" + Arrays.toString(giras) + "]";
}

}
