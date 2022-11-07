package tn.esprit.rh.achat.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class StockServiceImplTest {
    @Autowired
    IStockService stockService;

    @Test
    public void testaddStock() {

        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock((long) 1, "stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testAddStockOptimized() {

        Stock s = new Stock((long) 1, "stock test",10,100);
        Stock savedStock= stockService.addStock(s);
        assertNotNull(savedStock.getIdStock());
        assertSame(10, savedStock.getQte());
        assertTrue(savedStock.getQteMin()>0);
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testdeleteStock() {
        Stock s = new Stock((long) 1, "stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));

    }
}