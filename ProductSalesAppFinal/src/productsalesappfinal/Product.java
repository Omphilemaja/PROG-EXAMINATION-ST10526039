package productsalesappfinal;

public class Product implements IProducts {
    private int[][] salesData;
    private String[] productNames;

    public Product(int[][] salesData, String[] productNames) {
        this.salesData = salesData;
        this.productNames = productNames;
    }

    @Override
    public int GetTotalProductSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductSold();
        int count = 0;
        for (int i = 0; i < salesData.length; i++) {
            count += salesData[i].length;
        }
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int popularIndex = 0;
        for (int i = 0; i < salesData.length; i++) {
            int productSum = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productSum += salesData[i][j];
            }
            if (productSum > maxSales) {
                maxSales = productSum;
                popularIndex = i;
            }
        }
        return productNames[popularIndex] + " (" + maxSales + ")";
    }
}