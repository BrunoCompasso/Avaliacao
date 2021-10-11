package br.compasso.avaliacao.cadastro;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.compasso.avaliacao.dao.ProdutoDao;
import br.compasso.avaliacao.entity.Produto;
import br.compasso.avaliacao.util.JPAUtil;

public class cadastroproduto {
	   public static void main(String[] args) {
		   
	   int op = 5;
	   Produto produto1 = new Produto("produto 1","este é um produto",5.0, java.sql.Date.valueOf("2005-02-01"), java.sql.Date.valueOf("2005-03-01"));
       Produto produto2 = new Produto("produto 2","este é outro produto",5.0, java.sql.Date.valueOf("2005-02-01"), java.sql.Date.valueOf("2005-03-01"));
       Produto produto3 = new Produto("produto 3","este é mais um produto",5.0, java.sql.Date.valueOf("2005-02-01"), java.sql.Date.valueOf("2005-03-01"));
       final Scanner entrada = new Scanner(System.in);
          EntityManager em = JPAUtil.getEntityManager();
          ProdutoDao dao = new ProdutoDao(em);
		   while (op != 0) {

			   System.out.println("1: Cadastro Automatico de 3 Produtos");
	           System.out.println("2: Atualizar o primeiro produto cadastrado na opção 1");
	           System.out.println("3: Excluir o segundo produto cadastrado");
	           System.out.println("0: Sair");
			   System.out.println("Digite uma das Opções");
			   op = entrada.nextInt();    
	            
			   	if (op == 1 ) {
	            em.getTransaction().begin();
	            dao.cadastrar(produto1);
	            dao.cadastrar(produto2);
	            dao.cadastrar(produto3);
	            em.getTransaction().commit();
	            	    
	            
	            System.out.println("Produtos Cadastrados");
	            }
			   	else if (op == 2) {
			   	em.getTransaction().begin();
			   	dao.atualizar(produto1);
			   	produto1.setDescricao("Este produto foi atualizado");
			   	em.getTransaction().commit();
			   	
			   	System.out.println("Produto Atualizado");
			   	}
			   	else if (op == 3) {
			   		em.getTransaction().begin();
				   	dao.remover(produto2);
				   	em.getTransaction().commit();
				   	
				   	System.out.println("Produto Removido");
			   	}
			   	else if (op == 0) {
			   		System.out.println("Tchau");
			   		em.close();
			   	 System.exit(0);
			   	}
			   	else {
			   		System.out.println("Digite um número valido");	
			   	}
			   	}
			   	}
	            	   
	            	    
	     }

	            		     
