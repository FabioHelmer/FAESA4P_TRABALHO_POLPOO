package controllers;

import estruturasDados.Tabela;
import estruturasDados.arvore.ArvoreABB;
import services.find.ArvoreFindService;
import services.sort.HeapSortService;
import utils.InOutArquivos;

public class ArvoreABBController extends SuperController {

	@Override
	public void iniciaApp() {
		super.iniciaApp("ArvoreABB");
	}

	@Override
	public void iniciaApp(String tamanho) {
		super.iniciaApp("ArvoreABB", tamanho);
	}
	@Override
	public void instanciaEstrutura(int nElem) {
		estrutura = new Tabela(nElem);
	}

	@Override
	public void povoaEstruturaPeloTXT(String fileName) {
		if (getSistemaOperacional() == "Linux") {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in/" + fileName, (ArvoreABB) estrutura);
		}
		
		if (getSistemaOperacional() == "Windows") {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName, (ArvoreABB) estrutura);
		}
	}

	@Override
	public void ordenaEstrutura() {
		Ordenacoes.SortService((Tabela) estrutura, new HeapSortService());
	}

	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco((ArvoreABB) estrutura, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {

		InOutArquivos.leitorTXTBusca((ArvoreABB) estrutura, fileName, new ArvoreFindService());

	}

}