package com.cccpharma.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.Produto;
import com.cccpharma.models.Registro;
import com.cccpharma.repositories.ProductRepository;
import com.cccpharma.repositories.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	RegistroRepository registroRepository;
	@Autowired
	ProductRepository produtoRepository;

	public String criarRegistro(ArrayList<String> codigos) {
		String retorno;
		int qtdItens = codigos.size();
		ArrayList<String> codigosValidados = validaCodigos(codigos);
		double valorTotal = calculaVenda(codigosValidados);
		Registro registro = new Registro(qtdItens, valorTotal, codigosValidados);
		try {
			registroRepository.save(registro);
			retorno = "Registro Criado!";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}

	private ArrayList<String> validaCodigos(ArrayList<String> codigos) {
		ArrayList<String> codigosValidos = new ArrayList<>();
		for (String codigo : codigos) {
			if (produtoRepository.existsById(codigo)) {
				Produto produto = produtoRepository.findByCodigo(codigo);
				if (produto.getSituacao()) {
					codigosValidos.add(codigo);
				}
			}
		}
		return codigosValidos;
	}

	private double calculaVenda(ArrayList<String> codigos) {
		double retorno = 0;
		for (String codigo : codigos) {
			Produto produto = produtoRepository.findByCodigo(codigo);
			if (produto.getQuantidade() - 1 == 0) {
				retorno += produto.getPreco() - (produto.getPreco() * produto.getDesconto());
				produto.subQuantidade();
				produto.setSituacao(false);
				produtoRepository.save(produto);
			} else if (produto.getQuantidade() > 0) {
				retorno += produto.getPreco() - (produto.getPreco() * produto.getDesconto());
				produto.subQuantidade();
				produtoRepository.save(produto);
			}
		}
		return retorno;
	}

	public List<Registro> listarRegistros() {
		return registroRepository.findAll();
	}

	public Registro procurarRegistro(int id) {
		return registroRepository.findById(id);
	}

	
}
