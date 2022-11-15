package tn.esprit.rh.achat;

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
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IOperateurService;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest(classes=AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class SpringBootWithUnitTestApplicationTests {
    @Autowired
    IOperateurService ps;
    @Test
    @Order(1)
    public void testRetrieveAllOperateurs() {
        List<Operateur> listOperateurs = ps.retrieveAllOperateurs();
        Assertions.assertNotNull(listOperateurs);
    }


    @Test
    @Order(0) 
    void addOperateur() {
        Operateur p1 = new Operateur();
        p1.setIdOperateur(1L);
        p1.setPrenom("Operateur test");
        p1.setNom("test");
        p1.setPassword("mmmm");
        Operateur savedOperateur1= ps.addOperateur(p1);
        assertEquals(p1.getNom(), savedOperateur1.getNom());
    }

  //  @Test
    //@Order(2)
    //void deleteOperateur() {
      //  ps.deleteOperateur(1L);
   // }


}

