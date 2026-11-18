package productsalesappfinal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Question 1 product sales calculations.
 */
public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int[][] sampleData = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        
        Product product = new Product(sampleData, names);
        
        // Verifies that total sales sum equals 153
        assertEquals(153, product.GetTotalProductSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        int[][] sampleData = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        
        Product product = new Product(sampleData, names);
        
        // Verifies average sales calculation
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}