package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.PurchaseOrder;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PurchaseOrderDatabase {
    private List<PurchaseOrder> poDatabase = new ArrayList<>();

    public PurchaseOrderDatabase() {
        this.generateList();
    }

    //    @Bean(name = "poData")
    public void generateList() {
        poDatabase.add(new PurchaseOrder("1683485", "2019-07-03", "Compute","John Doe","open"));
        poDatabase.add(new PurchaseOrder("2348943", "2019-06-30", "GRM","Paul Sweeney","approved"));
        poDatabase.add(new PurchaseOrder("3569032", "2019-06-25", "Investments","Martin Fitzpatrick","rejected"));
        poDatabase.add(new PurchaseOrder("5236899", "2019-06-05", "Claims","Karen Mc'Donnell","open"));
        poDatabase.add(new PurchaseOrder("3957681", "2019-06-05", "Incubator","Jeff Altman","open"));
        poDatabase.add(new PurchaseOrder("4084631", "2019-06-05", "Compute","Mark Anthony","closed"));
        poDatabase.add(new PurchaseOrder("4168492", "2019-06-05", "Incubator","Barry Banes","closed"));
        poDatabase.add(new PurchaseOrder("4150722", "2019-06-05", "GRM","James Berry","approved"));
        poDatabase.add(new PurchaseOrder("4111247", "2019-06-05", "Streamrunners", "Christopher C. Murphy", "open"));
        poDatabase.add(new PurchaseOrder("4843339", "2019-06-05", "Compute", "Yisroel Lock", "open"));
        poDatabase.add(new PurchaseOrder("2610097", "2018-06-05", "Investments", "Bridget Harris", "approved"));
        poDatabase.add(new PurchaseOrder("4102385", "2019-07-01", "Talent", "Sandra Cooper Stanley Woods", "closed"));
        poDatabase.add(new PurchaseOrder("4218053", "2019-03-08", "Insurance", "Gary Pearson", "open"));
        poDatabase.add(new PurchaseOrder("4107432", "2019-04-27", "Claims", "Sean Monie", "approved"));
        poDatabase.add(new PurchaseOrder("4932760", "2019-02-09", "Claims", "Michael Forrest", "approved"));
        poDatabase.add(new PurchaseOrder("1437897", "2017-01-30", "Talent", "Benjamin Evans", "closed"));
        poDatabase.add(new PurchaseOrder("1307842", "2015-10-02", "Claims", "Emma Coates", "rejected"));
        poDatabase.add(new PurchaseOrder("2068463", "2016-03-05", "GRM", "James Bruce", "closed"));
        poDatabase.add(new PurchaseOrder("3067451", "2018-09-13", "Streamrunners", "Peter Lacey", "closed"));
        poDatabase.add(new PurchaseOrder("3887161", "2018-07-05", "Talent", "Jonathan Clark", "rejected"));
        poDatabase.add(new PurchaseOrder("2062892", "2018-06-05", "Recruitment", "Andrew Jackson", "closed"));
    }

    public void addToList(PurchaseOrder po) {
        poDatabase.add(po);
    }

    public List getAll() {
        return poDatabase;
    }

    public Integer getSize() {
        return poDatabase.size();
    }
}

