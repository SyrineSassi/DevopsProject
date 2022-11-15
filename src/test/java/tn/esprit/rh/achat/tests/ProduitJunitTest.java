package tn.esprit.rh.achat.tests;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest(classes=AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)

public class ProduitJunitTest {
	@Autowired
	IProduitService ps;
	@Test
	@Order(1)
	public void testRetrieveAllProduits() {
		List<Produit> listProduits = ps.retrieveAllProduits();
	      Assertions.assertNotNull(listProduits);
	}


	@Test
	void addProduit() {
	    Produit p1 = new Produit();
	    p1.setLibelleProduit("produit test");
	    p1.setPrix(10);
	    p1.setCodeProduit("15");
	    Produit savedProduct1= ps.addProduit(p1);
	   assertEquals(p1.getLibelleProduit(), savedProduct1.getLibelleProduit());
	}
	
	@Test
	void deleteProduit() {
	 ps.deleteProduit((long) 6);
	 }
	
	@Test
	void updateProduit() {
	    Produit p1= ps.retrieveProduit((long) 6);
	    p1.setPrix(30) ;
	    Produit updatedProduit= ps.updateProduit(p1);
	    assertEquals(p1.getLibelleProduit(), updatedProduit.getLibelleProduit());
	}

	@Test
	void retrieveProduit() {
	    ps.retrieveProduit((long) 6);
	}
	
	@Test
	public void assignProduitToStock() {
		
		ps.assignProduitToStock((long) 5, (long) 1);
	}
	
}
