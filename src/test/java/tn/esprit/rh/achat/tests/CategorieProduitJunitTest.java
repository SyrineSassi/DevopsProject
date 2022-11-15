package tn.esprit.rh.achat.tests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import tn.esprit.rh.achat.services.ICategorieProduitService;
import tn.esprit.rh.achat.services.IProduitService;


@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategorieProduitServiceImplTest {



    @Mock
    CategorieProduitRepository categorieRepository2;

    @InjectMocks
    CategorieProduitServiceImpl categorieService;

    CategorieProduit prod1 = new CategorieProduit(2L,"AAA","exple", null);

    Long getId()
    {
        for (CategorieProduit cat: categorieRepository2.findAll()) {
            return cat.getIdCategorieProduit();
        }
        return 0L;
    }
    @Test
    @Order(0)
    void TestaddCategorieProduit() {
        CategorieProduit categ = new CategorieProduit();
        List<CategorieProduit> LCategorie = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            categ.setIdCategorieProduit(i);
            categ.setLibelleCategorie("AAA");
            categ.setCodeCategorie("2L");

            CategorieProduit ca=categorieRepository2.save(categ);
            LCategorie.add(ca);
        }
        assertEquals(10,LCategorie.size());
    }
    @Test
    @Order(3)
    void TestdeleteAllCategorieProduit() {
        categorieRepository2.deleteAll();
        assertEquals(0,categorieRepository2.findAll().spliterator().estimateSize());
    }
    @Test
    @Order(2)
    void TestretrieveCategorirProduit() {
        Mockito.when(categorieRepository2.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1));

        Mockito.when(categorieRepository2.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1))
        ;
        CategorieProduit op = categorieService.retrieveCategorieProduit(2L);
        Assertions.assertNotNull(op);


    }
    @Test
    @Order(4)
    void TestgetAllCategorieProduit(){
        Iterable<CategorieProduit> Lcateg = categorieRepository2.findAll();
        Assertions.assertNotNull(Lcateg);
    }
}
