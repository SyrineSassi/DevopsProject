package tn.esprit.rh.achat;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JavaTest {

    @Mock
    OperateurRepository categorieRepository2;

    @InjectMocks
    OperateurServiceImpl categorieService;

    Operateur prod1 = new Operateur(2L,"AAA","exple", "aaaaa",null);

    Long getId()
    {
        for (Operateur cat: categorieRepository2.findAll()) {
            return cat.getIdOperateur();
        }
        return 0L;
    }
    @Test
    @Order(0)
    void TestaddOperateur() {
        Operateur categ = new Operateur();
        List<Operateur> LCategorie = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            categ.setIdOperateur(i);
            categ.setNom("AAA");
            categ.setPrenom("BBBB");
            categ.setPassword("2L");

            Operateur ca=categorieRepository2.save(categ);
            LCategorie.add(ca);
        }
        assertEquals(10,LCategorie.size());
    }
    @Test
    @Order(3)
    void TestdeleteAllOperateur() {
        categorieRepository2.deleteAll();
        assertEquals(0,categorieRepository2.findAll().spliterator().estimateSize());
    }
    @Test
    @Order(2)
    void TestretrieveOperateur() {
        Mockito.when(categorieRepository2.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1));

        Mockito.when(categorieRepository2.findById(Mockito.anyLong())).thenReturn(Optional.of(prod1))
        ;
        Operateur op = categorieService.retrieveOperateur(2L);
        Assertions.assertNotNull(op);


    }
    @Test
    @Order(4)
    void TestgetAllOperateur(){
        Iterable<Operateur> Lcateg = categorieRepository2.findAll();
        Assertions.assertNotNull(Lcateg);
    }
}
