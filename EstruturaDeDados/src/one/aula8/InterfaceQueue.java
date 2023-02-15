package one.aula8;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class InterfaceQueue {
	public static void main(String[] args) {
		//MEDOTOS DA FILA: .add(), .element(), .offer(), .peek(), .remove(), .poll(); .isEmpty()
		Queue<CarroQueue> queueCarros = new LinkedList<>();
		queueCarros.add(new CarroQueue("Ford"));
		queueCarros.add(new CarroQueue("Fiat"));
		queueCarros.add(new CarroQueue("Chevrolet"));
		queueCarros.add(new CarroQueue("Vw"));
		
		System.out.println(queueCarros.add(new CarroQueue("Peugeot")));
		System.out.println(queueCarros);
		System.out.println(queueCarros.offer(new CarroQueue("Renout")));
		System.out.println(queueCarros);
		System.out.println(queueCarros.peek());
		System.out.println(queueCarros.poll());
		System.out.println(queueCarros);
		
	}
}
class CarroQueue {
	String marca;

	public CarroQueue(String marca) {
		super();
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
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
	}

	@Override
	public String toString() {
		return "Carro [marca=" + marca + "]";
	}
	

}
