package aula1;

public class AtrubuicaoReferencia {
	public static void main(String[] args) {
			
		int intA = 1;
		int intB = intA;
		
		String stA = "Douglas";
		String stB = stA;
	
	System.out.println("stA: "+stA+", stA: "+stB);
	intA = 2;
	System.out.println("intA: "+intA+", intB: "+intB);
	stA = "Lucas";
	System.out.println("stA: "+stA+", stA: "+stB);
	System.out.println();
	
	MeuObj meuObjA = new MeuObj(10);
	MeuObj meuObjB = meuObjA;
	MeuObj meuObjC = new MeuObj(50);
	
	System.out.println(meuObjA);
	System.out.println(meuObjB);
	System.out.println(meuObjC);
	meuObjA.setNum(50);
	System.out.println();
	System.out.println(meuObjA);
	System.out.println(meuObjB);
	System.out.println(meuObjC);
	
	}
}
class MeuObj {
	
	Integer num;
	
	
	
	public MeuObj(Integer num) {
		super();
		this.num = num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/*@Override
	public String toString() {
		return this.num.toString();
	}*/
	
	
	
}