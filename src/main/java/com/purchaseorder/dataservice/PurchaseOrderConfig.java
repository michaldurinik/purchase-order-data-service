package com.purchaseorder.dataservice;

import com.purchaseorder.dataservice.model.PurchaseOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PurchaseOrderConfig {
    @Bean(name = "poData")
    public List<PurchaseOrder> function() {
        List<PurchaseOrder> units = new ArrayList<>();
        units.add(new PurchaseOrder("1683485", "2019-07-03", "Compute", "John Doe", "open"));
        return units;
    }
}

