package one.aula8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstruturaLista {
	public static void main(String[] args) {
		
	
	List<CarroList> listCarros = new ArrayList<>();

	listCarros.add(new CarroList("Ford"));
	listCarros.add(new CarroList("Fiat"));
	listCarros.add(new CarroList("Chevrolet"));
	listCarros.add(new CarroList("Vw"));
	
	System.out.println(listCarros.add(new CarroList("Peugeot")));
	System.out.println(listCarros);
	System.out.println(listCarros.contains("Renout"));
	System.out.println(listCarros);
	System.out.println(listCarros.get(2));
	System.out.println(listCarros.indexOf("Chevrolet"));
	System.out.println(listCarros);
}
}
class CarroList {
	String marca;

	public CarroList(String marca) {
		super();
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(marca, other.marca);
	}*/

	@Override
	public String toString() {
		return "Carro [marca=" + marca + "]";
	}
	

}