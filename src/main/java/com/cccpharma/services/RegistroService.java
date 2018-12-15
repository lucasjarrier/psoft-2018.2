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
		int qtdItens = validaCarrinho(carrinho);
		double valorTotal = calculaVenda(carrinho);
		Registro registro = new Registro(qtdItens, valorTotal, carrinho, idCliente);
		try {
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

	private int validaCarrinho(ArrayList<Produto> carrinho) {
		ArrayList<Produto> produtosValidos = new ArrayList<>();
		for (Produto produto : carrinho) {
			if(produto.getSituacao())
				produtosValidos.add(produto);
		}
		return produtosValidos.size();
	}

	private double calculaVenda(ArrayList<Produto> carrinho) {
		double retorno = 0;
		for (Produto produto : carrinho) {
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
