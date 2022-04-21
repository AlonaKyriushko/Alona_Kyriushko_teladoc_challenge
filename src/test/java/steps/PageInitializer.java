package steps;

import pages.TablePage;

public class PageInitializer {

    //in PageInitializer I create object of my pages following Page Object Model design pattern

    public static TablePage tablePage;

    public static void initializePageObjects(){
        tablePage=new TablePage();
    }

}
