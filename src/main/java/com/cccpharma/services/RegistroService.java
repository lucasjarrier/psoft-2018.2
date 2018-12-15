package com.cccpharma.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.Produto;
import com.cccpharma.models.Registro;
import com.cccpharma.models.user.Cliente;
import com.cccpharma.repositories.ClientRepository;
import com.cccpharma.repositories.ProductRepository;
import com.cccpharma.repositories.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	RegistroRepository registroRepository;
	@Autowired
	ProductRepository produtoRepository;
	@Autowired
	ClientRepository clienteRepository;

	public String criarRegistro(String idCliente) {
		Cliente cliente = procuraCliente(idCliente);
		String retorno;
		ArrayList<Produto> carrinho = cliente.getCarrinho();
		int qtdItens = validaProdutos(carrinho).size();
		double valorTotal = calculaVenda(carrinho);
		Registro registro = new Registro(qtdItens, valorTotal, carrinho);
		try {
			clienteRepository.delete(cliente);
			cliente.zeraCarrinho();
			clienteRepository.save(cliente);
			registroRepository.save(registro);
			retorno = "Registro Criado!";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}

	private Cliente procuraCliente(String idCliente) {
		return clienteRepository.findByUsername(idCliente);
	}

	private List<Produto> validaProdutos(List<Produto> produtos) {
		ArrayList<Produto> produtosValidos = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto.getSituacao())
				produtosValidos.add(produto);
		}
		return produtosValidos;
	}

	private double calculaVenda(List<Produto> produtos) {
		double retorno = 0;
		for (Produto produto : produtos) {
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

	public String criarRegistro(ArrayList<Produto> produtos) {
		String retorno;
		int qtdItens = validaProdutos(produtos).size();
		double valorTotal = calculaVenda(produtos);
		Registro registro = new Registro(qtdItens, valorTotal, produtos);
		try {
			registroRepository.save(registro);
			retorno = "Registro Criado!";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}

	public String removeRegistro(int id) {
		String retorno;
		try {
			registroRepository.delete(registroRepository.findById(id));
			ArrayList<Produto> produtos = registroRepository.findById(id).getVenda();
			for (Produto p : produtos) {
				produtoRepository.delete(p);
				p.setQuantidade(p.getQuantidade() + 1);
				produtoRepository.save(p);				
			}
			retorno = "Registro Apagado!";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}
}
