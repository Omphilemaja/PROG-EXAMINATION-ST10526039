package productsalesappfinal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Question 2 mattress calculations.
 */
public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // Verifies 15% VAT on 3500
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // Verifies 5% Commission on 3500
        assertEquals(175.0, calc.GetCommission(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // Verifies total sum (Price + VAT + Commission)
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}