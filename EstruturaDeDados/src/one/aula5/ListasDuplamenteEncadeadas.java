package one.aula5;

public class ListasDuplamenteEncadeadas {
	public static void main(String[] args) {
		
		ListaDuplamenteEncadeada<String> minhaLista = new ListaDuplamenteEncadeada<>();
		
		minhaLista.add("c1");
		minhaLista.add("c2");
		minhaLista.add("c3");
		minhaLista.add("c4");
		minhaLista.add("c5");
		minhaLista.add("c6");
		minhaLista.add("c7");
		System.out.println(minhaLista);
		minhaLista.remove(3);
		minhaLista.add(3, "99");
		System.out.println(minhaLista);
		System.out.println(minhaLista.size());
	}

}

class NoDuplo<T> {
	private T conteudo;
	private NoDuplo noPoximo;
	private NoDuplo noPrevio;

	public NoDuplo(T conteudo) {
		this.conteudo = conteudo;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public NoDuplo getNoPoximo() {
		return noPoximo;
	}

	public void setNoPoximo(NoDuplo noPoximo) {
		this.noPoximo = noPoximo;
	}

	public NoDuplo getNoPrevio() {
		return noPrevio;
	}

	public void setNoPrevio(NoDuplo noPrevio) {
		this.noPrevio = noPrevio;
	}

	@Override
	public String toString() {
		return "NoDuplo [conteudo=" + conteudo + "]";
	}
}



class ListaDuplamenteEncadeada<T> {
	private NoDuplo<T> primeiroNo;
	private NoDuplo<T> ultimoNo;

	private int tamanhoLista;

	public ListaDuplamenteEncadeada() {
		this.primeiroNo = null;
		this.ultimoNo = null;
		this.tamanhoLista = 0;
	}

	public T get(int index) {
		return this.getNo(index).getConteudo();
	}

	public void add(T elemento) {
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		novoNo.setNoPoximo(null);
		novoNo.setNoPrevio(ultimoNo);
		if (primeiroNo == null) {
			primeiroNo = novoNo;
		}
		if (ultimoNo != null) {
			ultimoNo.setNoPoximo(novoNo);
		}
		ultimoNo = novoNo;
		tamanhoLista++;

	}

	public void add(int index, T elemento) {
		NoDuplo<T> noAuxiliar = getNo(index);
		NoDuplo<T> novoNo = new NoDuplo(elemento);
		novoNo.setNoPoximo(noAuxiliar);

		if (novoNo.getNoPoximo() != null) {
			novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
			novoNo.getNoPoximo().setNoPrevio(novoNo);
		} else {
			novoNo.setNoPrevio(ultimoNo);
			ultimoNo = novoNo;
		}
		if (index == 0) {
			primeiroNo = novoNo;
		} else {
			novoNo.getNoPrevio().setNoPoximo(novoNo);
		}
		tamanhoLista++;

	}

	public void remove(int index) {

		if (index == 0) {
			primeiroNo = primeiroNo.getNoPoximo();
			if (primeiroNo != null) {
				primeiroNo.setNoPrevio(null);
			}
		}else {
			NoDuplo<T> noAuxiliar =getNo(index);
			noAuxiliar.getNoPrevio().setNoPoximo(noAuxiliar.getNoPoximo());
			if(noAuxiliar != ultimoNo) {
				noAuxiliar.getNoPoximo().setNoPrevio(noAuxiliar.getNoPrevio());
			}else {
				ultimoNo = noAuxiliar;
			}
		}
		this.tamanhoLista--;

	}

	private NoDuplo<T> getNo(int index) {
		NoDuplo<T> noAuxiliar = primeiroNo;
		for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
			noAuxiliar = noAuxiliar.getNoPoximo();
		}
		return noAuxiliar;
	}

	public int size() {
		return this.tamanhoLista;
	}
	@Override
	public String toString() {
		String strRetorno = "";
		NoDuplo<T> noAuxiliar = primeiroNo;
		for(int i=0; i<size();i++) {
			strRetorno += "[NO{conteudo="+noAuxiliar.getConteudo()+"}]--->";
			noAuxiliar = noAuxiliar.getNoPoximo();
		}
		strRetorno+="null";
		return strRetorno;
	}

}
