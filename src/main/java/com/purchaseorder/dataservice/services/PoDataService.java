package com.purchaseorder.dataservice.services;

import com.purchaseorder.dataservice.model.PoData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/po")
@CrossOrigin(origins = "http://localhost:4200")
public class PoDataService {
    private PurchaseOrderDatabase poDatabase = new PurchaseOrderDatabase();

//    @Resource(name = "poData")
//    private List<PurchaseOrder> poData;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<PurchaseOrder> allPurchaseOrders() {
//        return poData;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List allPurchaseOrders() {
        return poDatabase.getAll();
    }

    @RequestMapping(
        method = RequestMethod.POST,
        consumes = "application/json"
    )
    public String addPoData(@RequestBody PoData poData) {
        Integer poDbSize = poDatabase.getSize();
        poDatabase.addToList(poData.getPurchaseOrder());
        if (poDbSize + 1 == poDatabase.getSize()) {
            return "Success, PO added to the dictionary";
        }
        return  "Failed to add PO data to the database";
    }

//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/old/{name}"
//    )
//
//    public Unit byName(@PathVariable String name) {
//        return units.stream()
//                .filter(p -> p.getName().equals(name))
//                .findFirst()
//                .orElse(new Unit("Xel'naga", "melee", "Hybrid"));
//    }
//
//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "new/{name}"
//    )
//
//    public ResponseEntity<Unit> byNewName(@PathVariable String name) {
//        Optional<Unit> result = units.stream()
//                .filter(p -> p.getName().equals(name))
//                .findFirst();
//
//        return result.map(ResponseEntity::ok)
//                .orElse(notFound().build());
//    }
//
//    @RequestMapping(
//            method = RequestMethod.PUT,
//            consumes = "application/json"
//    )
//
//    public String addUnit(@RequestBody Unit newUnit) {
//        units.add(newUnit);
//        return "Request to add an unit received";
//    }
}
