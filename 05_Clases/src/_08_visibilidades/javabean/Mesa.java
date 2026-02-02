package _08_visibilidades.javabean;

public class Mesa {
	private String color;
	private double altura;
	private double anchura;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		if(altura > 0) this.altura = altura;
		else System.out.println("Altura no permitida");
	}
	public double getAnchura() {
		return anchura;
	}
	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}
	
	
}
