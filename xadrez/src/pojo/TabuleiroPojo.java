package pojo;

import java.util.ArrayList;
import java.util.List;

public class TabuleiroPojo {
	private List<PecaPojo> listaPecas;
	
	public TabuleiroPojo() {
		listaPecas = new ArrayList<PecaPojo>();
	}

	public List<PecaPojo> getListaPecas() {
		return listaPecas;
	}

	public void setListaPecas(List<PecaPojo> listaPecas) {
		this.listaPecas = listaPecas;
	}
}
