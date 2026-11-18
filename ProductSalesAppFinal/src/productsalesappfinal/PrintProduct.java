package productsalesappfinal;

public class PrintProduct {
    private IProducts productObj;

    public PrintProduct(IProducts productObj) {
        this.productObj = productObj;
    }

    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + productObj.GetTotalProductSold());
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(productObj.GetAverageProductSold()));
        System.out.println("MOST POPULAR PRODUCT: " + productObj.GetMostPopularProduct());
        System.out.println("**************************************************");
    }
}